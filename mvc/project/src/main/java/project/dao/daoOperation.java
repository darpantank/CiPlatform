package project.dao;


import java.sql.PreparedStatement;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import project.model.mission;
import project.model.password_reset;
import project.model.user;

@Component
public class daoOperation {
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Transactional
	public boolean createUser(user user1) {
		Integer i=(Integer) this.hibernateTemplate.save(user1);
		if(i==1) {
			return true;
		}
		return false;
	}
	@Transactional
	public String storeResetPassToken(password_reset prst) {
		this.hibernateTemplate.saveOrUpdate("token",prst);
		return prst.getToken();
	}
	public List<password_reset> validateToken(String Token) {
		String que="from password_reset where token=:Token";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("Token", Token);
		return q.list();
	}
	public boolean validateUserDetails(String email,String pass) {
		String que="from user where email=:email and password=:password";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("email", email);
		q.setParameter("password",pass);
		List<user> mylist=q.list();
		System.out.println("List Status "+mylist.isEmpty());
		if(mylist.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public user validateEmail(String email) {
		String que="from user where email=:email";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("email", email);
		user myuser=(user)q.getSingleResult();
		return myuser;
	}
	
	public password_reset validateTokenForReset(String token) {
		String que="from password_reset where token=:token";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("token", token);
		password_reset prst=(password_reset)q.getSingleResult();
		return prst;
	}
	
	@Transactional
	public boolean deleteToken(password_reset prst) {
		if(prst.isValidObject()) {
			this.hibernateTemplate.delete(prst);
			return true;
		}
			return false;
	}
	@Transactional
	public boolean saveUpdatedPassword(String email,String password) {
		user user1=this.validateEmail(email);
		user1.setPassword(password);
		this.hibernateTemplate.update(user1);
		return true;
	}
	
//	public List<mission> fetchAllMission(){
//		List<mission> missions=this.hibernateTemplate.get
//	}
}

package project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import project.model.mission;
import project.model.password_reset;
import project.model.user;

@Component
public class userDaoOperation implements userDaoInterface{
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public boolean createUser(user user1) {
		Integer i=(Integer) this.hibernateTemplate.save(user1);
		System.out.println(i);
		if(i==0) {
			return false;
		}
		return true;
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
	public user validateUserDetails(String email,String pass) {
		String que="from user where email=:email and password=:password";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("email", email);
		q.setParameter("password",pass);
		List<user> mylist=q.list();
		user myuser=new user();
		for(user temp:mylist) {
			myuser=temp;
		}
		return myuser;
	}
	
	public user validateEmail(String email) {
		String que="from user where email=:email";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("email", email);
		user myuser=new user();
		List<user> users=q.list();
		for(user temp:users) {
			myuser=temp;
		}
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
}

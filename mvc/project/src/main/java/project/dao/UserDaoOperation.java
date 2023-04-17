package project.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import project.model.City;
import project.model.ContactUs;
import project.model.Country;
import project.model.PasswordReset;
import project.model.Skill;
import project.model.User;

@Component
public class UserDaoOperation implements UserDaoInterface{
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public boolean createUser(User user1) {
		Integer i=(Integer) this.hibernateTemplate.save(user1);
		System.out.println(i);
		if(i==0) {
			return false;
		}
		return true;
	}
	@Transactional
	public String storeResetPassToken(PasswordReset prst) {
		this.hibernateTemplate.saveOrUpdate("token",prst);
		return prst.getToken();
	}
	public List<PasswordReset> validateToken(String Token) {
		String que="from PasswordReset where token=:Token";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("Token", Token);
		return q.getResultList();
	}
	public User validateUserDetails(String email,String pass) {
		String que="from User where email=:email and password=:password";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("email", email);
		q.setParameter("password",pass);
		List<User> mylist=q.getResultList();
		User myuser=new User();
		for(User temp:mylist) {
			myuser=temp;
		}
		return myuser;
	}
	
	public User validateEmail(String email) {
		String que="from User where email=:email";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("email", email);
		User myuser=new User();
		List<User> users=q.getResultList();
		for(User temp:users) {
			myuser=temp;
		}
		return myuser;
	}
	
	public PasswordReset validateTokenForReset(String token) {
		String que="from PasswordReset where token=:token";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("token", token);
		PasswordReset prst=(PasswordReset)q.getSingleResult();
		return prst;
		
	}
	
	@Transactional
	public boolean deleteToken(PasswordReset prst) {
		if(prst.isValidObject()) {
			this.hibernateTemplate.delete(prst);
			return true;
		}
			return false;
	}
	public City getCityObject(int id) {
		return this.hibernateTemplate.get(City.class,id);
	}
	public Country getCountryObject(int id) {
		return this.hibernateTemplate.get(Country.class,id);
	}
	public Skill getSkillObject(int id) {
		return this.hibernateTemplate.get(Skill.class,id);
	}
	@Transactional
	public boolean saveUpdatedPassword(String email,String password) {
		User user1=this.validateEmail(email);
//		user1.setPassword(password);
//		this.hibernateTemplate.update(user1);
//		return true;
		
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		s.beginTransaction();
		String hql="update User as u set u.password=:password where u.user_id=:userId";
		Query q=s.createQuery(hql);
		q.setParameter("password", password);
		q.setParameter("userId",user1.getUser_id());
		q.executeUpdate();
		s.getTransaction().commit();
		return true;
	}
	@Transactional
	public boolean updateUserDetails(User user) {
		this.hibernateTemplate.merge(user);
		return true;
	}
	public User fetchUserById(int user_id) {
		return this.hibernateTemplate.get(User.class,user_id);
	}
	@Transactional
	public void deleteAlereadyPresentSkills(int userId) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		s.beginTransaction();
		String hql="delete from UserSkill where User.user_id=:userId";
		Query q=s.createQuery(hql);
		q.setParameter("userId",userId);
		q.executeUpdate();
		s.getTransaction().commit();
	}
	@Transactional
	public boolean saveContsctUsDetail(ContactUs contactUs) {
		this.hibernateTemplate.save(contactUs);
		return true;
	}

}

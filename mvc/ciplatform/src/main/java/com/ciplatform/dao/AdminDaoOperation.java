package com.ciplatform.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ciplatform.model.User;

@Component
public class AdminDaoOperation implements AdminDaoInterface {
	@Autowired
	HibernateTemplate hibernateTemplate;
	public List<User> fetchUsers() {
		return this.hibernateTemplate.loadAll(User.class);
	}
	
}

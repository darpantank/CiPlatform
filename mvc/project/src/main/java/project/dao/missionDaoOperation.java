package project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import project.model.city;
import project.model.country;
import project.model.mission;
import project.model.mission_theme;
@Component
public class missionDaoOperation implements missionDaoInterface {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<mission> loadAllMissionOnSearch(String keyword) {
		/*
		 * List<mission> missionlist=this.hibernateTemplate.loadAll(mission.class);
		 * return missionlist;
		 */
		String que="from mission where title like :keyword";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("keyword", "%"+keyword+"%");
		List<mission> mylist=q.list();
		return mylist;
	}

	public List<country> loadListOfCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<city> loadCityOfCountry(int country_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<mission_theme> loadAllThemes() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<mission> loadAllMission() {
		return this.hibernateTemplate.loadAll(mission.class);
	}

}

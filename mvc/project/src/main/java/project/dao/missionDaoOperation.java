package project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import project.dto.FilterObject;
import project.model.city;
import project.model.country;
import project.model.mission;
import project.model.mission_theme;
@Component
public class missionDaoOperation implements missionDaoInterface {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<mission> loadAllMissionOnSearch(FilterObject filters) {
		
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(mission.class);
	    if(filters.getKeyword()!="") {
	    	c.add(Restrictions.like("title", "%" +filters.getKeyword()+ "%"));
	    }
	    
	    if(filters.getCountry_id()!= 0) {
	    	c.add(Restrictions.eq("country.country_id",filters.getCountry_id()));
	    }
	    if(filters.getCities().size()>0) {
	    	c.add(Restrictions.in("city.city_id",filters.getCities()));
	    }
	    if(filters.getThemes().size()>0) {
	    	c.add(Restrictions.in("mission_theme.mission_theme_id",filters.getThemes()));
	    }
		 
		return c.list();
//		String que="from mission where title like :keyword and country_id=:CountryId and city_id in :CityList"; 
//			if(CountryId!="") {
//				if(CityList!="") {
//					que="from mission where title like :keyword and country_id=:CountryId and city_id in :CityList";
//				}
//				else {
//					que="from mission where title like :keyword and country_id=:CountryId";
//				}
//			}
//			else {
//				que="from mission where title like :keyword";
//			}
//		 
//		 Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
//		 q.setParameter("keyword", "%"+keyword+"%");
//		
//		 q.setParameter("CityList",CityList);
//		 List<mission> mylist=q.list();
//		return mylist;
		
	}

	public List<country> loadListOfCountry() {
		return this.hibernateTemplate.loadAll(country.class);
	}

	public List<city> loadCityOfCountry(int country_id) {
		String que="from city where country_id=:country_id"; 
		 Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		 q.setParameter("country_id",country_id);
		 List<city> mylist=q.list();
		return mylist;
	}

	public List<mission_theme> loadAllThemes() {
		return this.hibernateTemplate.loadAll(mission_theme.class);
	}

	public List<mission> loadAllMission() {
		String que="from mission";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setFirstResult(0);
		q.setMaxResults(10);
		return q.list();
	}

}

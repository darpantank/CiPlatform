package project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import project.dto.FilterObject;
import project.model.MissionRating;
import project.model.city;
import project.model.country;
import project.model.favorite_mission;
import project.model.mission;
import project.model.mission_theme;
import project.model.skill;
import project.model.user;
@Component
public class missionDaoOperation implements missionDaoInterface {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	private final int totalMissionPerPage=3; //Total Mission On single page used For Pagination purpose please Add +1 to show perfectly
	public List<mission> loadAllMissionOnSearch(FilterObject filters) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(mission.class);
	    if(filters.getKeyword()!="") {
	    	Criterion searchByTitle= Restrictions.like("title", "%" +filters.getKeyword()+ "%");
	    	Criterion searchByDescription= Restrictions.like("description", "%" +filters.getKeyword()+ "%");
	    	c.add(Restrictions.or(searchByTitle,searchByDescription));
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
	    if(filters.getSkills().size()>0) {
	    	c.createAlias("missionSkills", "ms");
	    	c.add(Restrictions.in("ms.skills.skill_id",filters.getSkills()));
	    }
	    if(filters.getSortBy()!="NO_ORDER") {
	    	if(filters.getSortBy()=="NEWEST") {
	    		System.out.println("NEWEST Select");
	    		c.addOrder(Order.asc("created_at"));
	    	}
	    	if(filters.getSortBy()=="OLDEST") {
	    		c.addOrder(Order.desc("created_at"));
	    	}
	    }
	    int StartingIndex=(filters.getCurrentPage()-1)*3;
	    if(filters.getCurrentPage()==0) {
	    	StartingIndex=0;
	    }
	    ProjectionList myProjections=Projections.projectionList();
	    myProjections.add(Projections.property("mission_id"));
	    myProjections.add(Projections.property("created_at"));
	    c.setProjection(Projections.distinct(myProjections));
	    c.setFirstResult(StartingIndex);
	    c.setMaxResults(totalMissionPerPage);
	    List<Object[]> myObjSet=c.list();
	    List<mission> myMissions=new ArrayList<mission>();
	    for(Object[] myObj:myObjSet) {
	    	myMissions.add(this.fetchMissionById((Integer)myObj[0]));
	    }
//	    int firstResultCount=1;
//	    if(filters.getCurrentPage()==1) {
//	    	c.setFirstResult(0);
//	    	c.setMaxResults(totalMissionPerPage);
//	    }
//	    else {	    	
//	    	c.setFirstResult(((filters.getCurrentPage()-1)*3)+1);
//	    	c.setMaxResults(totalMissionPerPage);
//	    }
//	    System.out.println("Length is"+c.list().size());
//		if(c.list().size()<3) {
//			int setMax=totalMissionPerPage + (3-c.list().size());
//			c.setMaxResults(setMax);
//		}
//	    c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//		c.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("mission_id"))));
		return myMissions;
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
	public List<skill> loadAllSkill() {
		return this.hibernateTemplate.loadAll(skill.class);
	}
	public long countTotalEntry(FilterObject filters) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(mission.class);
	    if(filters.getKeyword()!="") {
	    	Criterion searchByTitle= Restrictions.like("title", "%" +filters.getKeyword()+ "%");
	    	Criterion searchByDescription= Restrictions.like("description", "%" +filters.getKeyword()+ "%");
	    	c.add(Restrictions.or(searchByTitle,searchByDescription));
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
	    if(filters.getSkills().size()>0) {
	    	c.createAlias("missionSkills", "ms");
	    	c.add(Restrictions.in("ms.skills.skill_id",filters.getSkills()));
	    }
	    if(filters.getSortBy()!="NO_ORDER") {
	    	if(filters.getSortBy()=="NEWEST") {
	    		System.out.println("NEWEST Select");
	    		c.addOrder(Order.asc("created_at"));
	    	}
	    	if(filters.getSortBy()=="OLDEST") {
	    		c.addOrder(Order.desc("created_at"));
	    	}
	    }
	    c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.setProjection(Projections.countDistinct("mission_id"));
		long result=(Long)c.uniqueResult();
		System.out.println("Total Entry : "+result);
		return result;
	}

	public mission fetchMissionById(int mission_id) {
		return this.hibernateTemplate.get(mission.class,mission_id);
	}
	@Transactional
	public boolean addFavourite(favorite_mission myFavMission) {		
		//check before Insertion 
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(favorite_mission.class);
		c.add(Restrictions.eq("mission", myFavMission.getMission()));
		c.add(Restrictions.eq("user", myFavMission.getUser()));
		favorite_mission fm=(favorite_mission)c.uniqueResult();
		if(fm!=null) {			
			this.hibernateTemplate.delete(fm);
			return false;
		}
		else {
			this.hibernateTemplate.save(myFavMission);
			return true;
		}
	}
	public boolean favouriteMission(user userId,mission missionId) {
		Session s=this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(favorite_mission.class);
	    c.add(Restrictions.eq("user", userId));
	    c.add(Restrictions.eq("mission", missionId));
		if(c.list().size()>0) {
			System.out.println("Found Fav Mission");
			return true;
		}
		else {
			System.out.println("No Found Fav Mission");
			return false;
		}
	}
	public Double getRatingOfMission(mission mission) {
		Session s=this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(MissionRating.class);
		c.add(Restrictions.eq("mission", mission));
		c.setProjection(Projections.avg("rating"));
		System.out.println(c.list());
		return (Double)c.uniqueResult();
	}
}

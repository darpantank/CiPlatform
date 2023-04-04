package project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import project.dto.FilterObjectDto;
import project.model.MissionDocument;
import project.model.MissionInvite;
import project.model.MissionRating;
import project.model.MissionRating.Rating;
import project.model.City;
import project.model.Comment;
import project.model.Country;
import project.model.FavoriteMission;
import project.model.Mission;
import project.model.MissionTheme;
import project.model.Skill;
import project.model.User;
@Component
public class MissionDaoOperation implements MissionDaoInterface {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	private final int totalMissionPerPage=3; //Total Mission On single page used For Pagination purpose please Add +1 to show perfectly
	private final int totalRelatedMissions=3;
	public List<Mission> loadAllMissionOnSearch(FilterObjectDto filters) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(Mission.class);
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
	    List<Mission> myMissions=new ArrayList<Mission>();
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

	public List<Country> loadListOfCountry() {
		return this.hibernateTemplate.loadAll(Country.class);
	}

	public List<City> loadCityOfCountry(int country_id) {
		String que="from City where country_id=:country_id"; 
		 Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		 q.setParameter("country_id",country_id);
		 List<City> mylist=q.list();
		return mylist;
	}
	public List<MissionTheme> loadAllThemes() {
		return this.hibernateTemplate.loadAll(MissionTheme.class);
	}
	public List<Skill> loadAllSkill() {
		return this.hibernateTemplate.loadAll(Skill.class);
	}
	public long countTotalEntry(FilterObjectDto filters) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(Mission.class);
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

	public Mission fetchMissionById(int mission_id) {
		return this.hibernateTemplate.get(Mission.class,mission_id);
	}
	@Transactional
	public boolean addFavourite(FavoriteMission myFavMission) {		
		//check before Insertion 
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(FavoriteMission.class);
		c.add(Restrictions.eq("mission", myFavMission.getMission()));
		c.add(Restrictions.eq("user", myFavMission.getUser()));
		FavoriteMission fm=(FavoriteMission)c.uniqueResult();
		if(fm!=null) {			
			this.hibernateTemplate.delete(fm);
			return false;
		}
		else {
			this.hibernateTemplate.save(myFavMission);
			return true;
		}
	}
	public boolean favouriteMission(User userId,Mission missionId) {
		Session s=this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(FavoriteMission.class);
	    c.add(Restrictions.eq("user", userId));
	    c.add(Restrictions.eq("mission", missionId));
		if(c.list().size()>0) {
			return true;
		}
		else {	
			return false;
		}
	}
	public Map<Double,Long> getRatingOfMission(Mission mission) {
		Session s=this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(MissionRating.class);
		c.add(Restrictions.eq("mission", mission));
		Projection p1=Projections.avg("rating");
		Projection p2=Projections.count("mission");
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(p1);
		projectionList.add(p2);
		c.setProjection(projectionList);
		Object[] obj=(Object[])c.uniqueResult();
		Map<Double,Long> map=new HashMap<Double,Long>();
		map.put((Double)obj[0], (Long)obj[1]);
		return map;
	}
	public List<MissionDocument> getDocumentOfMission(Mission mission){
		Session s=this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(MissionDocument.class);
		c.add(Restrictions.eq("mission", mission));
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return c.list();
	}

	public List<Mission> getRelatedMissions(Mission MyMission) {
		Session s=this.hibernateTemplate.getSessionFactory().openSession();
		Criteria cUsedInCity = s.createCriteria(Mission.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		Criteria cUsedInCountry = s.createCriteria(Mission.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		Criteria cUsedInTheme = s.createCriteria(Mission.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		cUsedInCity.add(Restrictions.ne("mission_id", MyMission.getMission_id()));
		cUsedInCity.add(Restrictions.eq("city",MyMission.getCity()));
		if(cUsedInCity.list().size()==0) {
			cUsedInCountry.add(Restrictions.ne("mission_id", MyMission.getMission_id()));
			cUsedInCountry.add(Restrictions.eq("country",MyMission.getCountry()));
			if(cUsedInCountry.list().size()==0) {
				cUsedInTheme.add(Restrictions.ne("mission_id", MyMission.getMission_id()));
				cUsedInTheme.add(Restrictions.eq("mission_theme",MyMission.getMission_theme()));
				return cUsedInTheme.list();
			}
			else {
				return cUsedInCountry.list();
			}
		}else {
			return cUsedInCity.list();
		}
	}
	@Transactional
	public Boolean ratingToMission(User myuser, Mission myMission, int rating) {
		Session s=this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(MissionRating.class);
		c.add(Restrictions.eq("mission", myMission));
		c.add(Restrictions.eq("user", myuser));
		 if(myuser.getEmail()==null || myuser.getEmail()=="") {
			return false;
		 }
		 else {
			 if(c.list().size()>0) {
				 MissionRating temp=(MissionRating)c.uniqueResult();
				 temp.setRating(Rating.values()[rating]);
				 this.hibernateTemplate.update(temp);
			 }
			 else {
				 MissionRating missionRating=new MissionRating();
					missionRating.setMission(myMission);
					missionRating.setUser(myuser);
				 missionRating.setRating(Rating.values()[rating]);
				this.hibernateTemplate.save("rating", missionRating);
			 }
		 }
		
		return true;
	}

	public int ratingOfMissionOfParticularUser(User myUser, Mission myMission) {
		Session s=this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(MissionRating.class);
		c.add(Restrictions.eq("user", myUser));
		c.add(Restrictions.eq("mission", myMission));
		MissionRating temp=(MissionRating)c.uniqueResult();
		if(temp==null||temp.getRating()==null) {
			return 0;
		}
		else {
			
			return temp.getRating().ordinal();
		}
	}
	@Transactional
	public void recommandToCoWorker(Mission myMission, User sendFromUser, User sendToUser) {
		MissionInvite missionInvite=new MissionInvite();
		missionInvite.setMission(myMission);
		missionInvite.setToUser(sendToUser);
		missionInvite.setFromUser(sendFromUser);
		this.hibernateTemplate.save(missionInvite);
	}

	public List<Comment> loadAllCommentsOfMission(Mission myMission) {
		Session s=this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(Comment.class);
		c.add(Restrictions.eq("mission", myMission));
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return c.list();
	}
}

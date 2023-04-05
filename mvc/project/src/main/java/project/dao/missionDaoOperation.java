package project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
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

import project.dto.FilterObjectDto;
import project.model.MissionDocument;
import project.model.MissionInvite;
import project.model.MissionMedia;
import project.model.MissionMedia.MediaDefault;
import project.model.MissionRating;
import project.model.MissionRating.Rating;
import project.model.City;
import project.model.Comment;
import project.model.Comment.ApprovalStatus;
import project.model.Country;
import project.model.FavoriteMission;
import project.model.Mission;
import project.model.MissionApplication;
import project.model.MissionApplication.ApprovalStatusMissionApplication;
import project.model.MissionTheme;
import project.model.Skill;
import project.model.User;
@Component
public class MissionDaoOperation implements MissionDaoInterface {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	private final int totalMissionPerPage=9; //Total Mission On single page used For Pagination purpose please Add +1 to show perfectly
	private final int totalRelatedMissions=3; // Fetch How many Related missions in Detail Mission Page
	private final int totalVolunteersInMissionViewPage=3;
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
	    int StartingIndex=(filters.getCurrentPage()-1)*totalMissionPerPage;
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
		return myMissions;
	}

	public List<Country> loadListOfCountry() {
		return this.hibernateTemplate.loadAll(Country.class);
	}

	public List<City> loadCityOfCountry(int country_id) {
		String que="from City where country_id=:country_id"; 
		 Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		 q.setParameter("country_id",country_id);
		 List<City> mylist=q.getResultList();
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
	public List<MissionMedia> getMediaOfMission(Mission mission) {
		Session s=this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(MissionMedia.class);
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

	public int ratingOfMissionByParticularUser(User myUser, Mission myMission) {
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
	@Transactional
	public void postUserComment(User user, Mission mission, String commentText) {
		Comment comment=new Comment();
		comment.setComment(commentText);
		comment.setMission(mission);
		comment.setUser(user);
		comment.setApprovalStatus(ApprovalStatus.PENDING);
		this.hibernateTemplate.save(comment);
	}

	public long countTotalVolunteersInMission(Mission mission) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(MissionApplication.class);
		c.add(Restrictions.eq("mission", mission));
		c.add(Restrictions.eq("approval_status",ApprovalStatusMissionApplication.APPROVE));
		c.setProjection(Projections.countDistinct("user"));
		long result=(Long)c.uniqueResult();
		return result;
	}

	public List<MissionApplication> getVolunteersOfMission(Mission mission, int pageNumber) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
//		Criteria c = s.createCriteria(MissionApplication.class);
//		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//		c.add(Restrictions.eq("mission", mission));
//		c.add(Restrictions.eq("approval_status",ApprovalStatusMissionApplication.APPROVE));
//		int FirstCount=(pageNumber-1)*totalVolunteersInMissionViewPage;
//		c.setFirstResult(FirstCount);
//		c.setMaxResults(totalVolunteersInMissionViewPage);
//		return c.list();
		
		String hql="from MissionApplication as m where m.mission=:mission and m.approval_status=:approval_status order by created_at";
		Query q=s.createQuery(hql);
		q.setParameter("mission", mission);
		q.setParameter("approval_status",ApprovalStatusMissionApplication.APPROVE);
		int FirstCount=(pageNumber-1)*totalVolunteersInMissionViewPage;
		q.setFirstResult(FirstCount);
		q.setMaxResults(totalVolunteersInMissionViewPage);
		return q.getResultList();
	}

	public String findDefaultMediaOfMission(Mission m) {
		String image="";
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="from MissionMedia as m where m.mission=:mission and m.mediaDefault=:defaultMedia order by created_at";
		Query q=s.createQuery(hql);
		q.setParameter("mission", m);
		q.setParameter("defaultMedia",MediaDefault.DEFAULT);
		if(q.getResultList().size()>0) {			
			MissionMedia missionMedia=(MissionMedia)q.getResultList().get(0);
			image=(String)missionMedia.getMedia_name();
		}
		return image;
	}

	
}

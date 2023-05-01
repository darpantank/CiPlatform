package com.ciplatform.dao;

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

import com.ciplatform.dto.FilterObjectDto;
import com.ciplatform.enums.ApprovalStatusMissionApplication;
import com.ciplatform.enums.CommentApprovalStatus;
import com.ciplatform.enums.MediaDefault;
import com.ciplatform.enums.Rating;
import com.ciplatform.enums.Status;
import com.ciplatform.model.City;
import com.ciplatform.model.Comment;
import com.ciplatform.model.Country;
import com.ciplatform.model.FavoriteMission;
import com.ciplatform.model.Mission;
import com.ciplatform.model.MissionApplication;
import com.ciplatform.model.MissionDocument;
import com.ciplatform.model.MissionInvite;
import com.ciplatform.model.MissionMedia;
import com.ciplatform.model.MissionRating;
import com.ciplatform.model.MissionTheme;
import com.ciplatform.model.Skill;
import com.ciplatform.model.User;
@Component
public class MissionDaoOperation implements MissionDaoInterface {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	private final int totalMissionPerPage=9; //Total Mission On single page used For Pagination purpose please Add +1 to show perfectly
	private final int totalRelatedMissions=3; // Fetch How many Related missions in Detail Mission Page
	private final int totalVolunteersInMissionViewPage=9;
	public List<Mission> loadAllMissionOnSearch(FilterObjectDto filters) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(Mission.class);
		c.add(Restrictions.eq("status",Status.ACTIVE));
	    if(filters.getKeyword()!="") {
	    	Criterion searchByTitle= Restrictions.like("title", "%" +filters.getKeyword()+ "%");
	    	Criterion searchByDescription= Restrictions.like("description", "%" +filters.getKeyword()+ "%");
	    	c.add(Restrictions.or(searchByTitle,searchByDescription));
	    }
	    if(filters.getCountry_id()!= 0) {
	    	c.add(Restrictions.eq("country.countryId",filters.getCountry_id()));
	    }
	    if(filters.getCities().size()>0) {
	    	c.add(Restrictions.in("city.cityId",filters.getCities()));
	    }
	    if(filters.getThemes().size()>0) {
	    	c.add(Restrictions.in("missionTheme.missionThemeId",filters.getThemes()));
	    }
	    if(filters.getSkills().size()>0) {
	    	c.createAlias("missionSkills", "ms");
	    	c.add(Restrictions.in("ms.skills.skillId",filters.getSkills()));
	    }
	    if(filters.getSortBy()!="NO_ORDER") {
	    	if(filters.getSortBy()=="NEWEST") {
	    		c.addOrder(Order.asc("createdAt"));
	    	}
	    	if(filters.getSortBy()=="OLDEST") {
	    		c.addOrder(Order.desc("createdAt"));
	    	}
	    	if(filters.getSortBy()=="DEADLINE") {
	    		c.addOrder(Order.asc("deadline"));
	    		c.add(Restrictions.isNotNull("deadline"));
	    	}
	    	if(filters.getSortBy()=="LOWESTSEAT") {
	    		c.addOrder(Order.asc("seatLeft"));
	    		c.add(Restrictions.gt("seatLeft", 0L));
	    	}
	    	if(filters.getSortBy()=="HIGHESTSEAT") {
	    		c.addOrder(Order.desc("seatLeft"));
	    		c.add(Restrictions.gt("seatLeft", 0L));
	    	}
	    }
	    int StartingIndex=(filters.getCurrentPage()-1)*totalMissionPerPage;
	    if(filters.getCurrentPage()==0) {
	    	StartingIndex=0;
	    }
	    ProjectionList myProjections=Projections.projectionList();
	    myProjections.add(Projections.property("missionId"));
	    myProjections.add(Projections.property("createdAt"));
	    myProjections.add(Projections.property("deadline"));
	    myProjections.add(Projections.property("seatLeft"));
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
		String que="from Country"; 
		 Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		 List<Country> mylist=q.getResultList();
		return mylist;
	}

	public List<City> loadCityOfCountry(int countryId) {
		String que="from City where country.countryId=:countryId"; 
		 Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		 q.setParameter("countryId",countryId);
		 List<City> mylist=q.getResultList();
		return mylist;
	}
	public List<MissionTheme> loadAllThemes() {
		 String que="from MissionTheme where status=:status"; 
		 Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		 q.setParameter("status",Status.ACTIVE);
		 List<MissionTheme> mylist=q.getResultList();
		return mylist;
	}
	public List<Skill> loadAllSkill() {
		String que="from Skill where status=:status"; 
		 Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		 q.setParameter("status",Status.ACTIVE);
		 List<Skill> mylist=q.getResultList();
		return mylist;
	}
	public long countTotalEntry(FilterObjectDto filters) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(Mission.class);
	    c.add(Restrictions.eq("status",Status.ACTIVE));
	    if(filters.getKeyword()!="") {
	    	Criterion searchByTitle= Restrictions.like("title", "%" +filters.getKeyword()+ "%");
	    	Criterion searchByDescription= Restrictions.like("description", "%" +filters.getKeyword()+ "%");
	    	c.add(Restrictions.or(searchByTitle,searchByDescription));
	    }
	    if(filters.getCountry_id()!= 0) {
	    	c.add(Restrictions.eq("country.countryId",filters.getCountry_id()));
	    }
	    if(filters.getCities().size()>0) {
	    	c.add(Restrictions.in("city.cityId",filters.getCities()));
	    }
	    if(filters.getThemes().size()>0) {
	    	c.add(Restrictions.in("missionTheme.missionThemeId",filters.getThemes()));
	    }
	    if(filters.getSkills().size()>0) {
	    	c.createAlias("missionSkills", "ms");
	    	c.add(Restrictions.in("ms.skills.skillId",filters.getSkills()));
	    }
	    if(filters.getSortBy()!="NO_ORDER") {
	    	if(filters.getSortBy()=="NEWEST") {
	    		c.addOrder(Order.asc("createdAt"));
	    	}
	    	if(filters.getSortBy()=="OLDEST") {
	    		c.addOrder(Order.desc("createdAt"));
	    	}
	    	if(filters.getSortBy()=="DEADLINE") {
	    		c.addOrder(Order.asc("deadline"));
	    		c.add(Restrictions.isNotNull("deadline"));
	    	}
	    	if(filters.getSortBy()=="LOWESTSEAT") {
	    		c.addOrder(Order.asc("seatLeft"));
	    		c.add(Restrictions.gt("seatLeft", 0L));
	    	}
	    	if(filters.getSortBy()=="HIGHESTSEAT") {
	    		c.addOrder(Order.desc("seatLeft"));
	    		c.add(Restrictions.gt("seatLeft", 0L));
	    	}
	    }
	    c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.setProjection(Projections.countDistinct("missionId"));
		long result=(Long)c.uniqueResult();
		return result;
	}

	public Mission fetchMissionById(int missionId) {
		return this.hibernateTemplate.get(Mission.class,missionId);
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
		cUsedInCity.add(Restrictions.ne("missionId", MyMission.getMissionId()));
		cUsedInCity.add(Restrictions.eq("city",MyMission.getCity()));
		if(cUsedInCity.list().size()==0) {
			cUsedInCountry.add(Restrictions.ne("missionId", MyMission.getMissionId()));
			cUsedInCountry.add(Restrictions.eq("country",MyMission.getCountry()));
			if(cUsedInCountry.list().size()==0) {
				cUsedInTheme.add(Restrictions.ne("missionId", MyMission.getMissionId()));
				cUsedInTheme.add(Restrictions.eq("missionTheme",MyMission.getMissionTheme()));
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
		comment.setApprovalStatus(CommentApprovalStatus.PENDING);
		this.hibernateTemplate.save(comment);
	}

	public long countTotalVolunteersInMission(Mission mission) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(MissionApplication.class);
		c.add(Restrictions.eq("mission", mission));
		c.add(Restrictions.eq("approvalStatus",ApprovalStatusMissionApplication.APPROVE));
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
		
		String hql="from MissionApplication as m where m.mission=:mission and m.approvalStatus=:approval_status order by createdAt";
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
		String hql="from MissionMedia as m where m.mission=:mission and m.mediaDefault=:defaultMedia order by createdAt";
		Query q=s.createQuery(hql);
		q.setParameter("mission", m);
		q.setParameter("defaultMedia",MediaDefault.DEFAULT);
		if(q.getResultList().size()>0) {			
			MissionMedia missionMedia=(MissionMedia)q.getResultList().get(0);
			image=(String)missionMedia.getMediaPath();
		}
		return image;
	}

	public boolean isAppliedForMission(Mission m, User userId) {
		if(userId.getUserId()==0||m.getMissionId()==0) {
			return false;
		}
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="from MissionApplication as m where m.mission=:mission and m.user=:user";
		Query q=s.createQuery(hql);
		q.setParameter("mission", m);
		q.setParameter("user", userId);		
		if(q.getResultList().size()==1) {			
			return true;
		}
		return false;
		
	}

	public Long countApplicationForMission(Mission m) {
		if(m.getMissionId()==0) {
			return 0L;
		}
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="select count(*) from MissionApplication as m where m.mission=:mission and m.approvalStatus=:status";
		Query q=s.createQuery(hql);
		q.setParameter("mission", m);
		q.setParameter("status", ApprovalStatusMissionApplication.APPROVE);		
		return (Long)q.getSingleResult();
		
	}
	@Transactional
	public boolean applyForMission(MissionApplication application) {
		this.hibernateTemplate.save(application);
		return true;
	}

	public int calculateGoalOfMission(Mission m) {
		if(m.getMissionId()==0) {
			return 0;
		}
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="select SUM(action) from TimeSheet where mission=:mission";
		Query q=s.createQuery(hql);
		q.setParameter("mission", m);
		int answer=0;
		if(q.getSingleResult()!=null) {
			Long temp=(Long)q.getSingleResult();
			answer=temp.intValue();
		}
		return answer;
	}

	
}

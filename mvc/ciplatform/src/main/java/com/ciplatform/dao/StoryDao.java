package com.ciplatform.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ciplatform.enums.ApprovalStatusMissionApplication;
import com.ciplatform.model.Mission;
import com.ciplatform.model.MissionApplication;
import com.ciplatform.model.Story;
import com.ciplatform.model.StoryInvite;
import com.ciplatform.model.User;
import com.ciplatform.model.Story.StoryStatus;
@Component
public class StoryDao implements StoryDaoInterface {
	
	private final int StoryCardPerPage=9;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public List<MissionApplication> findMissionFromUser(User user) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="from MissionApplication as m where m.user=:user and m.approval_status=:approval_status order by created_at";
		Query q=s.createQuery(hql);
		q.setParameter("user", user);
		q.setParameter("approval_status",ApprovalStatusMissionApplication.APPROVE);
		return q.getResultList();
	}
	@Transactional
	public void saveStory(Story story) {
		this.hibernateTemplate.saveOrUpdate(story);
	}
	public Story getDraftMission(User user,Mission mission) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="from Story as m where m.mission.mission_id=:mission and m.user=:user and m.status=:status";
		Query q=s.createQuery(hql);
		q.setParameter("mission", mission.getMission_id());
		q.setParameter("user",user);
		q.setParameter("status",StoryStatus.DRAFT);
		Story story=new Story();
		try {
			story=(Story)q.getResultList().get(0);
			return story;
		}catch(IndexOutOfBoundsException e) {
			return story;
		}
		
	}
	public Story fetchStoryObjectById(int storyId) {
		return this.hibernateTemplate.get(Story.class,storyId);
	}
	@Transactional
	public void deleteMediaOfStory(int storyId) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		s.beginTransaction();
		String hql="delete from StoryMedia as sm where sm.story.story_id=:storyId";
		Query q=s.createQuery(hql);
		q.setParameter("storyId", storyId);
		q.executeUpdate();
		s.getTransaction().commit();
	}
	public Story getDetailStory(int storyId) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="from Story as s where s.story_id=:storyId";
		Query q=s.createQuery(hql);
		q.setParameter("storyId", storyId);
		return (Story)q.getResultList().get(0);
	}
	public Long getCountOfStory() {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="select count(*) from Story where status=:status";
		Query q=s.createQuery(hql);
		q.setParameter("status",StoryStatus.PUBLISHED);
		Long result=0L;
		result=(Long)q.getSingleResult();
		return result;
	}
	public List<Story> getStoriesByPageNo(int currentPage) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="from Story as s where s.status=:status";
		Query q=s.createQuery(hql);		
		q.setParameter("status", StoryStatus.PUBLISHED);
		
		int startIndex=0;
		startIndex= (currentPage-1)*StoryCardPerPage;
		
		q.setFirstResult(startIndex);
		q.setMaxResults(StoryCardPerPage);
		return q.getResultList();
	}
	@Transactional
	public void submitDraftedStory(int storyId, int userId) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		s.beginTransaction();
		String hql="update Story as s set s.status=:status where s.user.user_id=:userId and s.story_id=:storyId";
		Query q=s.createQuery(hql);
		q.setParameter("status", StoryStatus.PENDING);
		q.setParameter("userId", userId);
		q.setParameter("storyId", storyId);
		q.executeUpdate();
		s.getTransaction().commit();
	}
	@Transactional
	public void recommandToCoWorkerStory(Story story, User sendFromUser, User sendToUser) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		StoryInvite storyInvite=new StoryInvite();
		storyInvite.setStory(story);
		storyInvite.setFromUser(sendFromUser);
		storyInvite.setToUser(sendToUser);
		this.hibernateTemplate.save(storyInvite);
		
	}
	@Transactional
	public void incrementPageViewCount(int storyId) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		s.beginTransaction();
		String hql="update Story as s set s.views=coalesce(s.views,0) + 1 where s.story_id=:storyId";
		Query q=s.createQuery(hql);
		q.setParameter("storyId", storyId);
		q.executeUpdate();
		s.getTransaction().commit();
	}
	

	
}

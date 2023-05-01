package com.ciplatform.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ciplatform.dto.MissionApplicationIncomingDto;
import com.ciplatform.enums.ApprovalStatusMissionApplication;
import com.ciplatform.enums.StoryStatus;
import com.ciplatform.model.Banner;
import com.ciplatform.model.CmsPage;
import com.ciplatform.model.Mission;
import com.ciplatform.model.MissionApplication;
import com.ciplatform.model.MissionTheme;
import com.ciplatform.model.Skill;
import com.ciplatform.model.Story;
import com.ciplatform.model.User;

@Component
public class AdminDaoOperation implements AdminDaoInterface {
	@Autowired
	HibernateTemplate hibernateTemplate;
	public List<User> fetchUsers() {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="from User where deletedAt is null";
		Query q=s.createQuery(hql);
		return q.getResultList();
	}
	
//	dao's for Cms Pages Based Operations
	
	public List<CmsPage> fetchCmaList() {
		return this.hibernateTemplate.loadAll(CmsPage.class);
	}
	
	public CmsPage fetchCmsById(int cmsId) {
		return this.hibernateTemplate.get(CmsPage.class, cmsId);
	}
	@Transactional
	public boolean saveOrUpdateCms(CmsPage cmsPage) {
		this.hibernateTemplate.saveOrUpdate(cmsPage);
		return true;
	}
	
	//dao's For theme Based Operations
	
	public List<MissionTheme> fetchThemeList() {
		return this.hibernateTemplate.loadAll(MissionTheme.class);
	}
	public MissionTheme fetchThemeById(int themeId) {
		return this.hibernateTemplate.get(MissionTheme.class, themeId);
	}
	@Transactional
	public boolean saveOrUpdateTheme(MissionTheme missionTheme) {
		this.hibernateTemplate.saveOrUpdate(missionTheme);
		return true;
	}

	public List<Skill> fetchSkillList() {
		return this.hibernateTemplate.loadAll(Skill.class);
	}

	public Skill fetchSkillById(int skillId) {
		return this.hibernateTemplate.get(Skill.class,skillId);
	}
	@Transactional
	public boolean saveOrUpdateSkill(Skill skill) {
		this.hibernateTemplate.saveOrUpdate(skill);
		return true;
	}

	public List<MissionApplication> fetchPendingApplications() {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="from MissionApplication as m where m.approvalStatus=:status";
		Query q=s.createQuery(hql);
		q.setParameter("status",ApprovalStatusMissionApplication.PENDING);
		return q.getResultList();
	}
	@Transactional
	public boolean updateStatusOfApplication(MissionApplicationIncomingDto application) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		s.beginTransaction();
		String hql="update MissionApplication as m set m.approvalStatus=:status where m.user.userId=:userId and m.mission.missionId=:missionId";
		Query q=s.createQuery(hql);
		q.setParameter("status",application.getStatus());
		q.setParameter("userId", application.getUserId());
		q.setParameter("missionId", application.getMissionId());
		q.executeUpdate();
		s.getTransaction().commit();
		return true;
	}

	public List<Story> fetchPendingStory() {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="from Story as s where s.status=:status";
		Query q=s.createQuery(hql);
		q.setParameter("status",StoryStatus.PENDING);
		return q.getResultList();
	}
	@Transactional
	public boolean updateStory(Story story) {
		this.hibernateTemplate.update(story);
		return true;
	}

	public User fetchUserById(int userId) {
		return this.hibernateTemplate.get(User.class,userId);
	}
	@Transactional
	public boolean updateUserProfile(User user) {
		this.hibernateTemplate.saveOrUpdate(user);
		return true;
	}

	public List<Mission> fetchAllMissions() {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="from Mission as m where m.deletedAt is null";
		Query q=s.createQuery(hql);
		return q.getResultList();
	}

	public Mission fetchMissionById(int missionId) {
		return this.hibernateTemplate.get(Mission.class,missionId);
	}
	@Transactional
	public boolean saveOrUpdateMission(Mission mission) {
		this.hibernateTemplate.saveOrUpdate(mission);
		return true;
	}

	public List<Banner> fetchBanners() {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="from Banner order by sortOrder desc";
		Query q=s.createQuery(hql);
		return q.getResultList();
	}

	public Banner fetchBannerById(int bannerId) {
		return this.hibernateTemplate.get(Banner.class,bannerId);
	}
	@Transactional
	public boolean addUpdateBanner(Banner banner) {
		this.hibernateTemplate.saveOrUpdate(banner);
		return true;
	}
	@Transactional
	public boolean deleteBanner(int bannerId) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		s.beginTransaction();
		String hql="update Banner set deletedAt=:time where bannerId=:bannerId";
		Query q=s.createQuery(hql);
		q.setParameter("time",new Date());
		q.setParameter("bannerId",bannerId);
		q.executeUpdate();
		s.getTransaction().commit();
		return true;
	}

	public boolean deleteUser(int userId) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		s.beginTransaction();
		String hql="update User set deletedAt=:time where userId=:userId";
		Query q=s.createQuery(hql);
		q.setParameter("time",new Date());
		q.setParameter("userId",userId);
		q.executeUpdate();
		s.getTransaction().commit();
		return true;
	}
	@Transactional
	public void lessSeatCountInMission(int missionId) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		s.beginTransaction();
		String hql="update Mission set seatLeft= seatLeft- 1 where missionId=:missionId and seatLeft is not null and seatLeft>0";
		Query q=s.createQuery(hql);
		q.setParameter("missionId", missionId);
		q.executeUpdate();
		s.getTransaction().commit();
	}
	@Transactional
	public boolean deleteSkillAlreadyPresentInMission(int missionId) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		s.beginTransaction();
		String hql="delete MissionSkill as m where m.missions.missionId=:missionId";
		Query q=s.createQuery(hql);
		q.setParameter("missionId", missionId);
		q.executeUpdate();
		s.getTransaction().commit();
		return true;
	}
	
}

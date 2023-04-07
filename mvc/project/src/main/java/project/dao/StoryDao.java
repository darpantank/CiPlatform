package project.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import project.model.Mission;
import project.model.MissionApplication;
import project.model.MissionMedia;
import project.model.MissionApplication.ApprovalStatusMissionApplication;
import project.model.MissionMedia.MediaDefault;
import project.model.Story.StoryStatus;
import project.model.Story;
import project.model.StoryMedia;
import project.model.User;
@Component
public class StoryDao implements StoryDaoInterface {
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
	public int saveStory(Story story) {
		int id=(Integer)this.hibernateTemplate.save(story);
		return id;
	}
	public Story getDraftMission(User user,Mission mission) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		String hql="from Story as m where m.mission=:mission and m.user=:user and m.status=:status";
		Query q=s.createQuery(hql);
		q.setParameter("mission", mission);
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
	

	
}

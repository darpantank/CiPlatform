package project.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import project.model.MissionApplication;
import project.model.MissionApplication.ApprovalStatusMissionApplication;
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

	
}

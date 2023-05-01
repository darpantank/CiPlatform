package com.ciplatform.dao;

import java.util.List;

import com.ciplatform.dto.MissionApplicationIncomingDto;
import com.ciplatform.model.Banner;
import com.ciplatform.model.CmsPage;
import com.ciplatform.model.Mission;
import com.ciplatform.model.MissionApplication;
import com.ciplatform.model.MissionTheme;
import com.ciplatform.model.Skill;
import com.ciplatform.model.Story;
import com.ciplatform.model.User;

public interface AdminDaoInterface {	
	List<User> fetchUsers();


//	Cms Operations
	List<CmsPage> fetchCmaList();
	boolean saveOrUpdateCms(CmsPage cmsPage);
	CmsPage fetchCmsById(int cmsId);


//	Mission Theme Operations
	List<MissionTheme> fetchThemeList();
	public MissionTheme fetchThemeById(int themeId);
	public boolean saveOrUpdateTheme(MissionTheme missionTheme);


	List<Skill> fetchSkillList();


	Skill fetchSkillById(int skillId);


	boolean saveOrUpdateSkill(Skill skill);


	List<MissionApplication> fetchPendingApplications();


	boolean updateStatusOfApplication(MissionApplicationIncomingDto application);


	List<Story> fetchPendingStory();


	boolean updateStory(Story story);


	User fetchUserById(int userId);


	boolean updateUserProfile(User user);


	List<Mission> fetchAllMissions();


	Mission fetchMissionById(int missionId);


	boolean saveOrUpdateMission(Mission mission);


	List<Banner> fetchBanners();


	Banner fetchBannerById(int bannerId);


	boolean addUpdateBanner(Banner banner);


	boolean deleteBanner(int bannerId);


	boolean deleteUser(int userId);


	void lessSeatCountInMission(int missionId);


	boolean deleteSkillAlreadyPresentInMission(int missionId);

}

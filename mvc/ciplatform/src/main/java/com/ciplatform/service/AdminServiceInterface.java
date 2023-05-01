package com.ciplatform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciplatform.dto.BannerIncomingDto;
import com.ciplatform.dto.BannerOutgoingDto;
import com.ciplatform.dto.CmsIncomingDto;
import com.ciplatform.dto.CmsOutgoingDto;
import com.ciplatform.dto.MissionApplicationIncomingDto;
import com.ciplatform.dto.MissionApplicationOutgoingDto;
import com.ciplatform.dto.MissionIncomingDto;
import com.ciplatform.dto.MissionOutgoingDto;
import com.ciplatform.dto.SkillDto;
import com.ciplatform.dto.StoryIncomingDto;
import com.ciplatform.dto.StoryOutgoingDto;
import com.ciplatform.dto.ThemeDto;
import com.ciplatform.dto.UserAdminPanelDto;
import com.ciplatform.dto.UserProfileDto;
import com.ciplatform.dto.UserProfileEditAdminDto;
import com.ciplatform.model.Banner;
import com.ciplatform.model.CmsPage;
import com.ciplatform.model.Mission;
import com.ciplatform.model.MissionTheme;
import com.ciplatform.model.Skill;
import com.ciplatform.model.User;

@Service
public interface AdminServiceInterface {
	List<UserAdminPanelDto> fetchUsers();
	boolean addUpdateCms(CmsIncomingDto cmsIncomingDto);
	List<CmsOutgoingDto> fetchCmsList();
	CmsPage fetchCms(int cmsId);
	boolean deleteCms(int cmsId);
	List<ThemeDto> fetchThemeList();
	MissionTheme fetchThemeById(int themeId);
	boolean addUpdatTheme(ThemeDto themeDto);
	boolean deleteTheme(int themeId);
	List<SkillDto> fetchSkillList();
	Skill fetchSkillById(int skillId);
	boolean addUpdateSkill(SkillDto skillDto);
	boolean deleteSkill(int skillId);
	List<MissionApplicationOutgoingDto> fetchPendingMissionsApplication();
	boolean updateMissionApplicationStatus(MissionApplicationIncomingDto application);
	List<StoryOutgoingDto> fetchPendingStory();
	boolean updateStoryStatus(StoryIncomingDto incomingDto);
	User fetchUserById(int userId);
	boolean updateUserProfile(UserProfileEditAdminDto profileEditAdminDto,String path);
	List<MissionOutgoingDto> fetchMissions();
	Mission fetchMissionById(int missionId);
	boolean addUpdateMission(MissionIncomingDto dto,String path);
	List<BannerOutgoingDto> fetchBanners();
	Banner fetchBannerById(int bannerId);
	boolean updateBanner(BannerIncomingDto bannerIncomingDto,String path);
	boolean deleteBanner(int bannerId);
	boolean deleteUserByAdmin(int userId);
}

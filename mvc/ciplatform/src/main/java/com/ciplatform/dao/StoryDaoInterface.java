package com.ciplatform.dao;

import java.util.List;

import com.ciplatform.dto.FindMissionFromUserDto;
import com.ciplatform.model.Mission;
import com.ciplatform.model.MissionApplication;
import com.ciplatform.model.Story;
import com.ciplatform.model.StoryMedia;
import com.ciplatform.model.User;

public interface StoryDaoInterface {

	List<MissionApplication> findMissionFromUser(User user);
	void saveStory(Story story);
	Story getDraftMission(User user, Mission mission);
	Story fetchStoryObjectById(int storyId);
	void deleteMediaOfStory(int storyId);
	Story getDetailStory(int storyId);
	Long getCountOfStory();
	List<Story> getStoriesByPageNo(int currentPage);
	void submitDraftedStory(int storyId, int userId);
	void recommandToCoWorkerStory(Story story, User sendFromUser, User sendToUser);
	void incrementPageViewCount(int storyId);
}

package project.dao;

import java.util.List;

import project.dto.FindMissionFromUserDto;
import project.model.Mission;
import project.model.MissionApplication;
import project.model.Story;
import project.model.StoryMedia;
import project.model.User;

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

package project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import project.dto.DraftStoryDto;
import project.dto.FindMissionFromUserDto;
import project.dto.StoryCardDto;
import project.dto.StoryDto;
import project.model.Mission;
import project.model.Story;
import project.model.User;

public interface StoryServiceIntereface {
	public List<FindMissionFromUserDto> findMissionOfUsers(User user);
	public void saveStoryOfUser(StoryDto storyDto, User user,HttpSession session);
	public DraftStoryDto getDraftMission(String missionId, User user);
	public Story getDetailStory(int storyId);
	public Long getCountOfStory();
	public List<StoryCardDto> getStoriesByPageNo(int currentPage);
	public void submitDraftedStory(int storyId, int userId);
	public void recommandToCoWorkerStory(int storyId, User sendFromUser, User sendToUser);
}

package com.ciplatform.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ciplatform.dto.DraftStoryDto;
import com.ciplatform.dto.FindMissionFromUserDto;
import com.ciplatform.dto.StoryCardDto;
import com.ciplatform.dto.StoryDto;
import com.ciplatform.model.Mission;
import com.ciplatform.model.Story;
import com.ciplatform.model.User;

public interface StoryServiceIntereface {
	public List<FindMissionFromUserDto> findMissionOfUsers(User user);
	public void saveStoryOfUser(StoryDto storyDto, User user,HttpSession session);
	public DraftStoryDto getDraftMission(String missionId, User user);
	public Story getDetailStory(int storyId);
	public Long getCountOfStory();
	public List<StoryCardDto> getStoriesByPageNo(int currentPage);
	public void submitDraftedStory(int storyId, int userId);
	public void recommandToCoWorkerStory(int storyId, User sendFromUser, User sendToUser);
	public void incrementPageViews(int storyId);
}

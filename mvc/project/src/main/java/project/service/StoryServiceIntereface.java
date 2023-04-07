package project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import project.dto.FindMissionFromUserDto;
import project.dto.StoryDto;
import project.model.Mission;
import project.model.Story;
import project.model.User;

public interface StoryServiceIntereface {
	public List<FindMissionFromUserDto> findMissionOfUsers(User user);
	public void saveStoryOfUser(StoryDto storyDto, User user,HttpSession session);
	public Story getDraftMission(String missionId, User user);
}

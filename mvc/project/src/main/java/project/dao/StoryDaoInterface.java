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
	int saveStory(Story story);
	Story getDraftMission(User user, Mission mission);
}

package project.dao;

import java.util.List;

import project.dto.FindMissionFromUserDto;
import project.model.Mission;
import project.model.MissionApplication;
import project.model.User;

public interface StoryDaoInterface {

	List<MissionApplication> findMissionFromUser(User user);
}

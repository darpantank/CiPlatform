package project.service;

import java.util.List;

import project.dto.FindMissionFromUserDto;
import project.model.Mission;
import project.model.User;

public interface StoryServiceIntereface {
	public List<FindMissionFromUserDto> findMissionOfUsers(User user);
}

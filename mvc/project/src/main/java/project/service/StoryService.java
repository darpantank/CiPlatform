package project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.StoryDaoInterface;
import project.dto.FindMissionFromUserDto;
import project.model.MissionApplication;
import project.model.User;

@Service
public class StoryService implements StoryServiceIntereface{
	
	@Autowired
	StoryDaoInterface storyDaoInterface;
	
	public List<FindMissionFromUserDto> findMissionOfUsers(User user){
		List<MissionApplication> myMissionApplicationList=this.storyDaoInterface.findMissionFromUser(user);
		List<FindMissionFromUserDto> myResultList=new ArrayList<FindMissionFromUserDto>();
		for(MissionApplication application:myMissionApplicationList) {
			FindMissionFromUserDto findMissionFromUserDto=new FindMissionFromUserDto();
			findMissionFromUserDto.setMissionId(application.getMission().getMission_id());
			findMissionFromUserDto.setMissionName(application.getMission().getTitle());
			myResultList.add(findMissionFromUserDto);
		}
		return myResultList;
	}
}

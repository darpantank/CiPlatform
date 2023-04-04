package project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.dao.MissionDaoInterface;
import project.dto.FetchMissionByUserDto;
import project.dto.FilterObjectDto;
import project.dto.MissionCommentDto;
import project.model.MissionDocument;
import project.model.City;
import project.model.Comment;
import project.model.Country;
import project.model.FavoriteMission;
import project.model.Mission;
import project.model.MissionTheme;
import project.model.Skill;
import project.model.User;
@Service
public class MissionService implements MissionServiceInterface {

	@Autowired
	MissionDaoInterface daoOfMission;
	public Map<Long,List<FetchMissionByUserDto>> loadAllMissionOnSearch(FilterObjectDto filters,User userId) {
		Map<Long,List<FetchMissionByUserDto>> map=new HashMap<Long,List<FetchMissionByUserDto>>();  
		List<Mission> missions;
		Long totalMission=0L;
		missions = this.daoOfMission.loadAllMissionOnSearch(filters);
		List<FetchMissionByUserDto> myMissionListWithFavourite=new ArrayList<FetchMissionByUserDto>();			
			for(Mission m:missions) {
				FetchMissionByUserDto fetchMissionWithFav=new FetchMissionByUserDto();
				Map<Double,Long> map1=this.daoOfMission.getRatingOfMission(m);
				fetchMissionWithFav.setMission(m);
				fetchMissionWithFav.setRating((Double)map1.keySet().toArray()[0]);
				fetchMissionWithFav.setRatingByNo((Long)map1.get(map1.keySet().toArray()[0]));
				if(userId==null) {
					fetchMissionWithFav.setFavourited(false);
				}
				else {					
					fetchMissionWithFav.setFavourited(this.daoOfMission.favouriteMission(userId,m));
				}
				myMissionListWithFavourite.add(fetchMissionWithFav);
			}
		totalMission = this.daoOfMission.countTotalEntry(filters);
		map.put(totalMission, myMissionListWithFavourite);
		return map;
	}

	public List<Country> loadListOfCountry() {
		return daoOfMission.loadListOfCountry();
	}

	public List<City> loadCityOfCountry(int country_id) {
		return this.daoOfMission.loadCityOfCountry(country_id);
	}

	public List<MissionTheme> loadAllThemes() {
		return this.daoOfMission.loadAllThemes();
	}
	public List<Skill> loadAllSkills() {
		return this.daoOfMission.loadAllSkill();
	}

	public Mission fetchMissionById(int mission_id) {
		return this.daoOfMission.fetchMissionById(mission_id);
	}
	public boolean addToFavourite(FavoriteMission myATF) {
		//convert dto to favorite_mission object
		return this.daoOfMission.addFavourite(myATF);
	}
	public boolean favouriteMission(User user,Mission mission) {
		return this.daoOfMission.favouriteMission(user, mission);
	}
	public Map<Double,Long> ratingOfMission(Mission mission) {
		return daoOfMission.getRatingOfMission(mission);
	}
	public List<MissionDocument> getDocumentOfMission(Mission mission) {
		return this.daoOfMission.getDocumentOfMission(mission);
	}

	public List<FetchMissionByUserDto> getRelatedMission(Mission mission,User user) {
		List<Mission> missions=this.daoOfMission.getRelatedMissions(mission);
		if(missions.size()>3) {
			missions=missions.subList(0,3);
		}
		List<FetchMissionByUserDto> missionWithData=new ArrayList<FetchMissionByUserDto>();
		for(Mission m:missions) {
			FetchMissionByUserDto temp=new FetchMissionByUserDto();
			temp.setMission(m);
			temp.setFavourited(this.daoOfMission.favouriteMission(user, m));
			Map<Double,Long> map=this.daoOfMission.getRatingOfMission(m);
			temp.setRating((Double)map.keySet().toArray()[0]);
			missionWithData.add(temp);
		}
		return missionWithData;
	}

	public Boolean ratingToMission(User myuser, Mission myMission, int rating) {
		return this.daoOfMission.ratingToMission(myuser,myMission,rating);
	}
	public int ratingOfParticularUser(User myUser,Mission myMission) {
		return this.daoOfMission.ratingOfMissionOfParticularUser(myUser,myMission);
	}

	public void recommandToCoWorker(Mission myMission, User sendFromUser, User sendToUser) {
		String msg="<!DOCTYPE html><h2>Your Friend "+sendFromUser.getFirst_name()+" "+sendFromUser.getLast_name()+" is recommand to you for this mission</h2><h3>Click Below Button to Open Mission</h3> <br><a href='http://localhost:8080/project/getMyMission?mission_id="+myMission.getMission_id()+"' class='btn btn-success'>Click Here</a>";
		String subject="Ci-Platform Recommandation Link";
		if(SendMail.send(sendToUser.getEmail(), msg,subject)) {			
			this.daoOfMission.recommandToCoWorker(myMission,sendFromUser,sendToUser);
		}
	}

	public List<MissionCommentDto> loadCommentsOfMission(Mission myMission) {
		List<Comment> myListOfComments=this.daoOfMission.loadAllCommentsOfMission(myMission);
		List<MissionCommentDto> listOfCommentsDto=new ArrayList<MissionCommentDto>();
		for(Comment comment:myListOfComments) {
			MissionCommentDto commentDto=new MissionCommentDto();
			commentDto.setAvatar(comment.getUser().getAvatar());
			commentDto.setComment(comment.getComment());
			commentDto.setName(comment.getUser().getFirst_name()+" "+comment.getUser().getLast_name());
			listOfCommentsDto.add(commentDto);
		}
		return listOfCommentsDto;
	}
}

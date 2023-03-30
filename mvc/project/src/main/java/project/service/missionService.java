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

import project.dao.missionDaoInterface;
import project.dto.FetchMissionByUser;
import project.dto.FilterObject;
import project.model.city;
import project.model.country;
import project.model.favorite_mission;
import project.model.mission;
import project.model.mission_theme;
import project.model.skill;
import project.model.user;
@Service
public class missionService implements missionServiceInterface {

	@Autowired
	missionDaoInterface daoOfMission;
	public Map<Long,List<FetchMissionByUser>> loadAllMissionOnSearch(FilterObject filters,user userId) {
		Map<Long,List<FetchMissionByUser>> map=new HashMap<Long,List<FetchMissionByUser>>();  
		List<mission> missions;
		Long totalMission=0L;
		missions = this.daoOfMission.loadAllMissionOnSearch(filters);
		List<FetchMissionByUser> myMissionListWithFavourite=new ArrayList<FetchMissionByUser>();			
			for(mission m:missions) {
				FetchMissionByUser fetchMissionWithFav=new FetchMissionByUser();
				fetchMissionWithFav.setMission(m);
				fetchMissionWithFav.setRating(this.daoOfMission.getRatingOfMission(m));
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

	public List<country> loadListOfCountry() {
		return daoOfMission.loadListOfCountry();
	}

	public List<city> loadCityOfCountry(int country_id) {
		return this.daoOfMission.loadCityOfCountry(country_id);
	}

	public List<mission_theme> loadAllThemes() {
		return this.daoOfMission.loadAllThemes();
	}
	public List<skill> loadAllSkills() {
		return this.daoOfMission.loadAllSkill();
	}

	public mission fetchMissionById(int mission_id) {
		return this.daoOfMission.fetchMissionById(mission_id);
	}
	public boolean addToFavourite(favorite_mission myATF) {
		//convert dto to favorite_mission object
		return this.daoOfMission.addFavourite(myATF);
	}
	public boolean favouriteMission(user user,mission mission) {
		return this.daoOfMission.favouriteMission(user, mission);
	}
}

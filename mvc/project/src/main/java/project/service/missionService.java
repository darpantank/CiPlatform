package project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.dao.missionDaoInterface;
import project.dto.AddToFavourite;
import project.dto.FilterObject;
import project.model.city;
import project.model.country;
import project.model.favorite_mission;
import project.model.mission;
import project.model.mission_theme;
import project.model.skill;
@Service
public class missionService implements missionServiceInterface {

	@Autowired
	missionDaoInterface daoOfMission;
	public Map<Long,List<mission>> loadAllMissionOnSearch(FilterObject filters) {
		Map<Long,List<mission>> map=new HashMap<Long,List<mission>>();  
		List<mission> missions;
		Long totalMission=0L;
		missions = this.daoOfMission.loadAllMissionOnSearch(filters);
		totalMission = this.daoOfMission.countTotalEntry(filters);
		map.put(totalMission, missions);
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
	
}

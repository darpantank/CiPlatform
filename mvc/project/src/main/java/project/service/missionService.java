package project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.dao.missionDaoInterface;
import project.dto.FilterObject;
import project.model.city;
import project.model.country;
import project.model.mission;
import project.model.mission_theme;
import project.model.skill;
@Service
public class missionService implements missionServiceInterface {

	@Autowired
	missionDaoInterface daoOfMission;
	public String loadAllMissionOnSearch(FilterObject filters) {
		Map<Long,List<mission>> map=new HashMap<Long,List<mission>>();  
		List<mission> missions;
		Long totalMission=0L;
		String Output="";
		ObjectMapper obj=new ObjectMapper();
		try{
			missions=this.daoOfMission.loadAllMissionOnSearch(filters);
			totalMission=this.daoOfMission.countTotalEntry(filters);
			map.put(totalMission,missions);
			Output=obj.writeValueAsString(map);
		}
		catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return Output;
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
	
}

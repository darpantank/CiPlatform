package project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<mission> loadAllMission() {
		return this.daoOfMission.loadAllMission();
	}
	public List<mission> loadAllMissionOnSearch(FilterObject filters) {
		return this.daoOfMission.loadAllMissionOnSearch(filters);
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

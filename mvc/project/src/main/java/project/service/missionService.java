package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.missionDaoInterface;
import project.model.city;
import project.model.country;
import project.model.mission;
import project.model.mission_theme;
@Service
public class missionService implements missionServiceInterface {

	@Autowired
	missionDaoInterface daoOfMission;
	
	public List<mission> loadAllMission() {
		return this.daoOfMission.loadAllMission();
	}
	public List<mission> loadAllMissionOnSearch(String keywords) {
		return this.daoOfMission.loadAllMissionOnSearch(keywords);
	}

	public List<country> loadListOfCountry() {
		return daoOfMission.loadListOfCountry();
	}

	public List<city> loadCityOfCountry(int country_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<mission_theme> loadAllThemes() {
		return this.daoOfMission.loadAllThemes();
	}
	
}

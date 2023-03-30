package project.dao;

import java.util.List;

import project.dto.FilterObject;
import project.model.city;
import project.model.country;
import project.model.favorite_mission;
import project.model.mission;
import project.model.mission_theme;
import project.model.skill;
import project.model.user;


public interface missionDaoInterface {
	public List<mission> loadAllMissionOnSearch(FilterObject filters);
	public List<country> loadListOfCountry();
	public List<city> loadCityOfCountry(int country_id);
	public List<mission_theme> loadAllThemes();
	public List<skill> loadAllSkill();
	public long countTotalEntry(FilterObject filters);
	public mission fetchMissionById(int mission_id);
	public boolean addFavourite(favorite_mission myFavMission);
	public boolean favouriteMission(user userId,mission missionId);
	public Double getRatingOfMission(mission mission);
}

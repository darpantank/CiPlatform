package project.dao;

import java.util.List;

import project.model.city;
import project.model.country;
import project.model.mission;
import project.model.mission_theme;


public interface missionDaoInterface {
	public List<mission> loadAllMissionOnSearch(String keywords);
	public List<country> loadListOfCountry();
	public List<city> loadCityOfCountry(int country_id);
	public List<mission_theme> loadAllThemes();
	public List<mission> loadAllMission();
}

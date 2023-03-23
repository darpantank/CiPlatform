package project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.dto.FilterObject;
import project.model.city;
import project.model.country;
import project.model.mission;
import project.model.mission_theme;
@Service
public interface missionServiceInterface {
	public List<mission> loadAllMissionOnSearch(FilterObject filters);
	public List<country> loadListOfCountry();
	public List<city> loadCityOfCountry(int country_id);
	public List<mission_theme> loadAllThemes();
	public List<mission> loadAllMission();
}

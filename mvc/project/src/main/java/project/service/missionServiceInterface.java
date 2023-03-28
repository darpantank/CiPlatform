package project.service;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import project.dto.FilterObject;
import project.model.city;
import project.model.country;
import project.model.favorite_mission;
import project.model.mission;
import project.model.mission_theme;
import project.model.skill;
@Service
public interface missionServiceInterface {
	public Map<Long,List<mission>> loadAllMissionOnSearch(FilterObject filters);
	public List<country> loadListOfCountry();
	public List<city> loadCityOfCountry(int country_id);
	public List<mission_theme> loadAllThemes();
	public List<skill> loadAllSkills();
	public mission fetchMissionById(int mission_id);
	public boolean addToFavourite(favorite_mission myATF);
}

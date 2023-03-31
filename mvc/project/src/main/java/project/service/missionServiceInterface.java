package project.service;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import project.dto.FetchMissionByUser;
import project.dto.FilterObject;
import project.model.MissionDocument;
import project.model.city;
import project.model.country;
import project.model.favorite_mission;
import project.model.mission;
import project.model.mission_theme;
import project.model.skill;
import project.model.user;
@Service
public interface missionServiceInterface {
	public Map<Long,List<FetchMissionByUser>> loadAllMissionOnSearch(FilterObject filters,user userId);
	public List<country> loadListOfCountry();
	public List<city> loadCityOfCountry(int country_id);
	public List<mission_theme> loadAllThemes();
	public List<skill> loadAllSkills();
	public mission fetchMissionById(int mission_id);
	public boolean addToFavourite(favorite_mission myATF);
	public boolean favouriteMission(user user,mission mission);
	public int ratingOfMission(mission mission);
	public List<MissionDocument> getDocumentOfMission(mission mission);
	public List<FetchMissionByUser> getRelatedMission(mission mission,user user);
}

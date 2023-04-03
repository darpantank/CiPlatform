package project.dao;

import java.util.List;
import java.util.Map;

import project.dto.FilterObjectDto;
import project.model.MissionDocument;
import project.model.City;
import project.model.Country;
import project.model.FavoriteMission;
import project.model.Mission;
import project.model.MissionTheme;
import project.model.Skill;
import project.model.User;


public interface MissionDaoInterface {
	public List<Mission> loadAllMissionOnSearch(FilterObjectDto filters);
	public List<Country> loadListOfCountry();
	public List<City> loadCityOfCountry(int country_id);
	public List<MissionTheme> loadAllThemes();
	public List<Skill> loadAllSkill();
	public long countTotalEntry(FilterObjectDto filters);
	public Mission fetchMissionById(int mission_id);
	public boolean addFavourite(FavoriteMission myFavMission);
	public boolean favouriteMission(User userId,Mission missionId);
	public Map<Double, Long> getRatingOfMission(Mission mission);
	public List<MissionDocument> getDocumentOfMission(Mission mission);
	public List<Mission> getRelatedMissions(Mission MyMission);
	public Boolean ratingToMission(User myuser, Mission myMission, int rating);
	public int ratingOfMissionOfParticularUser(User myUser, Mission myMission);
}

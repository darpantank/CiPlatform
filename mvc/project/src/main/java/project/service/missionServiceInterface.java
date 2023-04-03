package project.service;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import project.dto.FetchMissionByUserDto;
import project.dto.FilterObjectDto;
import project.model.MissionDocument;
import project.model.City;
import project.model.Country;
import project.model.FavoriteMission;
import project.model.Mission;
import project.model.MissionTheme;
import project.model.Skill;
import project.model.User;
@Service
public interface MissionServiceInterface {
	public Map<Long,List<FetchMissionByUserDto>> loadAllMissionOnSearch(FilterObjectDto filters,User userId);
	public List<Country> loadListOfCountry();
	public List<City> loadCityOfCountry(int country_id);
	public List<MissionTheme> loadAllThemes();
	public List<Skill> loadAllSkills();
	public Mission fetchMissionById(int mission_id);
	public boolean addToFavourite(FavoriteMission myATF);
	public boolean favouriteMission(User user,Mission mission);
	public Map<Double,Long> ratingOfMission(Mission mission);
	public List<MissionDocument> getDocumentOfMission(Mission mission);
	public List<FetchMissionByUserDto> getRelatedMission(Mission mission,User user);
	public Boolean ratingToMission(User myuser, Mission myMission, int rating);
	public int ratingOfParticularUser(User myUser,Mission myMission);
}

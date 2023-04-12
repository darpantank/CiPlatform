package project.dao;

import java.util.List;
import java.util.Map;

import project.dto.FilterObjectDto;
import project.model.MissionDocument;
import project.model.MissionMedia;
import project.model.City;
import project.model.Comment;
import project.model.Country;
import project.model.FavoriteMission;
import project.model.Mission;
import project.model.MissionApplication;
import project.model.MissionTheme;
import project.model.Skill;
import project.model.Story;
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
	public int ratingOfMissionByParticularUser(User myUser, Mission myMission);
	public void recommandToCoWorker(Mission myMission, User sendFromUser, User sendToUser);
	public List<Comment> loadAllCommentsOfMission(Mission myMission);
	public void postUserComment(User user, Mission mission, String commentText);
	public long countTotalVolunteersInMission(Mission mission);
	public List<MissionApplication> getVolunteersOfMission(Mission mission, int pageNumber);
	public List<MissionMedia> getMediaOfMission(Mission mission);
	public String findDefaultMediaOfMission(Mission m);
}

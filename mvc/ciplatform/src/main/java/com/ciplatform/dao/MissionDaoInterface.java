package com.ciplatform.dao;

import java.util.List;
import java.util.Map;

import com.ciplatform.dto.FilterObjectDto;
import com.ciplatform.model.City;
import com.ciplatform.model.Comment;
import com.ciplatform.model.Country;
import com.ciplatform.model.FavoriteMission;
import com.ciplatform.model.Mission;
import com.ciplatform.model.MissionApplication;
import com.ciplatform.model.MissionDocument;
import com.ciplatform.model.MissionMedia;
import com.ciplatform.model.MissionTheme;
import com.ciplatform.model.Skill;
import com.ciplatform.model.Story;
import com.ciplatform.model.User;


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
	public boolean isAppliedForMission(Mission m, User userId);
	public Long countApplicationForMission(Mission m);
	public boolean applyForMission(MissionApplication application);
	public int calculateGoalOfMission(Mission m);
}

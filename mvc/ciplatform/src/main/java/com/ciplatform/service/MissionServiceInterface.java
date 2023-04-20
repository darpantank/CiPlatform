package com.ciplatform.service;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ciplatform.dto.FetchMissionByUserDto;
import com.ciplatform.dto.FilterObjectDto;
import com.ciplatform.dto.MissionCommentDto;
import com.ciplatform.dto.MissionVolunteerIncomingDto;
import com.ciplatform.dto.MissionVolunteersOutgoingDto;
import com.ciplatform.dto.PostCommentDto;
import com.ciplatform.model.City;
import com.ciplatform.model.Country;
import com.ciplatform.model.FavoriteMission;
import com.ciplatform.model.Mission;
import com.ciplatform.model.MissionDocument;
import com.ciplatform.model.MissionMedia;
import com.ciplatform.model.MissionTheme;
import com.ciplatform.model.Skill;
import com.ciplatform.model.User;
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
	public void recommandToCoWorker(Mission myMission, User sendFromUser, User sendToUser);
	public List<MissionCommentDto> loadCommentsOfMission(Mission myMission);
	public void postComment(PostCommentDto postCommentDto,User user);
	public long fetchTotalVolunteersInMisson(Mission mission);
	public List<MissionVolunteersOutgoingDto> getVolunteersOfMission(MissionVolunteerIncomingDto missionVolunteerIncomingDto);
	public List<MissionMedia> getMediaofMission(Mission mission);
	public boolean applyForMission(Mission mission, User user);
	public boolean isAppliedForMission(Mission mission,User user);
}

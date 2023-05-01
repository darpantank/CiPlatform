package com.ciplatform.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ciplatform.dao.AdminDaoInterface;
import com.ciplatform.dao.StoryDaoInterface;
import com.ciplatform.dao.UserDaoInterface;
import com.ciplatform.dto.BannerIncomingDto;
import com.ciplatform.dto.BannerOutgoingDto;
import com.ciplatform.dto.CmsIncomingDto;
import com.ciplatform.dto.CmsOutgoingDto;
import com.ciplatform.dto.MissionApplicationIncomingDto;
import com.ciplatform.dto.MissionApplicationOutgoingDto;
import com.ciplatform.dto.MissionIncomingDto;
import com.ciplatform.dto.MissionOutgoingDto;
import com.ciplatform.dto.SkillDto;
import com.ciplatform.dto.StoryIncomingDto;
import com.ciplatform.dto.StoryOutgoingDto;
import com.ciplatform.dto.ThemeDto;
import com.ciplatform.dto.UserAdminPanelDto;
import com.ciplatform.dto.UserProfileDto;
import com.ciplatform.dto.UserProfileEditAdminDto;
import com.ciplatform.enums.ApprovalStatusMissionApplication;
import com.ciplatform.enums.MediaDefault;
import com.ciplatform.enums.MissionType;
import com.ciplatform.enums.Role;
import com.ciplatform.enums.Status;
import com.ciplatform.model.Banner;
import com.ciplatform.model.City;
import com.ciplatform.model.CmsPage;
import com.ciplatform.model.Country;
import com.ciplatform.model.GoalMission;
import com.ciplatform.model.Mission;
import com.ciplatform.model.MissionApplication;
import com.ciplatform.model.MissionDocument;
import com.ciplatform.model.MissionMedia;
import com.ciplatform.model.MissionSkill;
import com.ciplatform.model.MissionTheme;
import com.ciplatform.model.Skill;
import com.ciplatform.model.Story;
import com.ciplatform.model.StoryMedia;
import com.ciplatform.model.User;

@Service
public class AdminService implements AdminServiceInterface {
	@Autowired
	AdminDaoInterface daoOperation;
	@Autowired
	StoryDaoInterface storyDaoOpration;
	@Autowired
	UserDaoInterface userDaoOpration;
	private final String savePath="uploadFiles/";
	public List<UserAdminPanelDto> fetchUsers() {
		List<User> users=this.daoOperation.fetchUsers();
		List<UserAdminPanelDto> profileDtos=new ArrayList<UserAdminPanelDto>();
		if(users.size()>0) {
			for(User user:users) {
				UserAdminPanelDto profileDto=new UserAdminPanelDto();
				profileDto.setFirstName(user.getFirstName());
				profileDto.setLastName(user.getLastName());
				profileDto.setEmail(user.getEmail());
				profileDto.setDepartment(user.getDepartment());
				profileDto.setEmployeeId(user.getEmployeeId());
				profileDto.setStatus(user.getStatus().toString());
				profileDto.setUserId(user.getUserId());
				profileDtos.add(profileDto);
			}
		}
		return profileDtos;
	}

	public boolean addUpdateCms(CmsIncomingDto cmsIncomingDto) {
		CmsPage cmsPage=new CmsPage();
		if(cmsIncomingDto.getCmsId()==0)
		{
			cmsPage.setDescription(cmsIncomingDto.getDescription());
			cmsPage.setSlug(cmsIncomingDto.getSlug());
			cmsPage.setStatus(cmsIncomingDto.getStatus());
			cmsPage.setTitle(cmsIncomingDto.getTitle());
		}
		else {
			try {				
				cmsPage=this.daoOperation.fetchCmsById(cmsIncomingDto.getCmsId());
			}
			catch(DataAccessException e) {
				e.printStackTrace();
			}
			if(cmsPage==null) {
				return false;
			}
			else {
				cmsPage.setDescription(cmsIncomingDto.getDescription());
				cmsPage.setSlug(cmsIncomingDto.getSlug());
				cmsPage.setStatus(cmsIncomingDto.getStatus());
				cmsPage.setTitle(cmsIncomingDto.getTitle());
			}
		}
		return this.daoOperation.saveOrUpdateCms(cmsPage);
	}

	public List<CmsOutgoingDto> fetchCmsList() {
		List<CmsPage> myCmsList=this.daoOperation.fetchCmaList();
		List<CmsOutgoingDto> myCmsDtoList=new ArrayList<CmsOutgoingDto>();
		for(CmsPage cmsPage:myCmsList) {
			CmsOutgoingDto outgoingDto=new CmsOutgoingDto();
			outgoingDto.setCmsId(cmsPage.getCmsPageId());
			outgoingDto.setStatus(cmsPage.getStatus());
			outgoingDto.setTitle(cmsPage.getTitle());
			myCmsDtoList.add(outgoingDto);
		}
		return myCmsDtoList;
	}

	public CmsPage fetchCms(int cmsId) {
		return this.daoOperation.fetchCmsById(cmsId);
	}

	public boolean deleteCms(int cmsId) {
		CmsPage cmsPage=new CmsPage();
		cmsPage=daoOperation.fetchCmsById(cmsId);
		if(cmsPage==null) {
			return false;
		}
		cmsPage.setDeletedAt(new Date());
		return this.daoOperation.saveOrUpdateCms(cmsPage);
		
	}

	public List<ThemeDto> fetchThemeList() {
		List<MissionTheme> missionThemes=this.daoOperation.fetchThemeList();
		List<ThemeDto> outgoingDtos=new ArrayList<ThemeDto>();
		for(MissionTheme theme: missionThemes) {
			ThemeDto dto=new ThemeDto();
			dto.setTitle(theme.getTitle());
			dto.setStatus(theme.getStatus());
			dto.setThemeId(theme.getMissionThemeId());
			outgoingDtos.add(dto);
		}
		return outgoingDtos;
	}

	public MissionTheme fetchThemeById(int themeId) {
		return this.daoOperation.fetchThemeById(themeId);
	}

	public boolean addUpdatTheme(ThemeDto themeDto) {
		MissionTheme missionTheme=new MissionTheme();
		if(themeDto.getThemeId()==0)
		{
			missionTheme.setStatus(themeDto.getStatus());
			missionTheme.setTitle(themeDto.getTitle());
		}
		else {
			try {				
				missionTheme=this.daoOperation.fetchThemeById(themeDto.getThemeId());
			}
			catch(DataAccessException e) {
				e.printStackTrace();
			}
			if(missionTheme==null) {
				return false;
			}
			else {
				missionTheme.setStatus(themeDto.getStatus());
				missionTheme.setTitle(themeDto.getTitle());
			}
		}
		return this.daoOperation.saveOrUpdateTheme(missionTheme);
	}

	public boolean deleteTheme(int themeId) {
		MissionTheme missionTheme=new MissionTheme();
		missionTheme=daoOperation.fetchThemeById(themeId);
		if(missionTheme==null) {
			return false;
		}
		missionTheme.setDeletedAt(new Date());
		return this.daoOperation.saveOrUpdateTheme(missionTheme);
	}


	public Skill fetchSkillById(int skillId) {
		return this.daoOperation.fetchSkillById(skillId);
	}

	public boolean addUpdateSkill(SkillDto skillDto) {
		Skill skill=new Skill();
		if(skillDto.getSkillId()==0)
		{
			skill.setStatus(skillDto.getStatus());
			skill.setSkillName(skillDto.getSkillName());
		}
		else {
			try {				
				skill=this.daoOperation.fetchSkillById(skillDto.getSkillId());
			}
			catch(DataAccessException e) {
				e.printStackTrace();
			}
			if(skill==null) {
				return false;
			}
			else {
				skill.setStatus(skillDto.getStatus());
				skill.setSkillName(skillDto.getSkillName());
			}
		}
		return this.daoOperation.saveOrUpdateSkill(skill);
	}

	public boolean deleteSkill(int skillId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<SkillDto> fetchSkillList() {
		List<Skill> skills=this.daoOperation.fetchSkillList();
		List<SkillDto> outgoingDtos=new ArrayList<SkillDto>();
		for(Skill skill: skills) {
			SkillDto dto=new SkillDto();
			dto.setSkillName(skill.getSkillName());
			dto.setSkillId(skill.getSkillId());
			dto.setStatus(skill.getStatus());
			outgoingDtos.add(dto);
		}
		return outgoingDtos;
	}

	public List<MissionApplicationOutgoingDto> fetchPendingMissionsApplication() {
		List<MissionApplication> applications=new ArrayList<MissionApplication>();
		List<MissionApplicationOutgoingDto> applicationsDto=new ArrayList<MissionApplicationOutgoingDto>();
		applications=this.daoOperation.fetchPendingApplications();
		for(MissionApplication application:applications) {
			MissionApplicationOutgoingDto dto=new MissionApplicationOutgoingDto();
			dto.setAppliedDate(application.getCreatedAt());
			dto.setMissionId(application.getMission().getMissionId());
			dto.setMissionTitle(application.getMission().getTitle());
			dto.setUserId(application.getUser().getUserId());
			dto.setUserName(application.getUser().getFirstName()+" "+application.getUser().getLastName());
			applicationsDto.add(dto);
		}
		return applicationsDto;
	}

	public boolean updateMissionApplicationStatus(MissionApplicationIncomingDto application) {
		if(application.getStatus()==ApprovalStatusMissionApplication.APPROVE) {
			//left seat in db
			if(application.getMissionId()!=0) {				
				this.daoOperation.lessSeatCountInMission(application.getMissionId());
			}
		}
		return this.daoOperation.updateStatusOfApplication(application);
	}

	public List<StoryOutgoingDto> fetchPendingStory() {
		List<Story> stories=this.daoOperation.fetchPendingStory();
		List<StoryOutgoingDto> storyOutgoingDtos=new ArrayList<StoryOutgoingDto>();
		for(Story story:stories) {
			StoryOutgoingDto dto=new StoryOutgoingDto();
			dto.setMissionTitle(story.getMission().getTitle());
			dto.setStoryId(story.getStoryId());
			dto.setStoryTitle(story.getTitle());
			dto.setUserName(story.getUser().getFirstName()+" "+story.getUser().getLastName());
			storyOutgoingDtos.add(dto);
		}
		return storyOutgoingDtos;
	}

	public boolean updateStoryStatus(StoryIncomingDto incomingDto) {
		Story story=this.storyDaoOpration.fetchStoryObjectById(incomingDto.getStoryId());
		if(story==null) {
			return false;
		}
		else {
			story.setStatus(incomingDto.getStatus());
			if(incomingDto.isDeleteStory()) {
				story.setDeletedAt(new Date());
			}
			System.out.println(story);
			return this.daoOperation.updateStory(story);
		}
		
	}

	public User fetchUserById(int userId) {
		return this.daoOperation.fetchUserById(userId);
	}

	public boolean updateUserProfile(UserProfileEditAdminDto userProfileDto,String path) {
		User user=new User();
		if(userProfileDto.getUserId()==0) {
			user.setFirstName(userProfileDto.getFirstName());
			user.setLastName(userProfileDto.getLastName());
			user.setEmployeeId(userProfileDto.getEmployeeId());
			user.setDepartment(userProfileDto.getDepartment());
			user.setProfileText(userProfileDto.getProfileText());
			user.setEmail(userProfileDto.getEmail());
			user.setPassword(userProfileDto.getPassword());
			user.setStatus(Status.ACTIVE);
			user.setRole(Role.USER);
			if(userProfileDto.getCountryId()!=0) {
				Country country=new Country();
				country=this.userDaoOpration.getCountryObject(userProfileDto.getCountryId());
				if(country!=null&&country!=user.getCountry()) {
					user.setCountry(country);
				}
			}
			
//			check for city
			
			if(userProfileDto.getCityId()!=0) {
				City city=new City();
				city=this.userDaoOpration.getCityObject(userProfileDto.getCityId());
				if(city!=null&&city!=user.getCity()) {
					user.setCity(city);
				}
			}
			if(userProfileDto.getAvatar()!=null&&userProfileDto.getAvatar().getSize()>0) {
				CommonsMultipartFile file=userProfileDto.getAvatar();
				String timeStamp=String.valueOf(System.currentTimeMillis());
		        String finalPath=path.concat("WEB-INF/").concat(savePath);
		        try {
					byte barr[] = file.getBytes();
					String extension="."+FilenameUtils.getExtension(file.getOriginalFilename());
					String userName = user.getFirstName().trim().replaceAll("\\s", "");
					String filename=userName+user.getUserId()+timeStamp+extension;
					String fos = finalPath + filename;
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fos));
					bout.write(barr);
//	    			if successfully saved than Entry into Db 
					String dbPath = savePath + filename;
					user.setAvatar(dbPath);
					bout.flush();
					bout.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else {
			user=this.daoOperation.fetchUserById(userProfileDto.getUserId());
			user.setStatus(userProfileDto.getStatus());
			if(!user.getPassword().equals(userProfileDto.getPassword())) {
				user.setPassword(userProfileDto.getPassword());
			}
			if(!user.getFirstName().equals(userProfileDto.getFirstName())) {
				user.setFirstName(userProfileDto.getFirstName());
			}
//			check lastName Updated Or not
			
			if(!user.getLastName().equals(userProfileDto.getLastName())) {
				user.setLastName(userProfileDto.getLastName());
			}
//			check EmployeeId Updated Or not
				user.setEmployeeId(userProfileDto.getEmployeeId());
//			check department Updated Or not
				user.setDepartment(userProfileDto.getDepartment());
//			check profile Updated Or not
				user.setProfileText(userProfileDto.getProfileText());
				
//				Check For Country
				if(userProfileDto.getCountryId()!=0) {
					Country country=new Country();
					country=this.userDaoOpration.getCountryObject(userProfileDto.getCountryId());
					if(country!=null&&country!=user.getCountry()) {
						user.setCountry(country);
					}
				}
				
//				check for city
				
				if(userProfileDto.getCityId()!=0) {
					City city=new City();
					city=this.userDaoOpration.getCityObject(userProfileDto.getCityId());
					if(city!=null&&city!=user.getCity()) {
						user.setCity(city);
					}
				}
				if(userProfileDto.getAvatar()!=null&&userProfileDto.getAvatar().getSize()>0) {
					CommonsMultipartFile file=userProfileDto.getAvatar();
					String timeStamp=String.valueOf(System.currentTimeMillis());
			        String finalPath=path.concat("WEB-INF/").concat(savePath);
			        try {
						byte barr[] = file.getBytes();
						String extension="."+FilenameUtils.getExtension(file.getOriginalFilename());
						String userName = user.getFirstName().trim().replaceAll("\\s", "");
						String filename=userName+user.getUserId()+timeStamp+extension;
						String fos = finalPath + filename;
						System.out.println(fos);
						BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fos));
						bout.write(barr);
//		    			if successfully saved than Entry into Db 
						String dbPath = savePath + filename;
						user.setAvatar(dbPath);
						bout.flush();
						bout.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				
		}
		return this.daoOperation.updateUserProfile(user);
	}

	public List<MissionOutgoingDto> fetchMissions() {
		List<Mission> missions=this.daoOperation.fetchAllMissions();
		List<MissionOutgoingDto> missionsDto=new ArrayList<MissionOutgoingDto>();
		for(Mission mission:missions) {
			MissionOutgoingDto dto=new MissionOutgoingDto();
			dto.setMissionId(mission.getMissionId());
			dto.setMissionTitle(mission.getTitle());
			dto.setMissionType(mission.getMissionType());
			dto.setStartDate(mission.getStartDate());
			dto.setEndDate(mission.getEndDate());
			missionsDto.add(dto);
		}
		return missionsDto;
	}

	public Mission fetchMissionById(int missionId) {
		return this.daoOperation.fetchMissionById(missionId);
	}

	public boolean addUpdateMission(MissionIncomingDto dto,String path) {
		Mission mission=new Mission();
		if(dto.getMissionId()==0) {			
			if(dto.getTitle()!=null) {				
				mission.setTitle(dto.getTitle());
			}
			if(dto.getOrganizationName()!=null) {
				mission.setOrganizationName(dto.getOrganizationName());
			}
			if(dto.getOrganizationDetail()!=null) {
				mission.setOrganizationDetail(dto.getOrganizationDetail());
			}
			if(dto.getAvailability()!=null) {				
				mission.setAvailability(dto.getAvailability());
			}
			if(dto.getStartDate()!=null) {
				mission.setStartDate(dto.getStartDate());
			}
			if(dto.getEndDate()!=null) {
				mission.setEndDate(dto.getEndDate());
			}
			if(dto.getStatus()!=null) {
				mission.setStatus(dto.getStatus());
			}
			if(dto.getShortDescription()!=null) {
				mission.setShortDescription(dto.getShortDescription());
			}
			if(dto.getDescription()!=null) {
				mission.setDescription(dto.getDescription());
			}
			if(dto.getMissionType()!=null) {
				mission.setMissionType(dto.getMissionType());
			}
			if(dto.getMissionType()==MissionType.GOAL) {
				//for goal Based
				GoalMission goalMission=new GoalMission();
				goalMission.setGoalObjectiveText(dto.getGoalObjectiveText());
				goalMission.setGoalValue(dto.getGoalValue());
				goalMission.setMission(mission);
				mission.setGoalMission(goalMission);
			}
			if(dto.getMissionType()==MissionType.TIME) {
//				For Time Based
				mission.setTotalSeat(dto.getTotalSeat());
				mission.setSeatLeft(dto.getTotalSeat());
				mission.setDeadline(dto.getDeadline());
			}
//			Check For Country
			if(dto.getCountryId()!=0) {
				Country country=new Country();
				country=this.userDaoOpration.getCountryObject(dto.getCountryId());
				if(country!=null) {
					mission.setCountry(country);
				}
			}
			
//			check for city
			
			if(dto.getCityId()!=0) {
				City city=new City();
				city=this.userDaoOpration.getCityObject(dto.getCityId());
				if(city!=null) {
					mission.setCity(city);
				}
			}
			if(dto.getThemeId()!=0) {
				MissionTheme theme=new MissionTheme();
				theme=this.daoOperation.fetchThemeById(dto.getThemeId());
				if(theme!=null) {
					mission.setMissionTheme(theme);
				}
			}
			if(dto.getSkillsId()!=null) {
				List<MissionSkill> missionSkills=new ArrayList<MissionSkill>();
				for(int skillId:dto.getSkillsId()) {
					Skill skill=this.daoOperation.fetchSkillById(skillId);
					if(skill!=null) {
						MissionSkill missionSkill=new MissionSkill();
						missionSkill.setMissions(mission);
						missionSkill.setSkills(skill);
						missionSkills.add(missionSkill);
						
					}
				}
				mission.setMissionSkills(missionSkills);
			}
			if (dto.getMissionImages()!=null) {
				List<MissionMedia> myMedias=new ArrayList<MissionMedia>();
				int counter=1;
		        String Finalpath=path.concat("WEB-INF/").concat(savePath);
				for (CommonsMultipartFile file : dto.getMissionImages()) {
					if(file.getSize()>0) {
					String timeStamp=String.valueOf(System.currentTimeMillis());
					int leftLimit = 97; // letter 'a'
					int rightLimit = 122; // letter 'z'
					int targetStringLength = 10;
					Random random = new Random();
					StringBuilder buffer = new StringBuilder(targetStringLength);
					for (int i = 0; i < targetStringLength; i++) {
						int randomLimitedInt = leftLimit
								+ (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
						buffer.append((char) randomLimitedInt);
					}
					String generatedString = buffer.toString();
					String mediaType=file.getOriginalFilename().split("\\.")[1];
					String extension="."+mediaType;
					String filename = timeStamp + generatedString+extension;
					try {
						byte barr[] = file.getBytes();
						String fos = Finalpath + filename;
						BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fos));
						bout.write(barr);
//	        			if successfully saved than Entry into Db 
						MissionMedia media = new MissionMedia();
						String dbPath = savePath + filename;
						media.setMediaType(mediaType);
						media.setMediaPath(dbPath);
						media.setMediaName(file.getOriginalFilename());
						media.setMission(mission);
						if(counter==1)
						{							
							media.setMediaDefault(MediaDefault.DEFAULT);
						}
						else {
							media.setMediaDefault(MediaDefault.NOTDEFAULT);
						}
						
						myMedias.add(media);
						bout.flush();
						bout.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					counter++;
				}
				}
				mission.setMissionMedia(myMedias);
			}
			
			if (dto.getMissionDocuments()!=null) {
				List<MissionDocument> myDocs=new ArrayList<MissionDocument>();
				
		        String Finalpath=path.concat("WEB-INF/").concat(savePath);
				for (CommonsMultipartFile file : dto.getMissionDocuments()) {
					if(file.getSize()>0) {
					String timeStamp=String.valueOf(System.currentTimeMillis());
					int leftLimit = 97; // letter 'a'
					int rightLimit = 122; // letter 'z'
					int targetStringLength = 10;
					Random random = new Random();
					StringBuilder buffer = new StringBuilder(targetStringLength);
					for (int i = 0; i < targetStringLength; i++) {
						int randomLimitedInt = leftLimit
								+ (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
						buffer.append((char) randomLimitedInt);
					}
					String generatedString = buffer.toString();
					String docType=file.getOriginalFilename().split("\\.")[1];
					String extension="."+docType;
					String filename = timeStamp + generatedString+extension;
					try {
						byte barr[] = file.getBytes();
						String fos = Finalpath + filename;
						BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fos));
						bout.write(barr);
//	        			if successfully saved than Entry into Db 
						MissionDocument document = new MissionDocument();
						String dbPath = savePath + filename;
						document.setDocumentPath(dbPath);
						document.setDocumentType(docType);
						document.setDocumentName(file.getOriginalFilename());
						document.setMission(mission);
						myDocs.add(document);
						bout.flush();
						bout.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				}
				mission.setMissionDocument(myDocs);
			}
		}
		else {
			mission=this.daoOperation.fetchMissionById(dto.getMissionId());
			if(mission==null) {
				return false;
			}
			else {
				if(dto.getTitle()!=null) {				
					mission.setTitle(dto.getTitle());
				}
				if(dto.getOrganizationName()!=null) {
					mission.setOrganizationName(dto.getOrganizationName());
				}
				if(dto.getOrganizationDetail()!=null) {
					mission.setOrganizationDetail(dto.getOrganizationDetail());
				}
				if(dto.getAvailability()!=null) {				
					mission.setAvailability(dto.getAvailability());
				}
				if(dto.getStartDate()!=null) {
					mission.setStartDate(dto.getStartDate());
				}
				if(dto.getEndDate()!=null) {
					mission.setEndDate(dto.getEndDate());
				}
				if(dto.getStatus()!=null) {
					mission.setStatus(dto.getStatus());
				}
				if(dto.getShortDescription()!=null) {
					mission.setShortDescription(dto.getShortDescription());
				}
				if(dto.getDescription()!=null) {
					mission.setDescription(dto.getDescription());
				}
				if(dto.getMissionType()!=null) {
					mission.setMissionType(dto.getMissionType());
				}
				if(mission.getMissionType()==MissionType.GOAL) {
					//for goal Based
					GoalMission goalMission=mission.getGoalMission();
					goalMission.setGoalObjectiveText(dto.getGoalObjectiveText());
					goalMission.setGoalValue(dto.getGoalValue());
					goalMission.setMission(mission);
					mission.setGoalMission(goalMission);
				}
				if(mission.getMissionType()==MissionType.TIME) {
//					For Time Based
					if(dto.getTotalSeat()!=mission.getTotalSeat()) {
						long seatLeft=0;
						long application=0;
						application=mission.getTotalSeat()-mission.getSeatLeft();
						if(mission.getTotalSeat()<dto.getTotalSeat()) {
							seatLeft=dto.getTotalSeat()-application;
							mission.setSeatLeft(seatLeft);
						}
						else {
							if(dto.getTotalSeat()>application) {								
								seatLeft=dto.getTotalSeat()-application;
								mission.setSeatLeft(seatLeft);
							}
							else {
								mission.setSeatLeft(0);
							}
						}
					}
					mission.setTotalSeat(dto.getTotalSeat());
					mission.setDeadline(dto.getDeadline());
				}
//				Check For Country
				if(dto.getCountryId()!=0) {
					Country country=new Country();
					country=this.userDaoOpration.getCountryObject(dto.getCountryId());
					if(country!=null) {
						mission.setCountry(country);
					}
				}
				
//				check for city
				
				if(dto.getCityId()!=0) {
					City city=new City();
					city=this.userDaoOpration.getCityObject(dto.getCityId());
					if(city!=null) {
						mission.setCity(city);
					}
				}
				if(dto.getThemeId()!=0) {
					MissionTheme theme=new MissionTheme();
					theme=this.daoOperation.fetchThemeById(dto.getThemeId());
					if(theme!=null) {
						mission.setMissionTheme(theme);
					}
				}
				if(dto.getSkillsId()!=null) {
					this.daoOperation.deleteSkillAlreadyPresentInMission(mission.getMissionId());
					List<MissionSkill> missionSkills=new ArrayList<MissionSkill>();
					for(int skillId:dto.getSkillsId()) {
						Skill skill=this.daoOperation.fetchSkillById(skillId);
						if(skill!=null) {
							MissionSkill missionSkill=new MissionSkill();
							missionSkill.setMissions(mission);
							missionSkill.setSkills(skill);
							missionSkills.add(missionSkill);
						}
					}
					mission.setMissionSkills(missionSkills);
				}
				if (dto.getMissionImages()!=null) {
					List<MissionMedia> myMedias=new ArrayList<MissionMedia>();
			        String Finalpath=path.concat("WEB-INF/").concat(savePath);
					for (CommonsMultipartFile file : dto.getMissionImages()) {
						
						if(file.getSize()>0) {

						String timeStamp=String.valueOf(System.currentTimeMillis());
						int leftLimit = 97; // letter 'a'
						int rightLimit = 122; // letter 'z'
						int targetStringLength = 10;
						Random random = new Random();
						StringBuilder buffer = new StringBuilder(targetStringLength);
						for (int i = 0; i < targetStringLength; i++) {
							int randomLimitedInt = leftLimit
									+ (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
							buffer.append((char) randomLimitedInt);
						}
						String generatedString = buffer.toString();
						String mediaType=file.getOriginalFilename().split("\\.")[1];
						String extension="."+mediaType;
						String filename = timeStamp + generatedString+extension;
						try {
							byte barr[] = file.getBytes();
							String fos = Finalpath + filename;
							BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fos));
							bout.write(barr);
//		        			if successfully saved than Entry into Db 
							MissionMedia media = new MissionMedia();
							String dbPath = savePath + filename;
							media.setMediaType(mediaType);
							media.setMediaPath(dbPath);
							media.setMediaName(file.getOriginalFilename());
							media.setMission(mission);
							media.setMediaDefault(MediaDefault.NOTDEFAULT);
							myMedias.add(media);
							bout.flush();
							bout.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					}
					
					mission.setMissionMedia(myMedias);
				}
				
				if (dto.getMissionDocuments()!=null) {
					List<MissionDocument> myDocs=new ArrayList<MissionDocument>();
					
			        String FinalpathDoc=path.concat("WEB-INF/").concat(savePath);
					for (CommonsMultipartFile file : dto.getMissionDocuments()) {
						if(file.getSize()>0) {
						String timeStamp=String.valueOf(System.currentTimeMillis());
						int leftLimit = 97; // letter 'a'
						int rightLimit = 122; // letter 'z'
						int targetStringLength = 10;
						Random random = new Random();
						StringBuilder buffer = new StringBuilder(targetStringLength);
						for (int i = 0; i < targetStringLength; i++) {
							int randomLimitedInt = leftLimit
									+ (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
							buffer.append((char) randomLimitedInt);
						}
						String generatedString = buffer.toString();
						String docType=file.getOriginalFilename().split("\\.")[1];
						String extension="."+docType;
						String filename = timeStamp + generatedString+extension;
						try {
							byte barr[] = file.getBytes();
							String fos = FinalpathDoc + filename;
							BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fos));
							bout.write(barr);
//		        			if successfully saved than Entry into Db 
							MissionDocument document = new MissionDocument();
							String dbPath = savePath + filename;
							document.setDocumentPath(dbPath);
							document.setDocumentType(docType);
							document.setDocumentName(file.getOriginalFilename());
							document.setMission(mission);
							myDocs.add(document);
							bout.flush();
							bout.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					}
					mission.setMissionDocument(myDocs);
				}
			}
		}
		return this.daoOperation.saveOrUpdateMission(mission);
	}

	public List<BannerOutgoingDto> fetchBanners() {
		List<Banner> banners=this.daoOperation.fetchBanners();
		List<BannerOutgoingDto> bannersDto=new ArrayList<BannerOutgoingDto>();
		for(Banner banner:banners) {
			BannerOutgoingDto dto=new BannerOutgoingDto();
			dto.setImage(banner.getImage());
			dto.setBannerId(banner.getBannerId());
			dto.setSortBy(banner.getSortOrder());
			dto.setText(banner.getText());
			bannersDto.add(dto);
		}
		return bannersDto;
	}

	public Banner fetchBannerById(int bannerId) {
		return this.daoOperation.fetchBannerById(bannerId);
	}

	public boolean updateBanner(BannerIncomingDto bannerIncomingDto,String path) {
		Banner banner=new Banner();
		if(bannerIncomingDto.getBannerId()==0) {
			banner.setSortOrder(bannerIncomingDto.getSortOrder());
			banner.setText(bannerIncomingDto.getText());
			if(bannerIncomingDto.getImage().getSize()>0) {
				String FinalpathDoc=path.concat("WEB-INF/").concat(savePath);
				CommonsMultipartFile file=bannerIncomingDto.getImage();
				String timeStamp=String.valueOf(System.currentTimeMillis());
				int leftLimit = 97; // letter 'a'
				int rightLimit = 122; // letter 'z'
				int targetStringLength = 10;
				Random random = new Random();
				StringBuilder buffer = new StringBuilder(targetStringLength);
				for (int i = 0; i < targetStringLength; i++) {
					int randomLimitedInt = leftLimit
							+ (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
					buffer.append((char) randomLimitedInt);
				}
				String generatedString = buffer.toString();
				String docType=file.getOriginalFilename().split("\\.")[1];
				String extension="."+docType;
				String filename = timeStamp + generatedString+extension;
				try {
					byte barr[] = file.getBytes();
					String fos = FinalpathDoc + filename;
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fos));
					bout.write(barr);
					String dbPath = savePath + filename;
//        			if successfully saved than Entry into Db 
					banner.setImage(dbPath);
					bout.flush();
					bout.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else {
			banner=this.daoOperation.fetchBannerById(bannerIncomingDto.getBannerId());
			if(banner==null) {
				return false;
			}
			else {
				banner.setSortOrder(bannerIncomingDto.getSortOrder());
				banner.setText(bannerIncomingDto.getText());
				if(bannerIncomingDto.getImage().getSize()>0) {
					String FinalpathDoc=path.concat("WEB-INF/").concat(savePath);
					CommonsMultipartFile file=bannerIncomingDto.getImage();
					String timeStamp=String.valueOf(System.currentTimeMillis());
					int leftLimit = 97; // letter 'a'
					int rightLimit = 122; // letter 'z'
					int targetStringLength = 10;
					Random random = new Random();
					StringBuilder buffer = new StringBuilder(targetStringLength);
					for (int i = 0; i < targetStringLength; i++) {
						int randomLimitedInt = leftLimit
								+ (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
						buffer.append((char) randomLimitedInt);
					}
					String generatedString = buffer.toString();
					String docType=file.getOriginalFilename().split("\\.")[1];
					String extension="."+docType;
					String filename = timeStamp + generatedString+extension;
					try {
						byte barr[] = file.getBytes();
						String fos = FinalpathDoc + filename;
						BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fos));
						bout.write(barr);
						String dbPath = savePath + filename;
//	        			if successfully saved than Entry into Db 
						banner.setImage(dbPath);
						bout.flush();
						bout.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return this.daoOperation.addUpdateBanner(banner);
	}

	public boolean deleteBanner(int bannerId) {
		Banner banner=this.fetchBannerById(bannerId);
		if(banner==null) {
			return false;
		}
		else {
			return this.daoOperation.deleteBanner(bannerId);
		}
	}

	public boolean deleteUserByAdmin(int userId) {
		if(this.daoOperation.fetchUserById(userId)==null) {
			return false;
		}
		else {
			return this.daoOperation.deleteUser(userId);
		}
	}

}

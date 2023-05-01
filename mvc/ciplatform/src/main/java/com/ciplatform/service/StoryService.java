package com.ciplatform.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ciplatform.dao.MissionDaoInterface;
import com.ciplatform.dao.StoryDaoInterface;
import com.ciplatform.dto.DraftStoryDto;
import com.ciplatform.dto.FindMissionFromUserDto;
import com.ciplatform.dto.StoryCardDto;
import com.ciplatform.dto.StoryDto;
import com.ciplatform.dto.StoryMediaTypeUrlDto;
import com.ciplatform.enums.StoryStatus;
import com.ciplatform.model.Mission;
import com.ciplatform.model.MissionApplication;
import com.ciplatform.model.Story;
import com.ciplatform.model.StoryMedia;
import com.ciplatform.model.User;

@Service
public class StoryService implements StoryServiceIntereface{
	
	@Autowired
	StoryDaoInterface storyDaoInterface;
	
	@Autowired
	MissionDaoInterface missionDaoInterface;
	private final String savePath="uploadFiles/";
	
	public List<FindMissionFromUserDto> findMissionOfUsers(User user){
		List<MissionApplication> myMissionApplicationList=this.storyDaoInterface.findMissionFromUser(user);
		List<FindMissionFromUserDto> myResultList=new ArrayList<FindMissionFromUserDto>();
		for(MissionApplication application:myMissionApplicationList) {
			FindMissionFromUserDto findMissionFromUserDto=new FindMissionFromUserDto();
			findMissionFromUserDto.setMissionId(application.getMission().getMissionId());
			findMissionFromUserDto.setMissionName(application.getMission().getTitle());
			findMissionFromUserDto.setMissionType(application.getMission().getMissionType().toString());
			myResultList.add(findMissionFromUserDto);
		}
		return myResultList;
	}

	public void saveStoryOfUser(StoryDto storyDto, User user,HttpSession session) {
		if(user.getEmail()==null||user.getEmail()=="") {
			return;
		}
		Story story=new Story();
		List<StoryMedia> media=new ArrayList<StoryMedia>();
		int storyId=storyDto.getStoryId();
		if(storyId!=0) {
			story=this.storyDaoInterface.fetchStoryObjectById(storyId);
			this.storyDaoInterface.deleteMediaOfStory(storyId);
		}
		story.setMission(this.missionDaoInterface.fetchMissionById(storyDto.getMissionId()));
		story.setDescription(storyDto.getStory());
		story.setStatus(StoryStatus.DRAFT);
		story.setUser(user);
		story.setTitle(storyDto.getTitle());
		
		try {
//			If story is Not Already Present in DB
				String timeStamp=String.valueOf(System.currentTimeMillis());
		        String path=session.getServletContext().getRealPath("/").concat("WEB-INF/").concat(savePath);
				if (storyDto.getImages()!=null) {
					for (CommonsMultipartFile file : storyDto.getImages()) {
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
						String extension="."+file.getOriginalFilename().split("\\.")[1];
						String filename = timeStamp + generatedString+extension;
						try {
							byte barr[] = file.getBytes();
							String fos = path + filename;
							BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fos));
							bout.write(barr);
//		        		if successfully saved than Entry into Db 
							StoryMedia storyMedia = new StoryMedia();
							String dbPath = savePath + filename;
							storyMedia.setPath(dbPath);
							storyMedia.setStory(story);
							storyMedia.setType("IMAGE");
							media.add(storyMedia);
							bout.flush();
							bout.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
		        String videoUrl=storyDto.getVideoUrl();
				if(!videoUrl.equals("")) {
					System.out.println(videoUrl);
					StoryMedia storyMedia=new StoryMedia();
					storyMedia.setPath(videoUrl);
		    		storyMedia.setStory(story);
		    		storyMedia.setType("VIDEO");
		    		System.out.println(storyMedia.getPath()+" saved...");
		    		media.add(storyMedia);
				}
		        story.setStoryMedia(media);
		        this.storyDaoInterface.saveStory(story);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public DraftStoryDto getDraftMission(String missionId, User user) {
		int id=Integer.parseInt(missionId);
		DraftStoryDto storyDto=new DraftStoryDto();
		Mission mission=this.missionDaoInterface.fetchMissionById(id);
		Story story=this.storyDaoInterface.getDraftMission(user,mission);
		
//		if story object null then return from here 
		if(story.getStoryId()==0) {
			return new DraftStoryDto();
		}
//		Object To DTO 
		
		DraftStoryDto draftStoryDto=new DraftStoryDto();
		List<StoryMediaTypeUrlDto> storyMediaDraftDto=new ArrayList<StoryMediaTypeUrlDto>();
		draftStoryDto.setDate(story.getCreatedAt());
		draftStoryDto.setStory(story.getDescription());
		draftStoryDto.setStoryId(story.getStoryId());
		draftStoryDto.setStoryTitle(story.getTitle());
		for(StoryMedia storyMedia:story.getStoryMedia()) {
			StoryMediaTypeUrlDto mediaTypeUrlDto=new StoryMediaTypeUrlDto();
			mediaTypeUrlDto.setMediaType(storyMedia.getType());
			mediaTypeUrlDto.setMediaUrl(storyMedia.getPath());
			storyMediaDraftDto.add(mediaTypeUrlDto);
		}
		draftStoryDto.setVideoUrl("");
		draftStoryDto.setImages(storyMediaDraftDto);
		
		return draftStoryDto;
	}

	public Story getDetailStory(int storyId) {
		return this.storyDaoInterface.getDetailStory(storyId);
	}

	public Long getCountOfStory() {
		return this.storyDaoInterface.getCountOfStory();
	}

	public List<StoryCardDto> getStoriesByPageNo(int currentPage) {
		List<Story> stories=this.storyDaoInterface.getStoriesByPageNo(currentPage);
		List<StoryCardDto> result=new ArrayList<StoryCardDto>();
//		Convert Story Object to StoryCardDto
		
		for(Story story:stories) {
			StoryCardDto storyCardDto=new StoryCardDto();
			StoryMediaTypeUrlDto mediaTypeUrlDto=new StoryMediaTypeUrlDto();
			if(story.getStoryMedia().size()>0) {				
				for(StoryMedia storyMedia:story.getStoryMedia()) {
					if(storyMedia.getType().equals("IMAGE")) {
						mediaTypeUrlDto.setMediaType(storyMedia.getType());
						mediaTypeUrlDto.setMediaUrl(storyMedia.getPath());
						break;
					}
				}
			}
			storyCardDto.setImage(mediaTypeUrlDto);
			storyCardDto.setUserAvatar(story.getUser().getAvatar());
			storyCardDto.setStoryDescription(story.getDescription());
			storyCardDto.setStoryId(story.getStoryId());
			storyCardDto.setStoryTitle(story.getTitle());
			storyCardDto.setUserName(story.getUser().getFirstName()+" "+story.getUser().getLastName());
			storyCardDto.setMissionTheme(story.getMission().getMissionTheme().getTitle());
			
			
			result.add(storyCardDto);
		}
		
		
		return result;
	}

	public void submitDraftedStory(int storyId,int userId) {
		this.storyDaoInterface.submitDraftedStory(storyId,userId);
	}

	public void recommandToCoWorkerStory(int storyId, User sendFromUser, User sendToUser) {
		Story story=new Story();
		story=this.storyDaoInterface.fetchStoryObjectById(storyId);
		if(story.getStoryId()!=0) {			
			String msg="<!DOCTYPE html><h2>Your Friend "+sendFromUser.getFirstName()+" "+sendFromUser.getLastName()+" is recommand to you for this Story</h2><h3>Click Below Button to Open Mission</h3> <br><a href='http://localhost:8080/project/getDetailStory?storyId="+story.getStoryId()+"' class='btn btn-success'>Click Here</a>";
			String subject="Ci-Platform Story Recommandation Link";
			if(SendMail.send(sendToUser.getEmail(), msg,subject)) {			
				this.storyDaoInterface.recommandToCoWorkerStory(story,sendFromUser,sendToUser);
			}
		}
	}

	public void incrementPageViews(int storyId) {
		this.storyDaoInterface.incrementPageViewCount(storyId);
	}

}

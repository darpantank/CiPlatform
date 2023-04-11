package project.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import project.dao.MissionDaoInterface;
import project.dao.StoryDaoInterface;
import project.dto.DraftStoryDto;
import project.dto.FindMissionFromUserDto;
import project.dto.StoryCardDto;
import project.dto.StoryDto;
import project.dto.StoryMediaTypeUrlDto;
import project.model.Mission;
import project.model.MissionApplication;
import project.model.Story;
import project.model.StoryMedia;
import project.model.Story.StoryStatus;
import project.model.User;

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
			findMissionFromUserDto.setMissionId(application.getMission().getMission_id());
			findMissionFromUserDto.setMissionName(application.getMission().getTitle());
			myResultList.add(findMissionFromUserDto);
		}
		return myResultList;
	}

	public void saveStoryOfUser(StoryDto storyDto, User user,HttpSession session) {
		if(user.getEmail()==null||user.getEmail()=="") {
			return;
		}
		Story story=new Story();
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
		        List<StoryMedia> media=new ArrayList<StoryMedia>();
		        for(CommonsMultipartFile file:storyDto.getImages())
		        {        	
		        	
		            int leftLimit = 97; // letter 'a'
		            int rightLimit = 122; // letter 'z'
		            int targetStringLength = 10;
		            Random random = new Random();
		            StringBuilder buffer = new StringBuilder(targetStringLength);
		            for (int i = 0; i < targetStringLength; i++) {
		                int randomLimitedInt = leftLimit + (int) 
		                  (random.nextFloat() * (rightLimit - leftLimit + 1));
		                buffer.append((char) randomLimitedInt);
		            }
		            String generatedString = buffer.toString();
		        	
		        	String filename=timeStamp+generatedString;    
		        	try{  
		        		byte barr[]=file.getBytes();  
		        		String fos=path+filename;
		        		BufferedOutputStream bout=new BufferedOutputStream(  
		        				new FileOutputStream(fos));  
		        		bout.write(barr);
//		        		if successfully saved than Entry into Db 
		        		StoryMedia storyMedia=new StoryMedia();
		        		String dbPath=savePath+filename;
		        		storyMedia.setPath(dbPath);
		        		storyMedia.setStory(story);
		        		storyMedia.setType("IMAGE");
		        		System.out.println(storyMedia.getPath()+" saved...");
		        		media.add(storyMedia);
		        		bout.flush();  
		        		bout.close();  
		        	}catch(Exception e){e.printStackTrace();}
		        }
		        story.setStoryMedia(media);
		        System.out.println(story.getStoryMedia());
		        System.out.println("Story Media set");
		        this.storyDaoInterface.saveStory(story);
		        System.out.println("story Added "+storyId);
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
		if(story.getStory_id()==0) {
			return new DraftStoryDto();
		}
//		Object To DTO 
		
		DraftStoryDto draftStoryDto=new DraftStoryDto();
		List<StoryMediaTypeUrlDto> storyMediaDraftDto=new ArrayList<StoryMediaTypeUrlDto>();
		draftStoryDto.setDate(story.getCreated_at());
		draftStoryDto.setStory(story.getDescription());
		draftStoryDto.setStoryId(story.getStory_id());
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
				mediaTypeUrlDto.setMediaType(story.getStoryMedia().get(0).getType());
				mediaTypeUrlDto.setMediaUrl(story.getStoryMedia().get(0).getPath());
			}
			storyCardDto.setImage(mediaTypeUrlDto);
			storyCardDto.setUserAvatar(story.getUser().getAvatar());
			storyCardDto.setStoryDescription(story.getDescription());
			storyCardDto.setStoryId(story.getStory_id());
			storyCardDto.setStoryTitle(story.getTitle());
			storyCardDto.setUserName(story.getUser().getFirst_name()+" "+story.getUser().getLast_name());
			storyCardDto.setMissionTheme(story.getMission().getMission_theme().getTitle());
			
			
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
		if(story.getStory_id()!=0) {			
			String msg="<!DOCTYPE html><h2>Your Friend "+sendFromUser.getFirst_name()+" "+sendFromUser.getLast_name()+" is recommand to you for this Story</h2><h3>Click Below Button to Open Mission</h3> <br><a href='http://localhost:8080/project/getDetailStory?storyId="+story.getStory_id()+"' class='btn btn-success'>Click Here</a>";
			String subject="Ci-Platform Story Recommandation Link";
			if(SendMail.send(sendToUser.getEmail(), msg,subject)) {			
				this.storyDaoInterface.recommandToCoWorkerStory(story,sendFromUser,sendToUser);
			}
		}
	}

}

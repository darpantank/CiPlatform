package project.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import project.dao.MissionDaoInterface;
import project.dao.StoryDaoInterface;
import project.dto.FindMissionFromUserDto;
import project.dto.StoryDto;
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
		int storyId=0;
		story.setMission(this.missionDaoInterface.fetchMissionById(storyDto.getMissionId()));
		story.setDescription(storyDto.getStory());
		story.setStatus(StoryStatus.DRAFT);
		story.setUser(user);
		story.setTitle(storyDto.getTitle());
		
		try {
//			If story is Not Already Present in Db
				String timeStamp=String.valueOf(System.currentTimeMillis());
		        String path=session.getServletContext().getRealPath("/").concat("WEB-INF/").concat(savePath);
		        List<StoryMedia> media=new ArrayList<StoryMedia>();
		        for(CommonsMultipartFile file:storyDto.getImages())
		        {        	
		        	String filename=timeStamp+file.getOriginalFilename();    
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
		        		media.add(storyMedia);
		        		bout.flush();  
		        		bout.close();  
		        		
		        	}catch(Exception e){e.printStackTrace();}
		        }
		        story.setStoryMedia(media);
		        storyId=this.storyDaoInterface.saveStory(story);
		        System.out.println("story Added"+storyId);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Story getDraftMission(String missionId, User user) {
		int id=Integer.parseInt(missionId);
		StoryDto storyDto=new StoryDto();
		Mission mission=this.missionDaoInterface.fetchMissionById(id);
		Story story=this.storyDaoInterface.getDraftMission(user,mission);
		return story;
	}

}

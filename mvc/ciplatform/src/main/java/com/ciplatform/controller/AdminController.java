package com.ciplatform.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.ciplatform.model.Banner;
import com.ciplatform.model.CmsPage;
import com.ciplatform.model.Mission;
import com.ciplatform.model.MissionTheme;
import com.ciplatform.model.Skill;
import com.ciplatform.model.User;
import com.ciplatform.service.AdminServiceInterface;
import com.ciplatform.service.UserServiceInterface;
import com.mysql.cj.Session;

@Controller
@RequestMapping("/admin")

public class AdminController {
	@Autowired
	AdminServiceInterface service;
	
//	User Cruds 
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public String showAdminPanel() {
		return "userpageadmin";
	}
	@RequestMapping(value = "/adduser",method = RequestMethod.GET)
	public String showEditAdminPage() {
		return "edituserpageadmin";
	}
	@RequestMapping(value="/edituserprofile",method=RequestMethod.GET)
	public String editProfileDetails(@RequestParam("userId") int userId,Model m) {
		User selectedUser=this.service.fetchUserById(userId);
		m.addAttribute("selectedUser",selectedUser);
		return "edituserpageadmin";
	}
	@RequestMapping(value = "/updateuserprofile" , method = RequestMethod.POST)
	public @ResponseBody boolean updateUserProfile(UserProfileEditAdminDto profileEditAdminDto,HttpSession session) {
		String path=session.getServletContext().getRealPath("/");
		return this.service.updateUserProfile(profileEditAdminDto,path);
	}
	@RequestMapping(value = "/fetchusers",method = RequestMethod.GET)
	public @ResponseBody List<UserAdminPanelDto> fetchUsers(){
		return this.service.fetchUsers();
	}
	@RequestMapping(value="/deleteuser" ,method=RequestMethod.GET)
	public @ResponseBody boolean deleteUser(@RequestParam("user_id") int userId) {
		return this.service.deleteUserByAdmin(userId);
	}
	
//	Cms Related Cruds
	
	@RequestMapping(value = "/addcmspage",method = RequestMethod.GET)
	public String addCmsPanel(Model m) {
		CmsPage cmsPage=new CmsPage();
		m.addAttribute("cms",cmsPage);
		return "cmsaddadmin";
	}
	
	@RequestMapping(value = "/editcms",method = RequestMethod.GET)
	public String editcmsData(@RequestParam("cmsId") int cmsId,Model m)
	{
//		Fetch Cms By Id
		
		CmsPage cmsPage=new CmsPage();
		cmsPage=this.service.fetchCms(cmsId);
		if(cmsPage==null) {
			return "cmspageadmin";
		}
		else {
			m.addAttribute("cms",cmsPage);
			return "cmsaddadmin";
		}
	}
	@RequestMapping(value = "/cmspage",method = RequestMethod.GET)
	public String showCmsPanel() {
		return "cmspageadmin";
	}
	@RequestMapping(value = "/addcms",method=RequestMethod.POST)
	public @ResponseBody boolean addCms(CmsIncomingDto cmsIncomingDto) {
		return this.service.addUpdateCms(cmsIncomingDto);
	}
	@RequestMapping(value = "/deletecms",method=RequestMethod.GET)
	public @ResponseBody boolean deleteCms(@RequestParam("cmsId") int cmsId) {
		return this.service.deleteCms(cmsId);
	}
	
	@RequestMapping(value = "/fetchcms",method = RequestMethod.GET)
	public @ResponseBody List<CmsOutgoingDto> fetchCmsList(){
		return this.service.fetchCmsList();
	}
	
//	Mission Related Cruds
	
	@RequestMapping(value = "/missionpage",method=RequestMethod.GET)
	public String missionPageAdminView() {
		return "missionpageadmin";
	}
	@RequestMapping(value = "/fetchmissions" , method=RequestMethod.GET)
	public @ResponseBody List<MissionOutgoingDto> fetchAllMissions(){
		return this.service.fetchMissions();
	}
	@RequestMapping(value = "/addmission" , method = RequestMethod.GET)
	public String addMission() {
		return "editmissionpageadmin";
	}
	@RequestMapping(value = "/editmission" ,method = RequestMethod.GET)
	public String editMission(@RequestParam("missionId") int missionId,Model m) {
		Mission mission=this.service.fetchMissionById(missionId);
		if(mission==null) {
			return "missionpageadmin";
		}
		else {
			m.addAttribute("mission",mission);
			return "editmissionpageadmin";
		}
	}
	@RequestMapping(value = "/updatemission" , method=RequestMethod.POST)
	public @ResponseBody boolean updateMission(MissionIncomingDto dto,HttpSession session) {
		System.out.println(dto);
		String path=session.getServletContext().getRealPath("/");
		return this.service.addUpdateMission(dto,path);
	}
	
	
//	Theme Related Cruds
	
	@RequestMapping(value = "/fetchthemes",method = RequestMethod.GET)
	public @ResponseBody List<ThemeDto> fetchThemeList(){
		return this.service.fetchThemeList();
	}
	
	@RequestMapping(value = "/themepage",method = RequestMethod.GET)
	public String showThemePanel() {
		return "themepageadmin";
	}
	@RequestMapping(value = "/addthemepage",method = RequestMethod.GET)
	public String addThemePage() {
		return "themeaddadmin";
	}
	@RequestMapping(value = "/edittheme",method = RequestMethod.GET)
	public String editThemeData(@RequestParam("themeId") int themeId,Model m)
	{
//		Fetch theme By Id
		
		MissionTheme missionTheme=new MissionTheme();
		missionTheme=this.service.fetchThemeById(themeId);
		if(missionTheme==null) {
			return "themepageadmin";
		}
		else {
			m.addAttribute("theme",missionTheme);
			return "themeaddadmin";
		}
	}
	@RequestMapping(value = "/addtheme",method=RequestMethod.POST)
	public @ResponseBody boolean addTheme(ThemeDto themeDto) {
		return this.service.addUpdatTheme(themeDto);
	}
	@RequestMapping(value = "/deletetheme",method=RequestMethod.GET)
	public @ResponseBody boolean deleteTheme(@RequestParam("themeId") int themeId) {
		return this.service.deleteTheme(themeId);
	}
	
	
//	For Skills Related Activities
	
	@RequestMapping(value = "/fetchskills",method = RequestMethod.GET)
	public @ResponseBody List<SkillDto> fetchSkillList(){
		return this.service.fetchSkillList();
	}
	
	@RequestMapping(value = "/skillpage",method = RequestMethod.GET)
	public String showSkillPage() {
		return "skillpageadmin";
	}
	@RequestMapping(value = "/addskillpage",method = RequestMethod.GET)
	public String addSkillPage() {
		return "skilladdadmin";
	}
	@RequestMapping(value = "/editskill",method = RequestMethod.GET)
	public String editSkillData(@RequestParam("skill_id") int skillId,Model m)
	{
//		Fetch skill By Id
		
		Skill skill=new Skill();
		skill=this.service.fetchSkillById(skillId);
		if(skill==null) {
			return "skillpageadmin";
		}
		else {
			m.addAttribute("skill",skill);
			return "skilladdadmin";
		}
	}
	@RequestMapping(value = "/addskill",method=RequestMethod.POST)
	public @ResponseBody boolean addSkill(SkillDto skillDto) {
		return this.service.addUpdateSkill(skillDto);
	}
	@RequestMapping(value = "/deleteskill",method=RequestMethod.GET)
	public @ResponseBody boolean deleteSkill(@RequestParam("skillId") int skillId) {
		return this.service.deleteSkill(skillId);
	}
	
	
//	Task Related To Mission Application 
	
	@RequestMapping(value = "/missionapplicationpage",method = RequestMethod.GET)
	public String showMissionApplicationPage() {
		return "missionapplicationpageadmin";
	}
	@RequestMapping(value = "/fetchpendingapplications",method = RequestMethod.GET)
	public @ResponseBody List<MissionApplicationOutgoingDto> fetchPendingMissionsApplication(){
		return this.service.fetchPendingMissionsApplication();
	}
	@RequestMapping(value = "/updateapplication",method=RequestMethod.POST)
	public @ResponseBody boolean updateStatusOfApplication(MissionApplicationIncomingDto application) {
		return this.service.updateMissionApplicationStatus(application);
	}
	
	
//	Task Related to Story Page Admin Panel
	
	@RequestMapping(value = "/storypage",method = RequestMethod.GET)
	public String showStoryPage() {
		return "storypageadmin";
	}
	
	@RequestMapping(value = "/fetchpendingstory",method = RequestMethod.GET)
	public @ResponseBody List<StoryOutgoingDto> fetchPendingStory(){
		return this.service.fetchPendingStory();
	}
	@RequestMapping(value = "/updatestorystatus" , method = RequestMethod.POST)
	public @ResponseBody boolean updateStatusOfStory(StoryIncomingDto incomingDto) {
		return this.service.updateStoryStatus(incomingDto);
	}
	
//	Banner Management
	
	
	@RequestMapping(value = "/bannerpage" , method = RequestMethod.GET)
	public String viewBannerPage() {
		return "bannermanagement";
	}
	@RequestMapping(value = "/fetchbanners" , method = RequestMethod.GET)
	public @ResponseBody List<BannerOutgoingDto> fetchBanners(){
		return this.service.fetchBanners();
	}
	@RequestMapping(value = "/addbanner" , method = RequestMethod.GET)
	public String addBanner(){
		return "addeditbanner";
	}
	@RequestMapping(value = "/editbanner" , method = RequestMethod.GET)
	public String editBanner(@RequestParam("banner_id") int bannerId,Model m){
		Banner banner=this.service.fetchBannerById(bannerId);
		if(banner==null) {
			return "bannermanagement";
		}
		else {
			m.addAttribute("banner",banner);
			return "addeditbanner";
		}
	}
	@RequestMapping(value = "/addupdatebanner", method = RequestMethod.POST)
	public @ResponseBody boolean addUpdateBanner(BannerIncomingDto bannerIncomingDto,HttpSession session ) {
		return this.service.updateBanner(bannerIncomingDto,session.getServletContext().getRealPath("/"));
	}
	@RequestMapping(value = "/deletebanner", method = RequestMethod.GET)
	public @ResponseBody boolean deleteBanner(@RequestParam("bannerId") int bannerId) {
		return this.service.deleteBanner(bannerId);
	}
//	Admin Logout
	
	@RequestMapping(value = "/adminlogout",method=RequestMethod.GET)
	public String logoutAdmin(Model m,HttpServletResponse response,HttpServletRequest request) {
		try {
			response.sendRedirect(request.getContextPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.removeAttribute("admin");
		m.addAttribute("message","logoutsuccess");
		return "login";
	}
}

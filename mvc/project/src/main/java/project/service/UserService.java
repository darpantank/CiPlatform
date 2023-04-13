package project.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import project.dao.UserDaoInterface;
import project.dto.UserProfileDto;
import project.model.City;
import project.model.Country;
import project.model.PasswordReset;
import project.model.StoryMedia;
import project.model.User;

@Service
public class UserService implements UserServiceInterface {
	private final String savePath="uploadFiles/";
	final static int TOKEN_VALID_TIME = 240;
	@Autowired
	UserDaoInterface daoOperation;

	public boolean storeUserData(User user1) {
		user1.setCreated_at(new Date());
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user1.getEmail());
		if (user1.getPassword().length() >= 8 && matcher.matches() && user1.getPhone_number().length() == 10
				&& user1.getFirst_name() != "" && user1.getLast_name() != "") {
			System.out.println("Pass Email Validation true");
			if (this.daoOperation.createUser(user1)) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

	public User validateUserDetail(String email, String password) {
		return this.daoOperation.validateUserDetails(email, password);
	}

	public boolean validateEmailId(String email) {
		User myuser = this.daoOperation.validateEmail(email);
		if (myuser.getEmail() != null) {
			return true;
		} else {
			return false;
		}
	}
	public User getUserFromEmail(String email) {
		return this.daoOperation.validateEmail(email);
	}
	public boolean forgotPasswordImpl(String email) {
		String Token = GenerateToken.generateNewToken();
		String message="<!DOCTYPE html><h3>Click Below Button to Reset Your Password</h3> <br><a href=http://localhost:8080/project/validatetoken/"+Token+" class='btn btn-success'>Click Here</a>";
		String subject="Ci-Platform Reset Password";
		if (SendMail.send(email, message,subject)) {
			PasswordReset prst = new PasswordReset();
			prst.setEmail(email);
			prst.setToken(Token);
			prst.setCreated_at(new Date());
			if (this.daoOperation.storeResetPassToken(prst) != "") {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public PasswordReset validateToken(String Token) {
		PasswordReset prst = new PasswordReset();
		List<PasswordReset> prstlist = this.daoOperation.validateToken(Token);
		for (PasswordReset temp : prstlist) {
			prst = temp;
		}
		return prst;
	}

	public boolean deleteToken(PasswordReset prst) {
		return this.daoOperation.deleteToken(prst);
	}

	public PasswordReset isValidToken(String token) {
		return this.daoOperation.validateTokenForReset(token);
	}

	public boolean isPasswordUpdated(String Token, String password) {
		PasswordReset prst = isValidToken(Token);
		if (prst.isValidObject()) {
			String email = prst.getEmail();
			if (this.daoOperation.saveUpdatedPassword(email, password)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public PasswordReset getEmailFromToken(String token) {
		return this.daoOperation.validateTokenForReset(token);
	}

	public boolean isTokenExpire(PasswordReset prst) {
		Date d1 = prst.getCreated_at();
		Date d2 = new Date();
		long diff = d2.getTime() - d1.getTime();
		TimeUnit time = TimeUnit.MINUTES;
		long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
		System.out.println();
		if (diffrence > TOKEN_VALID_TIME) {
			System.out.println(diffrence);
			return true;
		} else {
			return false;
		}
	}

	public boolean editUserProfile(UserProfileDto userProfileDto, User user,HttpSession session) {
		if(!user.getFirst_name().equals(userProfileDto.getFirstName())) {
			user.setFirst_name(userProfileDto.getFirstName());
		}
//		check lastName Updated Or not
		
		if(!user.getLast_name().equals(userProfileDto.getLastName())) {
			user.setLast_name(userProfileDto.getLastName());
		}
//		check EmployeeId Updated Or not
			user.setEmployee_id(userProfileDto.getEmployeeId());
//		check title Updated Or not
			user.setTitle(userProfileDto.getTitle());
//		check department Updated Or not
			user.setDepartment(userProfileDto.getDepartment());
//		check profile Updated Or not
			user.setProfile_text(userProfileDto.getMyProfile());
//		check whyivolunteer Updated Or not
			user.setWhy_i_volunteer(userProfileDto.getWhyIVolunteer());
//		Check For Country
//			if(userProfileDto.getCountryId()!=0&&userProfileDto.getCountryId()!=user.getCountry().getCountry_id()) {
//				Country country=new Country();
//				country=this.daoOperation.getCountryObject(userProfileDto.getCountryId());
//				if(country!=null) {
//					user.setCountry(country);
//				}
//			}
//			if(userProfileDto.getCityId()!=0&&userProfileDto.getCityId()!=user.getCity().getCity_id()) {
//				City city=this.daoOperation.getCity(userProfileDto.getCityId());
//				if(city!=null) {					
//					user.setCity(city);
//				}
//			}
//			if(userProfileDto.getSkills().length>0) {
//				System.out.println("skills Found");
//			}
//		check profile picture updated or not
		if(userProfileDto.getAvatar()!=null&&userProfileDto.getAvatar().getSize()>0) {
			CommonsMultipartFile file=userProfileDto.getAvatar();
			String timeStamp=String.valueOf(System.currentTimeMillis());
	        String path=session.getServletContext().getRealPath("/").concat("WEB-INF/").concat(savePath);
	        try {
				byte barr[] = file.getBytes();
				String extension="."+FilenameUtils.getExtension(file.getOriginalFilename());
				String userName = user.getFirst_name().trim().replaceAll("\\s", "");
				String filename=userName+user.getUser_id()+timeStamp+extension;
				String fos = path + filename;
				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fos));
				bout.write(barr);
//    			if successfully saved than Entry into Db 
				String dbPath = savePath + filename;
				user.setAvatar(dbPath);
				bout.flush();
				bout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.daoOperation.updateUserDetails(user);
	}
}

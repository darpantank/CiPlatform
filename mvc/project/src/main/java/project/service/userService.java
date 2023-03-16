package project.service;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.daoOperation;
import project.model.password_reset;
import project.model.user;

@Service
public class userService {
	@Autowired
	daoOperation daoOperation;
	
	public boolean storeUserData(user user1) {
		user1.setCreated_at(new Date());
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user1.getEmail());
		if(user1.getPassword().length()>=8&&matcher.matches()&&user1.getPhone_number().length()==10&&user1.getFirst_name()!=""&&user1.getLast_name()!="") {			
			int i = this.daoOperation.createUser(user1);
			if(i==0) {
				return false;
			}
			System.out.println(i+ "row affected");
			return true;
		}
		else {
			return false;
		}
	}

	public boolean validateUserDetail(String email, String password) {
		System.out.println("Running Service Method");
		System.out.println(email + " " + password);
		return this.daoOperation.validateUserDetails(email, password);
	}

	public boolean validateEmailId(String email) {
		user myuser = this.daoOperation.validateEmail(email);
//		System.out.println(mylist);
//		if (mylist.isEmpty() || mylist.size() > 1) {
//			return false;
//		}
		return true;
	}
	public boolean forgotPasswordImpl(String email) {
		String Token=generateToken.generateNewToken();
		if(sendMail.send(email,Token)) {
			password_reset prst=new password_reset();
			prst.setEmail(email);
			prst.setToken(Token);
			prst.setCreated_at(new Date());
			if(this.daoOperation.storeResetPassToken(prst)!="") {
				return true;
			}
			else {
				return false;
			}
		}
		else {			
			return false;
		}
	}
	public String validateToken(String Token) {
		List<password_reset> list=this.daoOperation.validateToken(Token);
		if(list.isEmpty()||list.size()>1) {
			return "";
		}
		else {
			System.out.println(list);
			String email="";
			for(password_reset pst:list) {
				email=pst.getEmail();
			}
			return email ;
		}
		
	}
	public boolean deleteToken(password_reset prst) {
		return this.daoOperation.deleteToken(prst);
	}
	public password_reset isValidMailForToken(String email) {
		return this.daoOperation.validateEmailForReset(email);
	}
	public boolean isPasswordUpdated(String email,String password) {
		if(this.daoOperation.saveUpdatedPassword(email, password)) {
			return true;
		}
		return false;
	}
}

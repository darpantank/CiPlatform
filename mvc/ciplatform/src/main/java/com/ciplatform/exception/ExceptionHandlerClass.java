package com.ciplatform.exception;


import java.sql.SQLException;

import org.hibernate.boot.MappingException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {
	@ExceptionHandler(value = UserNotFoundException.class)
	public String userDataNotAvailable(Model m) {
		m.addAttribute("message","sessionexpire");
		return "login";
	}
	@ExceptionHandler(value = AdminNotFoundException.class)
	public String adminDataNotPresent(Model m) {
		m.addAttribute("message","nonadmin");
		return "login";
	}
	@ExceptionHandler(value = IndexOutOfBoundsException.class)
	public String indexOutOfBound(Model m) {       
      m.addAttribute("message", "Try to Access Unavailable Attribute");
      return "failed";
	}
//	@ExceptionHandler(value = NullPointerException.class)
//	public String NullPointerException(Model m) {       
//      m.addAttribute("message", "Try to Access Null Attribute");
//      return "failed";
//	}
	@ExceptionHandler(value = ConstraintViolationException.class)
	public String sqlExceptionHanler(Model m) {       
      m.addAttribute("message", "Try to Attamp Insert Duplicate Data Or Delete Some Important Data");
      return "failed";
	}
	@ExceptionHandler({SQLException.class,DataAccessException.class})
	  public String databaseError(Model m) {
		 m.addAttribute("message", "Data Is Not Accessible...");
	    return "failed";
	  }
	  @ExceptionHandler(MappingException.class)
	  public String dataMappingError(Model m) {
		 m.addAttribute("message", "Data Is Not Mapped Properly...");
	    return "failed";
	  }
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandlerGenric(Model m,Exception e) {
		e.printStackTrace();
		m.addAttribute("message","something went wrong!");
		return "failed";
	}
}

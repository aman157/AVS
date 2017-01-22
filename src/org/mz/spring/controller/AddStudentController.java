package org.mz.spring.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.mz.spring.dao.StudentDaoImpl;
import org.mz.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;



@Controller
public class AddStudentController{
	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@RequestMapping(value="/addAction", method = RequestMethod.POST)
	public ModelAndView addStudent(@Valid @ModelAttribute("student")Student student,BindingResult result,HttpServletRequest request) throws MySQLIntegrityConstraintViolationException, RuntimeException, IOException{
		if(result.hasErrors()){
			ModelAndView model=new ModelAndView("pages/add");
			return model;
		}
		MultipartFile multipartFile = student.getFile();
		String destPathOfUserPic = request.getServletContext().getRealPath("/"+"/resources/images/userPic/");
		student.setFileName(student.getRollNumber()+".jpg");
		studentDaoImpl.addStudent(student);
		ModelAndView model=new ModelAndView("pages/add");
		File studentPicFile=new File(destPathOfUserPic+File.separator+student.getFileName());
		multipartFile.transferTo(studentPicFile);
		model.addObject("status", "Record Insert Successfully");
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(Exception exception) {
		String error="Roll Number Already Exits";
		ModelAndView mav = new ModelAndView("pages/add");
		mav.addObject("exception", error);
		return mav;
	}

	public StudentDaoImpl getStudentDaoImpl() {
		return studentDaoImpl;
	}
	public void setStudentDaoImpl(StudentDaoImpl studentDaoImpl) {
		this.studentDaoImpl = studentDaoImpl;
	}
}

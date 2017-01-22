package org.mz.spring.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mz.spring.dao.StudentDaoImpl;
import org.mz.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadStudentImageController {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@RequestMapping(value="/uploadAction", method = RequestMethod.POST)
	public ModelAndView uploadStudentImage(@ModelAttribute("student") Student student,BindingResult result,HttpServletRequest request){
		if(result.hasErrors()){
			ModelAndView model=new ModelAndView("pages/add");
			return model;
		}
		MultipartFile multipartFile = student.getFile();
		String destPathOfUserPic = request.getServletContext().getRealPath("/"+"/resources/images/userPic/");
		student.setFileName(student.getRollNumber()+".jpg");
		File studentPicFile=new File(destPathOfUserPic+File.separator+student.getFileName());
		try {
			multipartFile.transferTo(studentPicFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public StudentDaoImpl getStudentDaoImpl() {
		return studentDaoImpl;
	}

	public void setStudentDaoImpl(StudentDaoImpl studentDaoImpl) {
		this.studentDaoImpl = studentDaoImpl;
	}
}

package org.mz.spring.controller;


import java.io.IOException;

import org.mz.spring.dao.StudentDaoImpl;
import org.mz.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteStudentController {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@RequestMapping( value = "/deleteAction/{studentRoll}" , method = RequestMethod.GET)
	public ModelAndView deleteStudents(@PathVariable("studentRoll") int studentRoll,@ModelAttribute("student") Student student,BindingResult result) throws IOException{
		if(result.hasErrors()){
			ModelAndView model=new ModelAndView("pages/add");
			return model;
		}
		else{
			studentDaoImpl.deleteStudent(studentRoll); 
			return null;
		}
	}

	public StudentDaoImpl getStudentDaoImpl() {
		return studentDaoImpl;
	}
	public void setStudentDaoImpl(StudentDaoImpl studentDaoImpl) {
		this.studentDaoImpl = studentDaoImpl;
	}
}

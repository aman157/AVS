package org.mz.spring.controller;

import java.util.List;

import org.mz.spring.dao.StudentDaoImpl;
import org.mz.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewStudentController {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@RequestMapping( value = "/view")
	public ModelAndView getAllStudents(){
		List<Student> listStudent= studentDaoImpl.getAllStudents(); 
		ModelAndView model = new ModelAndView("pages/view");
		model.addObject("listofStudent",listStudent);
		return model;
	}

	public StudentDaoImpl getStudentDaoImpl() {
		return studentDaoImpl;
	}
	public void setStudentDaoImpl(StudentDaoImpl studentDaoImpl) {
		this.studentDaoImpl = studentDaoImpl;
	}
}

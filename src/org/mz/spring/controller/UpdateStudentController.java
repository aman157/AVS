package org.mz.spring.controller;

import org.mz.spring.dao.StudentDaoImpl;
import org.mz.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateStudentController {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@RequestMapping(value="/editAction", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute("student") Student student,BindingResult result){
		if(result.hasErrors()){
			ModelAndView model=new ModelAndView("pages/add");
			return model;
		}
		studentDaoImpl.updateStudent(student);
		ModelAndView model=new ModelAndView("pages/add");
		model.addObject("status", "Record Insert Successfully");
		return model;
	}

	public StudentDaoImpl getStudentDaoImpl() {
		return studentDaoImpl;
	}

	public void setStudentDaoImpl(StudentDaoImpl studentDaoImpl) {
		this.studentDaoImpl = studentDaoImpl;
	}
}

package org.mz.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.mz.spring.dao.StudentDaoImpl;
import org.mz.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchStudentController {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@RequestMapping(value="/searchAction")
	public ModelAndView searchStudent(@Valid @ModelAttribute("student")Student student,BindingResult result,Model model){
		BeanPropertyBindingResult result2=null;
		if(result.hasErrors()){
			result2 = new BeanPropertyBindingResult(student, result.getObjectName());
			for(ObjectError error: result.getGlobalErrors()) {
				result2.addError(error);
			}
			for (FieldError error: result.getFieldErrors()) {
				if(error.getRejectedValue()!=null && !error.getRejectedValue().toString().trim().isEmpty()){
					result2.addError(new FieldError(error.getObjectName(), error.getField(), null, error.isBindingFailure(), error.getCodes(), error.getArguments(), error.getDefaultMessage()));
				}
			}
		}
		if(result2!=null && result2.hasErrors()){
			ModelAndView model1=new ModelAndView("pages/search");
			model.addAllAttributes(result2.getModel());
			return model1;
		}
		List<Student> listStudent= studentDaoImpl.searchStudentRecord(student);
		ModelAndView model1 = new ModelAndView("pages/view");
		model1.addObject("listofStudent",listStudent);
		return model1;
	}

	public StudentDaoImpl getStudentDaoImpl() {
		return studentDaoImpl;
	}
	public void setStudentDaoImpl(StudentDaoImpl studentDaoImpl) {
		this.studentDaoImpl = studentDaoImpl;
	}
}

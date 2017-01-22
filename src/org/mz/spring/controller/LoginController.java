package org.mz.spring.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mz.spring.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController{

	@RequestMapping(value = "/loginAction")
	public String loginStep(@Valid @ModelAttribute("login") Login login ,BindingResult result,HttpSession session){
		if(result.hasErrors()){
			return "forward:login";
		}
		if(!login.getPassword().equals("admin")){
			return "forward:login";
		}
		session.setAttribute("username", login.getUsername());
		return "forward:home";
	}

	@RequestMapping(value="/login")
	public ModelAndView loginPage(){
		return new ModelAndView("index");
	}

	@RequestMapping(value="/home")
	public ModelAndView home(){
		return new ModelAndView("pages/add");
	}

	@RequestMapping(value = "/logout")
	public String logoutAdmissionForm(HttpSession session){
		session.invalidate();
		return "redirect:login";
	}

	//The process for login interceptor and making session end

	@RequestMapping(value="search")
	public ModelAndView search(){
		return new ModelAndView("pages/search");
	}
}
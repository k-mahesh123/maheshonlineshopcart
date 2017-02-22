package com.niit.Shopingcart.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopinngcart1.dao.ProductDao;
import com.niit.shopinngcart1.dao.UserDao;
import com.niit.shopinngcart1.dao.UserSignUPDao;

import com.niit.shopinngcart1.model.Editor;
import com.niit.shopinngcart1.model.Supplier;
import com.niit.shopinngcart1.model.User;
import com.niit.shopinngcart1.model.UserSignUP;




@Controller
public class HomeController
{

	@Autowired 
	UserSignUPDao user;
	@Autowired 
	UserSignUP user2;
	@Autowired
	User usr;
	@Autowired
	UserDao userdao;
	@Autowired
	ProductDao productdao;
	
	
	//it opens first page when application is executed//
	@RequestMapping("/")
  
	public ModelAndView myHomePage()
	{
	
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView checkUserOne(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		
		if (request.isUserInRole("ROLE_ADMIN")) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String str = auth.getName(); // get username
			session = request.getSession(true);
			session.setAttribute("loggedInUser", str);
		    
			ModelAndView m1 = new ModelAndView("adminHome");
			
			return m1;
		}
		
		else if (request.isUserInRole("ROLE_USER"))
		{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String str = auth.getName();
			session = request.getSession(true);
			session.setAttribute("loggedInUser", str);
			ModelAndView m2 = new ModelAndView("userhome");
			
			return m2;
		}
		else
		{
			return new ModelAndView("home");
		}
		
	}
	@RequestMapping("/contact")
	public ModelAndView contact() {
		return new ModelAndView("contact");
	}
	@RequestMapping("/userhome")
	public ModelAndView userhome() {
		return new ModelAndView("userhome");
	}
	
	@RequestMapping(value = "/fail2login", method = RequestMethod.GET)
	public ModelAndView loginerror() {
		return new ModelAndView("login1", "error", true);
	}
	@RequestMapping(value = "/logoutsuccess", method = RequestMethod.GET)
	public ModelAndView logout() {
		return new ModelAndView("logout");
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public ModelAndView adminhome() {
		return new ModelAndView("adminHome");
	}


}

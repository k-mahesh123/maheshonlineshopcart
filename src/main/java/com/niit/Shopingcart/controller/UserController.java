package com.niit.Shopingcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopinngcart1.dao.SupplierDao;
import com.niit.shopinngcart1.dao.UserDao;
import com.niit.shopinngcart1.dao.UserSignUPDao;
import com.niit.shopinngcart1.model.Editor;
import com.niit.shopinngcart1.model.Product;
import com.niit.shopinngcart1.model.User;
import com.niit.shopinngcart1.model.UserSignUP;

@Controller
public class UserController {
	@Autowired
	private SupplierDao supplierdao;
	@Autowired
	private UserDao userdao;
	@Autowired
	private User usr;
	@Autowired
	private UserSignUPDao usersignupdao;
	@ModelAttribute("UserSignUP")
	public UserSignUP createUser() {
		return new UserSignUP();
	}
	

	// it opens the login page
	@RequestMapping("/login")
	  
	public ModelAndView myLoginPage()
	{
		
		ModelAndView mv=new ModelAndView("login1");
		return mv;
	}


	//registration page adding feilds of user		
	@RequestMapping("/register")
	  
	public ModelAndView myRegisterPage()
	{
		
		ModelAndView mv=new ModelAndView("registration");
		return mv;
	}


	@InitBinder
	public void initbinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(String.class, "mobilenumber",new Editor() );
		binder.registerCustomEditor(StringBuffer.class, "name",new Editor() );
		
	}
	@RequestMapping(value="signup",method=RequestMethod.POST)
	public ModelAndView mySignUp(@Valid @ModelAttribute("signup")UserSignUP signup,BindingResult result)
	{
	if(result.hasErrors())
	{
		System.out.println("HAS ERRORS");
		ModelAndView mv=new ModelAndView("registration");
		return mv;
	}
	
	
		ModelAndView mv=new ModelAndView("home");
		usersignupdao.save(signup);
		System.out.println(signup.getUsername());
		usr.setUsername(signup.getUsername());
		usr.setPassword(signup.getPassword());
		usr.setRole(signup.getRole());
		usr.setStatus(signup.isStatus());
	       
	      userdao.save(usr);
		

		return mv;
	}
	@RequestMapping("/updateuser")
	

	public ModelAndView updateSup(@RequestParam String username,@Valid @ModelAttribute("signup")UserSignUP signup,BindingResult result)
	{
		if (result.hasErrors()) {
			 
			return new ModelAndView("edituser");
		    
		  }

		usersignupdao.update(signup);
		
		usr.setUsername(signup.getUsername());
		usr.setPassword(signup.getPassword());
		usr.setRole(signup.getRole());
		usr.setStatus(signup.isStatus());
	       
	      userdao.update(usr);
	      
		

		return new ModelAndView("userview");
		
	}
	@RequestMapping("/userview")
	public ModelAndView userview()
	{
		
		ModelAndView mv2=new ModelAndView("userview");
		mv2.addObject("user",usersignupdao.getAllUsers());
		return mv2;
		
	}
	@RequestMapping("/viewofeachuser")
	public ModelAndView viewSup(@RequestParam String username) {
		ModelAndView mv3=new ModelAndView ("viewofeachuser");
		mv3.addObject("user1",usersignupdao.getSingleuser(username));
		
				
		return mv3;
	}
	@RequestMapping("/edituser")
	public ModelAndView editSup(@RequestParam String username) {
		ModelAndView mv5=new ModelAndView ("edituser");
		mv5.addObject("user",usersignupdao.getSingleuser(username));
				
		return mv5;
	}
	
}
	


	 
	


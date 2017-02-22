package com.niit.Shopingcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopinngcart1.dao.SupplierDao;
import com.niit.shopinngcart1.model.Supplier;


@Controller
public class SupplierController {

@RequestMapping("/supplier")
public ModelAndView AddSupplier()
{
	ModelAndView mv=new ModelAndView("supplier1");
	return mv;
}
@Autowired
private SupplierDao supplierdao;
@Autowired
private Supplier supplier;

@RequestMapping(value="supreg", method=RequestMethod.POST)
public String StoreSupplier( @Valid @ModelAttribute("supplier") Supplier supplier,BindingResult result,Model model)
{
if(result.hasErrors())
{
	return "supplier1";
}

 supplierdao.save(supplier);
 model.addAttribute("sup",supplierdao.getAllSuppliers());
 return "supplierview";
}

@RequestMapping("/supplierview")
public ModelAndView supplierview()
{
	List supplier=supplierdao.getAllSuppliers();
	ModelAndView mv2=new ModelAndView("supplierview");
	mv2.addObject("sup",supplier);
	return mv2;
	
}
@RequestMapping("/viewofeachsupplier")
public ModelAndView viewSup(@RequestParam int supid) {
	ModelAndView mv3=new ModelAndView ("viewofeachsupplier");
	mv3.addObject("sup",supplierdao.getSingleSupplier(supid));
			
	return mv3;
}

@RequestMapping("/deletesupplier")
public String deleteSup(@RequestParam int supid,Model model) {
	
	
	supplierdao.delete(supid);
	
	
	model.addAttribute("sup",supplierdao.getAllSuppliers());
	return "redirect:/supplierview";

	
			

}
@RequestMapping("/editsupplier")
public ModelAndView editSup(@RequestParam int supid) {
	ModelAndView mv5=new ModelAndView ("editsupplier");
	mv5.addObject("sup",supplierdao.getSingleSupplier(supid));

			
	return mv5;
}
@RequestMapping(value="/updatesupplier", method=RequestMethod.POST)

public String updateSup(@RequestParam int supid,@Valid @ModelAttribute("supplier") Supplier supplier,BindingResult result,Model model)
{
	if (result.hasErrors()) {
		return  "redirect:/editsupplier";
	  }
	supplierdao.update(supplier);
	ModelAndView mv6=new ModelAndView ("supplierview");
	model.addAttribute("sup",supplierdao.getAllSuppliers());
	return "redirect:/supplierview";
	
}
}

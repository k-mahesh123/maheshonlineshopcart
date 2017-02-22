package com.niit.Shopingcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopinngcart1.dao.CategoryDao;
import com.niit.shopinngcart1.dao.SupplierDao;
import com.niit.shopinngcart1.model.Category;
import com.niit.shopinngcart1.model.Supplier;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryDao categorydao;

	@Autowired
	SupplierDao supplierdao;
	
	
	
	@ ModelAttribute("Category")
	 public Category mycategory()
	 {
		 return new Category();
	 }
	
	
	
	@RequestMapping("/category")
	public String category(Model model)
	{
		model.addAttribute("suppliers",supplierdao.getAllSuppliers());
		return"category";
	}

@RequestMapping("/categoryview")
public String categoryview(Model mv)
{
	mv.addAttribute("category",categorydao.getAllCategorys());
	return"categoryview";
}
	

@RequestMapping("/addcategory")
	public String  addCategory(@Valid@ModelAttribute("Category")Category category,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "category";
		}
		System.out.println(category);
		
		categorydao.add(category);
		return"supplier1";
	}


	@RequestMapping("/viewcategory")
	public ModelAndView myproductview()
	{
		ModelAndView mv=new ModelAndView("viewproducts");
		mv.addObject("category",categorydao.getAllCategorys());

		return mv;
		
	}
	
	@RequestMapping("/viewofeachcategory")
	public String viewSup(@RequestParam int categoryid,Model model)throws Exception {
	
		model.addAttribute("c",categorydao.getsinglecategory(categoryid));
				
		return "viewofeachcategory";
	}
	@RequestMapping("/editcategory")
	public String editCategory(@RequestParam int categoryid,Model model)throws Exception {
		
		model.addAttribute("c",categorydao.getsinglecategory(categoryid));
		model.addAttribute("suppliers",supplierdao.getAllSuppliers());

				
		return "editcategory";
	}
	@RequestMapping("/updatecategory")
	public String updateSup(@RequestParam int categoryid,@Valid @ModelAttribute("Category") Category category,BindingResult result,Model model)throws Exception
	{
		if (result.hasErrors()) {
		    
		  }
		categorydao.edit(category);
		
	
		return "forward:/categoryview";
		
	}
	@RequestMapping("deletecategory")
	public String deleteSup(@RequestParam int categoryid,Model model)throws Exception {
		
		categorydao.delete(categoryid);

		
		model.addAttribute("category",categorydao.getAllCategorys());
		return "forward:/categoryview";

}
}

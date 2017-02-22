package com.niit.Shopingcart.controller;



import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shopinngcart1.dao.CategoryDao;
import com.niit.shopinngcart1.dao.ProductDao;
import com.niit.shopinngcart1.dao.SupplierDao;
import com.niit.shopinngcart1.model.Product;
import com.niit.shopinngcart1.model.Supplier;


@Controller
public class ProductController {

	@Autowired
    Product product;
	@Autowired
    ProductDao productdao;
	@Autowired
	SupplierDao supplierdao;
	@Autowired
    CategoryDao categorydao;
    
	//to create product object in jsp command arugument
	@ModelAttribute("Product")
	public Product createProduct() {
		return new Product();
	}
	
	//it help to avoid  calling methods getallsuppliersandproducts mltiple times
//	@ModelAttribute("")
//	public void allsuppliersandproducts(Model mv) {
//		
//		 mv.addAttribute("suppliers", supplierdao.getAllSuppliers());
//		 mv.addAttribute("product",productdao.getAllProducts());
//	}
//	
	
	
	//get all suppliers to product table

	@RequestMapping("/product")
	public ModelAndView myproduct()
	{
		ModelAndView mv=new ModelAndView("product");
		 mv.addObject("suppliers", supplierdao.getAllSuppliers());
		 mv.addObject("category", categorydao.getAllCategorys());
			
	
		return mv;
	}
	
			
//to get all product details
@RequestMapping("/viewproduct")
public ModelAndView myproductview()
{
	ModelAndView mv=new ModelAndView("viewproducts");
	mv.addObject("product",productdao.getAllProducts());

	return mv;
	
}

//to view each single product
@RequestMapping("/viewofeachproduct")
public ModelAndView singleProduct(@RequestParam int productid)
{
	ModelAndView mv=new ModelAndView("viewofeachproduct");
	mv.addObject("products",productdao.getsingleproduct(productid));
	return mv;
}

//to get all products and suppliers name  to edit
@RequestMapping("/editproduct")
public ModelAndView editProduct(@RequestParam int productid)
{
	ModelAndView mv=new ModelAndView("editproduct");
	mv.addObject("product",productdao.getsingleproduct(productid));
	 mv.addObject("suppliers", supplierdao.getAllSuppliers());
	
	return mv;
}

//to  delete single product
@RequestMapping("/deleteproduct")
public String delete(@RequestParam int productid,Model model)
{
	productdao.delete(productid);
	model.addAttribute("product",productdao.getAllProducts());
	return "viewproducts";
}


//to save product details into data base through save method
	private static final String UPLOAD_DIRECTORY ="resources/imgs";  

	 
@RequestMapping(value="/updateproduct",method=RequestMethod.POST)
	

	public ModelAndView updateproduct(HttpSession session,HttpServletRequest request,@RequestParam int productid,@Valid @ModelAttribute("product") Product product,BindingResult result)throws IOException
	{	
	System.out.println("HELLO BINDU");
	if (result.hasErrors()) {
	 ModelAndView mv=new ModelAndView("product");
		mv.addObject("suppliers", supplierdao.getAllSuppliers());
		 mv.addObject("category", categorydao.getAllCategorys());
			return mv;
		}
	
	System.out.println(product.getProductid());
	System.out.println(product.getProductname());
	System.out.println(product.getProductprice());
	System.out.println(product.getProductwaranty());
	System.out.println(product.getImg().getOriginalFilename());
	
		String filename = product.getImg().getOriginalFilename();
		product.setImage(filename);

		
			byte[] bytes = new byte[product.getImg().getInputStream().available()];
			product.getImg().getInputStream().read(bytes);
			BufferedInputStream buffer = new BufferedInputStream(product.getImg().getInputStream());
			MultipartFile file = product.getImg();
			ServletContext context = session.getServletContext();  
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		System.out.println(path);
		
			File rootPath = new File(path);
			if (!rootPath.exists())
				rootPath.mkdirs();
			File store = new File(rootPath.getAbsolutePath() + "/" + filename);
			System.out.println("Image path :" + path);
			OutputStream os;
			try {
				os = new FileOutputStream(store);
				os.write(bytes);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		product.setPath(path);
		productdao.edit(product);
		return new ModelAndView("viewproducts","product",productdao.getAllProducts());  
		  
	
}
@RequestMapping(value="/addproduct",method=RequestMethod.POST)
public ModelAndView addproduct(HttpSession session,HttpServletRequest request, @Valid @ModelAttribute Product product,BindingResult result) throws IOException{
	if (result.hasErrors()) {
		ModelAndView mv=new ModelAndView("product");
		mv.addObject("product",productdao.getAllProducts());
		 mv.addObject("suppliers", supplierdao.getAllSuppliers());
		return mv;
		    
		  }

		String filename = product.getImg().getOriginalFilename();
		product.setImage(filename);

		
			
				byte[] bytes = new byte[product.getImg().getInputStream().available()];
				product.getImg().getInputStream().read(bytes);
				BufferedInputStream buffer = new BufferedInputStream(product.getImg().getInputStream());
				MultipartFile file = product.getImg();
				ServletContext context = session.getServletContext();
				String path = context.getRealPath(UPLOAD_DIRECTORY);
				File rootPath = new File(path);
				product.setPath(path);
				if (!rootPath.exists())
					rootPath.mkdirs();
				File store = new File(rootPath.getAbsolutePath() + "/" + filename);
				System.out.println("Image path :" + path);
				OutputStream os;
				try{
				os = new FileOutputStream(store);
				os.write(bytes);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		productdao.add(product);
		 return new ModelAndView("viewproducts","product",productdao.getAllProducts());  
	
		
}
}


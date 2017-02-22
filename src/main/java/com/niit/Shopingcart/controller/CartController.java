package com.niit.Shopingcart.controller;


import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;

import org.h2.mvstore.db.TransactionStore.Change;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shopinngcart1.dao.CartDao;
import com.niit.shopinngcart1.dao.ProductDao;
import com.niit.shopinngcart1.dao.UserSignUPDao;
import com.niit.shopinngcart1.model.CartItem;
import com.niit.shopinngcart1.model.Product;
import com.niit.shopinngcart1.model.User;
import com.niit.shopinngcart1.model.UserSignUP;


@Controller
public class CartController 
{
	@Autowired
	 CartItem cartItem;
	@Autowired
	ProductDao productdao;
	@Autowired
	CartDao cartdao;
	@Autowired
    User user;
	@Autowired
	UserSignUPDao u;

	
	   
	
	 @RequestMapping(value="viewCart",method=RequestMethod.GET)
		public String vcHello(@RequestParam int productid,HttpSession session)
		{  
		 String username=(String)session.getAttribute("loggedInUser");
//        Session s1=sf.openSession();
//        Transaction t=s1.beginTransaction();
//    	 Query q=s1.createQuery("from User where username='"+username+"'");
//         List<User> li=q.list();
//	      User count1=(User)li.get(0);
//	    User user=(User)s1.get(User.class,(Integer)count1.getUserid());
//		 System.out.println(user.getUsername()+"hello hello");
//		 System.out.println("#########################"+username+"@@@@@@@@@@@@@@@@@@@@@@"); 
		 
	    Product product=productdao.getsingleproduct(productid);
	    CartItem cartItem=new CartItem();
	   
	   
	   	List list=cartdao.getAllItems();
	   	System.out.println("List size......."+list.size());
	   	for(int i=0;list.size()>i;i++)
	   	{
	   	  CartItem cti=(CartItem)list.get(i);
	   	  if(productid==cti.getId())
	   	  {
	   
	    cartItem.setId(product.getProductid());
	    cartItem.setName(product.getProductname());
	    cartItem.setPrice(product.getProductprice());
	    
	   cartItem.setQuantity(cartItem.getQuantity()+1+cti.getQuantity());
	
	    cartItem.setPrice(product.getProductprice()*cartItem.getQuantity());
	    
	    cartdao.add(cartItem);
       int count=cartItem.getCartItemId();
        cartdao.delete(--count);
    
	    
	    return "viewcart";
	   	}
	   	}
	   	
	   	cartItem.setId(product.getProductid());
	    cartItem.setName(product.getProductname());
	    cartItem.setPrice(product.getProductprice());
	    
	    cartItem.setQuantity(cartItem.getQuantity()+1);
	   
	    cartItem.setPrice(product.getProductprice()*cartItem.getQuantity());
	   
	    cartdao.add(cartItem);    
		  
	    return "viewcart";
	    }
		  
	 @RequestMapping(value="/listone",method=RequestMethod.GET,produces="application/json")
	    public @ResponseBody String showListOne(){
	    	List blist=cartdao.getAllItems();
	    	Gson x=new Gson();
	    	String json=x.toJson(blist);
	    	return json;
	    }

	 @RequestMapping("/deleteItemCart")
	    public ModelAndView deleteProduct(@RequestParam int id,Model model)
	    {
		 
         cartdao.delete(id);
         model.addAttribute("cart", cartdao.getAllItems());
	    	return new ModelAndView("viewcart");
	    }
	 @RequestMapping("/removeAll")
	 public ModelAndView removeAllItem()
	 {
		 cartdao.removeAll();
		 return new ModelAndView("viewcart");
	 }
	 @RequestMapping("/alert")
	 public ModelAndView dis()
	 {
		  return new ModelAndView("alert");
	 }
	 @RequestMapping("/Enduser")
	 public ModelAndView disp()
	 {
		 
		  return new ModelAndView("viewproducts","product",productdao.getAllProducts());
	 }
	 @RequestMapping(value="/checkOut",method=RequestMethod.GET)
	    public void createOrder()
		{
			
			System.out.println("Hello mahesh  ");
			
			
	    }

	
	 
	 
}

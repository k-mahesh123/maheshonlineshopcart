package com.niit.shopinngcart1.model;

import java.beans.PropertyEditorSupport;

public class Editor extends PropertyEditorSupport
{ 

	public void setAsText(String mobilenumber) throws IllegalArgumentException
	{ 
		if(mobilenumber!=("+91")+mobilenumber)
		{
			
		
		setValue(mobilenumber);
		
		
	}
		else
		{
			mobilenumber=("+91")+mobilenumber;
			
			setValue(mobilenumber);
		}
	}
	public void setAsText1(StringBuffer name) throws IllegalArgumentException
	{
		
		StringBuffer s1=new StringBuffer("mr.");
		name=s1.append(name);
		
			setValue(name);
		
	}



}

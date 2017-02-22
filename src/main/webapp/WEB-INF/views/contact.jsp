<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home">OnlineShop-Home</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      
      <li><a href="<c:url value='viewproduct'/>">product</a></li>
       <li><a href="viewproduct">AboutAs</a></li>
        <li><a href="contact">ContactUs</a></li>
         <li><a href="viewcart">Cart</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
  
</div>
<center>
<h1>WelCome To   OnlineShopping</h1>
<h1>CONTACT-AS</h1>
<H3>NAME:MAHESH KUMAR</H3>
<H3>MOBILE:9703208911</H3>
<H3>EMAIL:MAHESH.970308911</H3>
<H3>ADDRESS:HYDERABAD
    POSTAL:502313
</center>
</H3> 
<%@ include file="userfooter.jsp" %>

</body>
</html>
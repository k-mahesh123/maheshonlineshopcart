<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

      
<html>
<head>

  <title>Home Page</title>
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>Login</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style type="text/css">
.errorblock {
 color: #ff0000;
 background-color: #0000;
 border: 3px solid #ff0000;
 padding: 8px;
 margin: 16px;
}
.logoutblock {
 color: blue;
 background-color: lightgreen;
 border: 3px solid blue;
 padding: 8px;
 margin: 16px;
}
</style>
</head>
<body >



<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home">OnlineShop-Home</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      
      <li><a href="viewproduct">product</a></li>
       <li><a href="contact">AboutAs</a></li>
         <li><a href="contact">ContactUs</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     
    </ul>
  </div>
</nav>
<div class="container">
<c:if test="${error=='true'}">
  <div class="errorblock">
   Please enter valid Username or Password
 
  </div>
 </c:if>
 <c:if test="${not empty logoutmsg }">
   <div class="logoutblock">
   <c:out value="${logoutmsg}" />
   </div>
 </c:if>
 
 <form role="form" action="j_spring_security_check" method="post" commandName="User" >
 
    
                    <div class="form" >
							  <label for="username" class="cols-sm-6 control-label">Username</label>
							
								<div class="input-group">
									<span class="input-group-addon" ><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text"  name="username" id="username"  placeholder="Enter your Username"/>
								
								</div>
							</div>
						
						
					<div class="form-group">
							<label for="password" class="cols-sm-1 control-label">Password</label>
				
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password"  name="password" id="password"  placeholder="Enter your Password"/>
									
								</div>
							</div>
						
						

  
  
  <button type="submit"  class="btn btn-default" >Login</button>
</form>

</div>

</body>

</html>
<%@ include file="userfooter.jsp" %>
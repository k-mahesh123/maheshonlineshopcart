<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Add a product</title>
</head>
<body>

<sec:authorize access="hasRole('ROLE_ADMIN')">
<%@ include file="adminnav.jsp" %>
 </sec:authorize>
 <sec:authorize access="hasRole('ROLE_USER')">
<%@ include file="usernav.jsp" %>
 </sec:authorize>
<h1>USER DETAILS</h1>
<table border="2"  width="100%">
<tr >
<th>DateOfBirth</th>
<th>MailId</th>
<th>MobileNumber</th>
<th>UserName</th>
<th>Password</th>
<th>RegId</th>
<th>Role</th>
<th>Status</th>
<th>Name</th>
<th colspan="6">admin tools</th>
</tr>
<c:forEach items="${user}" var="user1">
<tr >
 <td> ${user1.dob}<br></td>
 <td> ${user1.email}<br></td>
 <td> ${user1.mobilenumber}<br></td>
  <td>${user1.username}<br></td>
  <td>${user1.password}<br></td>
  <td>${user1.registrationid}<br></td>
  <td>${user1.role}<br></td>
  <td>${user1.status}<br></td>
  <td>${user1.name}<br></td>
  
  <td><a href="<c:url value='/viewofeachuser?username=${user1.username}'/>"> <button style="font-size:10pt;color:white;background-color:#00ff00;border:3px solid #336600;padding:8px" >VIEW</button></a></td> 
   
    
</tr>
</c:forEach>
</table>
<sec:authorize access="hasRole('ROLE_ADMIN')">
      	<%@ include file="adminfooter.jsp" %>
   
      </sec:authorize>
      <sec:authorize access="hasRole('ROLE_USER')">
      	<%@ include file="userfooter.jsp" %>
   
      </sec:authorize>
</body>
</html>
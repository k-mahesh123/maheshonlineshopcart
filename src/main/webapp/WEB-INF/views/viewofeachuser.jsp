<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<%--   <link rel="stylesheet" href='<x:url value="/resources/css/bootstrap.min.css"></x:url>' /> --%>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<%@ include file="adminnav.jsp" %>
 </sec:authorize>
 <sec:authorize access="hasRole('ROLE_USER')">
<%@ include file="usernav.jsp" %>
 </sec:authorize>

<table border=""  width="100%">
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
   <sec:authorize access="hasRole('ROLE_USER')">
  <td><a href="<c:url value='/edituser?username=${user1.username}'/>"> <button style="font-size:10pt;color:white;background-color:#0080ff;border:3px solid #336600;padding:8px" >EDIT</button></a></td> 
  
 </sec:authorize>
</tr></table>
<sec:authorize access="hasRole('ROLE_ADMIN')">
      	<%@ include file="adminfooter.jsp" %>
   
      </sec:authorize>
      <sec:authorize access="hasRole('ROLE_USER')">
      	<%@ include file="userfooter.jsp" %>
   
      </sec:authorize>
</body>
</html>
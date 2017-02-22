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
<h1>category  DETAILS</h1>
<center>
<table border="2"  width="50%">
<tr >
<th>Categoryid</th>

<th>CategoryName</th>
<th>SupplierName</th>

<th colspan="6">admin tools</th>
</tr>
<c:forEach items="${category}" var="category">
<tr >
 <td> ${category.categoryid}<br></td>

 <td> ${category.categoryname}<br></td>
  <td>${category.suppliername}<br></td>
  <td><a href="<c:url value='viewofeachcategory?categoryid=${category.categoryid}'/>"/><button style="font-size:10pt;color:white;background-color:#00ff00;border:3px solid #336600;padding:8px" >VIEW</button></a></td>
  <sec:authorize access="hasRole('ROLE_ADMIN')">
  <td><a href="<c:url value='editcategory?categoryid=${category.categoryid}'/>"/> <button style="font-size:10pt;color:white;background-color:#0080ff;border:3px solid #336600;padding:8px" >EDIT</button></a></td>
   <td><a href="<c:url value='deletecategory?categoryid=${category.categoryid}'/>"/><button style="font-size:10pt;color:white;background-color:#ff8080;border:3px solid #336600;padding:8px" >DELETE</button></a></td>
</sec:authorize>
</tr>
</c:forEach>
</table></center>
<sec:authorize access="hasRole('ROLE_ADMIN')">
      	<%@ include file="adminfooter.jsp" %>
   
      </sec:authorize>
      <sec:authorize access="hasRole('ROLE_USER')">
      	<%@ include file="userfooter.jsp" %>
   
      </sec:authorize>
</body>
</html>
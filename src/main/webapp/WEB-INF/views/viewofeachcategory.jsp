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
DETAILS OF SUPPLIER ID ${c.categoryid} 
<table border=""  width="100%">
<tr >
<th>id</th>
<th>CategoryName</th>
<th>SupplierName</th>

</tr>
<tr >
 <td> ${c.categoryid}<br></td>
 <td> ${c.categoryname}<br></td>
 <td> ${c.suppliername}<br></td>
  
  
</tr></table>
<sec:authorize access="hasRole('ROLE_ADMIN')">
      	<%@ include file="adminfooter.jsp" %>
   
      </sec:authorize>
      <sec:authorize access="hasRole('ROLE_USER')">
      	<%@ include file="userfooter.jsp" %>
   
      </sec:authorize>
</body>
</html>
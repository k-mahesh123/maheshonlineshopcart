<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
"src/main/webapp/WEB-INF/views/supplierview.jsp"
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
<h1>SUPPLIER DETAILS</h1>
<table border="2"  width="100%">
<tr >
<th>id</th>
<th>address</th>
<th>name</th>
<th>contact</th>
<th>email</th>
<th colspan="6">admin tools</th>
</tr>
<c:forEach items="${sup}" var="sup1">
<tr >
 <td> ${sup1.supid}<br></td>
 <td> ${sup1.supaddress}<br></td>
 <td> ${sup1.supname}<br></td>
  <td>${sup1.supcontact}<br></td>
  <td>${sup1.supemail}<br></td>
  <td><a href="<c:url value='/viewofeachsupplier?supid=${sup1.supid}'/>"> <button style="font-size:10pt;color:white;background-color:#00ff00;border:3px solid #336600;padding:8px" >VIEW</button></a></td>
  <sec:authorize access="hasRole('ROLE_ADMIN')">
  <td><a href="<c:url value='/editsupplier?supid=${sup1.supid}'/>"> <button style="font-size:10pt;color:white;background-color:#0080ff;border:3px solid #336600;padding:8px" >EDIT</button></a></td>
  <td><a href="<c:url value='/deletesupplier?supid=${sup1.supid}'/>"> <button style="font-size:10pt;color:white;background-color:#ff8080;border:3px solid #336600;padding:8px" >DELETE</button></a></td>
</sec:authorize>
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
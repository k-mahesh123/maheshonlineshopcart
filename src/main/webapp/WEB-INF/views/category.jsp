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

<h2>Add a category</h2>
 
     <c:url var="addcategory" value="addcategory"></c:url>
  <form:form commandName="Category" method="post" action="addcategory" >
       <table class="table table-bordered" >
           <tr><td><form:label path="categoryname">category  Name :</form:label></td>
               <td><form:input path="categoryname"/>
               <font color="red"><form:errors path="categoryname"></form:errors></font></td>
           </tr>
           
                        <tr><td><form:label path="suppliername">Supplier Name:</form:label></td>
               <td><select name="Suppliername">
   				 <option value="">---Select---</option>
   				 <c:forEach var="Supplier" items="${suppliers}">
   				 <option value="${Supplier.supname}">${Supplier.supname}</option>
    		</c:forEach>
    		</select></td></tr>
            
          </table>
                 <center>
   
             <td><input type="submit" value="AddCategory" class="btn-success"/></td>
             </center>
      
   </form:form> 
   <sec:authorize access="hasRole('ROLE_ADMIN')">
      	<%@ include file="adminfooter.jsp" %>
   
      </sec:authorize>
      <sec:authorize access="hasRole('ROLE_USER')">
      	<%@ include file="userfooter.jsp" %>
   
      </sec:authorize>
  
   	
   
</body>
</html>
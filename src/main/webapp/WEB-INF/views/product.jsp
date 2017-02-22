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
 <h2>Add Products:</h2>
     <c:url var="addproduct" value="addproduct"></c:url>
  <form:form commandName="Product" method="post" action="addproduct" enctype="multipart/form-data">
       <table class="table table-bordered" >
           <tr><td><form:label path="productname">product  Name :</form:label></td>
               <td><form:input path="productname"/>
               <font color="red"><form:errors path="productname"></form:errors></font></td>
           </tr>
           <tr><td><form:label path="productprice">product price :</form:label></td>
               <td><form:input path="productprice"/>
               <font color="red"><form:errors path="productprice"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="productwaranty">product waranty:</form:label></td>
               <td><form:input path="productwaranty"/>
               <font color="red"><form:errors path="Productwaranty"></form:errors></font></td>
           </tr>
                   
            <tr><td><form:label path="img">Book Image:</form:label></td>
               <td><form:input path="img" type="file"/>
               <font color="red"><form:errors path="img"></form:errors></font></td>  
           </tr>
                                  
         
               <tr><td><form:label path="suppliername">Supplier Name:</form:label></td>
               <td><select name="Suppliername">
   				 <option value="">---Select---</option>
   				 <c:forEach var="Supplier" items="${suppliers}">
   				 <option value="${Supplier.supname}">${Supplier.supname}</option>
    		</c:forEach>
    		</select></td></tr>
    		 <tr><td><form:label path="categoryname">Category Name:</form:label></td>
               <td><select name="categoryname">
   				 <option value="">---Select---</option>
   				 <c:forEach var="category" items="${category}">
   				 <option value="${category.categoryname}">${category.categoryname}</option>
    		</c:forEach>
    		</select></td></tr>
            
          </table>
                 <center>
   
             <td><input type="submit" value="Addproduct" class="btn-success"/></td>
             </center>
      
   </form:form> 
   </div>
   
   	<sec:authorize access="hasRole('ROLE_ADMIN')">
      	<%@ include file="adminfooter.jsp" %>
   
      </sec:authorize>
      <sec:authorize access="hasRole('ROLE_USER')">
      	<%@ include file="userfooter.jsp" %>
   
      </sec:authorize>
   
</body>
</html>
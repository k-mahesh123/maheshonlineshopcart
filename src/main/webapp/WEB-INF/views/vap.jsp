<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>

 
</head>
<body>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<%@ include file="adminnav.jsp" %>
 </sec:authorize>
 <sec:authorize access="hasRole('ROLE_USER')">
<%@ include file="usernav.jsp" %>
 </sec:authorize>
<h2>Product Details</h2>
  <c:forEach items="${product}" var="products">
      <div class="container">
            <table border="0">
            <tr><td rowspan="8">
           <img src='<c:url value="/resources/imgs/${products.image}"/>'/>
         
           <b>
           <tr><td><h4>NAME :${products.productname}</h4></b></td></td></tr>
           <tr><td><b><h3>PRICE:${products.productprice}</h3></b></td></tr>
           <tr><td> <b><h4>WARRANTY:${products.productwaranty}</h4></b></td></tr>
            <tr><td> <b><h4>SUPPLIERNAME:${products.suppliername}</h4></b></td></tr>
        <td>
          <sec:authorize access="hasRole('ROLE_USER')">
            <a href="<c:url value='/viewCart?productid=${products.productid}'/>"><button style="font-size:10pt;color:white;background-color:green;border:2px solid #336600;padding:6px">AddToCart</button></a>
           </sec:authorize> 
    <a href="<c:url value='viewofeachproduct?productid=${products.productid}'/>"><button style="font-size:10pt;color:white;background-color:green;border:2px solid #336600;padding:6px">VIEW</button></a>        
  <sec:authorize access="hasRole('ROLE_ADMIN')">
      <a href="<c:url value='editproduct?productid=${products.productid}'/>"> <button style="font-size:10pt;color:white;background-color:blue;border:2px solid #336600;padding:6px">EDIT</button></a>
  
    <a href="<c:url value='deleteproduct?productid=${products.productid}'/>"><button style="font-size:10pt;color:white;background-color:red;border:2px solid #336600;padding:6px">DELETE</button></a>
        </sec:authorize></td>
            </table>
            
      </div>
      
      </c:forEach>
      <sec:authorize access="hasRole('ROLE_ADMIN')">
      	<%@ include file="adminfooter.jsp" %>
   
      </sec:authorize>
      <sec:authorize access="hasRole('ROLE_USER')">
      	<%@ include file="userfooter.jsp" %>
   
      </sec:authorize>
   </body>
</html>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

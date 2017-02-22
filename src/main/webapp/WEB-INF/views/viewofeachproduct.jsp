<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

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

<h1>Product Details</h1>
 <div class="container">
            <table >
            <tr><td rowspan="12">
           <img src='<c:url value="/resources/imgs/${products.image}" />'width="500" height="700"/>
        
           	<td><h4>productId :${products.productid}</h4></td>
           <tr><td><h4>Name :${products.productname}</h4></td></tr>
           <tr><td><h4>Price:${products.productprice}</h4></td></tr>
           <tr><td> <h4>Warranty:${products.productwaranty}</h4></td></tr>
            <tr><td> <h4>SupplierName:${products.suppliername}</h4></td></tr>
           
            
                 
            
            </tr></td>
            
            </table>
      </div>
      <sec:authorize access="hasRole('ROLE_ADMIN')">
      	<%@ include file="adminfooter.jsp" %>
   
      </sec:authorize>
      <sec:authorize access="hasRole('ROLE_USER')">
      	<%@ include file="userfooter.jsp" %>
   
      </sec:authorize>
</body>
</html>
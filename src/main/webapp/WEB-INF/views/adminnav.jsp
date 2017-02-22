
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html lang="en">
<head>
  <title>Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">


  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="adminHome">Admin-OnlineShop</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="adminHome">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="<c:url value='categoryview'/>">ManageCategories<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value='category'/>">AddCategories</a></li>
          <li><a href="<c:url value='categoryview'/>">ViewCategories</a></li>
          <li><a href="<c:url value='categoryview'/>">EditCategories</a></li>
          <li><a href="<c:url value='categoryview'/>">delteCategories</a></li>
        </ul>
      </li>
     
  
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">ManageSupplier<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="supplier">AddSupplier</a></li>
           <li><a href="supplierview">ViewSupplier</a></li>
          <li><a href="supplierview">EditSupplier</a></li>
          <li><a href="supplierview">DelteSupplier</a></li>

        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">ManageProducts<span class="caret"></span></a>
        <ul class="dropdown-menu">
           <li><a href="product">AddProduct</a></li>
            <li><a href="viewproduct">ViewProduct</a></li>
          <li><a href="viewproduct">EditProduct</a></li>
          <li><a href="viewproduct">delteProduct</a></li>

        </ul>
      </li>
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">ManageProfile<span class="caret"></span></a>
        <ul class="dropdown-menu">
          
          <li><a href="viewofeachuser?username=<%=session.getAttribute("loggedInUser")%>">ProfileView</a></li>
          <li><a href="edituser?username=<%=session.getAttribute("loggedInUser")%>">ProfileEdit</a></li>
          <li><a href="userview">ViewUsers</a></li>
        </ul>
      </li>
      
      <li><a href="userview">ViewUsers</a></li>
      
       <li><a href="supplier">AddSupplier</a></li>
       <li><a href="product">Addproduct</a></li>
       <li><a href="<c:url value='category'/>">Addcategory</a></li>
       
       
    </ul>
    <ul class="nav navbar-nav navbar-right">
    
           <%=session.getAttribute("loggedInUser")%>
       
   
       <li><a href="viewofeachuser?username=<%=session.getAttribute("loggedInUser")%>"> <span class="glyphicon glyphicon-user">Hi <%=session.getAttribute("loggedInUser")%></span></a></li>
      
      <li><a href="<c:url value='j_spring_security_Logout'/>"><span class="glyphicon glyphicon-log-out">Logout</span></a></li>
    
    </ul>
  </div>
</nav>
   

</body>
</html>
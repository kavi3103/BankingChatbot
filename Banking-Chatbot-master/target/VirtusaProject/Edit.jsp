<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
<style type="text/css">
        body{ font: 14px sans-serif; color: #421; 
    font-weight: bold; 
    font-size: 18px; 
    font-family: "Courier New"; 
    background: rgb(200, 232, 241); }
        .wrapper{ width: 350px; padding: 20px; }
</style>
<script> 
function validate()
{  
     var name = document.form.name.value;
     var phone =  document.form.phone.value;
     var address =  document.form.address.value;
    
      if (name==null || name=="")
     { 
         alert("Name can't be blank"); 
         return false; 
     }
     else if (address==null || address=="")
     { 
         alert("Address can't be blank"); 
         return false; 
     }
     else if (phone.length != 10)
     { 
         alert("Phone Number must be 10 numbers long"); 
         return false; 
     }
 } 
</script> 
</head>
<body>
<center><h2>XYZ Bank</h2></center>
<% HttpSession session2=request.getSession(false);  
 String name=(String)session2.getAttribute("username"); 
 if(name == null){
	 request.getRequestDispatcher("login.jsp").forward(request, response); 
 }
 	
 %>
 <div style="text-align: right"> Welcome  <%=name %>  <a href="LogoutServlet" class="btn btn-danger">Logout</a></div>
<div  class="wrapper">
<%String username = (String)request.getAttribute("UserName"); %>
	<div style="text-align:center"><h3>Edit User</h3></div>
    <form name="form" action="EditServlet" method="post" onsubmit="return validate()">
    	<span class="help-block"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></span>
         <input type="hidden"  name="username" value = "<%=username %>" />
         <div class="form-group">
         <label>Name</label>
         <input type="text" class="form-control" name="name" />
         </div>
         <div class="form-group">
         <label>Address</label>
         <input type="text" class="form-control" name="address" />
         </div>
         <div class="form-group">
         <label>Phone Number</label>
         <input type="number" class="form-control" name="phone" />
         </div>
         <br><br><br>
         <input type="submit" class="btn btn-primary" value="Edit"></input>
         

    </form><br><br>
    <a href = "admin.jsp">Back</a>
	</div>
</body>
</html>
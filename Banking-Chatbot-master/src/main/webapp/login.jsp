<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
<style type="text/css">
        body{ font: 14px sans-serif;
    color: #421; 
    font-weight: bold; 
    font-size: 18px; 
    font-family: "Courier New"; 
    background: rgb(200, 232, 241); 
         }
        .wrapper{ width: 350px; padding: 20px; }
</style>
<script>
function validate()
{ 
     var username = document.form.username.value; 
     var password = document.form.password.value;
 
     if (username==null || username=="")
     { 
     alert("Username cannot be blank"); 
     return false; 
     }
     else if(password==null || password=="")
     { 
     alert("Password cannot be blank"); 
     return false; 
     } 
}
</script>
</head>
<body>
<center><h2>XYZ Bank</h2></center>
<div  class="wrapper">


	<div style="text-align:center"><h3>Login</h3></div>
	<br>
	<div style="align:center">
    <form name="form" action="LoginServlet" method="post" onsubmit="return validate()">
    	
        <!-- Do not use table to format fields. As a good practice use CSS -->
         <span class="help-block"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></span>
         <div class="form-group">
         <label>Username</label>
         <input type="text" class="form-control" name="username" />
         </div>
         <div class="form-group">
         <label>Password</label>
         <input type="password" class="form-control" name="password" />
         </div>
         <br>
         <input type="submit" class="btn btn-primary" value="Login"></input>
    </form></div><br><br>
    <a href = "Resetpass.jsp">Forget Password?</a><br><br>
	<div style="text-align:center">New User?<a href = "register.jsp">Register</a></div>
	</div>
</body>
</html>
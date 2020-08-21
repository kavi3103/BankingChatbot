<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
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
     var username = document.form.username.value; 
     var password = document.form.password.value;
     var conpassword= document.form.conpassword.value;
     var name = document.form.name.value;
     var phone =  document.form.phone.value;
     var address =  document.form.address.value;
    
     if (username==null || username=="")
     { 
     alert("Username can't be blank"); 
     return false; 
     }
     else if(password.length<6)
     { 
     alert("Password must be at least 6 characters long."); 
     return false; 
     } 
     else if (password!=conpassword)
     { 
     alert("Confirm Password should match with the Password"); 
     return false; 
     } 
     else if (name==null || name=="")
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
<div  class="wrapper">
	<div style="text-align:center"><h3>Register</h3></div>
    <form name="form" action="RegisterServlet" method="post" onsubmit="return validate()">
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
         <div class="form-group">
         <label>Confirm Password</label>
         <input type="password" class="form-control" name="conpassword" />
         </div>
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
         <input type="submit" class="btn btn-primary" value="Register"></input>
         

    </form><br><br>
	<div style="text-align:center">Already a User?<a href = "login.jsp">Login</a></div>
	</div>
</body>
</html>
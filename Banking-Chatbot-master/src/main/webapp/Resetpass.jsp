<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
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
     var pass = document.form.oldpassword.value;
     var password = document.form.newpassword.value;
     var conpassword= document.form.conpassword.value;
 
     if (username==null || username=="")
     { 
     alert("Username cannot be blank"); 
     return false; 
     }
     else if(pass==null || password=="")
     { 
     alert("Old Password cannot be blank"); 
     return false; 
     } 
     else if(password==null || password=="")
     { 
     alert("New Password cannot be blank"); 
     return false; 
     }
     else if (password!=conpassword)
     { 
     alert("Confirm Password should match with the Password"); 
     return false; 
     } 
     
}
</script>
</head>
<body>
<center><h2>XYZ Bank</h2></center>
<div  class="wrapper">


	<div style="text-align:center"><h3>Reset Password</h3></div>
	<br>
	<div style="align:center">
    <form name="form" action="ResetServlet" method="post" onsubmit="return validate()">
    	
        <!-- Do not use table to format fields. As a good practice use CSS -->
         <span class="help-block"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></span>
         <div class="form-group">
         <label>Username</label>
         <input type="text" class="form-control" name="username" />
         </div>
         <div class="form-group">
         <label>Old Password</label>
         <input type="password" class="form-control" name="oldpassword" />
         </div>
         <div class="form-group">
         <label>New Password</label>
         <input type="password" class="form-control" name="newpassword" />
         </div>
         <div class="form-group">
         <label>Confirm Password</label>
         <input type="password" class="form-control" name="conpassword" />
         </div>
         
         <br><br><br>
         <input type="submit" class="btn btn-primary" value="Reset"></input>
    </form></div><br><br>
    <a href = "login.jsp">Back to Login</a>
	</div>
</body>
</html>
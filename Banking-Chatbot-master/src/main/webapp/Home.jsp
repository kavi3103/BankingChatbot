<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="chatbot.Virtusa.beans.RegisterBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
<style type="text/css">
        body{ font: 14px sans-serif; color: #421; 
    font-weight: bold; 
    font-size: 18px; 
    font-family: "Courier New"; 
    background: rgb(200, 232, 241);  }
        .wrapper{ width: 350px; padding: 20px; }
</style>
</head>
<body>
 <center><h2>XYZ Bank</h2></center>
 <div style="text-align: right">
<% HttpSession session1=request.getSession(false);  
 String name=(String)session1.getAttribute("username"); 
 if(name == null){
	 request.getRequestDispatcher("login.jsp").forward(request, response); 
 }
 	
 %>
 Welcome <%=name %>
 <strong><a href="<%=request.getContextPath()%>/GetProfile" class = "btn btn-primary">My Profile</a></strong>
 <a href="LogoutServlet" class="btn btn-danger">Logout</a></div>
 <br>
 <span class="help-block"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></span>
 <form method= "post" action="DirectServlet">
 <input type="hidden" name = "username" value=<%=name %>>
 <input type="submit" class="btn btn-primary" value = "Start Chat">
 </form>
 
 <br></br>
<%if(request.getAttribute("mydetail") != null)  // Null check for the object
{
	RegisterBean detail = (RegisterBean)request.getAttribute("mydetail");
	%>
	<div align="center">
        <table border="0" cellpadding="5">
        <tr>
        <td>USERNAME:</td>
        <td><%= detail.getUserName()%></td>
        </tr>
        <tr>
        <td>NAME :</td>
        <td><%= detail.getName() %></td>
        </tr>
        <tr>
        <td>ADDRESS :</td>
        <td><%= detail.getAddress() %></td>
        </tr>
        <tr>
        <td>PHONE NUMBER :</td>
        <td><%=detail.getPhoneNumber() %></td>
        </tr>
        </table>
        <br><br>
        <a class = "btn btn-primary" href="EditDirectServlet?username=<%=detail.getUserName()%>&name=<%= detail.getName()  %>&address=<%= detail.getAddress() %>&phone=<%= detail.getPhoneNumber() %>">Edit</a>
                    
	<%
	
	} %>
 
</body>
</html>
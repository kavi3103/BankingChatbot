<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="chatbot.Virtusa.beans.ChatBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Responded</title>
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
 <a href="LogoutServlet" class="btn btn-danger">Logout</a></div>
 <br>
 <h2>You have already Responded</h2>
  <strong><a href="<%=request.getContextPath()%>/GetUserChatServlet">View Your Response</a></strong>
  <% if(request.getAttribute("mychat") != null){ 
  		ChatBean chat = (ChatBean) request.getAttribute("mychat"); %>
  <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Your Response from Chatbot</h2></caption>
            <tr>
            <th>Bot Question</th>
            <th>Your Response</th>
            </tr>
            <tr>
            <td>Loan Amount</td>
            <td><%= chat.getLoan_amount() %></td>
            </tr>
            <tr>
            <td>Loan Type</td>
            <td><%= chat.getLoan_type() %></td>
            </tr>
            <tr>
            <td>Do you want moratorium?</td>
            <td><%= chat.getWant_moratorium() %></td>
            </tr>
            <tr>
            <td>For how much time?</td>
            <td><%= chat.getTime_period() %></td>
            </tr>
            <tr>
            <td>Your work</td>
            <td><%= chat.getType_work() %></td>
            </tr>
            <tr>
            <td>Your Income</td>
            <td><%= chat.getIncome() %></td>
            </tr>
            <tr>
            <td>Do you affected by covid19?</td>
            <td><%= chat.getAffected_covid() %></td>
            </tr>
            <tr>
            <td>Do you were paid during covid19?</td>
            <td><%= chat.getHas_paid() %></td>
            </tr>
            <tr>
            <td>Other Reasons</td>
            <td><%= chat.getOther_reasons() %></td>
            </tr>
            
         </table><br><br>
         <form action = "ChatServlet" method = "post">
         	<input type = "submit" class = "btn btn-primary" value ="Edit your Response">
         </form>
  </div>
  <%} %>
</body>
</html>
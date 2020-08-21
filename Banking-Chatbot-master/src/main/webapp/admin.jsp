<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
<%@page import="chatbot.Virtusa.beans.*"%>
<%@page import="java.util.Iterator"%> 
<%@page import = "chatbotVirtusa.dao.Authorise" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
<style type="text/css">
        body{ font: 14px sans-serif; color: #421; 
    font-weight: bold; 
    font-size: 18px; 
    font-family: "Courier New"; 
    background: rgb(200, 232, 241); }
        .wrapper{ width: 350px; padding: 20px; }
</style>
</head>
<body>
<center><h2>XYZ Bank</h2></center>
 <% HttpSession session2=request.getSession(false);  
 String name=(String)session2.getAttribute("username"); 
 if(name == null){
	 request.getRequestDispatcher("login.jsp").forward(request, response); 
 }
 	
 %>
 <% if(name != null){
 Authorise auth = new Authorise();
 String access = auth.authorise(name,"ADMIN");
 if(access.equals("UNAUTHORISED")){
	 request.getRequestDispatcher("unauthorised.jsp").forward(request, response);  
 }
 }
 %>
 <div style="text-align: right"> Welcome  <%=name %>  <a href="LogoutServlet" class="btn btn-danger">Logout</a></div>
 <strong><a href="<%=request.getContextPath()%>/GetAllUsersServlet">Show Customers</a></strong><br>
 <strong><a href="<%=request.getContextPath()%>/GetChatsServlet">Show Customer Chats</a></strong>
 <br></br>
<%if(request.getAttribute("user") != null)  // Null check for the object
{ %>
 
    <div align="center">
        <table border="1" cellpadding="5">
        <% ArrayList<RegisterBean> userlist = (ArrayList)request.getAttribute("user"); %>
            <caption><h2>Customers</h2></caption>
            <tr>
                <th>Username</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone Number</th>
                <th>Edit</th>
                <th>Delete</th>
                
            </tr>
<%
Iterator<RegisterBean> iterator = userlist.iterator();  // Iterator interface
	
	while(iterator.hasNext())  // iterate through all the data until the last record
	{
		RegisterBean user = iterator.next(); //assign individual employee record to the employee class object
	%>
                <tr>
                    <td><%= user.getUserName() %></td>
                    <td><%= user.getName()  %></td>
                    <td><%= user.getAddress() %></td>
                    <td><%= user.getPhoneNumber() %></td>
                    <td><a href="EditDirectServlet?username=<%=user.getUserName()%>&name=<%= user.getName()  %>&address=<%= user.getAddress() %>&phone=<%= user.getPhoneNumber() %>">Edit</a></td>
                    <td><a href="<%=request.getContextPath()%>/DeleteUserServlet?username=<%=user.getUserName()%>">Delete</a></td>
                    
                    
                </tr>
                <%
	}
}
%>
        </table>
    </div>
 
<br></br>
<%if(request.getAttribute("list") != null)  // Null check for the object
{ %>
 
    <div align="center">
        <table border="1" cellpadding="5">
        <% ArrayList<ChatBean> chatlist = (ArrayList)request.getAttribute("list"); %>
            <caption><h2>Customer Responses from Chatbot</h2></caption>
            <tr>
                <th>Username</th>
                <th>Loan Amount</th>
                <th>Loan Type</th>
                <th>Did they want moratorium?</th>
                <th>For how much time?</th>
                <th>Their work</th>
                <th>Customer's Income</th>
                <th>Has they affected by covid-19?</th>
                <th>Has they been paid during covid-19?</th>
                <th>Other Reasons</th>
                
            </tr>
<%
Iterator<ChatBean> iterator = chatlist.iterator();  // Iterator interface
	
	while(iterator.hasNext())  // iterate through all the data until the last record
	{
		ChatBean chat = iterator.next(); //assign individual employee record to the employee class object
	%>
                <tr>
                    <td><%= chat.getUsername() %></td>
                    <td><%= chat.getLoan_amount() %></td>
                    <td><%= chat.getLoan_type() %></td>
                    <td><%= chat.getWant_moratorium() %></td>
                    <td><%= chat.getTime_period() %></td>
                    <td><%= chat.getType_work() %></td>
                    <td><%= chat.getIncome() %></td>
                    <td><%= chat.getAffected_covid() %></td>
                    <td><%= chat.getHas_paid() %></td>
                    <td><%= chat.getOther_reasons() %></td>
                    
                </tr>
                <%
	}
}
%>
        </table>
    </div>
</body>
</html>
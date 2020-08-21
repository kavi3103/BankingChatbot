<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import = "javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chatbot</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
<style type="text/css">
        body{ font: 14px sans-serif; color: #421; 
    font-weight: bold; 
    font-size: 18px; 
    font-family: "Courier New"; 
    background: rgb(200, 232, 241); }
        .wrapper{ width: 350px; padding: 20px; }
</style>
<script src= 
"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> 
    </script> 
</head>
<body>
<style>
.footer {
   position: fixed;
   right:350px;
   bottom: 30px;
}
#example {
      position: fixed;
      width: 500px;
      height: 300px;
      bottom: 100px;
  		right:300px;
      overflow: auto;
      border: 1px solid #00b0ff;
      padding: 20px;
    }
.container {
  border: 2px solid #dedede;
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 10px;
  margin: 10px 0;
  width: 100%;
}

/* Darker chat container */
.darker {
  border-color: #ccc;
  background-color: #ddd;
  text-align: right;
}

/* Clear floats */
.container::after {
  content: "";
  clear: both;
  display: table;
}

/* Style images */
.container img {
  float: left;
  max-width: 60px;
  width: 100%;
  margin-right: 20px;
  border-radius: 50%;
}

/* Style the right image */
.container img.right {
  float: right;
  margin-left: 20px;
  margin-right:0;
}

</style>
<script> 
        $(document).ready(function() { 
                $("#example").scrollTop($("#example")[0].scrollHeight);
        }); 
</script> 
<script type="text/javascript">
function validate(){
	var answer = document.form.answer.value;
	if(answer == "" || answer == null){
		alert("Please type some answer...");
		return false;
	}
}
</script>
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
		<form name="form" action='ChatServlet' onsubmit="return validate()" method="post">
        <div id = "controls"  class="footer">
        <input name = "answer" type = "text">
        <button type = "submit" value="submit">Send</button>
        </div>
        </form> 
        <% 
        out.println("<div id = 'example'>");
        String ques = "Hi,"+name+"!!!Welcome to xyz bank! This is the chatbot made to decide whether to provide moratorium for your banking loan.";
        out.println("<div class='container'>");
        out.println("<img src='bot.png'>");
        out.println(ques);
        out.println("</div>");
        String[] questions = {"what is your loan amount?","What is your loan type?","Do you want moratorium for your loan?","For how much time?","What is your type of work?","What is your income?","Do you affected by covid-19?","Whether you are been paid during covid-19?","Any other personal reasons to specify","Thanks for your valuable response....Please press finish chat to save your response"};
        if(request.getAttribute("chat") != null){
        	ArrayList<String> chatlist = (ArrayList)request.getAttribute("chat");
        	if(chatlist.size()<=10){
        	for(int i=0;i<chatlist.size();i++){
        		out.println("<div class='container  darker'>");
        		out.println("<img src='user.png'  class='right'>");
        		out.println(chatlist.get(i));
        		out.println("</div>");
        		out.println("<div class='container'>");
        		out.println("<img src='bot.png'>");
        		out.println(questions[i]);
        		out.println("</div>");
        	}
        	}
        	if(chatlist.size()>10){
        		for(int i=0;i<10;i++){
        			out.println("<div class='container  darker'>");
            		out.println("<img src='user.png'  class='right'>");
            		out.println(chatlist.get(i));
            		out.println("</div>");
            		out.println("<div class='container'>");
            		out.println("<img src='bot.png'>");
            		out.println(questions[i]);
            		out.println("</div>");
            	}
        	}
        	
        	if(chatlist.size() >= 10){
        		out.println("<form method = 'post' action = 'SaveServlet'>");
        		out.println("<input type='hidden' name = 'username' value='"+name+"'>");
        		out.println("<input type='hidden' name = 'loanamount' value='"+chatlist.get(1)+"'>");
        		out.println("<input type='hidden' name = 'loantype' value='"+chatlist.get(2)+"'>");
        		out.println("<input type='hidden' name = 'wantmoratorium' value='"+chatlist.get(3)+"'>");
        		out.println("<input type='hidden' name = 'timeperiod' value='"+chatlist.get(4)+"'>");
        		out.println("<input type='hidden' name = 'worktype' value='"+chatlist.get(5)+"'>");
        		out.println("<input type='hidden' name = 'income' value='"+chatlist.get(6)+"'>");
        		out.println("<input type='hidden' name = 'affectedcovid' value='"+chatlist.get(7)+"'>");
        		out.println("<input type='hidden' name = 'paidcovid' value='"+chatlist.get(8)+"'>");
        		out.println("<input type='hidden' name = 'reason' value='"+chatlist.get(9)+"'>");
        		out.println("<input type='submit' class = 'btn btn-success' value='FINISH CHAT' >");
        		out.println("</form>");
        	}
        }
        out.println("</div>");
         %>
        

        

</body>
</html>
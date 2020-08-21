package chatbotVirtusa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chatbot.Virtusa.beans.RegisterBean;
import chatbotVirtusa.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
        String password = request.getParameter("password");
 
        RegisterBean loginBean = new RegisterBean(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
 
        loginBean.setUserName(userName); //setting the username and password through the loginBean object then only you can get it in future.
         loginBean.setPassword(password);
 
        LoginDao loginDao = new LoginDao(); //creating object for LoginDao. This class contains main logic of the application.
 
        String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
 
        if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
         {
        	HttpSession session=request.getSession();  
            session.setAttribute("username",userName);   //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
             request.getRequestDispatcher("/Home.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
         }
        else if(userValidate.equals("SUCCESS ADMIN")) {
        	HttpSession session=request.getSession(); 
        	session.setAttribute("username",userName); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
             request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
         else
         {
             request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
             request.getRequestDispatcher("/login.jsp").forward(request, response);//forwarding the request
         }
	}

}

package chatbotVirtusa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chatbot.Virtusa.beans.RegisterBean;
import chatbotVirtusa.Encryption.MD5Hashing;
import chatbotVirtusa.dao.RegisterDao;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String Hashedpassword = MD5Hashing.MD5(password);
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        
        RegisterBean registerBean = new RegisterBean();
       //Using Java Beans - An easiest way to play with group of related data
        registerBean.setUserName(userName);
        registerBean.setPassword(Hashedpassword); 
        registerBean.setAddress(address);
        registerBean.setName(name);
        registerBean.setPhoneNumber(phone);
        
        RegisterDao registerDao = new RegisterDao();
        
       //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String userRegistered = registerDao.registerUser(registerBean);
        
        if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
           request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else   //On Failure, display a meaningful message to the User.
        {
           request.setAttribute("errMessage", userRegistered);
           request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
	}

}

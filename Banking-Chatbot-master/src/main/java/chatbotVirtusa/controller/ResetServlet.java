package chatbotVirtusa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chatbot.Virtusa.beans.RegisterBean;
import chatbotVirtusa.Encryption.MD5Hashing;
import chatbotVirtusa.dao.ResetPassword;

/**
 * Servlet implementation class ResetServlet
 */
@WebServlet(name="ResetServlet",urlPatterns={"/ResetServlet"})
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
        String password = request.getParameter("newpassword");
        String Hashedpassword = MD5Hashing.MD5(password);
        String oldpass = request.getParameter("oldpassword");
        String Hashedoldpassword = MD5Hashing.MD5(oldpass);
        
        RegisterBean registerBean = new RegisterBean();
        //Using Java Beans - An easiest way to play with group of related data
         registerBean.setUserName(userName);
         registerBean.setPassword(Hashedpassword); 
         
         ResetPassword rs = new ResetPassword();
         String userRegistered = rs.setPassword(registerBean ,Hashedoldpassword );
         
         if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
         {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
         }
         else   //On Failure, display a meaningful message to the User.
         {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/Resetpass.jsp").forward(request, response);
         }
	}

}

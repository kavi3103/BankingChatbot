package chatbotVirtusa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chatbot.Virtusa.beans.RegisterBean;
import chatbotVirtusa.dao.AdminUser;
import chatbotVirtusa.dao.Authorise;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session2=request.getSession(false);  
		String sessionname=(String)session2.getAttribute("username");
		
		 Authorise auth = new Authorise();
		 String access = auth.authorise(sessionname,"ADMIN");
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        
        RegisterBean registerBean = new RegisterBean();
        //Using Java Beans - An easiest way to play with group of related data
         registerBean.setUserName(userName);
         registerBean.setAddress(address);
         registerBean.setName(name);
         registerBean.setPhoneNumber(phone);
         
         AdminUser au = new AdminUser();
         
         String status = au.editUser(registerBean);
         
         if(status.equals("SUCCESS"))   //On success, you can display a message to user on Home page
         {
        	if(access.equals("AUTHORISED")) {
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        	}
        	else {
        		request.getRequestDispatcher("/Home.jsp").forward(request, response);
        	}
         }
         else   //On Failure, display a meaningful message to the User.
         {
            request.setAttribute("errMessage", status);
            request.getRequestDispatcher("/Edit.jsp").forward(request, response);
         }
	}

}

package chatbotVirtusa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chatbot.Virtusa.beans.RegisterBean;
import chatbotVirtusa.dao.GetMyProfile;

/**
 * Servlet implementation class GetProfile
 */
public class GetProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session2=request.getSession(false);  
		 String name=(String)session2.getAttribute("username"); 
		 if(name == null){
			 request.getRequestDispatcher("login.jsp").forward(request, response); 
		 }
		 GetMyProfile get = new GetMyProfile();
		 RegisterBean rb = get.getdetail(name);
		 
		 request.setAttribute("mydetail",rb);

			RequestDispatcher rd= request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
	}

}

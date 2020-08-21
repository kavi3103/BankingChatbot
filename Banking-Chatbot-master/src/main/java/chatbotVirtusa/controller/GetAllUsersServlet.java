package chatbotVirtusa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chatbot.Virtusa.beans.RegisterBean;
import chatbotVirtusa.dao.AdminUser;

/**
 * Servlet implementation class GetAllUsersServlet
 */
public class GetAllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminUser au = new AdminUser();
		List<RegisterBean> list = au.getAllUsers();
		
		request.setAttribute("user", list);
		RequestDispatcher rd= request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
		
	}

}

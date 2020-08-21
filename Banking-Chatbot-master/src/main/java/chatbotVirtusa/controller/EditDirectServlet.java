package chatbotVirtusa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditDirectServlet
 */
public class EditDirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = (String)request.getParameter("username");
		String name = (String)request.getParameter("name");
		String address = (String)request.getParameter("address");
		String phone = (String)request.getParameter("phone");
		request.setAttribute("UserName", user);
		request.setAttribute("Name", name);
		request.setAttribute("Address", address);
		request.setAttribute("Phone", phone);
		RequestDispatcher rd= request.getRequestDispatcher("Edit.jsp");
		rd.forward(request, response);
	}

}

package chatbotVirtusa.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.util.*;

import chatbotVirtusa.dao.UniqueUsername;

/**
 * Servlet implementation class DirectServlet
 */
public class DirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out = response.getWriter();
		UniqueUsername us = new UniqueUsername();
		String username = (String) request.getParameter("username");
		String status = us.findUnique(username);
		if(status.equals("Username does not exist")) {
			//List<String> chat = new ArrayList<String>();
			RequestDispatcher rd= request.getRequestDispatcher("ChatServlet");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd= request.getRequestDispatcher("Responded.jsp");
			rd.forward(request, response);
		}
	}

}

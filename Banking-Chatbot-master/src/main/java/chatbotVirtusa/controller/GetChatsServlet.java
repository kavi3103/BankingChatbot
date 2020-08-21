package chatbotVirtusa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chatbot.Virtusa.beans.ChatBean;
import chatbotVirtusa.dao.GetChats;

/**
 * Servlet implementation class GetChatsServlet
 */
public class GetChatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Servlet");
		// TODO Auto-generated method stub
		GetChats getchats = new GetChats();
		List<ChatBean> list = getchats.getAllChats();
		request.setAttribute("list",list);

		RequestDispatcher rd= request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}

}

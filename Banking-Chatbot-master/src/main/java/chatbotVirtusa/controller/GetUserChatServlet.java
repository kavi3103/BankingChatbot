package chatbotVirtusa.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chatbot.Virtusa.beans.ChatBean;
import chatbotVirtusa.dao.GetUserChat;

/**
 * Servlet implementation class GetUserChatServlet
 */
public class GetUserChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session2=request.getSession(false);  
		 String name=(String)session2.getAttribute("username"); 
		 if(name == null){
			 request.getRequestDispatcher("login.jsp").forward(request, response); 
		 }
		 	
		// TODO Auto-generated method stub
		GetUserChat guc = new GetUserChat();
		//String username = (String)request.getParameter("username");
		//PrintWriter out = response.getWriter();
		//out.print(username);
		ChatBean cb = guc.viewMyChat(name);
		request.setAttribute("mychat",cb);

		RequestDispatcher rd= request.getRequestDispatcher("Responded.jsp");
		rd.forward(request, response);
	}

}

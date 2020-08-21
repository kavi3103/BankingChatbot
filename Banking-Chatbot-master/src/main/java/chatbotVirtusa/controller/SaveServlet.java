package chatbotVirtusa.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chatbot.Virtusa.beans.ChatBean;
import chatbotVirtusa.dao.SaveChat;


/**
 * Servlet implementation class SaveServlet
 */
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String loanamount = request.getParameter("loanamount");
		String loantype = request.getParameter("loantype");
		String wantmoratorium = request.getParameter("wantmoratorium");
		String timeperiod = request.getParameter("timeperiod");
		String worktype = request.getParameter("worktype");
		String income = request.getParameter("income");
		String affectedcovid = request.getParameter("affectedcovid");
		String paidcovid = request.getParameter("paidcovid");
		String reason = request.getParameter("reason");
		//out.println("YOUR RESPONSES:<br>"+username+"<br>"+loanamount+"<br>"+loantype+"<br>"+wantmoratorium+"<br>"+timeperiod+"<br>"+worktype+"<br>"+income+"<br>"+affectedcovid+"<br>"+paidcovid+"<br>"+reason);
		ChatBean chat = new ChatBean();
		chat.setUsername(username);
		chat.setLoan_amount(loanamount);
		chat.setLoan_type(loantype);
		chat.setWant_moratorium(wantmoratorium);
		chat.setAffected_covid(affectedcovid);
		chat.setOther_reasons(reason);
		chat.setTime_period(timeperiod);
		chat.setType_work(worktype);
		chat.setIncome(income);
		chat.setHas_paid(paidcovid);
		
		SaveChat save = new SaveChat();
		String status = save.StoreChat(chat);
		
		if(status.equals("SUCCESS")) {
			request.setAttribute("errMessage", "Saved Successfully"); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
            request.getRequestDispatcher("/Home.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errMessage", status); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
            request.getRequestDispatcher("/Home.jsp").forward(request, response);
		}
	}

}

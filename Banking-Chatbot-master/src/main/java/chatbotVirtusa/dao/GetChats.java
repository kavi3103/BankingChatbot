package chatbotVirtusa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chatbot.Virtusa.beans.ChatBean;
import chatbotVirtusa.util.DBConnection;


public class GetChats {
	public List<ChatBean> getAllChats(){
			Connection con = null;
	        //PreparedStatement preparedStatement = null;
	        
	        ResultSet resultSet = null;
	        try
	        {
	            con = DBConnection.createConnection();
	        	// con = DBUtil.getDataSource();
	            String query1 = "{ call getfromchat()}";
	            CallableStatement stmt = con.prepareCall(query1);
	            resultSet = stmt.executeQuery(query1);
	            List<ChatBean> list = new ArrayList<ChatBean>();
	            while(resultSet.next()) {
	            	ChatBean cb = new ChatBean();
	            	cb.setUsername(resultSet.getString(2));
	            	cb.setLoan_amount(resultSet.getString(3));
	            	cb.setLoan_type(resultSet.getString(4));
	            	cb.setWant_moratorium(resultSet.getString(5));
	            	cb.setTime_period(resultSet.getString(6));
	            	cb.setType_work(resultSet.getString(7));
	            	cb.setIncome(resultSet.getString(8));
	            	cb.setAffected_covid(resultSet.getString(9));
	            	cb.setHas_paid(resultSet.getString(10));
	            	cb.setOther_reasons(resultSet.getString(11));
	            	list.add(cb);
	            	
	            	
	            }
	            
	            return list;
	        } catch(Exception e) {
	        	e.printStackTrace();
	        }
		return null;
		
	}

}

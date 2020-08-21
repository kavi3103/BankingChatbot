package chatbotVirtusa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.PreparedStatement;

import chatbot.Virtusa.beans.ChatBean;
import chatbotVirtusa.util.DBConnection;




public class SaveChat {
	

	public String StoreChat(ChatBean chat) {
		Connection con = null;
        //PreparedStatement preparedStatement = null;
        try
        {
            con = DBConnection.createConnection();
            UniqueUsername us = new UniqueUsername();
            String status = us.findUnique(chat.getUsername());
            if(status.equals("Username does not exist")) {
            
            	String query = "{ call insertchat(?,?,?,?,?,?,?,?,?,?) }"; //Insert user details into the table 'USERS'
                CallableStatement stmt = con.prepareCall(query); //Making use of prepared statements here to insert bunch of data
                stmt.setString(1,chat.getUsername());
                stmt.setString(2,chat.getLoan_amount());
                stmt.setString(3,chat.getLoan_type());
                stmt.setString(4,chat.getWant_moratorium());
                stmt.setString(5,chat.getTime_period());
                stmt.setString(6,chat.getType_work());
                stmt.setString(7,chat.getIncome());
                stmt.setString(8,chat.getAffected_covid());
                stmt.setString(9,chat.getHas_paid());
                stmt.setString(10,chat.getOther_reasons());
                
                
                int i= stmt.executeUpdate();
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS";
            }
            else {
            	String query = "{ call updatechat2(?,?,?,?,?,?,?,?,?,?) }"; 
            	CallableStatement stmt = con.prepareCall(query); //Making use of prepared statements here to insert bunch of data
                stmt.setString(1,chat.getUsername());
                stmt.setString(2,chat.getLoan_amount());
                stmt.setString(3,chat.getLoan_type());
                stmt.setString(4,chat.getWant_moratorium());
                stmt.setString(5,chat.getTime_period());
                stmt.setString(6,chat.getType_work());
                stmt.setString(7,chat.getIncome());
                stmt.setString(8,chat.getAffected_covid());
                stmt.setString(9,chat.getHas_paid());
                stmt.setString(10,chat.getOther_reasons());
                
                
                int i= stmt.executeUpdate();
                
                
                if (i!=0)  //Just to ensure data has been inserted into the database
                return "SUCCESS";
            }
            
            
            
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return "Oops... Error in saving data. Please try again.... ";
	}

}

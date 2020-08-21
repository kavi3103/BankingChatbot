package chatbotVirtusa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;

import chatbot.Virtusa.beans.ChatBean;
import chatbotVirtusa.util.DBConnection;

public class GetUserChat {

	
	public ChatBean viewMyChat(String username) {
		Connection con = null;
        //PreparedStatement preparedStatement = null;
        //Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            con = DBConnection.createConnection();
            //System.out.print(con);
            String query1 = "{ call getmychat(?) }";
            CallableStatement stmt = con.prepareCall(query1);
            stmt.setString(1,username);
            resultSet = stmt.executeQuery();
            //String query1 = "select * from chat where username = ?";
            //preparedStatement = con.prepareStatement(query1); //Making use of prepared statements here to insert bunch of data
            //preparedStatement.setString(1,username);
           // resultSet = preparedStatement.executeQuery();
            ChatBean cb = new ChatBean();
            if(resultSet.next()) {
            	//ChatBean cb = new ChatBean();
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
            }
            return cb;
            
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

	

}

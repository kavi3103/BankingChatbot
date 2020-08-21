package chatbotVirtusa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import chatbot.Virtusa.beans.RegisterBean;
import chatbotVirtusa.util.DBConnection;

public class ResetPassword {

	public String setPassword(RegisterBean registerBean, String hashedoldpassword) {
		// TODO Auto-generated method stub
		String userName = registerBean.getUserName();
        String password = registerBean.getPassword();
        
        Connection con = null;
        //PreparedStatement preparedStatement = null;
        //Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            con = DBConnection.createConnection();
        	// con = DBUtil.getDataSource();
            String query1 = "{ call getuser(?) }";
            CallableStatement stmt = con.prepareCall(query1);
            stmt.setString(1,userName);
            resultSet = stmt.executeQuery();
            if(resultSet.next()) {
            	String passwordDB  = resultSet.getString("password");
            	if(hashedoldpassword.equals(passwordDB))
                {
            		String query = "{ call resetPasswordUser(?,?) }"; //Insert user details into the table 'USERS'
                    CallableStatement statement = con.prepareCall(query); //Making use of prepared statements here to insert bunch of dat
                    statement.setString(1, userName);
                    statement.setString(2, password);
                    
                    int i= statement.executeUpdate();
                    
                    if(i!=0) {
                    	return "SUCCESS";
                    }
            		
                }
            	else {
            		return "Old password incorrect";
            	}
            	
            	
            }
            else {
            	return "Username doesnot exist";
            }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
		return "Some error occured..try again";
	}

}

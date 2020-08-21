package chatbotVirtusa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;

import chatbotVirtusa.util.DBConnection;

public class UniqueUsername {

	public String findUnique(String username) {
		// TODO Auto-generated method stub
		Connection con = null;
       // PreparedStatement preparedStatement = null;
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
            if(resultSet.next()) {
            	return "Username exist";
            }
            else {
            	return "Username does not exist";
            }
            
            
            
            
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return null;
	}
	

}

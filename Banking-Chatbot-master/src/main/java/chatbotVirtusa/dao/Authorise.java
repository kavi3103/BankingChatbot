package chatbotVirtusa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
//import java.sql.Statement;

import chatbotVirtusa.util.DBConnection;

public class Authorise {
	public String authorise(String username,String Role) {
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
            stmt.setString(1,username);
            resultSet = stmt.executeQuery();
            if(resultSet.next()) {
            	String roleDb = resultSet.getString("role");
            	if(roleDb.equals(Role)) {
            		return "AUTHORISED";
            	}
            	/*if(username.equals(null)) {
            		return "AUTHORISED";
            	}*/
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
		
		return "UNAUTHORISED";
		
	}
}

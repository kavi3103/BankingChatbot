package chatbotVirtusa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import chatbot.Virtusa.beans.RegisterBean;
import chatbotVirtusa.util.DBConnection;

public class GetMyProfile {


	public RegisterBean getdetail(String name) {
		Connection con = null;
        //PreparedStatement preparedStatement = null;
        //Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            con = DBConnection.createConnection();
            //System.out.print(con);
            String query1 = "{ call getmyprofile(?) }";
            CallableStatement stmt = con.prepareCall(query1);
            stmt.setString(1,name);
            resultSet = stmt.executeQuery();
            
            if(resultSet.next()) {
            
            RegisterBean rb = new RegisterBean();
            rb.setUserName(resultSet.getString("username"));
            rb.setName(resultSet.getString("name"));
            rb.setAddress(resultSet.getString("address"));
            rb.setPhoneNumber(resultSet.getString("phoneno"));
            
            System.out.println(resultSet.getString("username")+" -  "+resultSet.getString("name"));
            
            return rb;
            }
            else {
            	System.out.println("empty");
            }
            
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

}

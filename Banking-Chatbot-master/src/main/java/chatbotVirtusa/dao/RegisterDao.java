package chatbotVirtusa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

//import chatbotVirtusa.util.DBUtil;

import chatbot.Virtusa.beans.RegisterBean;
import chatbotVirtusa.util.DBConnection;

public class RegisterDao {
	public String registerUser(RegisterBean registerBean)
    {
       
        String userName = registerBean.getUserName();
        String password = registerBean.getPassword();
        String name = registerBean.getName();
        String address = registerBean.getAddress();
        String phone = registerBean.getPhoneNumber();
        
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
            	return "Username already Exist";
            }
            String query = "{ call insertuser(?,?) }"; //Insert user details into the table 'USERS'
            CallableStatement statement = con.prepareCall(query); //Making use of prepared statements here to insert bunch of dat
            statement.setString(1, userName);
            statement.setString(2, password);
            
            int i= statement.executeUpdate();
            
            String query2 = "{ call insertdetail(?,?,?,?) }"; //Insert user details into the table 'USERS'
            CallableStatement state = con.prepareCall(query2); //Making use of prepared statements here to insert bunch of dat
            state.setString(1, userName);
            state.setString(2, name);
            state.setString(3, address);
            state.setString(4, phone);
            
            int j = state.executeUpdate();
            
            
            if (i!=0 && j!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }
}

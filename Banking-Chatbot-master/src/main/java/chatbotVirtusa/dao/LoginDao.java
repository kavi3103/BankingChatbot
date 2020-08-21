package chatbotVirtusa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import chatbot.Virtusa.beans.RegisterBean;
import chatbotVirtusa.Encryption.MD5Hashing;
import chatbotVirtusa.util.DBConnection;

public class LoginDao {
	public String authenticateUser(RegisterBean loginBean)
    {
        String userName = loginBean.getUserName(); //Assign user entered values to temporary variables.
        String password = loginBean.getPassword();
        String Hashedpassword = MD5Hashing.MD5(password);

        Connection con = null;
        //Statement statement = null;
        ResultSet resultSet = null;

        String Role = "";
        String passwordDB = "";
        

        try
        {
            con = DBConnection.createConnection(); //Fetch database connection object
            String query1 = "{ call getuser(?) }";
            CallableStatement stmt = con.prepareCall(query1);
            stmt.setString(1,userName);
            resultSet = stmt.executeQuery(); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.

            if(resultSet.next()) // Until next row is present otherwise it return false
            {
             passwordDB = resultSet.getString("password");
             Role = resultSet.getString("role");
             

              if(Hashedpassword.equals(passwordDB))
              {
            	  if(Role.equals("ADMIN")) {
            		  return "SUCCESS ADMIN";
            	  }
                 return "SUCCESS"; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
              }
            }
            else {
            	return "Invalid username or password";
            }
        }catch(SQLException e)
            {
               e.printStackTrace();
               //return "Invalid user credentials";
            }
             // Return appropriate message in case of failure
        return "Invalid user credentials";
        
    }

}

package chatbotVirtusa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import chatbot.Virtusa.beans.RegisterBean;
import chatbotVirtusa.util.DBConnection;

public class AdminUser {
	public List<RegisterBean> getAllUsers(){
		Connection con = null;
        ResultSet resultSet = null;
        try
        {
            con = DBConnection.createConnection();
            String query1 = "{ call getallusers()}";
            CallableStatement stmt = con.prepareCall(query1);
            resultSet = stmt.executeQuery(query1);
            List<RegisterBean> list = new ArrayList<RegisterBean>();
            while(resultSet.next()) {
            	RegisterBean rb = new RegisterBean();
            	rb.setUserName(resultSet.getString(2));
            	rb.setName(resultSet.getString(3));
            	rb.setAddress(resultSet.getString(4));
            	rb.setPhoneNumber(resultSet.getString(5));
            	list.add(rb);
            }
            return list;
            
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return null;
		
	}
	
	public String editUser(RegisterBean registerBean) {
		Connection con = null;
        try
        {
            con = DBConnection.createConnection();
            String query = "{ call updateuserdetail(?,?,?,?) }"; 
        	CallableStatement stmt = con.prepareCall(query);
        	stmt.setString(1,registerBean.getUserName());
            stmt.setString(2,registerBean.getName());
            stmt.setString(3,registerBean.getAddress());
            stmt.setString(4,registerBean.getPhoneNumber());
        	
        	int i= stmt.executeUpdate();
        	if (i!=0)  //Just to ensure data has been inserted into the database
                return "SUCCESS";
            
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return "Error in editing user";
		
	}
	
	public String deleteUser(String Username) {
		Connection con = null;
        try
        {
            con = DBConnection.createConnection();
            String query = "{ call deleteuser(?) }"; 
        	CallableStatement stmt = con.prepareCall(query);
        	stmt.setString(1,Username);
            
        	
        	int i= stmt.executeUpdate();
        	int j=0;
        	
        	String query1 = "{ call getmychat(?) }";
            CallableStatement stmt1 = con.prepareCall(query1);
            stmt1.setString(1,Username);
            ResultSet  resultSet = stmt1.executeQuery();
            
            if(resultSet.next()) {
            	String query2 = "{ call deletechat(?) }"; 
            	CallableStatement stmt2 = con.prepareCall(query2);
            	stmt2.setString(1,Username);
            	
            	j= stmt2.executeUpdate();
            }
            
            
        	if (i!=0 && j!=0)  //Just to ensure data has been inserted into the database
                return "SUCCESS";
            
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return "Error in deleting user";
		
	}

}

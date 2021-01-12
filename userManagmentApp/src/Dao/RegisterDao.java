package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import Bean.RegisterBean;
import Utils.DB;

public class RegisterDao {
	
    public RegisterDao()
    {
    	
    }

	public String register(RegisterBean registerBean) throws ClassNotFoundException {
	

		String fullname = registerBean.getFullname();
   	    String username = registerBean.getUsername();
        String email = registerBean.getEmail();
        String password = registerBean.getPassword();
        String contactno = registerBean.getContactno();
         

        PreparedStatement preparedStatement = null;      

		try {
			Connection connection = DB.getConnection();
			String query = "insert into admin(name,username,password,email,contactno) values (?,?,?,?,?)"; 
			
			preparedStatement = connection.prepareStatement(query); 
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, contactno);

			System.out.println(preparedStatement);
            int i= preparedStatement.executeUpdate();
      
            if (i!=0)  
            	return "SUCCESS"; 
		} catch (SQLException e) 
		{
			UserDao.printSQLException(e);
		}
		return "Oops.. Something went wrong there..!"; 
	}


}

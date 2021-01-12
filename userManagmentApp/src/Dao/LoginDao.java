package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.LoginBean;
import Utils.DB;



public class LoginDao {

	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		boolean status = false;


		try {
			Connection connection = DB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from admin where username = ? and password = ? ");
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
		} catch (SQLException e) 
		{
			UserDao.printSQLException(e);
		}
		return status;
	}
}

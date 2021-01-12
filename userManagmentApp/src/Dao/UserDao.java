package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.UserBean;
import Utils.DB;

public class UserDao {


	private static final String INSERT_USERS_SQL = "INSERT INTO companyusers" + "  (name, email, country) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,name,email,country from companyusers where id =?";
	private static final String SELECT_ALL_USERS = "select * from companyusers";
	private static final String DELETE_USERS_SQL = "delete from companyusers where id = ?;";
	private static final String UPDATE_USERS_SQL = "update companyusers set name = ?,email= ?, country =? where id = ?";
	
	public UserDao() {
	}
	
	 
	public void insertUser(UserBean user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
	
		try
		{
		    Connection connection = DB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) 
		{
			printSQLException(e);
		}
	}
	
	public static UserBean selectUser(int id) {
		UserBean user = new UserBean();
		
		try {
			Connection connection = DB.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) 
			{
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user = new UserBean(id, name, email, country);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	
	public List<UserBean> selectAllUsers() {

		
		List<UserBean> users = new ArrayList<>();
		
		try 
			{
			Connection connection = DB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) 
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				users.add(new UserBean(id, name, email, country));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted = false;
		try 
		{
			Connection connection = DB.getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}catch (SQLException e) {
			printSQLException(e);
		}
		return rowDeleted;
	}

	public boolean updateUser(UserBean user) throws SQLException {
		boolean rowUpdated = false;
		try 
		{
		    Connection connection = DB.getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
			System.out.println("updated User:"+statement);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setInt(4, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}catch (SQLException e) {
			printSQLException(e);
		}
		return rowUpdated;
	}

	static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}

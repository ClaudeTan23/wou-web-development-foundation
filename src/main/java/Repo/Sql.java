package Repo;

import java.sql.*;

public class Sql {
	private String Username;
	private String Password;
	private String Email;
	private String FirstName;
	private String LastName;
	
	private final String DbDriver = "com.mysql.cj.jdbc.Driver";
	private final String DbUrl    = "jdbc:mysql://localhost/";
	private final String DbName   = "dateset";
	private final String DbUsername = "root";
	private final String DbPassword = "";
	
	public Sql(String username, String password, String email, String firstname, String lastname) {
		this.Username  = username;
		this.Password  = password;
		this.Email     = email;
		this.FirstName = firstname;
		this.LastName  = lastname;
	}
	
	public Boolean Query() throws ClassNotFoundException, SQLException {
		
		try {
			Class.forName(DbDriver);
			Connection conn = DriverManager.getConnection(DbUrl + DbName, DbUsername, DbPassword);
			
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO user (username, password, email, firstname, lastname) VALUES (?, ?, ?, ?, ?)");
			
			stmt.setString(1, this.Username);
			stmt.setString(2, this.Password);
			stmt.setString(3, this.Email);
			stmt.setString(4, this.FirstName);
			stmt.setString(5, this.LastName);
			
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
			
			return true;
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean ExistUsername() throws ClassNotFoundException, SQLException {
		
		try {
			
			Boolean exists = false;
			
			Class.forName(DbDriver);
			Connection conn = DriverManager.getConnection(DbUrl + DbName, DbUsername, DbPassword);
			Statement stmt  = conn.createStatement();
			
			ResultSet User = stmt.executeQuery("SELECT username FROM user");
			
			while(User.next()) {
				
				if(User.getString("username").equals(this.Username)) exists = true;
			}
			
			User.close();
			stmt.close();
			conn.close();
			
			return exists;
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
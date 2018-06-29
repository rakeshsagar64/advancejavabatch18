package com.src.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.src.model.RegisterModel;

class DbImpl implements DbIntr {
	 	
	 private static Connection con;
	 static{
		 try {
			 InputStream stream = DbImpl.class.getResourceAsStream("db.properties");
			 
			 Properties p=new Properties();
			 p.load(stream);
			Class.forName(p.getProperty("driver"));
			 con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 	 
	 }
	 
	 
	 public int addUser(RegisterModel rm) throws SQLException{
		 String query="insert into registration_18 values(null,?,?,?,?)";
		 PreparedStatement ps = con.prepareStatement(query);
		 ps.setString(1, rm.getUsername());
		 ps.setString(2, rm.getEmail());
		 ps.setString(3, rm.getMobile());
		 ps.setString(4, rm.getPassword());
		 return ps.executeUpdate();
		 
		 
	 }
	 
	 public boolean isValid(String username,String password)throws SQLException{
		 String sql="select username from registration_18 where username=? and password=?";
		 PreparedStatement ps = con.prepareStatement(sql);
		 ps.setString(1, username);
		 ps.setString(2, password);
		 ResultSet set = ps.executeQuery();
		 
		return  set.next();
		 
	 }
	 
	 
}

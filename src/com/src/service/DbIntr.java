package com.src.service;

import java.sql.SQLException;

import com.src.model.RegisterModel;

public interface DbIntr {
	
	public int addUser(RegisterModel rm) throws SQLException;
	public boolean isValid(String username,String password)throws SQLException;

}

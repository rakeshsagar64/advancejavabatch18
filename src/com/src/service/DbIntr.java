package com.src.service;

import java.sql.SQLException;
import java.util.List;

import com.src.model.Job;
import com.src.model.RegisterModel;

public interface DbIntr {
	
	public int addUser(RegisterModel rm) throws SQLException;
	public boolean isValid(String username,String password)throws SQLException;
	public List<Job> fetchJobs() throws SQLException;

}

package com.src.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.Job;
import com.src.service.DbIntr;
import com.src.service.FactoryClass;

@WebServlet("/Jobs")
public class Jobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Jobs() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session!=null){
		String username= (String)request.getAttribute("username");	
		request.setAttribute("username", username);
		DbIntr intr = FactoryClass.getInstance();
		
		
		try {
			List<Job>fetchJobs = intr.fetchJobs();
			request.setAttribute("sampleList", fetchJobs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("WEB-INF/Second.jsp").forward(request, response);
		}
		else{
			
			request.setAttribute("message", "Session expired pls login again");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

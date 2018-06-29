package com.src.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.RegisterModel;
import com.src.service.DbIntr;
import com.src.service.FactoryClass;
import com.src.validation.Validate;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String mobile= request.getParameter("mobile");
		String email = request.getParameter("emailId");
		String password=request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		
		try {
		password=Validate.encryptPassword(password);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//successfull registration
		RegisterModel rm=new RegisterModel();
		rm.setUsername(username);
		rm.setPassword(password);
		rm.setEmail(email);
		rm.setMobile(mobile);
		
		
	
		
		DbIntr intr = FactoryClass.getInstance();
		try {
			int ans=intr.addUser(rm);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("username", username);
		request.getRequestDispatcher("Jobs").forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

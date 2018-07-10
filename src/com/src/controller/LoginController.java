package com.src.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.service.DbIntr;
import com.src.service.FactoryClass;
import com.src.validation.Validate;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		DbIntr intr = FactoryClass.getInstance();

			try {
				password=Validate.encryptPassword(password);
				boolean valid = intr.isValid(username, password);
				if(valid){
					HttpSession session=request.getSession();
					request.getRequestDispatcher("Jobs").forward(request, response);
					
				}
				else{
					request.setAttribute("message", "invalid username or pwd");
					request.setAttribute("icon", "animated wobble");
					request.getRequestDispatcher("index.jsp").forward(request, response);
							
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

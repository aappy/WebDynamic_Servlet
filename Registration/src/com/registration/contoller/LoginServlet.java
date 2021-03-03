package com.registration.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.registration.dao.EmployeeDAO;
import com.registration.model.Employee;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;     
	private EmployeeDAO daoObj = new EmployeeDAO();
	
    public LoginServlet() {
        super();     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
   
		Employee emoObj = new Employee();
		
		emoObj.setUsername(username);
		emoObj.setPassword(password);
		
		PrintWriter out = response.getWriter();
		
		boolean status = false;
		try {
			 status = daoObj.loginEmployee(emoObj);
			 
			 if(status) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/EmpDetails1.jsp");
					dispatcher.forward(request, response);
			 }else {

				    out.println("<h2>User not found Please Register here! </h2>");
				    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empRegisterPage.jsp");
					dispatcher.forward(request, response);
			 }	 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

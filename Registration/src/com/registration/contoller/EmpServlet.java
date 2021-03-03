package com.registration.contoller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.registration.dao.*;
import com.registration.model.Employee;

@WebServlet("/register")
public class EmpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private EmployeeDAO daoObj = new EmployeeDAO();
	  	  	
    public EmpServlet() {       
    	super(); 
    }   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empRegisterPage.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		Employee emoObj = new Employee();
		
		emoObj.setFirstName(firstname);
		emoObj.setLastName(lastName);
		emoObj.setUsername(username);
		emoObj.setPassword(password);
		emoObj.setAddress(address);
		emoObj.setContact(contact);
		
		try {
			daoObj.registrationEmployee(emoObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/EmpDetails.jsp");
		dispatcher.forward(request, response);			
	}
}

package com.as.samples;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sample extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Get registration details and set to the EMailAddress

		String firstName = request.getParameter("fname");
		String middleName = request.getParameter("mname");
		String lastName = request.getParameter("lname");
		String homePhone = request.getParameter("hphone");
		String workPhone = request.getParameter("wphone");

		System.out.println("First Name is " + firstName);
		System.out.println("Last Name is " + lastName);

		request.getSession().setAttribute("ofname", firstName);
		request.getSession().setAttribute("omname", middleName);
		request.getSession().setAttribute("olname", lastName);
		request.getSession().setAttribute("ohphone", homePhone);
		request.getSession().setAttribute("owphone", workPhone);
		
		response.setContentType("text/html");
		response.sendRedirect("jsp/output.jsp");
	}

	public void doGet1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//Get registration details and set to the EMailAddress
		String pfirstName = request.getParameter("pfname");
		String pmiddleName = request.getParameter("pmname");
		String plastName = request.getParameter("plname");
		
		System.out.println("First Name is " + pfirstName);
		System.out.println("Last Name is " + pmiddleName);
		System.out.println("Last Name is " + plastName);
		
		request.getSession().setAttribute("ofname", pfirstName);
		request.getSession().setAttribute("omname", pmiddleName);
		request.getSession().setAttribute("olname", plastName);
		
		response.setContentType("text/html");
		response.sendRedirect("jsp/output1.jsp");
	}
}

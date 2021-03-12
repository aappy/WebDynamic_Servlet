package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.PersonalInfo;

/**
 * Servlet implementation class personalDetailsServlet
 */
@WebServlet("/personalDetailsServlet")
public class personalDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public personalDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstname");
    	String middleName = request.getParameter("middlename");
    	String lastName = request.getParameter("lastname");
    	String gender = request.getParameter("gender");
    	System.out.println("Gender in servlet " +gender + " " +request.getParameter("gender"));
    	
    	String  errorMessages = "";
    	//FirstName Validation 
    	if(isFieldBlank(firstName)) {	
    		errorMessages += "First name is Mandatory.</br>";   		
    	}else if(isFieldHasMinChars(firstName)) {   		
    		errorMessages += "First name is less than 2 characters.</br>";
    	}
    	else if(!isValidName(firstName)) {    		    		
    		errorMessages += "First name should start with Letters.</br>";
    	}
    	
    	//LastName Validation 
    	if(isFieldBlank(lastName)) {	
    		errorMessages += "Last name is Mandatory.</br>";   		
    	}else if(isFieldHasMinChars(lastName)) {   		
    		errorMessages += "Last name is less than 2 characters.</br>";
    	}
    	else if(!isValidName(lastName)) {    		    		
    		errorMessages += "Last name should start with Letters.</br>";
    	}
    	System.out.println("Middle Name :" +middleName);
    	//Middle Name Validation 
    	if(!middleName.isEmpty() && !isValidName(middleName)){

    		System.out.println("latest111");
    		errorMessages += "Middle name should start with Letters.</br>";

    	}
    	
    	System.out.println("Error Message :" + errorMessages);
    	System.out.println("Length :" +errorMessages.length());

    	if(isFieldBlank(errorMessages)) {
    		System.out.println("Error");
    		
    		  PersonalInfo personalInfo = new PersonalInfo();
    		  
    		  personalInfo.setFirstName(firstName); 
    		  personalInfo.setMiddleName(middleName);
    		  personalInfo.setLastName(lastName); 
    		  personalInfo.setGender(gender);
    		  
    		  request.getSession().setAttribute("personalInfo", personalInfo);
    		  response.setContentType("text/html"); 
    		  response.sendRedirect("jsp/contactinfo.jsp");
    	}
    	
    	else {
    	request.setAttribute("Personal", errorMessages);
    		request.setAttribute("abc", "def");
    	System.out.println("request:" +request.getAttribute("abc"));
    	System.out.println("Error messages latest  :" + request.getAttribute("PersonalPageError"));
    	request.getRequestDispatcher("/jsp/personalinfo.jsp").forward(request, response);
    	
    	}
	}

     //Checking the field is not empty
  		private boolean isFieldBlank(String name) {
  		return name.length() == 0;
  	}
  	
  	  //Checking the name start with Alphabets
  	  private  boolean isValidName( String name ) {
  		  String pattern= "^[a-zA-Z]{1}[a-zA-Z0-9-_]*$";
  		  System.out.println("name val!!!!");
  	      return name.matches(pattern);
  	   }
  	  
  	  //Checking the name consists atleast 2 characters
  		private boolean isFieldHasMinChars(String name) {
  			return name.length() <2;
  		}
}

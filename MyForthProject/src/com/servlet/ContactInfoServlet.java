package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.ContactInfo;

@WebServlet("/ContactInfoServlet")
public class ContactInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String phoneNo = request.getParameter("phoneNo");
		
		String errorMessages = "";
		
		//Address Validation 
    	if(isFieldBlank(address)) {	
    		errorMessages += "Address is Mandatory.</br>";   		
    	}
    	
    	//City Validation
    	if(isFieldBlank(city)) {	
    		errorMessages += "City is Mandatory.</br>";   		
    	}
    	else if(!isValidString(city)) {    		    		
    		errorMessages += "City should start with Letters.</br>";
    	}
    	
    	//State Validation
    	if(isFieldBlank(state)) {	
    		errorMessages += "State is Mandatory.</br>";   		
    	}
    	else if(!isValidString(state)) {    		    		
    		errorMessages += "State should start with Letters.</br>";
    	}
    	
    	//Country validation 
    	
    	if(isFieldBlank(country)) {	
    		errorMessages += "Country is Mandatory.</br>";   		
    	}  	
    	//PhoneNumber Validation 
    	if(!phoneNo.isEmpty() && !isValidPhoneNum(phoneNo)) {
    		
    		errorMessages += "Please enter valid 10 digit phone number.";
    	} 	
    	System.out.println("ERROR Message :" +errorMessages);
     	
    	if(isFieldBlank(errorMessages)) {
    		
    		 ContactInfo contactInfo = new ContactInfo(); 
    		  contactInfo.setAddress(address);
    		  contactInfo.setCity(city);
    		  contactInfo.setState(state);
    		  contactInfo.setCountry(country);
    		  contactInfo.setPhoneNo(phoneNo);
    		  
    		  request.getSession().setAttribute("contactInfo", contactInfo);
    		  response.setContentType("text/html");
    		  response.sendRedirect("jsp/bankinfo.jsp");    				
    	}
    	
    	else {
    		request.setAttribute("ContactPageError", errorMessages);
        	request.getRequestDispatcher("/jsp/contactinfo.jsp").forward(request, response);		
    	}
	}
	
		//Checking the field is not empty
		private boolean isFieldBlank(String input) {
			return input.length() == 0;
		}
		
		 //Checking the name start with Alphabets
		  private  boolean isValidString( String input ) {
			  String pattern= "^[a-zA-Z]{1}[a-zA-Z0-9-_]*$";
			  System.out.println("name val!!!!");
		      return input.matches(pattern);
		   }
		  
		  //Checking the phone Number
		  private  boolean isValidPhoneNum( String inputPhone ) {
			  String pattern= "[0-9]{10}";
			  System.out.println("phoneNumber  val!!!!");
		      return inputPhone.matches(pattern);
		   }
}

package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BankInfo;

@WebServlet("/BankInfoServlet")
public class BankInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Inside doget");
		String bankName = request.getParameter("bankName");
		String ssn = request.getParameter("ssn");
		String accountNumber = request.getParameter("accountNumber");
		
		String errorMessages = "";
		
		//Address Validation 
    	if(isFieldBlank(bankName)) {
    		System.out.println("1");
    		errorMessages += "Please Select the Bank name. It is Mandatory.</br>";   		
    	}
    	
    	//Account Number  Validation 
    	if(isFieldBlank(accountNumber)) {
    		System.out.println("2");
    		errorMessages += "Account Number is Mandatory.</br>";   		
    	}
    	else if (!isValidNum(accountNumber)) {		
    		errorMessages += "Please enter 10 digit valid account Number.</br>";
    	}
    	
    	//SSN Validation 
    	if(isFieldBlank(ssn)) {	
    		errorMessages += "SSN is Mandatory.</br>";   		
    	}
    	else if (!isValidNum(ssn)) {   		
    		
    		errorMessages += "Please enter 10 digit valid SSN.</br>";
    	}
		
    	if(isFieldBlank(errorMessages)) {
    		System.out.println("Error");
		
		BankInfo bankInfo = new BankInfo();
		
		bankInfo.setBankName(bankName);
		bankInfo.setSsn(ssn);
		bankInfo.setAccountNumber(accountNumber);
	
		request.getSession().setAttribute("bankInfo", bankInfo);    	
        response.setContentType("text/html");
		response.sendRedirect("jsp/successPage.jsp");
		
    	} else {
    		
    		request.setAttribute("BankPageError", errorMessages);
        	request.getRequestDispatcher("/jsp/bankinfo.jsp").forward(request, response);
    	}
	  }
	
	//Checking the field is not empty
	  private boolean isFieldBlank(String input) {
		return input.length() == 0;
	  }
	
	//Checking the SSN Number and Account Number 
	   private  boolean isValidNum( String input ) {
		  String pattern= "[0-9]{10}";
		  System.out.println("Number  val!!!!");
	      return input.matches(pattern);
	   }
}

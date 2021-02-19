package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicLogin extends HttpServlet{
	int counter = -1;
	
	public void init() {
		counter = 0;
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	response.setContentType("text/html");
    	
    	String username = request.getParameter("userName");
    	String password = request.getParameter("userPassword");
    	
    	PrintWriter out = response.getWriter();

    	//out.println("<h1> " + username + " , " + password + "</h1>");
    	
    	if(username.equals("appy") && password.equals("appy")) { 
    		out.println("Login Successful");
    		counter++;
    		out.print(" <font color=\"blue\"> <br> Number of Hits : " +counter);
    	}else {
    		out.println("Login Failed");
    		counter++;
    		out.print(" <font color=\"blue\"> <br> Number of Hits : " + counter);
    	}
    	out.close();
    }
}
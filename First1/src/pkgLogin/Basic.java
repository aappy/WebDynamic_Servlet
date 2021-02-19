package pkgLogin;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Basic extends HttpServlet{

	private String message;
	
	private static final long serialVersionUID = 1L;
    public Basic() {
       message = "Welcome to LogIn Page";
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	out.println("<h1> " + message + "</h1>");
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
	}
}
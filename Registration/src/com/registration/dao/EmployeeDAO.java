package com.registration.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import com.registration.model.Employee;

public class EmployeeDAO {
	
public int registrationEmployee(Employee employee) throws Exception {
	
	String insert_data = "INSERT INTO emp2" + 
	"(first_name, last_name, username, password, address, contact) VALUES " +
	"(?, ?, ?, ?, ?, ?);";		
	
	 int result = 0;
	 
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 
	 try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aparnadb?useSSL=false&user=root&password=password");	 
	     PreparedStatement p = con.prepareStatement(insert_data)){
		 
		// p.setInt(1, 1);
		 p.setString(1, employee.getFirstName());
		 p.setString(2, employee.getLastName());
		 p.setString(3, employee.getUsername());
		 p.setString(4, employee.getPassword());
		 p.setString(5, employee.getAddress());
		 p.setString(6, employee.getContact());	
		 
		 System.out.println(p);
		 
		 result = p.executeUpdate();
		 
	 }catch(SQLException e) {
		 e.printStackTrace();
	 }	 
	    return result;
    }

public boolean loginEmployee(Employee employee) throws Exception {
	
	String query = "select username,password from emp2;";		
	
	 boolean status = false;
	 
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 
	 try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aparnadb?useSSL=false&user=root&password=password");	 
	     PreparedStatement p = con.prepareStatement(query)){
	 
			ResultSet rs = p.executeQuery(query);
			while (rs.next()) {
				
				String username = rs.getString("username");
				String password = rs.getString("password");
			//	System.out.println("*********"+employee.getUsername());
			
			if(username.equals(employee.getUsername()) && password.equals(employee.getPassword())) {
				status = true;
				return status;
			}
		} 
	 }catch(SQLException e) {
		 e.printStackTrace();
	 }	 
	 return status;
    }
}

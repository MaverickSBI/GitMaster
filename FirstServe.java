package pack;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class FirstServe extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String name=request.getParameter("uname");
		String password=request.getParameter("pswrd");
	//	out.println("the user name is"+name);
		try{
			Connection con;
			PreparedStatement pst;

			  Class.forName("com.mysql.jdbc.Driver");
				 con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/eclerx_catlog","root","root");
			  String q = "insert into Login(username,password)values('"+name+"','"+password+"')";
			pst=(PreparedStatement) con.prepareStatement(q); 
		//	pst.setString(0, name);

			out.println(name);
			
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
		
	}

}

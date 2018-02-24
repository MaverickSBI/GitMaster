package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Login1 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String name= request.getParameter("username");
	String password=request.getParameter("password");
	
	//out.println(name);
	//boolean flg=false;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/eclerx_catlog","root","root");
		//java.sql.Statement s=con.createStatement();
		String q="select * from admin where username=? ";
		
		PreparedStatement pt=(PreparedStatement) con.prepareStatement(q);
		pt.setString(1, "name");
		//use of where clause username to reduce time complexity it will check whole database and iterate whole loop...
		ResultSet rs=pt.executeQuery();//no primary key declared...condition match of two existing datbase leads security problem
		HttpSession session=request.getSession();//need break statement to stop while loop
		session.setAttribute("username",name);//check whole databse take to time so use wwhere username in select query
		String n=(String)session.getAttribute("username");
		//out.println("welcome:::::::"+n);
		if(rs!=null){
		while(rs.next()){// for rs use as iterator as interface from database
			//out.println();
			if(rs.getString(3).equals(password)){
				//flg=true;
				out.println("User is Valid...Welcome Admin:"+n); 
				break;
				//response.sendRedirect("Home1.jsp");
			  }
			else{
				out.println("user is invalid");
			}
		}
		
			
				  
		}else{
			out.println("user is not valid");
			response.sendRedirect("Home.jsp");
		}
			  //if(flg==false){  
				 // flag=false;
			  //out.println("You are not a Valid User");  
			 // response.sendRedirect("Contacts.jsp");
			            
			   
				
				
				//flg=true;
				
				//s.close();
				//con.close();
				//response.sendRedirect("Home.jsp");
				
			
		
		/* if(flg==false){
			out.println("user is not valid");
			s.close();
			con.close();
			//response.sendRedirect("Home1.jsp"); } */
		
		
		
		
		
		
		
		
		
			
		
	}catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}
	

}}


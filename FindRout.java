package pack;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

public class FindRout extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eclerx_catlog" ,"root","root");
	System.out.println("connection Created");
		
	resp.setContentType("text/Html");
	PrintWriter out=resp.getWriter();
	
	String source = req.getParameter("sel");
	String []destination =req.getParameterValues("dest");
	String opt = req.getParameter("opt");
	
	ArrayList<String> des =new ArrayList<String>();
	
	for(int i=0;i<destination.length;i++)
	{
		des.add(destination[i]);
	}
	String input =source;
	String desti=" ";
	LinkedHashMap<String, String> output = new LinkedHashMap<String, String>();
	int max=5000;
	
	PreparedStatement smt =con.prepareStatement("select * from route where city1=? and city2= ?");
	
	for(int j=0;j<destination.length;j++)
	{
		for(int i=0;i<des.size();i++)
		{
			smt.setString(1, input);
			smt.setString(2,(String) des.get(i));
			ResultSet rs=smt.executeQuery();
			int index=0;
			if(opt.equals("time"))
				index=3;
			else
				index=4;
			int time1=max ;
			if(rs.next())
				time1=rs.getInt(index);
			System.out.println("Opt="+time1);
			if(max>time1)
			{
				max=time1;
				desti=(String) des.get(i);
				output.put(input,desti);
				System.out.println("In if:="+output);
			}
		}
		input=desti;
		max=5000;
		des.remove(desti);
	}
	HttpSession session=req.getSession();
	session.setAttribute("output", output);
resp.sendRedirect("Table.jsp");
	out.print("<b>source:-</b>"+source);
	for(String s :destination)
	{
		
		out.print("<br><b>Destination:-</b>"+s);
	}
	out.print("<br>Root =" +output);
	
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(req, resp);
}
}

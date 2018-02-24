package pack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;



public class ReadCSV {

	Connection con;
	PreparedStatement pst;
	
	
	ReadCSV()
	{
	try{
		
	
	
	}catch(Exception e){}
	}
	void readfile(String csvFile){
		 try { 
			 RoutBean rb=new RoutBean();
		 File file = new File(csvFile);  
		    //Get data from this file using a file reader.   
		    FileReader fr = new FileReader(file);  
		    //To store the contents read via File Reader  
		    BufferedReader br = new BufferedReader(fr); 
		      String line = "";
		      StringTokenizer st = null;

		      int lineNumber = 0; 
		      int tokenNumber = 0;

		      //read comma separated file line by line
		      while ((line = br.readLine()) != null) {
		        lineNumber++;

		        //use comma as token separator
		        st = new StringTokenizer(line, ",");

//		        while (st.hasMoreTokens()) {
//		          tokenNumber++;
//		          
//		          //display csv values
//		          System.out.print(st.nextToken()+" " );
//		        }
		        if(st.countTokens()==5)
		        {
		        	rb.setCity1(st.nextToken());
		        	rb.setCity2(st.nextToken());
		        	rb.setTime(Integer.parseInt(st.nextToken()));
		        	rb.setCost(Float.parseFloat(st.nextToken()));
		        	rb.setBusNo(Integer.parseInt(st.nextToken()));
		        	insert(rb);
		        }

		        System.out.println();

		        //reset token number
		        tokenNumber = 0;
		      }
con.close();
		    } catch (Exception e) {
		      System.err.println("CSV file cannot be read : " + e);
		    }
		
	}
	
	
  private void insert(RoutBean rb) throws ClassNotFoundException {
	 
	  try {
		  
		  
		  Class.forName("com.mysql.jdbc.Driver");
			 con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/eclerx_catlog","root","root");
		  String q = "insert into route(city1,city2,time,cost,busnumber) values(?, ?, ?,?,?)";
		pst=(PreparedStatement) con.prepareStatement(q);
		   //ResultSet rs =  pst.executeUpdate(q);
		
		 pst.setString(1, rb.getCity1());
		 pst.setString(2,rb.getCity2());
		 pst.setInt(3, rb.getTime());
		 pst.setFloat(4,rb.getCost());
		 pst.setInt(5, rb.getBusnumber() );
		 pst.executeUpdate();
		 //while (rs.next()) {
	      //   String city1 = rs.getString("city1");
	       //  String city2 = rs.getString("city2");
	       //  int time = rs.getInt("time");
	       //  int cost = rs.getInt("cost");
	       //  int busnumber = rs.getInt("busnumber");
	        // System.out.println(city1 + "  " + city2+"   "+time+ "  " + cost+"   "+busnumber+"");
	       
		
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	  
	  
	}


public static void main(String[] args) {

    try { 
			
      String csvFile = "D:\\New folder\\CSVFile.csv";

      //create BufferedReader to read csv file
      File file = new File(csvFile);  
    //Get data from this file using a file reader.   
    FileReader fr = new FileReader(file);  
    //To store the contents read via File Reader  
    BufferedReader br = new BufferedReader(fr); 
      String line = "";
      StringTokenizer st = null;

      int lineNumber = 0; 
      int tokenNumber = 0;

      //read comma separated file line by line
      while ((line = br.readLine()) != null) {
        lineNumber++;

        //use comma as token separator
        st = new StringTokenizer(line, ",");

        while (st.hasMoreTokens()) {
          tokenNumber++;

          //display csv values
          System.out.print(st.nextToken()+" " );
        }

        System.out.println();

        //reset token number
        tokenNumber = 0;
      }

    } catch (Exception e) {
      System.err.println("CSV file cannot be read : " + e);
    }
  }

void close()
{
	
}


}

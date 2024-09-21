import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.time.*;

public class fir extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

String fname=request.getParameter("fname");
String uname=request.getParameter("uname");
String gender=request.getParameter("radio");
String mail=request.getParameter("mail");
String mob=request.getParameter("mob");
String cat=request.getParameter("cat");
String about=request.getParameter("about");
String suspect=request.getParameter("suspect");
String add=request.getParameter("add");
String ip=request.getRemoteAddr();
LocalDate d= LocalDate.now();
String date= d.toString();
LocalTime t= LocalTime.now();
String time= t.toString();



		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		 
       try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			String sql="insert into fir values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,fname);
			stmt.setString(2,uname);
			stmt.setString(3,gender);
			stmt.setString(4,mail);
			stmt.setString(5,mob);
			stmt.setString(6,cat);
			stmt.setString(7,about);
			stmt.setString(8,suspect);
			stmt.setString(9,add);
			stmt.setString(10,ip);
			stmt.setString(11,date);
			stmt.setString(12,time);
			
			
			
			String sql1="select * from user where username=?";
		    PreparedStatement stmt1=con.prepareStatement(sql1);
			stmt1.setString(1,uname);
			ResultSet rs =stmt1.executeQuery();
			if (rs.next())
			{
			
			
			int result =stmt.executeUpdate();
					if (result>0)
			                    {
				
				                 out.println("<b style='color:lightgreen'>Your FIR Have been Registered Sucessfully....</b>");	
				
			                    }
			                      else
			                         {
			                        	out.println("<b style='color:red'> FIR Registration Failed....Try Again</b>");		
			                         }
				
				
			}
			
			 
			
			
			else 
				
				{
					
					out.println("<b style='color:red'>username already in use....Try with another username..</b>");
			   	}
			con.close();
		}
		catch(Exception ex)
		{
		  out.println("Error: "+ex);	
		}
                
	}

	
	
}
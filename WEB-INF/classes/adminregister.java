import java.time.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class adminregister extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

String fname=request.getParameter("fname");
String lname=request.getParameter("lname");
String designation=request.getParameter("designation");
String gender=request.getParameter("radio");
String mail=request.getParameter("mail");
String mob=request.getParameter("mob");
String add=request.getParameter("add");
String uname=request.getParameter("uname");
String pass=request.getParameter("pass");
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
			String sql="insert into admin values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,fname);
			stmt.setString(2,lname);
			stmt.setString(3,designation);
			stmt.setString(4,gender);
			stmt.setString(5,mail);
			stmt.setString(6,mob);
			stmt.setString(7,add);
			stmt.setString(8,uname);
			stmt.setString(9,pass);
			stmt.setString(10,ip);
			stmt.setString(11,date);
			stmt.setString(12,time);
			
			
			
			String sql1="select * from user where username=?";
		    PreparedStatement stmt1=con.prepareStatement(sql1);
			stmt1.setString(1,uname);
			ResultSet rs =stmt1.executeQuery();
			if (rs.next())
			{
				response.sendRedirect("reg-successfull.html");
			}
			
			 
			
			
			else 
				
				{
					int result =stmt.executeUpdate();
					if (result>0)
			{
				
				out.println("<b style='color:lightgreen'>You Have Registered Sucessfully....</b>");	
				
			}
			else
			{
				out.println("<b style='color:red'>Registration Failed....Try Again</b>");		
			}
				}
			con.close();
		}
		catch(Exception ex)
		{
		  out.println("Error: "+ex);	
		}
                
	}

	
	
}
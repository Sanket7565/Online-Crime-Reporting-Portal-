import java.util.*;
import java.time.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class message extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	
	String fname=request.getParameter("fname");
String email=request.getParameter("email");
String message=request.getParameter("message");
String ip=request.getRemoteAddr();
LocalDate d= LocalDate.now();
String date= d.toString();
LocalTime t= LocalTime.now();
String time= t.toString();
String status= "sent";

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 
		 
		 
		 try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			String sql="insert into message values(?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,fname);
			stmt.setString(2,email);
			stmt.setString(3,message);
			stmt.setString(4,ip);
			stmt.setString(5,date);
			stmt.setString(6,time);
			stmt.setString(7,status);
			
			
			
			int result =stmt.executeUpdate();
			if (result>0)
			{
				response.sendRedirect("feedback-success.html");
			}
			else
			{
				out.println("Failed....Try Again");		
			}
			con.close();
		}
		catch(Exception ex)
		{
		  out.println("Error: "+ex);	
		}
		 
		 
                
	}
		

}
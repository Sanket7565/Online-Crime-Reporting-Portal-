import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class userlogin extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

String uname=request.getParameter("uname");
String pass=request.getParameter("pass");

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		 
		 
       try
		{
			if(uname!=null)
			{
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			String sql="select * from user where username=? and pass=?";
		    PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,uname);
			stmt.setString(2,pass);

			
			ResultSet rs =stmt.executeQuery();
			if (rs.next())
			{
				response.sendRedirect("userui.html");
			}
			else
			{
				out.println("<h3 style='color:red'>login failed....</h3>");
			}
			con.close();
			
			}
		}
		catch(Exception ex)
		{
		  out.println("Error: "+ex);	
		}
                
	}

	
	
}
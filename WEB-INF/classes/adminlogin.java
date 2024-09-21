import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class adminlogin extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

String uname=request.getParameter("auname");
String pass=request.getParameter("apass");

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		 out.println("...............");
		 
       try
		{
			if(uname!=null)
			{
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			String sql="select * from admin where username=? and pass=?";
		    PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,uname);
			stmt.setString(2,pass);

			
			ResultSet rs =stmt.executeQuery();
			if (rs.next())
			{
				out.println("login ....");
				response.sendRedirect("adminui.html");
				
			}
			else
			{
				out.println("login failed....");
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
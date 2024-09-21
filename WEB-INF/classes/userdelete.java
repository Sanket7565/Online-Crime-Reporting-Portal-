import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class userdelete extends HttpServlet 
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
			String sql="delete from user where username=? and pass=?";
		   PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,uname);
			stmt.setString(2,pass);

			
			int result =stmt.executeUpdate();
			if (result>0)
			{
				
				out.println("<h3 style='color:red'>Acount deleted sucessfully...</h3>");
				
			}
			else
			{
				out.println(" <h3 style='color:red'>No such account found.......</h3>");
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
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.time.*;

@WebServlet("/fir1")
@MultipartConfig(maxFileSize =16177216)

public class fir1 extends HttpServlet 
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
Part part=request.getPart("evi");
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
			String sql="insert into fir values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			InputStream is=part.getInputStream();
			stmt.setString(1,fname);
			stmt.setString(2,uname);
			stmt.setString(3,gender);
			stmt.setString(4,mail);
			stmt.setString(5,mob);
			stmt.setString(6,cat);
			stmt.setString(7,about);
			stmt.setString(8,suspect);
			stmt.setString(9,add);
			stmt.setBlob(10,is);
			stmt.setString(11,ip);
			stmt.setString(12,date);
			stmt.setString(13,time);
			
			
			
			
			
			
			
			
			
			
			int result =stmt.executeUpdate();
					if (result>0)
			                    {
				
				                response.sendRedirect("fir-success.html");
			                    }
			                      else
			                         {
			                        	out.println("<b style='color:red'> FIR Registration Failed....Try Again</b>");		
			                         }
				
				
			
			
			 
			
		
			con.close();
		}
		catch(Exception ex)
		{
		  out.println("Error: "+ex);	
		}
                
	}

	
	
}
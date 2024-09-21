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

@WebServlet("/fir")
@MultipartConfig(maxFileSize =16177216)

public class fir extends HttpServlet 
{

PrintWriter out;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{


    
	 
	 out=response.getWriter();
	 int result=0;
	 
	 Part part=request.getPart("image");
		
		 
       try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			String sql="insert into image values(?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			InputStream is=part.getInputStream();
			
			
			
			
			stmt.setBlob(1,is);
			
		   result=stmt.executeUpdate();	
		
			if (result>0)
			{
			

				
				         out.println("<b style='color:lightgreen'>Your Image Have been Uploaded Sucessfully....</b>");
			}
			
			 
			
			
			else 
				
				{
					
					out.println("<b style='color:red'>Failed to upload..</b>");
			   	}
			con.close();
		}
		catch(Exception ex)
		{
		  out.println("Error: "+ex);	
		}
                
	}

	
	
}

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<html>
<head>
<script language="javascript">


function BreakInDetected(){
alert('Admin has Restricted this action for security purpose')
return false
}
function NetscapeBrowser(e){
if (document.layers||
document.getElementById&&!document.all){
if (e.which==2||e.which==3){
BreakInDetected()
return false
}
}
}
function InternetExploreBrowser(){
if (event.button==2){
BreakInDetected()
return false
}
}
if (document.layers){
document.captureEvents(Event.MOUSEDOWN)
document.onmousedown=NetscapeBrowser()
}
else if (document.all&&!document.getElementById){
document.onmousedown=InternetExploreBrowser()
}
document.oncontextmenu=new Function(
"BreakInDetected();return false")



</script>
<title>ecrimefile.gov.in</title> 
<link rel="stylesheet" type="text/css" href="mycss.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<font size="+2">
<div id="navbar">  
</head>
<body bgcolor="black" style="background-repeat:no-repeat; background-size:100%100%">
<body>
<header>
<img src="images/logo.png"style="float:" width="120" height="120" >
<img src="images/logo1.png" width="100" height="110" >



</header>
<ul>
<li> | </a></li>
<li><a href="https://www.indiatoday.in/topic/crime">Hot News </a></li>
<li> | </a></li>
<li><a href="admin login.html">Admin Home </a></li>
<li> | </a></li>
<li><a href="Home.html">Home</a></li>
<li> | </a></li>
<li><a href="Account Setting.html">User Control</a></li>
<li> | </a></li>
<li><a href="cybercrime.html">Cyber Crime</a></li>
<li> | </a></li>
<li><a href="Contact Us.html">Contact Us</a></li>
<li> | </a></li>
<li><a href="faq.html">FAQ</a></li>
<li> | </a></li>
</div>
</div>
<br>
<div class="user1">
<a href="adminui.html">
<input type="button"  value="Back To Admin Page">
</a>
</div>
<br>

<br>
</br>
<form name="form1" method="get" action="">
<center>
</b><h3 style="color:white">F.I.R. Database</h3></b>
<img src="images/database.png"  style="float:"width="50" height="50">
<br>
<br>
<table class="table table-bordered" >
<tr>
<th bgcolor="red">First Name </th>
<th bgcolor="red">User Name </th>
<th bgcolor="red">Gender </th>
<th bgcolor="red">Mail-Id </th>
<th bgcolor="red">Mobile Number </th>
<th bgcolor="red">Category </th>
<th bgcolor="red">About Crime </th>
<th bgcolor="red">Suspect </th>
<th bgcolor="red">Address </th>
<th bgcolor="red">Evidence </th>
<th bgcolor="red">Ip-Address </th>
<th bgcolor="red">Date Of Registration </th>
<th bgcolor="red">Time Of Registration </th>
</tr>

<% 

try
		{
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			String sql="select * from fir";
		    Statement stmt=con.createStatement();

			
			ResultSet rs =stmt.executeQuery(sql);
			while (rs.next())
			{
				%>
				<tr bgcolor="lightgray">
				<td><%=rs.getString("fname")%></td>
				<td><%=rs.getString("uname")%></td>
                <td><%=rs.getString("gender")%></td>
                <td><%=rs.getString("mail")%></td>
                <td><%=rs.getString("mobile")%></td>
				<td><%=rs.getString("category")%></td>
				<td><%=rs.getString("about")%></td>
				<td><%=rs.getString("suspect")%></td>
                <td><%=rs.getString("address")%></td>
				<td><%=rs.getBlob("evidence")%></td>
				<td><%=rs.getString("ip")%></td>
				<td><%=rs.getString("date")%></td>
				<td><%=rs.getString("time")%></td>
				</tr>
				
				
				
				<%
				
			}
			
		}
catch(Exception ex)
{
	out.println("Error: "+ex);
}

%>


</table>
</center>
</form>


                                                                      
</body>
</html>






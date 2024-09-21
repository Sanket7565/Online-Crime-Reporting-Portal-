<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>


<html>
<head>

<script language="javascript">
var state= false;
 function toggle()
 {
   if(state)
   {
    document.getElementById("pass").setAttribute("type","password");
	document.getElementById("eye").setAttribute("class","fa fa-eye-slash");
	state=false;
	
   }
   else
   {
    document.getElementById("pass").setAttribute("type","text");
	document.getElementById("eye").setAttribute("class","fa fa-eye");
	state=true;
   }
 }

function con()
{
if(confirm('do you want to delete your account ?'))
{
   window.document.forms.form1.submit();
   }
else 
   alert('Ok. Thank You!..')
}


Banners = new Array('images/wanted.jfif','images/wanted1.jpg','images/wanted2.jfif')
Banners1 = new Array('images/missing.jfif','images/missing1.jpg')
CurrentBanner = 0
function DisplayBanners() {
if (document.images) {
CurrentBanner++
if (CurrentBanner == Banners.length || CurrentBanner == Banners1.length) {
CurrentBanner = 0
}
document.RotateBanner.src= Banners[CurrentBanner]
document.RotateBanner1.src= Banners1[CurrentBanner]
setTimeout("DisplayBanners()",3000)
}
}


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
<body onload="DisplayBanners()">
<header>
<img src="images/logo.png"style="float:" width="120" height="120" >
<img src="images/logo1.png"style="float:" width="100" height="110" >

<!--<div class="chatbot">
<img src="images/chatbot.png" height="90" width="100" style="float:right">
</div>-->
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
</br>


<div class="userdel">
<img src="images/remove-user.png" class="avatar">
<form name="form1" method="POST"action="userdelete">
<h3 style="color:black"><center><b> Delete Account</b></center></h3>
<br>
<span>Username</span>
<input type="text" name="uname" id="uname" placeholder=" Enter Valid Username" required>
<span>Password</span><span></span>
<input type="password" name="pass" id="pass" placeholder=" Enter Valid Password" required  >
<div class="eye1">
<i class="fa fa-eye-slash" aria-hidden="true" id="eye" onclick="toggle();"></i>
</div>
<table>
                          <tr>
                             <td>
<pre><b><input type="checkbox" required>Delete Account </b></pre
                              </td>
                               </tr>
							   </table>
							   <center>
<a href="userui.html"><input type="button" name="cancel" value="Cancel" id="contBtn"  ></a>
<input type="submit" name="delete" value="Delete" id="contBtn"  onSubmit="con();" >
</center>

<% 

String uname=request.getParameter("uname");
String pass=request.getParameter("pass");
		 
		 
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
%>

</form>


                                                                      
</body>
</html>






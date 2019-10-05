<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Benbill system org.</title>
    <link rel="stylesheet" type="text/css" href="style.css">

  </head>

  <body>
  <div id="outer">
    <div id="header">
      <div id="logo">
        <h1 style="color: firebrick; font-family: 'Colonna MT'">BenBill System</h1>

      </div>
    </div>
    <div id="banner">
      <div class="captions">
        <h2>Sign In</h2>
      </div>
      <img src="image/banner.png" alt=""/>

    </div>
    <div id="nav">
      <ul>
        <li class="first">
          <a href="home.jsp">Home</a>
        </li>

        <li>
          <a href="generalinfo.jsp">New Registration</a>
        </li>

        <li>
          <a href="modify.jsp">Modify Details</a>
        </li>

        <li>
          <a href="ahome.jsp">Administrator</a>
        </li>
        <li>
          <a href="contactus.jsp">Contact Us</a>
        </li>
      </ul>
      <br class="clear"/>

    </div>
    <%
    if(request.getAttribute("notlogin_msg")!=null){
      out.print("<font size='2' color='red' m>");
      out.print(request.getAttribute("notlogin_msg"));
      out.print("</font>");
    }
    %>
<%
 if (request.getAttribute("Error")!=null){
   out.print("<font size='2' color='red' m>");
   out.print(request.getAttribute("Error"));
   out.print("</font>");

 }
%>

    <div id="main">
      <table align="right">
        <tr align="center"><td style="color:navy"><b>Urgent Notice</b></td></tr>
        <tr><td><div><marquee direction="up" width="300px" truespeed="truespeed" onmouseover="stop()" onmouseout="start()" style="color:red;">Last date of Fee submission
        MUST be before date 15 of every month
        Failure to that you will have to attract a penalty of Ksh 100
        per day and your tution fee exclusively</marquee></div></td></tr>
      </table>
      <center><a href="admin.jsp"><font style="color:chartreuse;">Login as Administrator</font> </a> </center>
         <div id="sidebar">
           <div class="box">
             <form method="post" action="loginprocess.jsp">
               <table>
                 <tr><td style="color:blueviolet;"><B> Login:</B></td></tr>
                 <tr><td><br></td></tr>
                 <tr><td style="color: burlywood">Branch:</td><td><select name="branch">
                   <option>Select a Branch</option>
                   <option>Nairobi</option>
                   <option>Nakuru</option>
                   <option>Eldoret</option>
                   <option>Kisumu</option>
                   <option>Nyamira</option>
                   <option>Mombasa</option>
                 </select></td></tr>
                 <tr><td><br></td></tr>

                 <tr><td style="color: blueviolet">Username:</td><td><input type="text" name="username"/></td></tr>
                 <tr><td><br></td></tr>
                 <tr><td style="color: blueviolet">Password:</td><td><input type="password" name="userpass"/> </td></tr>
                 <tr><td><br></td></tr>
                 <tr><td>      </td><td><input type="submit" value="Sign in"></td></tr>
               </table>
             </form>
           </div>
         </div><br class="clear"/>

    </div>
    <div id="header">
      <h4>
        Copyright 2019 All rights reserved.For more Information visit: <a href="www.levinesystems.co.ke"><font style="color: crimson;">Levine Systems Company</font></a>
      </h4>
    </div>
  </div>
  </body>
</html>
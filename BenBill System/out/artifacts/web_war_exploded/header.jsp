<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="style.css">
<div id="header">
    <div id="logo">
        <h1 style="color: firebrick; font-family: 'Colonna MT'; text-shadow: aqua">
            BenBill System
        </h1>
    </div>
</div>
<div id="banner">
    <div class="captions">
   <h2><a href="logout.jsp"><font style="color: crimson"; >LOG OUT</font></a></h2>
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
            <a href="modify.jsp">Modify Detail</a>
        </li>
        <li>
            <a href="ahome.jsp">Administrator</a>
        </li>
        <li>
            <a href="contactus.jsp">Contact us</a>
        </li>
    </ul><br class="clear" />
</div>

</html>

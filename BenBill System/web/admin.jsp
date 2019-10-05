<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Welcome Page</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>
<div id="outer">
    <div id="header">
        <div id="logo">
            <h1>BenBill System</h1>

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

            <tr align="center"><td style="color: slateblue;"><B>Notice</B></td></tr>
            <tr><td><div><marquee direction="up" width="300px" truespeed="truespeed" onmouseover="stop()" onmouseout="start()" style="color: red;">Welcome Administrator sir.
                You Can Visit a lot of information
                about my various Branches.and Accountants
            </marquee></div></td></tr></table>

        <h3 style="color: cornflowerblue;" align="center"><B>Consultant:-   Levine Inc.</B></h3>
        <div id="box">

            <form method="post" action="aloginprocess.jsp" >
                <table>
                    <tr><td style="color:slateblue;"><B> Login Form</B></td></tr>
                    <tr><td><br></td></tr>
                    <tr><td style="color: deepskyblue">Username:</td><td><input type="text" name="username"/></td></tr>
                    <tr><td><br></td></tr>
                    <tr><td style="color: deepskyblue">Password:</td><td><input type="password" name="userpass"/></td></tr>
                    <tr><td><br></td></tr>
                    <tr><td>      </td><td style="color: slateblue"><input type="submit" value="Sign in"></td></tr>

                </table>
            </form>

            <br>

        </div>

    </div>
</div>
</body>

<jsp:include page="footer.jsp"></jsp:include>

</html>

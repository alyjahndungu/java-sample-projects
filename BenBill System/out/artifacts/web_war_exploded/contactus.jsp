<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>


<%
    String islogin=(String)session.getAttribute("islogin");
    if(islogin==null){
        request.setAttribute("notlogin_msg","Sorry, You must login first");
%>
<jsp:forward page="index.jsp"/>
<%
    }
%>



<body>
<Font style="color: blue;" size="4">Contact Us:</Font>
<form method="post" name="myform" id="myform" action="query.jsp">
    <table width="100%">
        <tr>
            <td>
                <table width="55%" align="left" >
                    <tr><td><img src="images/pic01.jpg"/></td>
                        <td><Font style="color: limegreen;" size="3"><B>Your Query:</B></Font><br>

                            <textarea name="query" style="width: 600px; height:80px"></textarea><br>
                            <Font style="color: gold;" size="2"><B>Your Email:</B></Font><input type="text" name="email" style="width: 180px; "/>
                            <input type="submit" value="submit" style="padding: 2px 2px" >
                        </td>
                    </tr>
                </table>
            </td>
            <td>
                <table align="right" >
                    <tr align="left"><td><Font style="color: red;" size="3">Mobile No: +254741862008</Font><br>
                        <Font style="color: olivedrab;" size="3">Email id:hr@levinesystems@gmail.com</Font><br>
                        <Font style="color: darkolivegreen;" size="3">Contact Person:HR Levine System</Font>
                    </td></tr>
                </table>
            </td>
        </tr>

    </table>
</form>
</body>

<jsp:include page="footer.jsp"/>
</div>

</html>

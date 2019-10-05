<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 1:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username= getServletConfig().getServletContext().getInitParameter("username");
    String password=getServletConfig().getServletContext().getInitParameter("password");

    if(request.getParameter("username").equalsIgnoreCase(username)&& request.getParameter("userpass").equalsIgnoreCase(password))
    {
        session.setAttribute("islogin","please sign in first");
%>
<jsp:forward page="ahome.jsp"/>
<%
}

else{
    request.setAttribute("Error","Sorry! Username or Password Error. Please Enter Correct Detail");
    session.setAttribute("Loginmsg","please sign in first");
%>
<jsp:forward page="admin.jsp"/>
<%
    }
%>

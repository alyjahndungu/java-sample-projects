<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 12:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*"%>
<%
    String username=request.getParameter("username");
    System.out.print(username);
    String userpass=request.getParameter("userpass");
    String branch=request.getParameter("branch");
    boolean status=false;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/benbill_schema", "root", "4321");

        PreparedStatement ps=con.prepareStatement("select * from payregister where username=? and userpass=? and branch=? ");
        ps.setString(1,username);
        ps.setString(2,userpass);
        ps.setString(3,branch);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        if(status){
            System.out.print("hi");
            username=rs.getString(2);
            session.setAttribute("username",String.valueOf(username));
            session.setAttribute("islogin","please sign in first");

%>
<jsp:forward page="home.jsp"/>
<%
}
else{
    System.out.print("Hi");
    request.setAttribute("Error","Sorry! Username or Password Error. Please Enter Correct Detail ");
    session.setAttribute("Loginmsg","Please sign in first");
%>
<jsp:forward page="index.jsp"/>
<%
        }
    }

    catch(Exception e){
        e.printStackTrace();
    }

%>

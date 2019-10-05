<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 1:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="java.sql.*"%>
<%
    try {
        String query = request.getParameter("query");
        String email = request.getParameter("email");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/benbill_schema", "root", "4321");
        PreparedStatement ps = con.prepareStatement("insert into query values(?,?)");
        ps.setString(1, query);
        ps.setString(2, email);
        int s = ps.executeUpdate();
        con.close();
    }catch (Exception e){
        e.printStackTrace();
    }
%>
<jsp:forward page="contactus.jsp"/>

<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 1:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*"%>

<%
    try{

        String username=request.getParameter("username");
        String userpass=request.getParameter("userpass");

        String dateofbirth=request.getParameter("dob");
        String dateofjoining=request.getParameter("doj");
        String salary=request.getParameter("salary");
        String branch=request.getParameter("branch");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/benbill_schema", "root", "4321");

        PreparedStatement ps=con.prepareStatement("insert into payregister values(?,?,?,?,?,?,?)");
        ps.setInt(1,21);
        ps.setString(2,username);
        ps.setString(3,userpass);
        ps.setString(4,branch);
        ps.setString(6,dateofbirth);
        ps.setString(5,dateofjoining);
        ps.setString(7,salary);

        int s=ps.executeUpdate();
        System.out.print(s);
  }catch(SQLException e){
        e.printStackTrace();

    }

%>
<jsp:forward page="ahome.jsp"/>


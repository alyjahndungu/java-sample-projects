<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 1:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%
    String n=request.getParameter("val");
    if(n.length()>0){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/benbill_schema", "root", "4321");
            PreparedStatement ps=con.prepareStatement("select * from payregister where id ='"+n+"'");

            ResultSet rs=ps.executeQuery();
            out.print("<br>");
            out.print("<table border='5' cellspacing=5 cellpadding=2>");
            out.print("<tr><td><a href='#' name='ID' onmouseover='javascript:viewAllInfo(this.name)'><B>ID</B></a></td><td><B>User name</B></td><td><B>Password</B></td><td><B>Date of joining</B></td><td><B>Date of Birth</B></td><td><B>Salary</B></td><td><B>Remove</B></td></tr>");
            while(rs.next()){
                out.print("<tr><td><a href='#' name='"+rs.getString(1)+"' onmouseover='javascript:viewAllInfo(this.name)'>"+rs.getString(1)+"</a></td>");
                out.print("<td>"+rs.getString(2)+"</td>");
                out.print("<td>"+rs.getString(3)+"</td>");
                out.print("<td>"+rs.getString(5)+"</td>");
                out.print("<td>"+rs.getString(6)+"</td>");
                out.print("<td>"+rs.getString(7)+"</td>");
                out.print("<td><a href='aremove.jsp?val="+rs.getString(1)+"' name='"+rs.getString(1)+"'>Delete</a></td>");
                out.print("</tr>");
            }
            out.print("</table>");
            con.close();
        }catch(Exception e2){
            e2.printStackTrace();

        }
    }
%>

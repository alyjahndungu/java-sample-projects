<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 1:26 AM
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
            PreparedStatement ps=con.prepareStatement("select * from student2 where name like '%"+n+"%'");
            out.print("<br>");
            ResultSet rs=ps.executeQuery();

            out.print("<table border='5' cellspacing=5 cellpadding=2 id='myTable'>");
            out.print("<tr><td><a href='#' name='ID' onmouseover='javascript:viewAllInfo(this.name)'><B>ID</B></a></td><td><B>Name</B></td><td><B>Mobile</B></td></tr>");
            while(rs.next()){
                out.print("<tr><td><a href='#' name='"+rs.getString(1)+"' onmouseover='javascript:viewAll(this.name)'>"+rs.getString(1)+"</a></td>");
                out.print("<td>"+rs.getString(2)+"</td>");
                out.print("<td>"+rs.getString(4)+"</td>");
                out.print("</tr>");
            }
            out.print("</table>");
            con.close();
        }catch(Exception e3){
            e3.printStackTrace();
        }
    }
%>

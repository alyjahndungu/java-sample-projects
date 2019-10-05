<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 1:40 AM
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
            PreparedStatement ps=con.prepareStatement("delete from payregister where id ='"+n+"'");
            ps.executeUpdate();
            con.close();
            request.setAttribute("msg","Record Has been Successfully Deleted");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
%>
<h2 style="color: crimson">Record has been deleted successfully...!!!</h2>
<jsp:forward page="ahome.jsp"/>
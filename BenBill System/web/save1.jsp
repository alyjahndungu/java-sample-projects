<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*"%>
<%try{
    System.out.print(request.getParameter("name"));
    String id=request.getParameter("id");
    out.println(id);
    String name=request.getParameter("name");
    String course=request.getParameter("course");
    String mobile=request.getParameter("mobile");
    String fathername=request.getParameter("fathername");
    String mothername=request.getParameter("mothername");
    String qualification=request.getParameter("qualification");
    String dateofbirth=request.getParameter("dateofbirth");
    String dateofjoining=request.getParameter("dateofjoining");
    String feesub=request.getParameter("feesub");
    String paid=request.getParameter("paid");
    String fee=request.getParameter("fee");
    String balance=request.getParameter("balance");
    String address=request.getParameter("address");
    String description=request.getParameter("description");
    String trainer=request.getParameter("trainer");

    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/benbill_schema", "root", "4321");
    PreparedStatement ps=con.prepareStatement("update student2 set name='"+name+"',course='"+course+"',mobile='"+mobile+"',address='"+address+"',trainer='"+trainer+"',description='"+description+"',dateofbirth='"+dateofbirth+"',dateofjoining='"+dateofjoining+"',qualification='"+qualification+"',feesub='"+feesub+"',fee='"+fee+"',paid='"+paid+"',balance='"+balance+"',fathername='"+fathername+"',mothername='"+mothername+"'  where id= '"+id+"'");

    int s=ps.executeUpdate();
    System.out.print(s);
}catch(SQLException e2){
    e2.printStackTrace();
}
%>

<jsp:forward  page="modify.jsp"/>


<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 12:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        var request;
        function sendInfo()
        {
            var v=document.myform.findName.value;
            var url="findname1.jsp?val="+v;
            if(window.XMLHttpRequest){
                request=new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
                request=new ActiveXObject("Microsoft.XMLHTTP");
            }
            try
            {
                request.onreadystatechange=getInfo;
                request.open("GET",url,true);
                request.send();
            }
            catch(e){alert("Unable to connect to server");}
        }

        function getInfo(){
            if(request.readyState==4){
                var val=request.responseText;
                document.getElementById('hi').innerHTML=val;
            }
        }

        function sendGenInfo(name)
        {
            var v=name;
            var url="getgeninfoname.jsp?val="+v;
            if(window.XMLHttpRequest){
                request=new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
                request=new ActiveXObject("Microsoft.XMLHTTP");
            }
            try
            {
                request.onreadystatechange=getGenInfo;
                request.open("GET",url,true);
                request.send();
            }
            catch(e){alert("Unable to connect to server");}
        }

        function getGenInfo(){
            if(request.readyState==4){
                var val=request.responseText;
                document.getElementById('hello').innerHTML=val;
            }
        }


    </script>

    <div id="outer">
        <%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
        <jsp:include page="header.jsp"></jsp:include>


            <%
String islogin=(String)session.getAttribute("islogin");
if(islogin==null){
request.setAttribute("notlogin_msg","Sorry,You must login first!!!");
%>
        <jsp:forward page="index.jsp"></jsp:forward>
            <%
}
%>



<body background="image/port.png">
<h3 style="color: deepskyblue;" align="center"><B>Consultant:-  Levine Inc. Systems.</B></h3>
<div id="box">

    <form action="save1.jsp" name="myform" id="hello" method="post">
        <table width="100%">
            <tr>
                <td><table width="55%" align="left" style="table-layout: fixed;">
                    <tr><td>
                        <table cellspacing=15 cellpadding=15">
                            <tr><td><font style="color: blueviolet"><B>Student Detail:</B></font></td></tr>
                            <tr><td style="color: cyan"><B>ID:</B></td><td><input type="text" name="id"/></td></tr>
                            <tr><td style="color: cyan"><B>Name:</B></td><td><input type="text" name="name" /></td></tr>
                            <tr><td style="color: cyan"><B>Course:</B></td><td><input type="text" name="course"/></td></tr>
                            <tr><td style="color: cyan"><B>Mobile:</B></td><td><input type="text" name="mobile"/></td></tr>
                            <tr><td style="color: cyan"><B>Father's Name:</B></td><td><input type="text" name="fathername"/></td></tr>
                            <tr><td style="color: cyan"><B>Mother's Name:</B></td><td><input type="text" name="mothername"/></td></tr>
                            <tr><td style="color: cyan"><B>Qualification:</B></td><td><input type="text" name="qualification"/></td></tr>
                            <tr><td style="color: cyan"><B>Date of Birth:</B></td><td><input type="text" name="dateofbirth"/></td></tr>
                            <tr><td style="color: cyan"><B>Date of Joining:</B></td><td><input type="text" name="dateofjoining" /></td></tr>
                            <tr><td style="color: cyan"><B>Date of Submission:</B></td><td><input type="text" name="feesub" /></td></tr>
                            <tr><td style="color: cyan"><B>Paid:</B></td><td><input type="text" name="paid" /></td></tr>
                            <tr><td style="color: cyan"><B>Fee:</B></td><td><input type="text" name="fee" /></td></tr>
                            <tr><td style="color: cyan"><B>Balance:</B></td><td><input type="text" name="balance" /></td></tr>
                            <tr><td style="color: cyan"><B>Address:</B></td><td><input type="text" name="address"/></td></tr>
                            <tr><td style="color: cyan"><B>Description:</B></td><td><input type="text" name="description"/></td></tr>
                            <tr><td style="color: cyan"><B>Trainer:</B></td><td><input type="text" name="trainer"/></td></tr>
                            <tr><td></td><td><input style="padding:3px 3px " value=" Edit & Save" type="submit"></td></tr>
                        </table>


                </table>
                    <table align="right" width="25%" >
                        <tr>
                            <td><font style="color: blueviolet;"><B>Search:</B></font><input type="text" name="findName" onkeyup="sendInfo()"/></td>
                        </tr>
                        <tr><td><div id="hi"></div></td></tr>

                    </table>
                </td>
            </tr>

        </table>

    </form>

</div>
</body>
<jsp:include page="footer.jsp"/>
</div>
</head>
</html>

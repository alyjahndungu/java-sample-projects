<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/13/2019
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Search</title>
    <script type="text/javascript">
        var request;
        function sendInfo(){
            var v=document.myform.findName.value;
            var url="findname.jsp?val="+v;
            if(window.XMLHttpRequest){
                request=new XMLHttpRequest();
            }else if(window.ActiveXObject){
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
                document.getElementById('location').innerHTML=val;
            }
        }

        function sendGenInfo(name)
        {
            var v=name;
            var url="getgeninfo.jsp?val="+v;
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
                document.getElementById('getgeninfo').innerHTML=val;
            }
        }



        function getAllInfo(){
            if(request.readyState==4){
                var val=request.responseText;
                document.getElementById('bottom').innerHTML=val;
            }
        }

        function getAllRec(){
            if(request.readyState==4){
                var val=request.responseText;
                document.getElementById('right').innerHTML=val;
            }
        }


        function viewAll(name)
        {
            var v=name;
            var url="viewall.jsp?val="+v;

            if(window.XMLHttpRequest){
                request=new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
                request=new ActiveXObject("Microsoft.XMLHTTP");
            }

            try
            {
                request.onreadystatechange=getAllInfo;
                request.open("GET",url,true);
                request.send();
            }
            catch(e){alert("Unable to connect to server");}
        }


        function viewAllInfo(name)
        {
            var v=name;
            var url="viewallinfo.jsp?val="+v;

            if(window.XMLHttpRequest){
                request=new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
                request=new ActiveXObject("Microsoft.XMLHTTP");
            }

            try
            {
                request.onreadystatechange=getAllRec;
                request.open("GET",url,true);
                request.send();
            }
            catch(e){alert("Unable to connect to server");
            }
        }

    </script>
</head>
<div id="outer">
    <jsp:include page="header.jsp"/>

    <%
        String islogin=(String)session.getAttribute("islogin");
        if(islogin==null){
            request.setAttribute("notlogin_msg","Sorry,Please login first");
    %>
    <jsp:forward page="create.jsp"/>
    <%
        }
    %>
</div>
<body width="100">

<div id="main">
    <h3 style="color: deepskyblue;" align="center"><B>Consultant:-  Levine Inc.</B></h3>
    <div id="box">

        <form name="myform" >
            <font style="color: cornflowerblue;">Find:-</font>
            <input type="text" align="right" name="findName" onkeyup="sendInfo()"/>
            <div id="right" align="right"></div>

            <div id="location" align="left"></div>
        </form>

        <div id="bottom" align="justify"></div>
        <div id="getgeninfo" align="justify"></div>
    </div>
</div>

</body>
<jsp:include page="footer.jsp"/>
</html>

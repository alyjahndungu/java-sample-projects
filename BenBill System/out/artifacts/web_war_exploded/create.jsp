<%--
  Created by IntelliJ IDEA.
  User: snipper
  Date: 9/14/2019
  Time: 1:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="outer">
    <jsp:include page="header.jsp"/>


    <div id="main">

        <h3 style="color: navy;" align="center"><B>Consultant:-   Levine Inc. Systems</B></h3>
        <div id="box">

            <form name="myform" action="asave.jsp">
                <table>
                    <tr><td>Branch:</td><td><select name="branch">
                        <option>Select a Branch</option>
                        <option>Nairobi</option>
                        <option>Nakuru</option>
                        <option>Eldoret</option>
                        <option>Kisumu</option>
                        <option>Nyamira</option>
                        <option>Mombasa</option>
                    </select></td></tr>
                    <tr><td><br></td></tr>
                    <tr><td>Username:  </td><td><input type="text" name="username"/></td></tr>
                    <tr><td><br></td></tr>

                    <tr><td>Password:  </td><td><input type="password" name="userpass"/></td></tr>
                    <tr><td><br></td></tr>
                    <tr><td>Date of Joining:</td><td><input type="text" name="doj"/></td></tr>
                    <tr><td><br></td></tr>
                    <tr><td>Date of Birth:</td><td><input type="text" name="dob"/></td></tr>
                    <tr><td><br></td></tr>
                    <tr><td>Salary:</td><td><input type="text" name="salary"/></td></tr>
                    <tr><td><br></td></tr>
                    <tr><td></td><td><input type="submit" value="create" style="padding: inherit"></td></tr>
                    <tr><td><br></td></tr>
                </table>
                <div id="location" align="left"></div>
            </form>

        </div>

    </div>




    <jsp:include page="footer.jsp"/>

</div>


</html>

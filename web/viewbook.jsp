<%-- 
    Document   : viewBook
    Created on : 19 Sep, 2021, 11:44:50 AM
    Author     : bibit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <h1>View Course</h1>
        <s:if test="noData==true">
            <table>
                <center>
                    <thead>
                        <tr style="background-color: #E0E0E5;">
                            <th>Book Id</th>
                            <th>Book Name</th>
                            <th>Book Author</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <s:iterator value="blist">
                        <tr>
                            <td><s:property value="id" /></td>
                            <td><s:property value="bname" /></td>
                            <td><s:property value="bauth" /></td>
                            
                        </tr>
                    </s:iterator>
                </center>
            </table>
                
        </s:if>
        <a href="index.html">Goto Home</a>
    </body>
</html>

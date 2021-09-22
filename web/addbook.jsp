<%-- 
    Document   : addbook
    Created on : 19 Sep, 2021, 10:00:20 AM
    Author     : bibit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
    </head>
    <body>
        <center>
            <h1>Add Course</h1>
            <s:form method="post" action="addBook">
                <s:textfield name="bname" label="Book Name"></s:textfield>
                <br>
                <s:textfield name="bauth" label="Book Auther"></s:textfield>
                <s:submit value="Save"></s:submit>

            </s:form>
             <a href="index.html">Goto Home</a>
        </center>
    </body>
</html>

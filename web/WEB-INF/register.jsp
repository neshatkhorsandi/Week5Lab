<%-- 
    Document   : register
    Created on : Oct 3, 2019, 4:13:22 PM
    Author     : 784789
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>
            <form action="" method="post">
                Username: <input type="text" name="user" size="25" value="${userValue}">
                <input type="submit" value="Register name">
                <input type="hidden" value="register">
            </form>
        </div>
    </body>
</html>

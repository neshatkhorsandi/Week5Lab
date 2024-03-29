<%-- 
    Document   : shoppingList
    Created on : Oct 3, 2019, 4:13:34 PM
    Author     : 784789
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form action="" method="post">
        Hello, ${username} <a href="ShoppingList?action=logout">Log out</a>
        <input type="hidden" name="action" value="logout">
        </form>
        
        
        <h2>List</h2>
        <form action="" method="post">
        Add item: <input type="text" name="addToList" value>
        <input type="hidden" name="action" value="add">
        <input type="submit" value="Add">
        <br>
        
        </form>
        <form action="" method="post">
        <c:forEach items="${shoppingList}" var="addItem">
            <input type="radio" name="radio">
            ${addItem}           
            <br>         
        </c:forEach>
            
        <c:if test = "${!shoppingList.isEmpty()}">
        <input type="hidden" name="action" value="delete">
        <input type="submit" value="Delete">
        </c:if>    
        </form>
   </body>
</html>

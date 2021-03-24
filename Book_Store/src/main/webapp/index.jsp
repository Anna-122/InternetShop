
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h1>Hello from Book Store!</h1><br />

<h2>Все пользователи</h2><br />

<c:forEach var="user" items="${requestScope.users}">
    <ul>

        <li>Имя: <c:out value="${user.name}"/></li>

        <li>Возраст: <c:out value="${user.age}"/></li>

        <form method="post" action="<c:url value='/delete'/>">
            <input type="number" hidden name="id" value="${user.id}" />
            <input type="submit" name="delete" value="Удалить"/>
        </form>

        <form method="get" action="<c:url value='/update'/>">
            <input type="number" hidden name="id" value="${user.id}" />
            <input type="submit" value="Редактированть"/>
        </form>
    </ul>
    <hr />

</c:forEach>

<h2>Создание нового пользователя</h2><br />

<form method="post" action="<c:url value='/add_user'/>">

    <label><input type="text" name="name"></label>Имя<br>

    <label><input type="number" name="age"></label>Возраст<br>

    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>




<%--<%@page import="javax.swing.JOptionPane"%>--%>
<%--<%@page import="java.sql.Connection"%>--%>
<%--<%@page import="java.sql.Statement"%>--%>
<%--<%@page import="java.sql.ResultSet"%>--%>
<%--<%@page import="java.sql.DriverManager"%>--%>
<%--<%@page import="com.solution.goncharova.login"%>--%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%--<%@page import="com.solution.goncharova.login" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
<%--    <title>Book_Store</title>--%>
<%--    <a href="index.jsp">Home Page</a>--%>
<%--    <link rel="stylesheet" type="text/css" href="style.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1><center>Enter Page</center></h1>--%>
<%--<center>--%>
<%--    <h2>Welcome </h2>--%>
<%--    <table>--%>
<%--        <tr><td>User:<input name="name" type="text" size="10"></td></tr>--%>
<%--        <tr><td>Password:<input name="password" size="10"></td></tr>--%>
<%--        <td><input type="submit" value="Submit"></input></td>--%>
<%--    </table>--%>
<%--</center>--%>
<%--</body>--%>
<%--</html>--%>



<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.solution.goncharova.login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.solution.goncharova.login" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book_Store</title>
    <a href="login.jsp">Home Page</a>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1><center>Enter Page</center></h1>
<center>
    <h2>Welcome </h2>
    <table>
        <tr><td>User:<input name="name" type="text" size="10"></td></tr>
        <tr><td>Password:<input name="password" size="10"></td></tr>
        <td><input type="submit" value="Submit"></input></td>
    </table>
</center>
</body>
</html>




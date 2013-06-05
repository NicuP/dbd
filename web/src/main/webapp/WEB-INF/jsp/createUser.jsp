<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<h1>
    Register a new user :
</h1>
<form:form method="post" commandName="user">
    <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
           cellpadding="5">
        <tr>
            <td align="right" width="20%">Name :</td>
            <td width="20%"><form:input path="name" /></td>
        </tr>
        <tr>
            <td align="right" width="20%">Username :</td>
            <td width="20%"><form:input path="username" /></td>
        </tr>
        <tr>
            <td align="right" width="20%">Email :</td>
            <td width="20%"><form:input path="email" /></td>
        </tr>
        <tr>
            <td align="right" width="20%">Password :</td>
            <td width="20%"><form:input path="password" /></td>
        </tr>
    </table>
    <br>
    <input type="submit" align="middle" value="Register">
</form:form>
</body>
</html>
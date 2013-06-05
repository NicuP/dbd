<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
	<body>
		<div>
			<a href="createUser">Register a new user</a>
		</div>
		<div>
			<a href="deleteUser">Remove an existing user</a>
		</div>
        <div>
            <a href="importUsers">Import users from file</a>
        </div>
        <br>
        <div>
            <a href="home">Home</a>
        </div>
        <br>

		<div>
			<h3>Users</h3>
            <br>
            <c:forEach items="${userList}" var="user">
                <%--<form:form method="post" commandName="id">--%>
                    Id : <c:out value="${user.id}" /><br>
                    Name : <c:out value="${user.name}" /><br>
                    Username : <c:out value="${user.username}" />  <br>
               <%-- <a href="updateUser/${user.id}">Update</a>--%>
                <form class="int" method="get" action="/updateUser">
                    <input type="hidden" name="id" value="${user.id}">
                    <input class="btn" type="submit" value="Edit" />
                </form>
                <%-- si altele --%>
                    <%--<input type="submit" value="Update">
                </form:form>--%>
                <br />
                <br />
            </c:forEach>
		</div>
	</body>
</html>
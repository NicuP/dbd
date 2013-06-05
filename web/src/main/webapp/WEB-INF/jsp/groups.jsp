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
			<a href="createGroup">Register a new group</a>
		</div>
		<div>
			<a href="deleteGroup">Remove an existing group</a>
		</div>
        <br>
        <div>
            <a href="home">Home</a>
        </div>
        <br>

		<div>
			<h3>Groups</h3>
            <br>
            <c:forEach items="${groupList}" var="group">
                <%--<form:form method="post" commandName="id">--%>
                    Id : <c:out value="${group.id}" /><br>
                    Name : <c:out value="${group.name}" /><br>
               <%-- <a href="updateUser/${user.id}">Update</a>--%>
                <form class="int" method="get" action="/updateGroup">
                    <input type="hidden" name="id" value="${group.id}">
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
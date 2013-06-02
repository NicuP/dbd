<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 	add css and javascript -->
    <title>Assignment</title>
</head>
<body>
    Assignment Page

    <form:form action="/addAssignment" commandName="assignmentDTO" enctype="multipart/form-data" >
        <form:label path="name">Name</form:label>
        <form:input path="name" />

        <form:label path="text">Description</form:label>
        <form:input path="text" />

        <form:label path="image">Image</form:label>
        <form:input path="image" type="file" />

        <form:label path="attachment1">Attachment 1</form:label>
        <form:input path="attachment1" type="file" />

        <form:label path="attachment2">Attachment 2</form:label>
        <form:input path="attachment2" type="file" />

        <form:label path="attachment3">Attachment 3</form:label>
        <form:input path="attachment3" type="file" />

        <form:label path="attachment4">Attachment 4</form:label>
        <form:input path="attachment4" type="file" />

        <form:label path="attachment5">Attachment 5</form:label>
        <form:input path="attachment5" type="file" />

        <input type="submit" name="Add Assignment" />
    </form:form>

</body>
</html>
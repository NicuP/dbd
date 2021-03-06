<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,java.lang.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
    .title{
        color: #5516C4;
        margin: 25px 0px;
        margin-left: 25px;
    }
    .btn{
        margin-left:140px;
        margin-top:10px;
    }
    .label{
        width: 100px;
        float:left;
    }
   .number{
   		width: 25px;
   }
</style> 
</head>
	<body>
		<div>
			Return to: <
			<a href="/dbd-assignment/home">home</a> <
			<a href="/dbd-assignment/activities"> activities</a>
		</div>
		<div class="title">
			Add new activity
		</div>
		<form:form action="/createActivity" commandName="activityDTO">
	        <form:label path="name" cssClass="label">Name</form:label>
	        <form:input path="name"/>
	        <div>
		        <form:label path="duration" cssClass="label">Duration</form:label>
		        <form:input path="duration" cssClass="number"/>
	        </div>
	        <div>
	        	<form:label path="type" cssClass="label">Type</form:label>
	        	<form:select path="type">
	        		<form:option value="1">Lecture</form:option>
	        		<form:option value="2">Laboratory</form:option>
	        		<form:option value="3">Others</form:option>
	        	</form:select>
	        </div>
	        <div class="label">
		        <form:button name="Submit">Add</form:button>
	        </div>
   	 </form:form>
	</body>
</html>
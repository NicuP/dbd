<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
    .mmm{
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
   
</style> 
</head>
	<body>
		<div>
			Return to: <
			<a href="index.jsp">home</a> <
			<a href="activities.jsp"> < activities</a>
		</div>
		<form class="mmm" method="POST" action="addDVD">
            <div class="btn">Create activity</div>
            <br>
            <div class="label">Name</div> <input type="text" name="name" /><br>
            <div class="label">ActivityType </div> <input type="activityType" name="type" /><br>
            <div class="label">Duration </div> <input type="text" name="duration" /><br>
            
            <input class="btn" type="submit" value="Insert" />
        </form>
	</body>
</html>
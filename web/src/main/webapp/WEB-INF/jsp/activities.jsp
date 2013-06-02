<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*,dbd.web.dto.*"%>
<html>
<head>
<style type="text/css">
	.int {
		float:left;
		width: 150px;
	}
</style>
</head>
	<body>
		<div>
			Return to: <
			<a href="/dbd-assignment/home">home</a> 
		</div>
		<div>
			<a href="/dbd-assignment/assignActivity">Assign activity to group</a>
		</div>
		<div>
			<a href="/dbd-assignment/trackActivity">Track Activity Presence</a>
		</div>	
		<div>
			<a href="/dbd-assignment/createActivity">Create new activity</a>
		</div>
		<div>
			<ol>
        <%
        @SuppressWarnings("unchecked") 
            List<ActivityDTO> activities = (List<ActivityDTO>)request.getAttribute("activities");
            if (activities != null && activities.size() != 0) {%>
                <% for (ActivityDTO activity : activities) { %>
                    <li> 
                        <div>                               
                                <div>
                                    <label class="int">Name : <%= activity.getName() %> </label>            
                                    <label class="int">Duration: <%= activity.getDuration() %></label>
				                    <form class="int" method="GET" action="/removeActivity">
				                        <input type="hidden" name="id" value="<%activity.getId();%>">
				                        <input class="btn" type="submit" value="Edit" />                                
				                    </form>                                               
                                    <form class="int" method="POST" action="/editActivity">
				                          <input type="hidden" name="id" value="<%activity.getId();%>">                               
				                          <input class="btn" type="submit" value="Remove" />
				                    </form>
                                </div>
                                <div class="clear"></div>
                        </div>  
                        <div class="clear"></div>
                    </li>
              <%
                }
            } else {
                	%>
                		<label>There are no activities available</label>
                	<%
                }%>    
        </ol>
		</div>
	</body>
</html>
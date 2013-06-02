<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*,dbd.web.dto.*"%>
<html>
<head>
<style type="text/css">
	 .row{
        margin-left:50px;
    }
    .int{
        float:right;
    }
	.hr {
       border-color: #EAEAF3;
       border-width: 1px;
    }
    .label {
    	width: 200px;
    }
    .title{
       color: #FF7A00;
       font-size: 20px; 
       margin-left:15px;
       margin-right:300px;
       margin-bottom: 25px;
       margin-top: 25px;
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
            	<div class="title">
	            	Activities table
            	</div>
                <% for (ActivityDTO activity : activities) { %>
                    <li> 
                        <div class="row">                                   
                                <div>
                                	<div class="label">
                                   	 <label >Name : <%= activity.getName() %> </label>            
                                	</div>
									<div class="label">
                                    	<label >Duration: <%= activity.getDuration() %></label>
									</div>
				                    <form class="int" method=POST action="/dbd-assignment/removeActivity">
				                       <input type="hidden" name="id" value="<%=activity.getId()%>">  
				                        <input class="btn" type="submit" value="Remove" />                                
				                    </form>
                                    <form class="int" method="POST" action="/dbd-assignment/editActivity">
				                          <input type="hidden" name="id" value="<%=activity.getId()%>">                               
				                          <input class="btn" type="submit" value="Edit" />
				                    </form>
				                    <br/>
                                </div>
                        </div>  
                    </li>
                    <hr class="hr">
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="usermain_header.jsp" %>
<%@ page import="model.SessionUser" %>


<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<%

	String msg = (String) request.getAttribute("msg");
	%>
	<%
	if (msg != null) {
	%>
	<%
	out.print(msg);
	%>
	<%
	}
	%>
<div class="container mt-5" style="max-width: 500px;">
    <h3 class="mb-4 text-center">Change Password</h3>
    <form action="SessionUserController" method="post">
    <div class="form-group">
           
            <input type="hidden" value="<%=d.getSuid() %>" name="suid" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Current Password</label>
            <input type="password" name="op" class="form-control" required>
        </div>
        <div class="form-group">
            <label>New Password</label>
            <input type="password" name="np" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Confirm New Password</label>
            <input type="password" name="cnp" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block" name="action"
										value="cp">Update Password</button>
    </form>
</div>
</body>
</html>

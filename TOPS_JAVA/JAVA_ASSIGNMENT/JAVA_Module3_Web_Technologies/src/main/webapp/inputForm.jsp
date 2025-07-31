<!-- Implement a filter to perform server-side validation of user input. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Input Form</title></head>
<body>
    <form action="SubmitServlet" method="post">
        <p style="color:red;"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>
        Name: <input type="text" name="name" /><br/>
        Email: <input type="text" name="email" /><br/>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>

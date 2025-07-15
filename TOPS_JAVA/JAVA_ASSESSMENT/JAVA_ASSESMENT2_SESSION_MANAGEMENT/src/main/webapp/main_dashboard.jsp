<%@ page import="model.SessionUser" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="usermain_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body { background: #f1f3f6; }
        .navbar-brand { font-weight: 600; }
    </style>
</head>
<body>

<!-- Page Content -->
<div class="container mt-5">
    <h3>Welcome, <%= d.getFirstname() %>!</h3>
    <p>You are successfully logged in.</p>
</div>

</body>
</html>

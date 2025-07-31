<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String user = (session != null) ? (String) session.getAttribute("user") : null;
    if (user == null) {
        response.sendRedirect("userLogin.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(to right, #dfe9f3, #ffffff);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .welcome-card {
            background-color: white;
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 500px;
            width: 100%;
        }
        .welcome-card h2 {
            color: #0d6efd;
            margin-bottom: 20px;
        }
        .logout-btn {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="welcome-card">
    <h2>Welcome, <%= user %> 👋</h2>
    <p class="lead">You have successfully logged in.</p>
    <a href="UserLogoutServlet" class="btn btn-danger logout-btn">Logout</a>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

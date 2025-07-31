<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%
    // Sample data – normally fetched from session or database
    String username = (String) session.getAttribute("username");
    String email = (String) session.getAttribute("email");
    String fullName = (String) session.getAttribute("fullName");
    String phone = (String) session.getAttribute("phone");
    if (username == null) {
        response.sendRedirect("index.jsp"); // redirect if not logged in
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background: linear-gradient(to right, #e3f2fd, #ffffff);
	padding-top: 60px;
}

.profile-card {
	max-width: 500px;
	margin: auto;
	border-radius: 20px;
	padding: 30px;
	background-color: #ffffff;
	box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1);
}

.profile-card h2 {
	color: #007bff;
}

.logout-btn {
	float: right;
}
</style>
</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">User Portal</a>
			<div class="d-flex">
				<a href="LogoutServlet" class="btn btn-outline-light">Logout</a>
			</div>
		</div>
	</nav>

	<!-- Main Profile Card -->
	<div class="profile-card mt-5 text-center">
		<h2>
			Welcome,
			<%= fullName %>
			👋
		</h2>
		<p class="text-muted">Here are your profile details:</p>
		<hr>
		<div class="text-start">
			<p>
				<strong>Username:</strong>
				<%= username %></p>
			<p>
				<strong>Full Name:</strong>
				<%= fullName %></p>
			<p>
				<strong>Email:</strong>
				<%= email %></p>
			<p>
				<strong>Phone:</strong>
				<%= phone %></p>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

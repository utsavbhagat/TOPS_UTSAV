<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Web Technology</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link rel="stylesheet" href="styles.css">
</head>
<body>

	<!-- Navigation Menu -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">WebTech</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link" href="#home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#about">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Main Content -->
	<div class="container">
		<h2 class="text-center">Welcome to Our Website</h2>

		<!-- Login Form -->
		<form action="LoginServlet" method="POST"
			class="mt-4 p-4 border bg-white rounded shadow-sm">
			<div class="mb-3">
				<label class="form-label">Username</label> <input type="text"
					name="username" class="form-control" required>
			</div>
			<div class="mb-3">
				<label class="form-label">Password</label> <input type="password"
					name="password" class="form-control" required>
			</div>
			<button type="submit" class="btn btn-primary w-100">Login</button>
		</form>

		<!-- Table -->
		<h3>User Data</h3>
		<table class="table table-striped table-bordered">
			<thead class="table-dark">
				<tr>
					<th>Name</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Utsav Bhagat</td>
					<td>bhagatutsav2000@gmail.com</td>
				</tr>
			</tbody>
		</table>

		<!-- Button to trigger the servlet -->
		<div class="text-center mt-4">
			<a href="${pageContext.request.contextPath}/HeaderServlet"
				class="btn btn-secondary">View Request Headers</a>
		</div>


		<!-- Lists -->
		<h4>Ordered List</h4>
		<ol class="list-group list-group-numbered">
			<li class="list-group-item">First Item</li>
			<li class="list-group-item">Second Item</li>
			<li class="list-group-item">Third Item</li>
		</ol>

		<h4 class="mt-4">Unordered List</h4>
		<ul class="list-group">
			<li class="list-group-item">Apple</li>
			<li class="list-group-item">Banana</li>
			<li class="list-group-item">Cherry</li>
		</ul>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

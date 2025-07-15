<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Sign Up</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<% String msg = (String) request.getAttribute("msg"); %>
<% if (msg != null) { %>
    <p style="color:red;"><%= msg %></p>
<% } %>

<div class="container mt-5">
    <h2 class="mb-4 text-center">User Sign Up</h2>
    <form action="SessionUserController" method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>First Name</label>
                <input type="text" name="firstName" class="form-control" required>
            </div>
            <div class="form-group col-md-6">
                <label>Last Name</label>
                <input type="text" name="lastName" class="form-control" required>
            </div>
        </div>

        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Mobile</label>
            <input type="text" name="mobile" class="form-control" required pattern="[0-9]{10}" title="Enter 10-digit mobile number">
        </div>

        <div class="form-group">
            <label>Address</label>
            <textarea name="address" class="form-control" rows="3" required></textarea>
        </div>

        <div class="form-group">
            <label>Gender</label><br>
            <div class="form-check form-check-inline">
                <input type="radio" name="gender" value="Male" class="form-check-input" id="male" required>
                <label class="form-check-label" for="male">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="radio" name="gender" value="Female" class="form-check-input" id="female">
                <label class="form-check-label" for="female">Female</label>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Password</label>
                <input type="password" name="password" class="form-control" required minlength="6">
            </div>
            <div class="form-group col-md-6">
                <label>Confirm Password</label>
                <input type="password" name="confirmPassword" class="form-control" required minlength="6">
            </div>
        </div>

        <button type="submit" class="btn btn-primary btn-block" name="action" value="register">Register</button>
    </form>
</div>
</body>
</html>

<%@page import="model.SessionUser"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        
    </style>
</head>
<body>
<%String msg =(String)request.getAttribute("msg"); %>
<%out.print(msg); %>
<div class="container d-flex justify-content-center align-items-center" style="min-height: 90vh;">
    <div class="col-md-6 col-lg-4">
        <div class="login-card">
            <h3 class="text-center login-title mb-4">User Login</h3>
           
            <form action="SessionUserController" method="post">
                <div class="form-group">
                    <label>Email Address</label>
                    <input type="email" name="email" class="form-control" placeholder="Enter email" required>
                </div>

                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Enter password" required>
                </div>

                <div class="form-group text-right">
                    <a href="forgot_password.jsp" class="forgot-password text-primary">Forgot Password?</a>
                </div>

                <button type="submit" name="action" value="login" class="btn btn-primary">Login</button>

                <div class="text-center mt-3">
                    <small>Don't have an account? <a href="signup.jsp">Sign Up</a></small>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reset Password</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
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
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="col-md-6">
            <div class="card p-4">
  				<%String email = (String)request.getAttribute("email"); %>
                <h3 class="text-center mb-4">🔒 Set New Password</h3>
                <label class="form-label"><%=email %></label>
                <form action="SessionUserController" method="post">
                    <div class="mb-3">
                        <label for="newPassword" class="form-label">New Password</label>
							<input type="hidden" name="email" value="<%=email%>">
                        <input type="password" class="form-control" name="np" required placeholder="Enter new password" required minlength="6">
                    </div>
                    <div class="mb-3">
                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                        <input type="password" class="form-control" name="cnp" required placeholder="Re-enter password" required minlength="6">
                    </div>
                    <button type="submit" class="btn btn-primary" name="action"
										value="np">Reset Password</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>

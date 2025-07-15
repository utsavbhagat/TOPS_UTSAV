<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reset Password</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body { background: #f1f3f6; }
        .reset-card {
            background: #fff;
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<div class="container d-flex justify-content-center align-items-center" style="min-height: 90vh;">
    <div class="col-md-6 col-lg-4">
        <div class="reset-card">
            <h4 class="text-center mb-4">Reset Password</h4>
            <form action="ResetPasswordController" method="post">
                <div class="form-group">
                    <label>New Password</label>
                    <input type="password" name="newPassword" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Confirm Password</label>
                    <input type="password" name="confirmPassword" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block mt-3">Change Password</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            background: #f1f3f6;
        }
        .forgot-card {
            background: #fff;
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }
        .form-control {
            border-radius: 10px;
        }
        .btn-primary {
            border-radius: 10px;
            width: 100%;
            margin-top: 10px;
        }
    </style>
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
<div class="container d-flex justify-content-center align-items-center" style="min-height: 90vh;">
    <div class="col-md-6 col-lg-4">
        <div class="forgot-card">
            <h4 class="text-center mb-4">Forgot Password</h4>
            <form action="SessionUserController" method="post">
                <div class="form-group">
                    <label>Enter your registered email</label>
                    <input type="email" name="email" class="form-control" placeholder="you@example.com" required>
                </div>
                <button type="submit" class="btn btn-primary" name="action"
										value="fp">Send OTP</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

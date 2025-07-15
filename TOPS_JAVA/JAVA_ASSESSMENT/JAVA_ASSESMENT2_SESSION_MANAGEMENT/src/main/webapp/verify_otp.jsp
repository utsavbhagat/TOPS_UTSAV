<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Verify OTP</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body { background: #f1f3f6; }
        .otp-card {
            background: #fff;
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
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
        <div class="otp-card">
            <h4 class="text-center mb-4">Enter OTP</h4>
            <%String email = (String)request.getAttribute("email"); %>
					<%int otp = (Integer)request.getAttribute("otp"); %>
						
            <form action="SessionUserController" method="post">
                <div class="form-group">
                    <label>Enter OTP sent to your email</label>
                    <input type="hidden" name="email" value="<%=email%>">
							<input type="hidden" name="otp1" value="<%=otp%>">
								
                    <input type="text" name="otp2" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block mt-3" name="action"
										value="verify">Verify OTP</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<%@page import="model.SessionUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mainheader</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<%
	  response.setHeader("Cache-Control","no-cache");
	  response.setHeader("Cache-Control","no-store");
	  response.setHeader("Pragma","no-cache");
	  response.setDateHeader ("Expires", 0);
	
	
	  SessionUser d = null;
	if (session.getAttribute("data") != null) {
		d = (SessionUser) session.getAttribute("data");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>
<!-- Bootstrap Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">SessionApp</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" 
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link <% if(request.getRequestURI().contains("change_password.jsp")) out.print("active"); %>" href="change_password.jsp">Change Password</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link <% if(request.getRequestURI().contains("logout")) out.print("active"); %>" href="logout.jsp">Logout (<%=d.getFirstname()+" " +d.getLastname()
                    %>)</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Optional Bootstrap JS for responsive menu -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>



</body>
</html>
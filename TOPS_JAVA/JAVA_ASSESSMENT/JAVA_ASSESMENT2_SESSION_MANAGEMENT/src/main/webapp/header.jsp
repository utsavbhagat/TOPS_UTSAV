<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>body {
            background: #f1f3f6;
        }
        .login-card {
            background: #fff;
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }
        .login-title {
            font-weight: 600;
            color: #343a40;
        }
        .form-control {
            border-radius: 10px;
        }
        .btn-primary {
            border-radius: 10px;
            width: 100%; /* Full width like text fields */
            margin-top: 10px; /* Move one step down */
        }
        .forgot-password {
            font-size: 0.9rem;
        }
        
        
        .card {
            border-radius: 1rem;
            box-shadow: 0 0 20px rgba(0,0,0,0.2);
        }
        .form-control:focus {
            box-shadow: none;
            border-color: #2575fc;
        }
        .btn-custom {
            background-color: #2575fc;
            color: white;
        }
        .btn-custom:hover {
            background-color: #1a5edb;
        }
    </style>
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
                    <a class="nav-link <% if(request.getRequestURI().contains("index")) out.print("active"); %>" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <% if(request.getRequestURI().contains("signup")) out.print("active"); %>" href="signup.jsp">Sign Up</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <% if(request.getRequestURI().contains("login")) out.print("active"); %>" href="login.jsp">Login</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Optional Bootstrap JS for responsive menu -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

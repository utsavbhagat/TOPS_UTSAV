<%@include file="a-main-sidebar.jsp"%>
<!DOCTYPE html>
<html lang="en">

<!-- index.html  21 Nov 2019 03:44:50 GMT -->
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no"
	name="viewport">
<title>admin medinova</title>
<!-- General CSS Files -->
<link rel="stylesheet" href="assets/css/app.min.css">
<!-- Template CSS -->
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/components.css">
<!-- Custom style CSS -->
<link rel="stylesheet" href="assets/css/custom.css">
<link rel='shortcut icon' type='image/x-icon'
	href='assets/img/favicon.ico' />
</head>

<body>

	<div class="loader"></div>
	<div id="app">
		<div class="main-wrapper main-wrapper-1">
			<div class="navbar-bg"></div>
			<nav class="navbar navbar-expand-lg main-navbar sticky">
				<div class="form-inline mr-auto">
					<ul class="navbar-nav mr-3">
						<li><a href="#" data-toggle="sidebar"
							class="nav-link nav-link-lg
									collapse-btn"> <i
								data-feather="align-justify"></i></a></li>
						<li><a href="#" class="nav-link nav-link-lg fullscreen-btn">
								<i data-feather="maximize"></i>
						</a></li>
						<li>
							<form class="form-inline mr-auto">
								<div class="search-element">
									<input class="form-control" type="search" placeholder="Search"
										aria-label="Search" data-width="200">
									<button class="btn" type="submit">
										<i class="fas fa-search"></i>
									</button>
								</div>
							</form>
						</li>
					</ul>
				</div>
				<ul class="navbar-nav navbar-right">
					<li class="dropdown dropdown-list-toggle"><a href="#"
						data-toggle="dropdown" class="nav-link nav-link-lg message-toggle"><i
							data-feather="mail"></i> <span class="badge headerBadge1">
						</span> </a>
						<div
							class="dropdown-menu dropdown-list dropdown-menu-right pullDown">
							<div class="dropdown-header">
								Messages
								<div class="float-right">
									<a href="#">Mark All As Read</a>
								</div>
							</div>

							<div class="dropdown-footer text-center">
								<a href="#">View All <i class="fas fa-chevron-right"></i></a>
							</div>
						</div></li>
					<li class="dropdown dropdown-list-toggle"><a href="#"
						data-toggle="dropdown"
						class="nav-link notification-toggle nav-link-lg"><i
							data-feather="bell" class="bell"></i> </a>
						<div
							class="dropdown-menu dropdown-list dropdown-menu-right pullDown">
							<div class="dropdown-header">
								Notifications
								<div class="float-right">
									<a href="#">Mark All As Read</a>
								</div>
							</div>

							<div class="dropdown-footer text-center">
								<a href="#">View All <i class="fas fa-chevron-right"></i></a>
							</div>
						</div></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="nav-link dropdown-toggle nav-link-lg nav-link-user"> <img
							alt="image" src="assets/img/user.png"
							class="user-img-radious-style"> <span
							class="d-sm-none d-lg-inline-block"></span></a>
						<div class="dropdown-menu dropdown-menu-right pullDown">
							<div class="dropdown-title">Hello Admin</div>
							
							<div class="dropdown-divider"></div>
							<a href="a-logout.jsp"
								class="dropdown-item has-icon text-danger"> <i
								class="fas fa-sign-out-alt"></i> Logout
							</a>
						</div></li>
				</ul>
			</nav>
		</div>
	</div>
	<!-- General JS Scripts -->
	<script src="assets/js/app.min.js"></script>
	<!-- JS Libraies -->
	<script src="assets/bundles/apexcharts/apexcharts.min.js"></script>
	<!-- Page Specific JS File -->
	<script src="assets/js/page/index.js"></script>
	<!-- Template JS File -->
	<script src="assets/js/scripts.js"></script>
	<!-- Custom JS File -->
	<script src="assets/js/custom.js"></script>
</body>
</html>
<!-- Createa navigation menu and use pseudo-classes to:
 o Changethecoloroflinks onhover.
 o Styleforminputs when theyare focused. -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Pseudo-Classes Example</title>

<style>
/* Navigation menu links */
nav a {
	text-decoration: none;
	color: black;
	margin-right: 15px;
	font-size: 18px;
}

/* Hover effect */
nav a:hover {
	color: red;
	text-decoration: underline;
}

/* Focus effect on inputs */
input:focus {
	border: 2px solid blue;
	background-color: #e0f7fa;
	outline: none;
}
</style>
</head>
<body>

	<!-- Navigation Menu -->
	<nav>
		<a href="#">Home</a> <a href="#">About</a> <a href="#">Contact</a>
	</nav>

	<hr>

	<!-- Form with focusable inputs -->
	<h3>Contact Form</h3>
	<form>
		<label for="name">Name:</label><br> <input type="text" id="name"><br>
		<br> <label for="email">Email:</label><br> <input
			type="email" id="email"><br>
		<br> <input type="submit" value="Submit">
	</form>

</body>
</html>

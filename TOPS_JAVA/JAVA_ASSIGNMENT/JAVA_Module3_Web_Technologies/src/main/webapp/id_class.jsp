<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ID and Class Example</title>

<style>
/* Style using ID */
#main-heading {
	color: darkblue;
	text-align: center;
	font-size: 28px;
	text-decoration: underline;
}

/* Style using Class */
.highlight {
	background-color: lightyellow;
	border: 1px solid orange;
	padding: 10px;
	margin: 10px 0;
}
</style>
</head>
<body>

	<!-- ID used for unique styling -->
	<h1 id="main-heading">Welcome to My Webpage</h1>

	<!-- Class used for shared styling -->
	<p class="highlight">This is the first highlighted paragraph.</p>
	<p class="highlight">This is the second highlighted paragraph using
		the same class.</p>
	<div class="highlight">Even this div shares the same class style!</div>

</body>
</html>

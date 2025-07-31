<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSS Types Demo</title>

<!-- External CSS -->
<link rel="stylesheet" href="styles.css">

<!-- Internal CSS -->
<style>
.internal-style {
	color: white;
	background-color: teal;
	padding: 10px;
	border-radius: 5px;
}
</style>
</head>
<body>

	<!-- Inline CSS -->
	<h2 style="color: red; text-align: center;">This is an Inline
		Styled Heading</h2>

	<!-- Internal CSS -->
	<p class="internal-style">This paragraph uses Internal CSS styling.</p>

	<!-- External CSS -->
	<div class="external-style">This box is styled using External
		CSS.</div>

</body>
</html>

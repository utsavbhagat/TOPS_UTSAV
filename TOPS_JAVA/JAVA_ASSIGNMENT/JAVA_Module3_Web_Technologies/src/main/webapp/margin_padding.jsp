<!-- Createa webpageand useCSS todemonstrate:
o Marginapplied to an element.
o Paddingapplied to a div.
o Theeffectofdifferent margin and padding values on the layout. -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Margin and Padding Demo</title>

<style>
.margin-box {
	background-color: lightcoral;
	color: white;
	margin: 30px;
	padding: 10px;
	text-align: center;
}

.padding-box {
	background-color: lightseagreen;
	color: white;
	padding: 40px;
	margin: 10px;
	text-align: center;
}

.comparison {
	background-color: lightgray;
	margin: 50px;
	padding: 5px;
	text-align: center;
}
</style>
</head>
<body>

	<h2 style="text-align: center;">Margin and Padding Example</h2>

	<!-- Margin applied -->
	<div class="margin-box">
		This div has <strong>30px margin</strong> and 10px padding.
	</div>

	<!-- Padding applied -->
	<div class="padding-box">
		This div has <strong>40px padding</strong> and 10px margin.
	</div>

	<!-- Comparison -->
	<div class="comparison">
		This div has <strong>50px margin</strong> and <strong>5px
			padding</strong>.
	</div>

</body>
</html>

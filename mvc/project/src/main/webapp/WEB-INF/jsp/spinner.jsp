<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
	.spinner{
	display:flex;
		align-items:center;
		justify-content:center;
		position:absolute;
		top:50%;
		left:50%;
		transform: translate(-50%, -50%);
		z-index:9999;
	}
	#loading div{
		height:60px !important;
		width:60px !important;
		margin:0 15px;
	}
	.spinnerImg{
		height:100px;
		width:100px;
	}
</style>
</head>
<body>
	<div class="spinner">
		<div id="loading">
				<img alt="" src="image/Hourglass.gif" class="spinnerImg">
		</div>
	</div>
</body>
</html>
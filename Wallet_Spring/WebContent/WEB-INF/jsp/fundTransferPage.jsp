<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
table, th, td {
	border: collapse;
	border-spacing: 15px;
	padding: 5px;
}
.btn-primary {
	width: 500px;
	hight: 10px;
}
</style>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
</head>
<h1><font size="9" style="font-weight: bold;">My Wallet</font></h1>
<body bgcolor=aqua>
	<div align="center" style="padding-top: 20px">
		<h1>My Payment App</h1>
	</div>
	<div align="center" style="padding-top: 100px">
		<form action="fundTransfer" method="post">
			<table>
				<tr>
					<td>Your Mobile Number</td>
					<td><input name="sourceMobileNo" size="30"></input></td>
				</tr>
				<tr>
					<td>Target Mobile Number</td>
					<td><input name="targetMobileNo" size="30"></input></td>
				</tr>
				<tr>
					<td>Amount</td>
					<td><input name="balance" size="30"></input></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Transfer" class="btn btn-primary"></td>
				</tr>
			</table>
		</form>
		<div align="center" style="padding-top: 20px">
			<button class="btn" onclick="goBack()">Back</button>
		</div>
	</div>
</body>
</html>
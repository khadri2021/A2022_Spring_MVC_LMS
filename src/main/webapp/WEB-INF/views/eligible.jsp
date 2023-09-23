<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.center {
	padding: 70px 0;
	text-align: center;
}

mark {
	background-color: #ffccf3;
	color: green;
}
</style>
<meta charset="ISO-8859-1">
<title>Eligible</title>
</head>
<body bgcolor="#d1ebd6">
	<div align="center" class="center">
	<h1>SBI BANK LOAN APPLICATION</h1>
	<hr>
		<h1>
			<mark> You Are Eligible For Applying Loan </mark>
			<br> <br>
			<%
			String accountNumber = (String) request.getAttribute("accountNumber");
			%>
			<a href="createform?accountNumber=<%=accountNumber%>">Click Here</a>
			For Apply Loan <br> <br> 
			</h1>
			<a href="search">Click Here</a> To
			Go Previous Page
	</div>
</body>
</html>
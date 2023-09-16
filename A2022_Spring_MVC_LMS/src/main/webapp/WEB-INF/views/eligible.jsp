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
	background-color: blue;
	color: green;
}
</style>
<meta charset="ISO-8859-1">
<title>Eligible</title>
</head>
<body bgcolor="#66ff66">
	<div align="center" class="center">
		<h1>
			<mark> You Are Eligible For Applying Loan </mark>
			<br> <br>
			<%
			String accountNumber = (String) request.getAttribute("accountNumber");
			%>
			<a href="createform?accountNumber=<%=accountNumber%>">Click Here</a>
			For Apply Loan <br> <br> <a href="search">Click Here</a> To
			Go Previous Page
		</h1>
	</div>
</body>
</html>
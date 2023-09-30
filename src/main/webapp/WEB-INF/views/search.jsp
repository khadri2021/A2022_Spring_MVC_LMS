<%@ page import="com.khadri.spring.mvc.loan.form.CustomerForm"%>
<%@ page import="java.util.Objects"%>

<html>
<head>
<style type="text/css">
.center {
	padding: 70px 0;
	text-align: center;
}
</style>
<title>Search Page</title>
</head>
<body bgcolor="#d1ebd6">
	<div align="center" class="center">
	<h1>LOAN ACCOUNT PROCESS</h1>
	<hr>
		<form action="checkeligibility" method="post">
			ACCOUNT NUMBER : <input type="text" name="accountNumber"><br>
			<br> <input type="submit" value="Search">
		</form>
	</div>
</body>
</html>

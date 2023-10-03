<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.khadri.spring.mvc.loan.form.CustomerForm"%>

<html>
<head>
<style type="text/css">
.center {
	padding: 70px 0;
	text-align: center;
}

.errors {
	color: red
}

#link {
	width: 100px;
	height: 20px;
	background: #4285f4 !important;
	padding: 1px;
	text-align: center;
	border-radius: 5px;
	color: white;
	font-weight: bold;
	line-height: 20px;
	text-decoration: none;
	height: 20px;
}

#link:active, #link:hover {
	color: pink;
}
</style>
<title>Search Page</title>
<script type="text/javascript">
	function validation() {
		var accountNumber = document.getElementById("accountNumber").value;
		if (accountNumber == "") {
			alert("Please enter account number...!");
			return false;
		}
		return true;
	}
</script>
</head>
<body bgcolor="#d1ebd6">
	<div align="center" class="center">
		<h1>LOAN ACCOUNT PROCESS</h1>
		<hr>
		<form:form action="checkeligibility" method="post"
			onsubmit="return validation()" modelAttribute="accForm">
			<table align="center">
				<tr align="center">
					<td>ACCOUNT NUMBER : <form:input path="accountNumber"
							name="accountNumber" id="accountNumber" /> <form:errors
							path="accountNumber" cssClass="errors" /></td>
				</tr>
				<tr align="center">
					<td><input type="submit" value="Search" /></td>
				</tr>
				<tr align="center">
					<td><a href="../index.jsp" id="link">Click Here</a> To Go Home
						Page</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>

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
		<form action="checkeligibility" method="post" onsubmit="return validation();">
			ACCOUNT NUMBER : <input type="text" name="accountNumber" id="accountNumber"><br>
			<br> <input type="submit" value="Search">
		</form>
		<a href="../index.jsp">Click Here</a> To Go Home Page
	</div>
</body>
</html>

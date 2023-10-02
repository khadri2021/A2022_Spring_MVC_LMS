<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<script type="text/javascript">
	function validation() {
		//alert("Enter into validations");
		var user = document.getElementById("aNum").value;
		if (user == "") {
			alert("Please Enter Aadhar Number!!");
			return false;
		}

		var p = document.getElementById("pNum").value;

		if (p == "") {
			alert("Please Enter PAN Number!!");
			return false;
		}

		return true;
	}
	 
</script>


<style type="text/css">
 .erros{
   color:BLACK	
 }
</style>
</head>
<body bgcolor="#d1ebd6">
<center>
	<h1>CIBIL CHECK PROCESS</h1>
</center>
	<hr>

<center>
	<form:form action="check" method="post" onsubmit="return validation();"  modelAttribute= "cf">
		<table border="4">
			<tr>
				<td colspan="2" align="center">CHECK CIBIL SCORE</td>
			</tr>
			<tr>
				<td>ENTER YOUR AADHAR :</td>
				<td><form:input path ="aNum" id ="aNum"/>
				<form:errors path="aNum" cssClass="erros"/>
				</td>
			</tr>
			<tr>
				<td>ENTER YOUR PAN :</td>
				<td><form:input path ="pNum" id = "pNum"/>
				<form:errors path="pNum" cssClass="erros"/>
				</td>
				<tr>
				<td colspan="2" align="center"><input type="submit"
					 value="CHECK-CIBIL"></td>
			</tr>
			</tr></table>
			
			</form:form>
			<a href ="../index.jsp">HOME PAGE</a>
			</center>
			</body>
			</html>
			
			
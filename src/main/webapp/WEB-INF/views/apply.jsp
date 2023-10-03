<%@page import="com.khadri.spring.mvc.loan.form.CustomerForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
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
<meta charset="ISO-8859-1">
<title>Loan Apply Form</title>
<script type="text/javascript">
	function validation() {
		var loanType = document.getElementById("lType").value;
		var assets = document.getElementById("assets").value;
		var loanAmount = document.getElementById("loanAmount").value;
		if (loanType == "") {
			alert("Please select type of the loan...!");
			return false;
		} else if (assets == "") {
			alert("Please enter assets name...!");
			return false;
		} else if (loanAmount == "") {
			alert("Please enter required loan amount...!");
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
		<form:form action="process" method="post"
			onsubmit="return validation()" modelAttribute="custForm">

			<table border="1">
				<tr>
					<td width="400">FIRST_NAME</td>
					<td width="400"><input type="text" name="firstName"
						id="firstName" value=${custForm.firstName } readonly="readonly">
						<form:errors path="firstName" cssClass="errors" /></td>

				</tr>
				<tr>
					<td>LAST_NAME</td>
					<td><input type="text" name="lastName" id="lastName"
						value=${custForm.lastName } readonly="readonly"> <form:errors
							path="lastName" cssClass="errors" /></td>
				<tr>
					<td>FATHER_NAME</td>
					<td><input type="text" name="fatherName" id="fatherName"
						value=${custForm.fatherName } readonly="readonly"> <form:errors
							path="fatherName" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>AGE</td>
					<td><input type="text" name="age" id="age"
						value=${custForm.age } readonly="readonly"> <form:errors
							path="age" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" name="email" id="email"
						value=${custForm.email } readonly="readonly"> <form:errors
							path="email" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>PHONE_NUMBER</td>
					<td><input type="text" name="phoneNumber" id="phoneNumber"
						value=${custForm.phoneNumber } readonly="readonly"> <form:errors
							path="phoneNumber" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>ALTERNATIVE_PHONE_NUMBER</td>
					<td><input type="text" name="alternativePhoneNumber"
						id="alternativePhoneNumber"
						value=${custForm.alternativePhoneNumber } readonly="readonly">
						<form:errors path="alternativePhoneNumber" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>ACCOUNT_TYPE</td>
					<td><input type="text" name="accountType" id="accountType"
						value=${custForm.accountType } readonly="readonly"> <form:errors
							path="accountType" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>CURRENT_ADDRESS</td>
					<td><input type="text" name="currentAddress"
						id="currentAddress" value=${custForm.currentAddress }
						readonly="readonly"> <form:errors path="currentAddress"
							cssClass="errors" /></td>
				</tr>
				<tr>
					<td>PERMANENT_ADDRESS</td>
					<td><input type="text" name="permanentAddress"
						id="permanentAddress" value=${custForm.permanentAddress }
						readonly="readonly"> <form:errors path="permanentAddress"
							cssClass="errors" /></td>
				</tr>
				<tr>
					<td>ADHAAR_NUMBER</td>
					<td><input type="text" name="adhaarNumber" id="adhaarNumber"
						value=${custForm.adhaarNumber } readonly="readonly"> <form:errors
							path="adhaarNumber" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>PAN_NUMBER</td>
					<td><input type="text" name="panNumber" id="panNumber"
						value=${custForm.panNumber } readonly="readonly"> <form:errors
							path="panNumber" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>NOMINEE_NAME</td>
					<td><input type="text" name="nomineeName" id="nomineeName"
						value=${custForm.nomineeName } readonly="readonly"> <form:errors
							path="nomineeName" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>NOMINEE_ADHAAR_NUMBER</td>
					<td><input type="text" name="nomineeAdhaarNumber"
						id="nomineeAdhaarNumber" value=${custForm.nomineeAdhaarNumber }
						readonly="readonly"> <form:errors
							path="nomineeAdhaarNumber" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>NOMINEE_ACCOUNT_NUMBER</td>
					<td><input type="text" name="nomineeAccountNumber"
						id="nomineeAccountNumber" value=${custForm.nomineeAccountNumber }
						readonly="readonly"> <form:errors
							path="nomineeAccountNumber" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>ACCOUNT_NUMBER</td>
					<td><input type="text" name="accountNumber" id="accountNumber"
						value=${custForm.accountNumber } readonly="readonly"> <form:errors
							path="accountNumber" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>LOAN_ELIGIBLE</td>
					<td><input type="text" name="loanEligible" id="loanEligible"
						value=${custForm.loanEligible } readonly="readonly"> <form:errors
							path="loanEligible" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>GENERATED LOAN ACCOUNT NUMBER</td>
					<td><input type="text" name="loanAccountNumber"
						id="loanAccountNumber" value=${custForm.loanAccountNumber }
						readonly="readonly"> <form:errors path="loanAccountNumber"
							cssClass="errors" /></td>
				</tr>
				<tr>
					<td>TYPE OF LOAN</td>
					<td><form:select path="lType" name="lType" id="lType">
							<form:option value="">--Select Loan Type--</form:option>
							<form:option value="Personal Loan">Personal Loan</form:option>
							<form:option value="Home Loan">Home Loan</form:option>
							<form:option value="Gold Loan">Gold Loan</form:option>
						</form:select> <form:errors path="lType" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>ASSETS</td>
					<td><form:input path="assets" name="assets" id="assets" /> <form:errors
							path="assets" cssClass="errors" /></td>
				</tr>
				<tr>
					<td>REQUESTED LOAN AMOUNT</td>
					<td><form:input path="howMuchLoanRequired"
							name="howMuchLoanRequired" id="howMuchLoanRequired" /> <form:errors
							path="howMuchLoanRequired" cssClass="errors" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Apply For Loan" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><a href="search" id="link">Click
							Here</a> To Go Search Page</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
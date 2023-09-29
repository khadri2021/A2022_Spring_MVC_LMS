<%@page import="java.util.Objects"%>
<%@page import="com.khadri.spring.mvc.loan.form.CustomerForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Apply Form</title>
</head>
<body bgcolor="#d1ebd6">
	<div align="center" class="center">
		<h1>LOAN ACCOUNT PROCESS</h1>
		<hr>
		<form action="apply" method="post">
			<%
			CustomerForm searchRecord = (CustomerForm) request.getAttribute("search_result");
			%>

			<table border="2">
				<tr>
					<td width="400">FIRST_NAME</td>
					<td width="400"><input type="text"
						value="<%=searchRecord.getFirstName()%>" name="firstName"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>LAST_NAME</td>
					<td><input type="text" value="<%=searchRecord.getLastName()%>"
						name="lastName" readonly="readonly" /></td>
				<tr>
					<td>FATHER_NAME</td>
					<td><input type="text"
						value="<%=searchRecord.getFatherName()%>" name="fatherName"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>AGE</td>
					<td><input type="text" value="<%=searchRecord.getAge()%>"
						name="age" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" value="<%=searchRecord.getEmail()%>"
						name="email" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>PHONE_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getPhoneNumber()%>" name="phoneNumber"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>ALTERNATIVE_PHONE_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getAlternativePhoneNumber()%>"
						name="alternativePhoneNumber" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>ACCOUNT_TYPE</td>
					<td><input type="text"
						value="<%=searchRecord.getAccountType()%>" name="accountType"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>CURRENT_ADDRESS</td>
					<td><input type="text"
						value="<%=searchRecord.getCurrentAddress()%>"
						name="currentAddress" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>PERMANENT_ADDRESS</td>
					<td><input type="text"
						value="<%=searchRecord.getPermanentAddress()%>"
						name="permanentAddress" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>ADHAAR_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getAdhaarNumber()%>" name="adhaarNumber"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>PAN_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getPanNumber()%>" name="panNumber"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>NOMINEE_NAME</td>
					<td><input type="text"
						value="<%=searchRecord.getNomineeName()%>" name="nomineeName"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>NOMINEE_ADHAAR_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getNomineeAdhaarNumber()%>"
						name="nomineeAdhaarNumber" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>NOMINEE_ACCOUNT_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getNomineeAccountNumber()%>"
						name="nomineeAccountNumber" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>ACCOUNT_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getAccountNumber()%>" name="accountNumber"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>GENERATED LOAN ACCOUNT NUMBER</td>
					<td><input type="text"
						value="<%=(String) request.getAttribute("loanAccountNumber")%>"
						name="loanAccountNumber" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>WHICH TYPE OF LOAN</td>
					<td><select name="lType">
							<option value="">--Select Type Of Loan--</option>
							<option value="Personal Loan">Personal Loan</option>
							<option value="Home Loan">Home Loan</option>
							<option value="Gold Loan">Gold Loan</option>
					</select></td>
				</tr>
				<tr>
					<td>ASSETS</td>
					<td><input type="text" name="assets"></td>
				</tr>
				<tr>
					<td>HOW MUCH LOAN</td>
					<td><input type="text" name="howMuchLoanRequired"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Apply For Loan" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><a href="search">Click Here</a>
						To Go Search Page</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
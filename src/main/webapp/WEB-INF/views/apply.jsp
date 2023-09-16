<%@page import="java.util.Objects"%>
<%@page import="com.khadri.spring.mvc.form.CustomerForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Apply Form</title>
</head>
<body bgcolor="#66ff66">
	<div align="center">
		<form action="apply" method="post">
			<%
			CustomerForm searchRecord = (CustomerForm) request.getAttribute("search_result");
			%>

			<table>
				<tr>
					<td width="400">FIRST_NAME</td>
					<td width="400"><input type="text"
						value="<%=searchRecord.getFirstName()%>" name="firstName" /></td>
				</tr>
				<tr>
					<td>LAST_NAME</td>
					<td><input type="text" value="<%=searchRecord.getLastName()%>"
						name="lastName" /></td>
				<tr>
					<td>FATHER_NAME</td>
					<td><input type="text"
						value="<%=searchRecord.getFatherName()%>" name="fatherName" /></td>
				</tr>
				<tr>
					<td>AGE</td>
					<td><input type="text" value="<%=searchRecord.getAge()%>"
						name="age" /></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" value="<%=searchRecord.getEmail()%>"
						name="email" /></td>
				</tr>
				<tr>
					<td>PHONE_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getPhoneNumber()%>" name="phoneNumber" /></td>
				</tr>
				<tr>
					<td>ALTERNATIVE_PHONE_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getAlternativePhoneNumber()%>"
						name="alternativePhoneNumber" /></td>
				</tr>
				<tr>
					<td>ACCOUNT_TYPE</td>
					<td><input type="text"
						value="<%=searchRecord.getAccountType()%>" name="accountType" /></td>
				</tr>
				<tr>
					<td>CURRENT_ADDRESS</td>
					<td><input type="text"
						value="<%=searchRecord.getCurrentAddress()%>"
						name="currentAddress" /></td>
				</tr>
				<tr>
					<td>PERMANENT_ADDRESS</td>
					<td><input type="text"
						value="<%=searchRecord.getPermanentAddress()%>"
						name="permanentAddress" /></td>
				</tr>
				<tr>
					<td>ADHAAR_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getAdhaarNumber()%>" name="adhaarNumber" /></td>
				</tr>
				<tr>
					<td>PAN_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getPanNumber()%>" name="panNumber" /></td>
				</tr>
				<tr>
					<td>NOMINEE_NAME</td>
					<td><input type="text"
						value="<%=searchRecord.getNomineeName()%>" name="nomineeName" /></td>
				</tr>
				<tr>
					<td>NOMINEE_ADHAAR_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getNomineeAdhaarNumber()%>"
						name="nomineeAdhaarNumber" /></td>
				</tr>
				<tr>
					<td>NOMINEE_ACCOUNT_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getNomineeAccountNumber()%>"
						name="nomineeAccountNumber" /></td>
				</tr>
				<tr>
					<td>ACCOUNT_NUMBER</td>
					<td><input type="text"
						value="<%=searchRecord.getAccountNumber()%>" name="accountNumber" /></td>
				</tr>
				<tr>
					<td>GENERATED LOAN ACCOUNT NUMBER</td>
					<td><input type="text"
						value="<%=(String) request.getAttribute("loanAccountNumber")%>"
						name="loanAccountNumber" /></td>
				</tr>
				<tr>
					<td>WHICH TYPE OF LOAN</td>
					<td><select name="lType">
							<option>--Select Type Of Loan--</option>
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
				<td colspan="2"><a href="search">Click Here</a> To Go Search Page</td>
				<tr></tr>
			</table>
		</form>
	</div>
</body>
</html>
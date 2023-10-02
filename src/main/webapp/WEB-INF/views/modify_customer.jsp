<%@ page import="java.util.List"%>
<%@ page import="com.khadri.spring.mvc.account.form.AccountForm"%>

<html>
<script type="text/javascript">
	function ajaxEditForm(rowCount) {
	//	alert('ajax Invoking '+rowCount);
		var firstName = document.getElementById('fName' + rowCount).value;
		var lastName = document.getElementById('lName' + rowCount).value;
	//	alert('last name'+lastName);
		var fatherName = document.getElementById('Name' + rowCount).value;
		var age = document.getElementById('sAge' + rowCount).value;
		var email = document.getElementById('email' + rowCount).value;
		var phoneNumber = document.getElementById('phone' + rowCount).value;
		var alterPhoneNo = document.getElementById('alterPhone' + rowCount).value;
		var accountType = document.getElementById('type' + rowCount).value;
		var currentAddress = document.getElementById('cAddress' + rowCount).value;
		var permanentAddress = document.getElementById('pAddress' + rowCount).value;
		var adhaarNo = document.getElementById('adhaar' + rowCount).value;
		var panNumber = document.getElementById('pan' + rowCount).value;
		var nomineeName = document.getElementById('nName' + rowCount).value;
		var AdhaarNo = document.getElementById('ano' + rowCount).value;
		var nomineeAccountNo = document.getElementById('aco' + rowCount).value;
	//	var ciblScore = document.getElementById('cibil' + rowCount).value;
		
		

		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				alert("Update Successfully");
			}
		};
		xhttp.open("POST", "../../modify/register?fName=" + firstName
				+ "&lName=" + lastName + "&Name=" + fatherName + "&sAge="
				+ age + "&email=" + email + "&phone=" + phoneNumber
				+ "&alterPhone=" + alterPhoneNo + "&type=" + accountType + "&cAddress="
				+ currentAddress + "&pAddress=" + permanentAddress + "&adhaar=" + adhaarNo
				+ "&pan=" + panNumber+ "&nName=" + nomineeName+ "&ano=" + AdhaarNo+ "&aco=" + nomineeAccountNo , true);
		xhttp.send();

	}
</script>

<body bgcolor="#ffff99">
	<%
	List<AccountForm> listOfCustomers = (List<AccountForm>) request.getAttribute("edit_result");
	%>

	<form action="">

		<table border="4" id="mydata">
			<tr>
				<td colspan="7" align="center">MODIFY CUSTOMER FORM</td>
			</tr>


			<tr>
				<td align="center">FIRST NAME</td>
				<td align="center">LAST NAME</td>
				<td align="center">NAME</td>
				<td align="center">AGE</td>
				<td align="center">EMAIL</td>
				<td align="center">PHONE NUMBER</td>
				<td align="center">ALTERNATIVE PHONE NUMBER</td>
				<td align="center">TYPE</td>
				<td align="center">CURRENT ADDRESS</td>
				<td align="center">PERAMANENT ADDRESS</td>
				<td align="center">ADHAAR NO</td>
				<td align="center">PAN NO</td>
				<td align="center">NOMINEE NAME</td>
				<td align="center">NOMINEE ADHAARNO</td>
				<td align="center">NOMINEE ACCOUNTNO</td>
				<td align="center">CIBIL</td>
			</tr>
			<%
			int inc = 1;
			for (AccountForm customer : listOfCustomers) {
			%>
		 
	

			<tr>
				<td><input type="text" id="fName<%=inc%>"
					value="<%=customer.getfName()%>" ></td>
					
				<td><input type="text" id="lName<%=inc%>"
					value="<%=customer.getlName()%>"></td>
					
				 	
				<td><input type="text" id="Name<%=inc%>"
					value="<%=customer.getName()%>"></td>
					
				<td><input type="text" id="sAge<%=inc%>"
					value="<%=customer.getsAge()%>"></td>
					
				<td><input type="text" id="email<%=inc%>"
					value="<%=customer.getEmail()%>"></td>
					
				<td><input type="text" id="phone<%=inc%>"
					value="<%=customer.getPhone()%>"></td>
					
				<td><input type="text" id="alterPhone<%=inc%>"
					value="<%=customer.getAlterPhone()%>"></td>
					
				<td><input type="text" id="type<%=inc%>"
					value="<%=customer.getType()%>"></td>
			 
					
					
				<td><input type="text" id="cAddress<%=inc%>"
					value="<%=customer.getcAddress()%>"></td>
					
				<td><input type="text" id="pAddress<%=inc%>"
					value="<%=customer.getpAddress()%>"></td>
					
				<td><input type="text" id="adhaar<%=inc%>"
					value="<%=customer.getAdhaar()%>" disabled="disabled"></td>
					
				<td><input type="text" id="pan<%=inc%>"
					value="<%=customer.getPan()%>" disabled="disabled"></td>
					
				<td><input type="text" id="nName<%=inc%>"
					value="<%=customer.getnName()%>"></td>
					
				<td><input type="text" id="ano<%=inc%>"
					value="<%=customer.getAno()%>"></td>
					
				<td><input type="text" id="aco<%=inc%>"
					value="<%=customer.getAco()%>"></td>
					
			<%-- 	<td><input type="text" id="cibil<%=inc%>"
					value="<%=customer.getCibil()%>"></td>
			 --%>		
			 
				<td><input type="button" value="MODIFY RECORD"
					onclick="ajaxEditForm(<%=inc%>)"></td>
			</tr>


			<%
			inc++;
			}
			%>

			<input type="hidden" name="mode" value="EDIT">


		</table>
		<table bgcolor="#99ff99">
			<tr>
				<td colspan="2" align="center"><a href="../../adminpage">Go
						To</a> previous page</td>
			</tr>
		</table>


	</form>

</body>
</html>

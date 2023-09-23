<%@ page import="java.util.List"%>
<%@ page import="com.khadri.spring.mvc.account.form.AccountForm"%>


<html>
<script type="text/javascript">

function ajaxDeleteForm(rowCount){
	//alert('ajax Invoking '+rowCount);
	var panNo= document.getElementById('panNo'+rowCount).value; 
	
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      alert("Deleted Successfully");
	    }
	  };
	  xhttp.open("POST", "../../delete/register?pan="+panNo, true);
	  xhttp.send();
	
}
</script>

<body bgcolor="#ffff99">
	<%
	List<AccountForm> listOfCustomers = (List<AccountForm>) request.getAttribute("delete_result");
	%>

	<form action="">
		</table>
		<table bgcolor="#99ff99">
			<tr>
				<td colspan="2" align="center"><a href="../../adminpage">Go
						To</a> previous page</td>
			</tr>
		</table>
		<table border="4" id="mydata">
			<tr>
				<td colspan="8" align="center">DELETE CUSTOMER FORM</td>
			</tr>

			<tr>
				<td align="center">First Name</td>
				<td align="center">Last NAME</td>
				<td align="center">NAME</td>
				<td align="center">AGE</td>
				<td align="center">Email</td>
				<td align="center">PHONE NUMBER</td>
				<td align="center">ALTERNATIVE PHONE NUMBER</td>
				<td align="center">Type</td>
				<td align="center">Current ADDRESS</td>
				<td align="center">Peramanent ADDRESS</td>
				<td align="center">Adhaar</td>
				<td align="center">Pan</td>
				<td align="center">Nominee name</td>
				<td align="center">Nominee adhaarno</td>
				<td align="center">Nominee Accountno</td>
				<td align="center">CIBIL</td>
			</tr>
			<%
			int inc = 1;
			for (AccountForm customer : listOfCustomers) {
			%>

			<tr>
				<td><input type="text" id="fName<%=inc%>"
					value="<%=customer.getfName()%>" disabled="disabled"></td>

				<td><input type="text" id="lName<%=inc%>"
					value="<%=customer.getlName()%>"></td>


				<td><input type="text" id="Name<%=inc%>"
					value="<%=customer.getName()%>"></td>

				<td><input type="text" id="sAge<%=inc%>"
					value="<%=customer.getsAge()%>"></td>

				<td><input type="text" id="email<%=inc%>"
					value="<%=customer.getEmail()%>"></td>

				<td><input type="text" id="alterPhone<%=inc%>"
					value="<%=customer.getAlterPhone()%>"></td>

				<td><input type="text" id="type<%=inc%>"
					value="<%=customer.getType()%>"></td>



				<td><input type="text" id="cAddress<%=inc%>"
					value="<%=customer.getcAddress()%>"></td>

				<td><input type="text" id="pAddress<%=inc%>"
					value="<%=customer.getpAddress()%>"></td>

				<td><input type="text" id="adhaar<%=inc%>"
					value="<%=customer.getAdhaar()%>"></td>

				<td><input type="text" id="pan<%=inc%>"
					value="<%=customer.getPan()%>"></td>

				<td><input type="text" id="nName<%=inc%>"
					value="<%=customer.getnName()%>"></td>

				<td><input type="text" id="ano<%=inc%>"
					value="<%=customer.getAno()%>"></td>

				<td><input type="text" id="aco<%=inc%>"
					value="<%=customer.getAco()%>"></td>

				<td><input type="button" value="DELETE RECORD"
					onclick="ajaxDeleteForm(<%=inc%>)"></td>
			</tr>

			<%
			inc++;
			}
			%>

		</table>

		 
	</form>

</body>
</html>

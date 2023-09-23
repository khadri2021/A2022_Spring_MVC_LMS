<%@ page import="com.khadri.spring.mvc.account.form.AccountForm"%>
<%@ page import="java.util.Objects"%>

<html>
<script type="text/javascript">
	
</script>
<body bgcolor="#80ffff">
	<form action="view/register">
		<table border="4">

			<tr>
				<td colspan="2" align="center">VIEW Customer FORM</td>
			</tr>
			<tr>
				<td>PAN NUMBER :</td>
				<td><input type="text" name="pan"
					placeholder="enter pan number for search"></td>
			</tr>

			<tr>
				<td colspan="16" align="center"><input type="submit"
					value="Search Record"></td>
			</tr>
			<input type="hidden" name="mode" value="SEARCH">
			<%
			AccountForm searchRecord = (AccountForm) request.getAttribute("search_result");
			%>

			<%
			if (Objects.nonNull(searchRecord)) {
			%>

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

			<tr>
				<td align="center"><%=searchRecord.getfName()%></td>
				<td align="center"><%=searchRecord.getlName()%></td>
				<td align="center"><%=searchRecord.getName()%></td>
				<td align="center"><%=searchRecord.getsAge()%></td>
				<td align="center"><%=searchRecord.getEmail()%></td>
				<td align="center"><%=searchRecord.getPhone()%></td>
				<td align="center"><%=searchRecord.getAlterPhone()%></td>
				<td align="center"><%=searchRecord.getType()%></td>
				<td align="center"><%=searchRecord.getcAddress()%></td>
				<td align="center"><%=searchRecord.getpAddress()%></td>
				<td align="center"><%=searchRecord.getAdhaar()%></td>
				<td align="center"><%=searchRecord.getPan()%></td>
				<td align="center"><%=searchRecord.getAno()%></td>
				<td align="center"><%=searchRecord.getAco()%></td>
				<td align="center"><%=searchRecord.getCibil()%></td>
			</tr>

			<%
			} else {
			%>
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

			<tr bgcolor="red">
				<td colspan="7" align="center">No Record Found</td>
			</tr>

			<%
			}
			%>

		</table>
	</form>

</body>
</html>

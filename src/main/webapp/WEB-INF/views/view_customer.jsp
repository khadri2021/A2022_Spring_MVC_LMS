<%@page import="com.khadri.spring.mvc.account.entity.Account"%>
<%@ page import="java.util.Objects"%>

<html>
<script type="text/javascript">
	
</script>
<body bgcolor="#80ffff">
	<form action="view/register">
		<table border="4">

			<tr>
				<td colspan="15" align="center">VIEW CUSTOMER FORM</td>
			</tr>
			<tr>
				<td>PAN NUMBER :</td>
				<td><input type="text" name="pan"
					placeholder="enter pan number for search" required="required"></td>
			</tr>

			<tr>
				<td colspan="16" align="center"><input type="submit"
					value="Search Record"></td>
			</tr>
<!-- 			<input type="hidden" name="mode" value="SEARCH"> -->
			<%
			Account searchRecord = (Account) request.getAttribute("view_result");
			%>

			<%
			if (Objects.nonNull(searchRecord)) {
			%>

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
				<td align="center">PERMANENT ADDRESS</td>
				<td align="center">ADHAAR NO</td>
				<td align="center">PAN NO</td>
				<td align="center">NOMINEE NAME</td>
				<td align="center">NOMINEE ADHAARNO</td>
				<td align="center">NOMINEE ACCPUNTNO</td>
				<td align="center">ACCOUNTNO</td>
				<td align="center">CIBIL</td>
			</tr>

			<tr>
				<td align="center"><%=searchRecord.getFirstName()%></td>
				<td align="center"><%=searchRecord.getLastName()%></td>
				<td align="center"><%=searchRecord.getName()%></td>
				<td align="center"><%=searchRecord.getAge()%></td>
				<td align="center"><%=searchRecord.getEmail()%></td>
				<td align="center"><%=searchRecord.getPhoneNo()%></td>
				<td align="center"><%=searchRecord.getAlternativePhoneNo()%></td>
				<td align="center"><%=searchRecord.getAccountType()%></td>
				<td align="center"><%=searchRecord.getCurrentAddress()%></td>
				<td align="center"><%=searchRecord.getPermanentAddress()%></td>
				<td align="center"><%=searchRecord.getAdhaarNo()%></td>
				<td align="center"><%=searchRecord.getPanNo()%></td>
				<td align="center"><%=searchRecord.getNomineeAdhaarNo()%></td>
				<td align="center"><%=searchRecord.getNomineeAcNo()%></td>
				<td align="center"><%=searchRecord.getAccountNumber()%></td>
				<td align="center"><%=searchRecord.getCibilScore()%></td>
			</tr>

			<%
			} else {
			%>
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
				<td align="center">PERMANENT ADDRESS</td>
				<td align="center">ADHAAR NO</td>
				<td align="center">PAN NO</td>
				<td align="center">NOMINEE NAME</td>
				<td align="center">NOMINEE ADHAARNO</td>
				<td align="center">NOMINEE ACCOUNTNO</td>
				<td align="center">ACCOUNTNO</td>
				<td align="center">CIBIL</td>
			</tr>

			<tr bgcolor="red">
				<td colspan="17" align="center">NO RECORD FOUND</td>
			</tr>

			<%
			}
			%>

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

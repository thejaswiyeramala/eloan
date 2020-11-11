<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Application Form</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body onload="myFunction()">

<!--
	write the html code to accept laon info from user and send to placeloan servlet	
-->
<jsp:include page="header.jsp"/>
<a href="userhome.jsp">HomePage </a>	
<hr/>
<div align=left>
	<h2>Loan Application Form</h2>
	<form action="user?action=application1" method="post">
		<div>
			<div><label for="LoanName">Enter LoanName</label>
			<input type="text" id="LoanName" name="LoanName"> </div>
		</br>
		<div>
			<div><label for="LoanAmountRequest">Enter LoanAmountRequest</label>
			<input type="text" id="LoanAmountRequest" name="LoanAmountRequest"> </div>
        </br>
		<div>
			<div><label for="LoanApplicationDate">Enter LoanApplicationDate</label>
			<input type="text" id="LoanApplicationDate" name="LoanApplicationDate"> </div>
		</br>
		<div>
		<label for="Businessstruture">Businessstruture</label>
<select name="Businessstruture" id="Businessstruture">
<option value="0">Individual</option>
<option value="1">Organisation</option>
</select></div>
</br>
		<div>
		<label for="Billing Indicator">BillingIndicator</label>
<select name="BillingIndicator" id="BillingIndicator">
<option value="0">Salaried Employee</option>
<option value="1">Non Salaried Employee</option>
</select></div>
</br>
		<label for=" Tax indicator"> Tax indicator</label>
<select name="Taxindicator" id="Taxindicator">
<option value="0">Tax Payer</option>
<option value="1">Non Tax Payer</option>
</select></div>
</br>
			<div><label for="Address ">Enter Address</label>
			<input type="text" id="Address" name="Address"> </div>
            </br>
			<div><label for="Mobile Number">Enter Mobile Number</label>
			<input type="text" id="MobileNumber" name="MobileNumber"> </div>
			</br>
			<div><label for="EmailID">Enter EmailID</label>
			<input type="text" id="EmailID" name="EmailID"></div>
			</br>
			<div><input type="submit" value="Submit"onclick="location.href='loanDetails.jsp'">
			<input type="submit" value="Cancel"> </div>
		</div>	
	</form>
	</div>
	</div>
<hr/>
<jsp:include page="footer.jsp"/>

</script>


</body>
</html>
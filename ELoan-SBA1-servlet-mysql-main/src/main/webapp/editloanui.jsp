<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div align="right"><a href="index.jsp">Logout</a></div>
<form action="user?action=editLoanProcess" method="post">
		<div>
			<div><label for="LoanName">Enter LoanName</label>
			<input type="text" id="LoanName" name="LoanName"> </div>
			<% String LoanApplicationNumber =(String)request.getAttribute("LoanApplicationNumber"); %>
			<a><% out.println(LoanApplicationNumber); %>	
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
			<div><input type="submit" value="Submit"onclick="location.href='editloan1.jsp'">
			<input type="submit" value="Cancel"> </div>
		</div>	
	</form>
	</div>
	</div>
<hr/>
<jsp:include page="footer.jsp"/>

<jsp:include page="footer.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- write the code to read application number, and send it to admincontrollers
	     callemi method to calculate the emi and other details also provide links
	     to logout and admin home page
	-->
	<jsp:include page="header.jsp"/>
<div align="right"><a href="index.jsp">Logout</a></div>
<div><label for="LoanApplicationNumber">LoanApplicationNumber</label>
			<input type="text" id="LoanApplicationNumber" name="LoanApplicationNumber">
		</div>
			<div><input type="submit" value="Submit">
			<input type="submit" value="Cancel"> </div>
		</div>
		
<jsp:include page="footer.jsp"/>

</body>
</html>
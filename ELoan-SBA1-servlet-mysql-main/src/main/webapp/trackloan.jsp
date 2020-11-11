<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Track Loan Application</title>
</head>
<body>
	<!-- write html code to read the application number and send to usercontrollers'
             displaystatus method for displaying the information
	-->
	<jsp:include page="header.jsp"/>
<hr/>
<div align=left>
	<h2>Track Loan Application Form</h2>
	<a href="userhome.jsp">HomePage </a>	
	<form action="user?action=displaystatus" method="post">
	<div>
			<div><label for="LoanApplicationNumber">LoanApplicationNumber</label>
			<input type="text" id="LoanApplicationNumber" name="LoanApplicationNumber">
		</div>
		</br>
			<div><input type="submit" value="Submit">
			<input type="submit" value="Cancel"> </div>
		</div>
		
	</form>
	</div>
	</div>
<hr/>
<jsp:include page="footer.jsp"/>
	
	

</body>
</html>
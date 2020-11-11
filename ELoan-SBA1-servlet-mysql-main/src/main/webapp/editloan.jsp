<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Loan Application</title>
</head>
<script type="text/JavaScript">
        function showMessage(){
            var message = document.getElementById("message").value;
            display_message.innerHTML= message;
        }
    </script>
<body>
	<!-- read the application number to edit from user and send to 
	     user controller to edit info
	-->
	<jsp:include page="header.jsp"/>
	<a href="userhome.jsp">HomePage </a>	
<hr/>
<div align=left>
	<h2>Edit Loan Application Form</h2>
	<div>
			<div><label for="LoanApplicationNumber">LoanApplicationNumber</label>
			<input type="text" id="LoanApplicationNumber" name="LoanApplicationNumber">
		</div>
			<div><input type="submit" value="Submit">
			<input type="submit" value="Cancel"> </div>
		</div>
	</div>
	</div>
<hr/>
<jsp:include page="footer.jsp"/>
	

</body>
</html>
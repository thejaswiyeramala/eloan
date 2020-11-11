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
	<!-- write the code to display the loan status information 
	     received from usercontrollers' displaystatus method
	-->
<jsp:include page="header.jsp"/>
 <a href="userhome1.jsp">HomePage </a>	
<hr/>
<div align=center>
	<h2>Track Loan Status</h2>
			<div>
			<label for="LoanApplicationNumber">LoanApplicationNumber</label>
			<% String LoanApplicationNumber =(String) request.getServletContext().getAttribute("LoanApplicationNumber"); %>
			<a><% out.println(LoanApplicationNumber); %>		
		</div>
		</br>
  	<label for="status">status </label>
			<% String Status =(String)request.getAttribute("Status"); %>
			<% out.println(Status); %>	
		</div>
	</div>
	</div>
<hr/>
<jsp:include page="footer.jsp"/>

</body>
</html>
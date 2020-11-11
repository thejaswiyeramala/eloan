<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Loans</title>
</head>
<body>
	<!-- write code to display all the loan details 
             which are received from the admin controllers' listall method
	-->
<h4>Loan Information Dashboard</h4>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ApplicationNumber</th>
                <th>loanName</th>
                <th>AmountRequest</th>
                <th>ApplicationDate</th>
                <th>BusinessStructure</th>
                <th>BillingIndicator</th>
                 <th>TaxIndicator</th>
                  <th>Address</th>
                   <th>MobileNumber</th>
                   <th>EmailID</th>
                   <th>Status</th>
                
            </tr>
            <c:forEach var="LoanInfo" items="${LoanInfo}">
                <tr>
                    <td><c:out value="${LoanInfo.ApplicationNumber}"/></td>
                    <td><c:out value="${LoanInfo.loanName}" /></td>
                    <td><c:out value="${LoanInfo.AmountRequest}" /></td>
                    <td><c:out value="${LoanInfo.ApplicationDate}" /></td>
                     <td><c:out value="${LoanInfo.BusinessStructure}" /></td>
                      <td><c:out value="${LoanInfo.BillingIndicator}" /></td>
                       <td><c:out value="${LoanInfo.TaxIndicator}" /></td>
                        <td><c:out value="${LoanInfo.Address}" /></td>
                        <td><c:out value="${LoanInfo.MobileNumber}" /></td>
                        <td><c:out value="${LoanInfo.EmailID}" /></td>
                        <td><c:out value="${LoanInfo.Status}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
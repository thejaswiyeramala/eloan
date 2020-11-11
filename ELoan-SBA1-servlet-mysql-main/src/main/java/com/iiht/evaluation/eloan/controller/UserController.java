package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectionDao connDao;

	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}

	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		String viewName = "";
		try {
			switch (action) {
			case "registernewuser":
				viewName = registernewuser(request, response);
				break;
			case "validate":
				viewName = validate(request, response);
				break;
			case "placeloan":
				viewName = placeloan(request, response);
				break;
			case "application1":
				viewName = application1(request, response);
				break;
			case "editLoanProcess":
				viewName = editLoanProcess(request, response);
				break;
			case "registeruser":
				viewName = registerUser(request, response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;
			case "displaystatus":
				viewName = displaystatus(request, response);
				break;
			default:
				viewName = "notfound.jsp";
				break;
			}
		} catch (Exception ex) {

			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
	}

	private String validate(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		/* write the code to validate the user */
		String username=request.getParameter("loginid");
		String password=request.getParameter("password");
		User newUser = new User(username, password);
		connDao.selectUser(username, password);
		
		  if(username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin"))
		 { 
			  return "adminhome1.jsp"; 
		 }
		 
		  else {
		return "user?action=registeruser";
		  }
	}

	private String placeloan(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to place the loan information */
		// create instance of Random class 
        Random rand = new Random(); 
        // Generate random integers in range 0 to 999 
        int number = rand.nextInt(1000); 
		String ApplicationNumber="Loan" + number;
		String LoanName=request.getParameter("LoanName");
		String LoanApplicationDate=request.getParameter("LoanApplicationDate");
		String AmountRequest1=request.getParameter("LoanAmountRequest");
		String Businessstruture=request.getParameter("Businessstruture");
		String BillingIndicator=request.getParameter("BillingIndicator");
		String Taxindicator=request.getParameter("Taxindicator");
		String Address=request.getParameter("Address");
		String EmailID=request.getParameter("EmailID");
		String MobileNumber=request.getParameter("MobileNumber");
		String Status="Submitted";
		int AmountRequest=Integer.parseInt(AmountRequest1);
		request.setAttribute("ApplicationNumber", ApplicationNumber);
		request.setAttribute("Status", Status);
		LoanInfo loan = new LoanInfo(ApplicationNumber, LoanName, AmountRequest, LoanApplicationDate,Businessstruture, BillingIndicator, Taxindicator, Address, EmailID, MobileNumber,Status);
		connDao.insertLoan(loan);

		return "loanDetails.jsp";
	}

	private String application1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to display the loan application page */

		return "user?action=placeloan";
	}

	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to edit the loan info */
		String LoanName=request.getParameter("LoanName");
		String LoanApplicationDate=request.getParameter("LoanApplicationDate");
		String LoanAmountRequest1=request.getParameter("LoanAmountRequest");
		String Businessstruture=request.getParameter("Businessstruture");
		String BillingIndicator=request.getParameter("BillingIndicator");
		String Taxindicator=request.getParameter("Taxindicator");
		String Address=request.getParameter("Address");
		String EmailID=request.getParameter("EmailID");
		String MobileNumber=request.getParameter("MobileNumber");
		
		LoanInfo loan = new LoanInfo();
		connDao.updateUser(loan);

		return "editloan.jsp";
	}

	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		return "userhome.jsp";
		}

	private String registernewuser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		/*
		 * write the code to create the new user account read from user and return to
		 * index page
		 */
		String username=request.getParameter("loginid");
		String password=request.getParameter("password");
		User newUser = new User(username, password);
		connDao.insertUser(newUser);
		return "index.jsp";
	}

	private String register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to redirect to register page */

		return null;
	}

	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * write the code the display the loan status based on the given application
		 * number
		 */
		String LoanApplicationNumber=request.getParameter("LoanApplicationNumber");
		request.setAttribute(LoanApplicationNumber, LoanApplicationNumber);
		connDao.selectLoanId(Integer.parseInt(LoanApplicationNumber));

		return "loanDetails.jsp";
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write a code to return to editloan page */
		String ApplicationNumber=request.getParameter("LoanApplicationNumber");
		request.setAttribute("LoanApplicationNumber", ApplicationNumber);
		connDao.selectLoanId(Integer.parseInt(ApplicationNumber));

		return "editloan.jsp";
	}

	private String trackloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write a code to return to trackloan page */

		return null;
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write a code to return to trackloan page */
		return "trackloan.jsp";
	}
}
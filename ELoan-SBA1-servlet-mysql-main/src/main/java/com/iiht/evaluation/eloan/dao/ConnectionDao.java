package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;


public class ConnectionDao {
	private static final long serialVersionUID = 1L;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	public static final String INS_register_QRY = "INSERT INTO ibs_register(username,password) Values(?,?)";

	public ConnectionDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	public Connection connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		return jdbcConnection;
	}

	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	public void insertUser(User user) throws SQLException {
		// try-with-resource statement will auto close the connection.
		try {
			//jdbcConnection.createStatement();
			connect();
			PreparedStatement ps = jdbcConnection
					.prepareStatement("INSERT INTO user(username,password) Values(?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			System.out.println(ps);
			ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
  
	public void selectUser(String username,String password) {
		//User u=null;
		
		// Step 1: Establishing a Connection
		try {
			//jdbcConnection.createStatement();
			connect();

			PreparedStatement ps = jdbcConnection
					.prepareStatement("select * from user where username=? and password=?");

			ps.setString(1,username);
			ps.setString(2,password);
			System.out.println(ps);
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				username = rs.getString("username");
				password = rs.getString("password");
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
}
	public void insertLoan(LoanInfo loan) throws SQLException {
		// try-with-resource statement will auto close the connection.
		try {
			//jdbcConnection.createStatement();
			connect();
			PreparedStatement ps = jdbcConnection
					.prepareStatement("INSERT INTO loan(ApplicationNumber,loanName,AmountRequest,ApplicationDate,BusinessStructure,BillingIndicator,TaxIndicator,Address,MobileNumber,EmailID,Status) Values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,loan.getApplicationNumber());
			ps.setString(2,loan.getLoanName() );
			ps.setLong(3,loan.getAmountRequest());
			ps.setString(4,loan.getApplicationDate());
			ps.setString(5,loan.getBusinessStructure());
			ps.setString(6,loan.getBillingIndicator());
			ps.setString(7,loan.getTaxIndicator());
			ps.setString(8,loan.getAddress());
			ps.setString(9,loan.getMobileNumber());
			ps.setString(10,loan.getEmailID());
			ps.setString(11,loan.getStatus());
			System.out.println(ps);
			ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
}
	public LoanInfo selectLoanId(int LoanApplicationNumber) {
		LoanInfo loaninfor = null;
		try {
			connect();
				PreparedStatement preparedStatement = jdbcConnection.prepareStatement("select ApplicationNumber,AmountRequest,ApplicationDate,Address,MobileNumber,EmailID from users where ApplicationNumber =?");
			preparedStatement.setInt(1, LoanApplicationNumber);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String loanName = rs.getString("loanName");
				String AmountRequest = rs.getString("AmountRequest");
				String ApplicationDate = rs.getString("ApplicationDate");
				String Address = rs.getString("Address");
				String MobileNumber = rs.getString("MobileNumber");
				String EmailID = rs.getString("EmailID");
				String BusinessStructure = rs.getString("BusinessStructure");
				String BillingIndicator = rs.getString("BillingIndicator");
				String TaxIndicator = rs.getString("TaxIndicator");
				String Status = rs.getString("Status");
				loaninfor = new LoanInfo(loanName,AmountRequest, LoanApplicationNumber, ApplicationDate, Address, MobileNumber, EmailID,BusinessStructure,BillingIndicator,TaxIndicator, Status);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return loaninfor;
	}
	
	public boolean updateUser(LoanInfo loan) throws SQLException {
		boolean rowUpdated;
		try {
			connect();
			PreparedStatement preparedStatement = jdbcConnection.prepareStatement("update loan set loanName = ?,AmountRequest= ?, ApplicationDate =?,Address=? where id = ?");
			preparedStatement.setString(1, loan.getLoanName());
			preparedStatement.setInt(2, loan.getAmountRequest());
			preparedStatement.setString(3, loan.getApplicationDate());
			preparedStatement.setString(4, loan.getAddress());
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}finally {}
		return rowUpdated;
	}
	
	public List<LoanInfo> selectAllUsers() {
		List<LoanInfo> LoanInfo = new ArrayList<>();
		// Step 1: Establishing a Connection
		try{
			connect();
			PreparedStatement preparedStatement = jdbcConnection.prepareStatement("select * from loan");
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				System.out.println(rs.getString("ApplicationNumber")
						+ " | " + rs.getString("loanName")
						+ " | " + rs.getInt("AmountRequest")
						+ " | " + rs.getString("ApplicationDate")
						+ " | " + rs.getString("BusinessStructure"));
				String ApplicationNumber = rs.getString("ApplicationNumber");
				String loanName = rs.getString("loanName");
				int AmountRequest = rs.getInt("AmountRequest");
				String ApplicationDate = rs.getString("ApplicationDate");
				String BusinessStructure = rs.getString("BusinessStructure");
				String BillingIndicator = rs.getString("BillingIndicator");
				String TaxIndicator = rs.getString("TaxIndicator");
				String Address = rs.getString("Address");
				String MobileNumber = rs.getString("MobileNumber");
				String EmailID = rs.getString("EmailID");
				String Status = rs.getString("Status");
				LoanInfo.add(new LoanInfo(ApplicationNumber, loanName, AmountRequest, ApplicationDate,BusinessStructure,BillingIndicator,TaxIndicator,Address,MobileNumber,EmailID,Status));
			System.out.println(LoanInfo);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return LoanInfo;
	}


}

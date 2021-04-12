package com.retailbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.retailbank.beans.Account;
import com.retailbank.utilities.DBCon;

public class AccountDao implements AccountDaoInterface<Account> {

	private static Connection con= null;
	private static Statement smt = null;
	private static ResultSet rs = null;	

	@Override
	public ArrayList<Account> getAllAccounts() {
		ArrayList<Account> list= new ArrayList<Account>();		
		String getAllAccountsQuery= "Select * from accounts";
		try {
			con = DBCon.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(getAllAccountsQuery);
			while(rs.next()) {
				Account a= new Account();
				a.setAccountId(rs.getString("accountId"));
				a.setCustomerID(rs.getString("customerId"));
				a.setAccountType(rs.getString("accountType"));
				a.setStatus(rs.getString("status"));
				a.setBalance(rs.getDouble("balance"));
				a.setLastTransaction(rs.getTimestamp("lastTransaction"));
				list.add(a);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCon.closeConnection();
		}		
		return list;
	}	

}

package com.retailbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.retailbank.beans.Customer;
import com.retailbank.utilities.DBCon;

public class CustomerDao implements CustomerDaoInterface<Customer>{
	
	private static Connection con= null;
	private static Statement smt = null;
	private static ResultSet rs = null;	
	
	
	
	@Override
	public void deleteCustomer(String obj) {
		String delQuery = "update customers set status='Inactive' where customerId='"+obj+"'";
		try {
			con=DBCon.getConnection();
			smt= con.createStatement();
			smt.executeUpdate(delQuery);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCon.closeConnection();
		}		
	}
	

}

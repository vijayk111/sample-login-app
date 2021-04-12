package com.retailbank.services;

import java.util.ArrayList;

import com.retailbank.beans.Customer;
import com.retailbank.dao.CustomerDao;

public class CustomerServices implements CustomerInterface<Customer> {
	
	private static CustomerDao dao;
	
	public CustomerServices() {
		dao = new CustomerDao();
	}
	
	

	@Override
	public void deleteCustomer(String obj) {
		dao.deleteCustomer(obj);		
	}

}

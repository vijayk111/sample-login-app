package com.retailbank.controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.retailbank.beans.Account;
import com.retailbank.beans.Customer;
import com.retailbank.services.AccountService;
import com.retailbank.services.CustomerServices;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices service= new CustomerServices();		
		HttpSession session = request.getSession();		
		ArrayList<Customer> list= service.findActiveCustomers();					
		session.setAttribute("list", list);
		request.getRequestDispatcher("jsp/Customer/updateCustomer.jsp").forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt= request.getParameter("action");
		CustomerServices service = new CustomerServices();
		if(opt.equals("del")){
			service.deleteCustomer(request.getParameter("cid"));
			doGet(request, response);
		}
	}

}

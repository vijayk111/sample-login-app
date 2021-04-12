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

public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String w= request.getParameter("v");
		AccountService service = new AccountService();
		HttpSession session = request.getSession();
		if(w.equals("getall")) {
			ArrayList<Account> list= service.getAllAccounts();
			session.setAttribute("list", list);
			request.getRequestDispatcher("jsp/Customer/allAccounts.jsp").forward(request, response);
		}
	}

}

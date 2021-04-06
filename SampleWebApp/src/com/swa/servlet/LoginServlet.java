package com.swa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.swa.bean.User;
import com.swa.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			User user = new User();
		     user.setUsername(request.getParameter("username"));
		     user.setPassword(request.getParameter("password"));
		     String uname = UserDAO.login(user);
		     if (uname != null)
		     {
		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",uname); 
		          response.sendRedirect("home.html"); //logged-in page      		
		     }   
		     else 
		          response.sendRedirect("invalidLogin.html"); //error page 
		}catch (Throwable te){
		     te.printStackTrace();
		}
	}
}

package com.swa.dao;

import java.sql.*;

import com.swa.bean.User;
import com.swa.utilities.DBCon;

public class UserDAO {
	 private static Connection Con = null;
     private static ResultSet rs = null;  
	
	public static String login(User bean) {
        //objects for connection 
        Statement stmt = null;	
        String username = bean.getUsername();    
        String password = bean.getPassword();   
	    
        String searchQuery =
              "select * from bs1981222_info where username='"
                       + username
                       + "' AND password='"
                       + password
                       + "'";	    
     try 
     {
        //connect to DB 
        Con = DBCon.getConnection();
        stmt=Con.createStatement();
        rs = stmt.executeQuery(searchQuery);	        
        boolean more = rs.next();
        if (!more) 
        {
           System.out.println("Sorry, you are not a registered user! Please sign up first");
           return null;
        }
        else if (more) 
        {
           String username1 = rs.getString("username");
           bean.setUsername(username1);
        }
     }catch (Exception ex) 
     {
        System.out.println("Log In failed: An Exception has occurred! ");
        ex.printStackTrace();
     }
     
     finally 
     {
        if (rs != null)	{
           try {
              rs.close();
           } catch (Exception e) {}
              rs = null;
           }
	
        if (stmt != null) {
           try {
              stmt.close();
           } catch (Exception e) {}
              stmt = null;
           }
	
        if (Con != null) {
           try {
              Con.close();
           } catch (Exception e) {
           }

           Con = null;
        }
     }
     return bean.getUsername();
	 }	
}

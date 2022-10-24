package com.store;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

// @WebServlet(name = "UserController", urlPatterns = {"/profile.html", "/myaccount"})
public class servletUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        // String url = "/home.html";
        String url = "/profile.html";
        //if action is update password then update password
        // String action = request.getParameter("action");
        // if (action == null) {
        //     action = "join";  // default action
        // }
        // else if (action.equals("update")) {
        //     url = "/profile.html";    // the "join" page
        // }
        // System.out.println("doPOST");
        request.getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
        String url = "/profile.html";

        HttpSession session=request.getSession(false);
        if (session == null) {
            //create a new session
            session = request.getSession(true);
            System.out.println("New session created");
        }
        //if attribute is not null then return the default page
        if (session.getAttribute("dbconnect") != null) {
            // MongoUtils client = (MongoUtils) session.getAttribute("dbconnect");
            // System.out.println(client.alive());
        }
        else {
            url = "/";
            System.out.println("dbconnect is null");
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}
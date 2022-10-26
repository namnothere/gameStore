package com.store;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
// import com.store.MongoUtils;

// @WebServlet(name = "StoreController", urlPatterns = {"/home"})
// @WebServlet(name = "StoreController", urlPatterns = {"/"})
@WebServlet(name = "StoreController")
public class servletStore extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
        // System.out.println("doGET");
        // String url = "/home.html";
        String url = "/home.jsp";
        HttpSession session=request.getSession(false);
        
        if (session == null) {
            //create a new session
            session = request.getSession(true);
            System.out.println("New session created");
            // MongoUtils client = new MongoUtils();
            session.setAttribute("username","admin");  
            session.setAttribute("password","123");
            session.setAttribute("dbconnect", "connected");
        }
        else {
            System.out.println("GET - Session already exists");
        }

        request.getRequestDispatcher(url).forward(request, response);
        // doPost(request, response);
    }
}

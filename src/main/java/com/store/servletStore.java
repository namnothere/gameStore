package com.store;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
// import com.store.MongoUtils;
import com.user.user;

// @WebServlet(name = "StoreController", urlPatterns = {"/home", "/"})
@WebServlet(name = "StoreController", urlPatterns = {"store"})
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

        // String uri = request.getRequestURI();
        // System.out.println("uri: " + uri);
        // System.out.println("pathInfo: " + pathInfo .toString());

        String url = "/home.jsp";
        HttpSession session=request.getSession(false);
        
        if (session == null) {
            //create a new session
            session = request.getSession(true);
            // System.out.println("New session created");
            // MongoUtils client = new MongoUtils();

        //     // String username = "Guest";
        //     // session.setAttribute("username", username);
        //     // String password = "mypassword";
        //     // session.setAttribute("password", dataUtils.hashPassword(password));

        //     // session.setAttribute("username","admin");  
        //     // session.setAttribute("password","123");

        //     // create a temp user for testing
        //     user user = new user();
        //     user.setUsername("Guest");
        //     user.setPassword("123");
        //     user.setName("Guest");
        //     user.setEmail("guest@localhost");
        //     session.setAttribute("user", user);

        //     session.setAttribute("dbconnect", "connected (not actually connected)");

        //     System.out.println("user: " + user.toString());

        // }
        // else {
        //     System.out.println("GET - Session already exists");
        // }

        request.getRequestDispatcher(url).forward(request, response);
    }
    }
}

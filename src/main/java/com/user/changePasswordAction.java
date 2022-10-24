package com.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.store.MongoUtils;

// @WebServlet(name = "UserController", urlPatterns = {"/profile.html", "/myaccount"})
// @WebServlet(name = "UserController", urlPatterns = {"/profile", "/myaccount"})
@WebServlet(name = "UserController", 
            urlPatterns = {"/profile", "/myaccount", "/hello"})
            // value = "/hello")
public class changePasswordAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

            // StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
            String queryString = request.getQueryString();
            
            System.out.println("doPOST");

            System.out.println(queryString);
            
            String action = request.getParameter("action");
            // if (action=="updateProfile") {
            if (action.equals("updateProfile")) {
                System.out.println("action: " + action);
                String fullName = request.getParameter("fullName");
                String username = request.getParameter("username");
                String bio = request.getParameter("bio");
                String url = request.getParameter("url");
                String location = request.getParameter("location");
                
                // System.out.println("fullName: " + fullName);
                // System.out.println("username: " + username);
                // System.out.println("bio: " + bio);
                // System.out.println("url: " + url);
                // System.out.println("location: " + location);
                
            }
            else {
                System.out.println("action: " + action);
            }


        HttpSession session = request.getSession(false);
        
        // String newPassword = request.getParameter("newPassword");
        // String email = request.getParameter("reNewPassword");
        // OrganizationService organizationService = (OrganizationService)PortalContainer.getInstance().getComponentInstanceOfType(OrganizationService.class);
        // String userId = request.getRemoteUser();


        // MongoUtils client = (MongoUtils) session.getAttribute("dbconnect");

        // System.out.println(client.testConnection());
        


    }
    
    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
        // System.out.println("doGET");
        String url = "/profile.jsp";
        //redirect to myaccount page
        HttpSession session=request.getSession(false);

        // MongoUtils client = (MongoUtils) session.getAttribute("dbconnect");

        // System.out.println(client.testConnection());

        System.out.println("doGET - changePasswordAction");

        getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
        // doPost(request, response);
    }
}

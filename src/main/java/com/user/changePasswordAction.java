package com.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.store.MongoUtils;


// @WebServlet(name = "UserController", urlPatterns = {"/profile", "/myaccount"})
public class changePasswordAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
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
        String url = "/profile.html";

        HttpSession session=request.getSession(false);

        MongoUtils client = (MongoUtils) session.getAttribute("dbconnect");

        System.out.println(client.testConnection());

        request.getRequestDispatcher(url).forward(request, response);
        // doPost(request, response);
    }
}

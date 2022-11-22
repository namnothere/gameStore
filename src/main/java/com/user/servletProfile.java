package com.user;

import java.io.IOException;
import java.io.PrintWriter;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet(name = "ProfileControl", urlPatterns = {"/profile"})




public class servletProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("logined") != "true") {
        //check if user is logged in
        response.sendRedirect(request.getContextPath() + "/account");
        return;
        }
        String url = "/profile.jsp";
        request.setAttribute("user", session.getAttribute("user"));
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        //using if assuming you work with Java SE 6");
        if ("updateProfile".equals(action.toString())) {
            processRequestUpdateProfile(request, response);
        }
        else if ("changeUsername".equals(action.toString()))
        {
            processRequestChangeUsername(request, response);
        }
        else if ("deleteAccount".equals(action.toString()))
        {
            processRequestDeleteAccount(request, response);
        }
        else if ("changePassword".equals(action.toString())
        {
            processRequestChangePassword(request, response);
        }
        

    }

    protected void processRequestUpdateProfile (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            
    }

    protected void processRequestChangeUsername (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }
    
    protected void processRequestDeleteAccount (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }

    protected void processRequestChangePassword (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }

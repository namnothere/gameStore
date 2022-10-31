package com.Account;

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

import com.user.user;

@WebServlet(name = "LoginControl", urlPatterns = {"/account"})




public class AccountControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("/account.jsp").forward(request, response);
        return;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        //using if assuming you work with Java SE 6
        if ("login".equals(action.toString())) {
            processRequestLogin(request, response);
        }
        else if ("register".equals(action.toString()))
        {
            processRequestRegister(request, response);
        }
        else
        {
            PrintWriter out = response.getWriter();
            out.println("Error<br/>");
        }
    }

    protected void processRequestLogin (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        user u = new user();
        u.setUsername(username);
        u.setPassword(password);
        if (u.isValid()){
            response.sendRedirect("/store/");
        }
        else{
            request.setAttribute("messagelogin", "Incorrect username or password");
            request.getRequestDispatcher("/account.jsp").forward(request, response);
        }
    }   
    protected void processRequestRegister (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("user");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String TaC = request.getParameter("checkbox");
        user u = new user();
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);
        if (TaC == null)
        {
            request.setAttribute("messageregisterTaC", "You have to accept terms & conditions");
            request.getRequestDispatcher("/account.jsp").forward(request, response);
            return;
        }
        else if (u.isExist()){
            request.setAttribute("messageregisterEmail", "This email is already used by another account");
            request.getRequestDispatcher("/account.jsp").forward(request, response);
            return;
        }
        
    }
}

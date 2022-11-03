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
        HttpSession session = request.getSession(false);
                if (session != null) {
                    // session.invalidate();
        
                    //check if user is logged in
                    user user = (user) session.getAttribute("user");
                    if (user != null) {
                        // resp.sendRedirect("/home.jsp");
                        response.sendRedirect(request.getContextPath() + "/");
                        System.out.println("User is logged in" + user);
                        return;
                    }
                }
                String url = "/account.jsp";
                // resp.sendRedirect("login.jsp");
                // resp.sendRedirect("account-login.html");
                // req.getRequestDispatcher("login").forward(req, resp);
                getServletContext()
                                .getRequestDispatcher(url)
                                .forward(request, response);
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
        if (u.login()){
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            // if (remember != null) {
            //     Cookie cookie = new Cookie("username", username);
            //     cookie.setMaxAge(60 * 60 * 24 * 7);
            //     resp.addCookie(cookie);
            // }
            response.sendRedirect("home.jsp");
            return;
        }
        else{
            request.setAttribute("messagelogin", "Incorrect username or password");
            request.getRequestDispatcher("/account.jsp").forward(request, response);
            return;
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

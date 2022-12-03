package com.user;

import com.store.*;
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

@WebServlet(name = "LoginControl", urlPatterns = {"/account"})




public class servletAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        header.headerInitiate(request, response);
        if (session.getAttribute("logined") == "true") {
        //check if user is logged in
        response.sendRedirect(request.getContextPath() + "");
        return;
        }
        String url = "/account.jsp";
        // resp.sendRedirect("login.jsp");
        // resp.sendRedirect("account-login.html");
        // req.getRequestDispatcher("login").forward(req, resp);
        getServletContext().getRequestDispatcher(url).forward(request, response);
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

    }

    protected void processRequestLogin (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String remember = request.getParameter("remember-me");
        user u = new user();
        u.setUsername(username);
        u.setPassword(password);
        if (userDB.login(username, password)){
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            if (remember != null) {
                 Cookie cookie = new Cookie("cookuser", username);
                 Cookie cookie2 = new Cookie("cookpass", password);
                 cookie.setPath("/");
                 cookie2.setPath("/");
                 cookie.setMaxAge(60 * 60 * 24 * 7);
                 cookie2.setMaxAge(60 * 60 * 24 * 7);
                 response.addCookie(cookie);
                 response.addCookie(cookie2);
            }
            u = userDB.getUser(username);
            session.setAttribute("user", u);
            session.setAttribute("logined", "true");
            response.sendRedirect(request.getContextPath());
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
        else if (userDB.isExistUser(username)){
            request.setAttribute("messageregisterEmail", "This email is already used by another account");
            request.getRequestDispatcher("/account.jsp").forward(request, response);
            return;
        }
        else
        {
            userDB.insertUser(u);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Register success');");
            out.println("location='account.jsp';");
            out.println("</script>");
            out.close();
        }
        
    }
}

package com.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class servletLogin extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user-name-email");
        String password = req.getParameter("login-password");
        // String remember = req.getParameter("remember");
        String error = "";
        if (username == null || password == null) {
            error = "Username or password is empty";
        } else {
            user user = new user();
            user.setUsername(username);
            user.setPassword(password);
            if (user.login()) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                // if (remember != null) {
                //     Cookie cookie = new Cookie("username", username);
                //     cookie.setMaxAge(60 * 60 * 24 * 7);
                //     resp.addCookie(cookie);
                // }
                resp.sendRedirect("index.jsp");
                return;
            } else {
                error = "Username or password is incorrect";
            }
        }
        System.out.println("error: " + error);
        req.setAttribute("error", error);
        // req.getRequestDispatcher("login.jsp").forward(req, resp);
        req.getRequestDispatcher("/account-login.html").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            // session.invalidate();

            //check if user is logged in
            user user = (user) session.getAttribute("user");
            if (user != null) {
                // resp.sendRedirect("/home.jsp");
                resp.sendRedirect(req.getContextPath() + "/");
                System.out.println("user is logged in");
                return;
            }
        }
        String url = "/account-login.html";
        // resp.sendRedirect("login.jsp");
        // resp.sendRedirect("account-login.html");
        // req.getRequestDispatcher("login").forward(req, resp);
        getServletContext()
                        .getRequestDispatcher(url)
                        .forward(req, resp);
    }
}

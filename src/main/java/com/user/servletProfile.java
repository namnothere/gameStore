package com.user;

import java.io.IOException;
import java.io.PrintWriter;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.wls.shaded.org.apache.xalan.templates.ElemSort;

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
        else if ("changePassword".equals(action.toString()))
        {
            processRequestChangePassword(request, response);
        }
        

    }

    protected void processRequestUpdateProfile (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        user u = userDB.getUser(session.getAttribute("user.name").toString());
        u.setName(request.getParameter("fullName"));
        userDB.updateUserBalance(u);
        PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Update profile success');");
            out.println("location='profile.jsp';");
            out.println("</script>");
            out.close();
    }

    protected void processRequestChangeUsername (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = session.getAttribute("user.username").toString();
        if (username == null)
        {
            request.setAttribute("messageChangeUsername", "Username cant be empty.");
        }
        else if (userDB.isExistUser(username))
        {
            request.setAttribute("messageChangeUsername", "Username exist.");
        }
        else
        {
            user u = userDB.getUser(username);
            u.setUsername(request.getParameter("username"));
            userDB.updateUserBalance(u);
            session.setAttribute("user.username", request.getParameter("username"));
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Change username success');");
            out.println("location='profile.jsp';");
            out.println("</script>");
            out.close();
        }
        
    }
    
    protected void processRequestDeleteAccount (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        userDB.deleteUser(session.getAttribute("user.username").toString());
        PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Delete account success');");
            out.println("location='profile.jsp';");
            out.println("</script>");
            out.close();
    }

    protected void processRequestChangePassword (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        user u = userDB.getUser(session.getAttribute("user.name").toString());
        String oldpass = request.getParameter("oldPassword");
        String newpass = request.getParameter("newPassword");
        String rnewpass = request.getParameter("rnewPassword");
        if (oldpass == newpass)
        {
            request.setAttribute("messageChangePass", "New password cannot be the same as old password");
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        }
        else if(newpass != rnewpass)
        {
            request.setAttribute("messageChangePass", "New passwords are not the same");
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        }
        else
        {
            u.setPassword(rnewpass);
            session.setAttribute("user.password", rnewpass);
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Reset password success');");
            out.println("location='profile.jsp';");
            out.println("</script>");
            out.close();
        }
        //userDB.updatePassword(u, , getServletInfo());
    }
}

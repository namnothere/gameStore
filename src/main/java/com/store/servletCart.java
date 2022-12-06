package com.store;

import com.user.*;
import com.cart.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
// import com.store.MongoUtils;
import com.user.user;
import java.util.ArrayList;
import java.util.List;
import com.game.Game;
import com.game.category;
import com.game.gameDB;
import com.game.genre;

@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class servletCart extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        header.headerInitiate(request, response);
        String url = "/cart.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("deleteFromCart".equals(action))
        {
            processRequestRemoveCart(request, response);
        }
        doGet(request, response);
    }

    public static void processRequestAddCart(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession(false);
        user user = new user();
        user = (user) session.getAttribute("user");

        user.addGameToCart(Integer.parseInt(request.getParameter("gameID")));
        session.setAttribute("user", user);
        if (session.getAttribute("logined") == "true")
        {
            user.getCart().save();
        }
    }
    public static void processRequestRemoveCart(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession(false);
        user user = new user();
        user = (user) session.getAttribute("user");
        user.removeGameFromCart(Integer.parseInt(request.getParameter("gameID").toString()));
        session.setAttribute("user", user);
        if (session.getAttribute("logined") == "true")
        {
            user.getCart().save();
        }
    }
}

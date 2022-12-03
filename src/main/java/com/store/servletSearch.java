package com.store;
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

import java.util.List;
import com.game.Game;
import com.game.gameDB;
import com.user.user;
import com.user.userDB.ResponseData;

@WebServlet(name = "SearchController", urlPatterns = {"/search"})
public class servletSearch extends HttpServlet {
    /* public static void processRequestSearch (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("searched");
        String url = "search?term=" + request.getParameter("search") + "&index=1";
        response.sendRedirect(url);
    }    */
    @Override
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
        String url = "search.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
        header.headerInitiate(request, response);
        List<Game> game = gameDB.getGamesByName(request.getParameter("term"), 100);
        request.setAttribute("gameList", game);
        request.setAttribute("term", request.getParameter("term"));
        request.setAttribute("index", request.getParameter("index"));
        doPost(request, response);
    }
}

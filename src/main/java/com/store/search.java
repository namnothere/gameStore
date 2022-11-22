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

import com.game.Game;
import com.game.gameDB;
import com.user.user;

public class search {
    public static void processRequestSearch (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        gameDB gamesDB =  new gameDB();
        response.setContentType("text/html;charset=UTF-8");
        String search = request.getParameter("search-landscape");
        //Game game = gamesDB.searchGame(search);
        //request.setAttribute("gameList", game);
        response.sendRedirect("search.jsp");
    }   
}

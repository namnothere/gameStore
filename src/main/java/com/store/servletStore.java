package com.store;

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

// @WebServlet(name = "StoreController", urlPatterns = {"/home", "/"})
@WebServlet(name = "StoreController", urlPatterns = {""})
public class servletStore extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        //buttons
        String action = request.getParameter("action");
        if ("addCart".equals(action.toString())) {
            servletCart.processRequestAddCart(request, response);
        }
        else
        {
            PrintWriter out = response.getWriter();
            out.println("Error<br/>");
        }
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
        // String uri = request.getRequestURI();
        // System.out.println("uri: " + uri);
        // System.out.println("pathInfo: " + pathInfo .toString());

        String url = "/home.jsp";
        header.headerInitiate(request, response);
        System.out.println("//");
        HttpSession session = request.getSession(false);  
        System.out.println(session.getAttribute("logined"));
        System.out.println("//");
        //create lists of games
        HashMap<Integer, List<Game>> gamesGen = new HashMap<Integer, List<Game>>();
        List<genre> genres = gameDB.getAllGenres();
        for (genre gen : genres)
        {
            gamesGen.put(gen.ID, gameDB.getGamesByGenre(gen.ID, 12));
        }
        

        //pass sample data to the jsp
        request.setAttribute("gamesGen", gamesGen);
        request.setAttribute("genres", genres);
        request.getRequestDispatcher(url).forward(request, response);
    }
}

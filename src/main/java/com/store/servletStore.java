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
import com.store.search;

// @WebServlet(name = "StoreController", urlPatterns = {"/home", "/"})
@WebServlet(name = "StoreController", urlPatterns = {""})
public class servletStore extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        //search button
        String action = request.getParameter("action");
        if ("search".equals(action.toString())) {
            search.processRequestSearch(request, response);
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
        System.out.println("ran");

        // String uri = request.getRequestURI();
        // System.out.println("uri: " + uri);
        // System.out.println("pathInfo: " + pathInfo .toString());

        String url = "/home.jsp";
        HttpSession session = request.getSession(false);        
        gameDB GameDB = new gameDB();
        
        user usr = new user();
        if (session == null) {
            session = request.getSession(true);
            Cookie[] cookies = request.getCookies();
            boolean foundUser = false;
            boolean foundPass = false; 
            for(int i = 0; i < cookies.length; i++)
            { 
                Cookie c = cookies[i];
                if (c.getName().equals("cookuser"))
                {
                    usr.setUsername(c.getValue());
                    foundUser = true;
                    
                }
                if (c.getName().equals("cookpass"))
                {
                    usr.setPassword(c.getValue());
                    foundPass = true;
                }
                
                if (foundUser && foundPass)
                {
                    if(usr.login())
                    {
                        session.setAttribute("logined", "true");
                        session.setAttribute("user", usr);
                    }
                    else
                    {
                        session.setAttribute("logined", "false");
                    }
                }
            }
        }
        //create lists of games
        HashMap<Integer, List<Game>> gamesGen = new HashMap<Integer, List<Game>>();
        List<genre> genres = GameDB.getAllGenres();
        for (genre gen : genres)
        {
        gamesGen.put(gen.ID, GameDB.getGamesByGenre(gen.ID, 12));
        }
        

        //pass sample data to the jsp
        request.setAttribute("gamesGen", gamesGen);
        request.setAttribute("genres", genres);
        request.getRequestDispatcher(url).forward(request, response);
    }
}

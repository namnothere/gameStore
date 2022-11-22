package com.store;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.game.*;


@WebServlet(name = "GameController", urlPatterns = {"/game/*", "/product"})
public class servletProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/WEB-INF/single-product.jsp";
        request.getRequestDispatcher(url).forward(request, response);
        // get getServletContext()
        // getServletContext().getRequestDispatcher(url).forward(request, response);
        // RequestDispatcher rd = request.getRequestDispatcher(url);
        // rd.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            
            gameDB GameDB = new gameDB();
            //?id=100
            //split the 100 and get the id
            
            String id = request.getParameter("id");
            if (id==null) {
                id = "0";
            }
            Game game = new Game();
            game = GameDB.getGame(Integer.parseInt(id));
            List<Game> similarGames = new ArrayList<Game>();
            for (category cat : game.categories)
            {
                List<Game> temp = GameDB.getGamesByCategory(cat.ID, 10);
                if (!(similarGames.stream().map(Game::getName).filter(temp.get(0).getName()::equals).findFirst().isPresent()))
                {
                    similarGames.add(temp.get(0));
                }
                
            }

            request.setAttribute("game", game);
            request.setAttribute("similarGames", similarGames);
            //System.out.println(game.name);
            doPost(request, response);
            //generate the product using the id
            //send the product to the jsp
            //forward the request to the jsp
            // System.out.println("doGET");

            // doPost(request, response);

            // doPost(request, response);
    }
    public static String getFullURL(HttpServletRequest request) {
        StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
        String queryString = request.getQueryString();
        
        System.out.println("queryString: " + queryString);
        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append('?').append(queryString).toString();
        }
    }
    
}
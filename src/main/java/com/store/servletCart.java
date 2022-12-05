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

public class servletCart extends HttpServlet{
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
        System.out.println("//");
        System.out.println(gameDB.getGame(user.getCart().getCartItems().getCartItems().get(0).getGameID()).getName());
        System.out.println("//");
    }
}

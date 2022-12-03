package com.store;

import java.io.*;
import java.net.http.HttpRequest;
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
import com.store.servletSearch;

public class header {
    public static void headerInitiate(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession(false);        
        
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
    }
}

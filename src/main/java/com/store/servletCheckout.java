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

@WebServlet(name = "CheckoutControl", urlPatterns = {"/checkout"})
public class servletCheckout extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        //buttons
        String action = request.getParameter("action");
        if ("placeOrder".equals(action))
        {
            System.out.println("ran");
            processRequestPlaceOrder(request, response);
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

        String url = "/checkout.jsp";
        header.headerInitiate(request, response); 
        request.getRequestDispatcher(url).forward(request, response);
    }

    public static void processRequestPlaceOrder (HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ran");
        HttpSession session = request.getSession(false);
        user user = (user) session.getAttribute("user");
        String TaC = request.getParameter("accept");
        if (TaC == null)
        {
            request.setAttribute("messageTaC", "You have to accept terms & conditions");
            return;
        }
        else
        {
            if (user.buyGames() == false)
            {
                request.setAttribute("messageInsufficientBalance", "Insufficient Balance");
                return;
            }
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Order complete');");
            out.println("location='account.jsp';");
            out.println("</script>");
            out.close();
        }
    }
}

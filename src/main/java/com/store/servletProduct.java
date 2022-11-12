package com.store;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "GameController", urlPatterns = {"/game/*/", "/product/*/"})
public class servletProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/single-product.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            
            //?id=100
            //split the 100 and get the id
            
            String id = request.getPathInfo();
            request.setAttribute("id", id);
            // if (id==null) {
            //     id = "0";
            // }
            // else {
            //     id = id.substring(1);
            // }
            PrintWriter out = response.getWriter(); 
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('"+ id +"');");  
            out.println("</script>");
            System.out.println("getPathInfo: " + id);
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

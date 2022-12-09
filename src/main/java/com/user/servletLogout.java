package com.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
// import com.store.MongoUtils;

@WebServlet(name = "servletLogout", urlPatterns = {"/logout"})
public class servletLogout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException 
    {  
        if (request.getHeader("referer") != null)
        {  
            HttpSession session=request.getSession();  
            session.invalidate();  
                
            Cookie[] cookies = request.getCookies();
            if (cookies != null){
                for (Cookie cookie : cookies) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            response.sendRedirect(request.getContextPath());
        }

    }  

}

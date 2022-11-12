package com.store;
import javax.servlet.http.*;

public class PageNotFound extends HttpServlet {
    // @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {
        String url = "/404.html";
        System.out.println("PageNotFound");
        request.getRequestDispatcher(url).forward(request, response);
    }

    // @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }
}


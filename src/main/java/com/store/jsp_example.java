// package com.store;

// import javax.servlet.annotation.WebServlet;


// import com.game.gameDB;

// @WebServlet("/jsp_example")
// public class jsp_example extends javax.servlet.http.HttpServlet {
//     @Override
//     protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {


//         int gameID = Integer.valueOf(request.getParameter("id"));

        
//         //if parameter is not a number or null, redirect to index

//         gameDB db = new gameDB();

//         request.setAttribute("db", db);
//         request.setAttribute("gameID", gameID);

//         String url = "/getGame.jsp";

//         request.getRequestDispatcher(url).forward(request, response);
//     }
   
    
//     @Override
//     protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
//         doGet(request, response);
//     }

// }

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
import com.game.genre;

// @WebServlet(name = "StoreController", urlPatterns = {"/home", "/"})
@WebServlet(name = "StoreController", urlPatterns = {""})
public class servletStore extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

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
        HttpSession session=request.getSession(false);
        
        if (session == null) {
            //create a new session
            session = request.getSession(true);
            // System.out.println("New session created");
            // MongoUtils client = new MongoUtils();

        //     // String username = "Guest";
        //     // session.setAttribute("username", username);
        //     // String password = "mypassword";
        //     // session.setAttribute("password", dataUtils.hashPassword(password));

        //     // session.setAttribute("username","admin");  
        //     // session.setAttribute("password","123");

        //     // create a temp user for testing
        //     user user = new user();
        //     user.setUsername("Guest");
        //     user.setPassword("123");
        //     user.setName("Guest");
        //     user.setEmail("guest@localhost");
        //     session.setAttribute("user", user);

        //     session.setAttribute("dbconnect", "connected (not actually connected)");

        //     System.out.println("user: " + user.toString());

        // }
        // else {
        //     System.out.println("GET - Session already exists");
        // }
        }
         //create a list of games
         List<Game> games = new ArrayList<Game>();
         List<String> genres = new ArrayList<String>();

         //create 5 games
         for (int i = 0; i < 5; i++) {
             Game game = new Game();
             final Integer innerI = Integer.valueOf(i);
             game.setName("Game " + innerI);
             game.setPriceInitial((float) 10.00);
             game.setPriceFinal((float) 5.00);
             game.setDesc("This is a sample game");
             game.setImages(new ArrayList<String>() {
                 {
                     add("https://preview.redd.it/kbuawznk8u241.jpg?width=640&crop=smart&auto=webp&s=31cb0765c9a3bc3132a4f75488a87574c0471248");
                     add("https://preview.redd.it/kbuawznk8u241.jpg?width=640&crop=smart&auto=webp&s=31cb0765c9a3bc3132a4f75488a87574c0471248");
                 }
             });
             game.setCategories(new category("category_" + i, "description_" + i));
             game.setGenres(new genre("genre_" + i, "description_" + i));
             game.setReleaseDate("2020-01-01");
             game.setPublishers(new ArrayList<String>() {
                     {
                         add("Publisher " + innerI);
                         add("SecondPublisher " + innerI);
                     }
                 });
             game.setDevelopers(new ArrayList<String>() {
                 {
                     add("Developer " + innerI);
                     add("SecondDeveloper " + innerI);
                 }
             });
             game.setRating(0);
 
             games.add(game);
         }
         
         //create 5 categories
         for (int i = 0; i < 5; i++) {
            genres.add("genre " + i);
         }
 
         //pass sample data to the jsp
        request.setAttribute("games", games);
        request.setAttribute("genres", genres);
        request.getRequestDispatcher(url).forward(request, response);
    }
}

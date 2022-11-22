/* package com.store;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.game.Game;
import com.game.category;
import com.game.genre;

@WebServlet("/jsp_example")
public class jsp_example extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        //create a list of games
        List<Game> games = new ArrayList<Game>();

        //create 5 games
        for (int i = 0; i < 5; i++) {
            Game game = new Game();
            final Integer innerI = Integer.valueOf(i);
            game.setName("Game " + innerI);
            game.setInitialPrice((float) 10.00);
            game.setDesc("This is a sample game");
            game.setImages(new ArrayList<String>() {
                {
                    add("https://www.google.com");
                    add("https://www.google.com");
                }
            });
            game.setCategories(new category(i, "description_" + i));
            game.setGenres(new genre(i, "description_" + i));
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
        

        //pass sample data to the jsp


        request.setAttribute("games", games);
        String url = "/jsp_example.jsp";

        String name = "name";

        request.setAttribute("name", name);

        request.getRequestDispatcher(url).forward(request, response);
    }
   
    
}
 */
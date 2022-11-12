package com.game;

import java.util.ArrayList;
import java.util.List;
// import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.dataUtils.dataUtils;
import com.mongodb.MongoException;

import com.mongodb.client.MongoClient;
// import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;

import org.bson.Document;
import org.bson.conversions.Bson;
// import org.json.JSONArray;

public class gameDB {

    private static MongoClient client = null;
    private static final Logger LOGGER = Logger.getLogger(gameDB.class
    .getClass().getName());

    private static MongoClient connect() {
        if (gameDB.client == null) {
            LOGGER.log(Level.SEVERE, "mongoClient is null");
            gameDB.client = dataUtils.getMongoClientInstance();
            LOGGER.log(Level.INFO, "Successfully connected to the database");
        }
        return gameDB.client;
    }


    public gameDB() {
        gameDB.client = dataUtils.getMongoClientInstance();
    }

    public gameDB(MongoClient client) {
        gameDB.client = client;
    }

    public static Game getGame(String name) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("products");

        //declare filter to find the game
        Bson filter = Filters.eq("name", name);

        //find the user, return the first one
        Document doc = collection.find(filter).first();
        if (doc == null) {
            return null;
        }

        //create a new game object
        Game game = new Game(doc.toJson(), doc.getString("steam_appid"));
        return game;
    }


    public static boolean insertGame(Game game) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("products");


        //append document to the document
        Document genreDoc = new Document();
        List<genre> genres = game.getGenres();
        for (genre g : genres) {
            genreDoc.append(g.ID, g.description);
        }

        // Document publisherDoc = new Document();
        // List<String> publishers = game.getPublishers();
        // for (String p : publishers) {
        //     publisherDoc.append(p.ID, p.description);
        // }


        //create a document
        Document newGame = new Document("name", game.getName())
        .append("price", game.getPrice())
        .append("description", game.getDesc())
        .append("image", game.getImages())
        .append("genre", genreDoc)
        .append("releaseDate", game.getReleaseDate())
        .append("publisher", game.getPublishers())
        .append("developer", game.getDevelopers())
        .append("rating", 0);

        //insert the document
        try {
            InsertOneResult result = collection.insertOne(newGame);
            LOGGER.log(Level.INFO, "Successfully inserted a new game id: " + result.getInsertedId());
            return true;
        } catch (MongoException e) {
            LOGGER.log(Level.SEVERE, "Error inserting game", e);
            return false;
        }
    } 

    public static boolean seedSampleGames() {
        //insert sample games for testing
        try {
            for (int i = 0; i < 10; i++) {
                Game game = new Game();

                final Integer innerI = Integer.valueOf(i);

                game.setName("Game " + i);
                game.setPrice((float) 10.00);
                game.setDesc("This is a sample game");
                game.setImages(new ArrayList<String>() {
                    {
                        add("https://www.google.com");
                        add("https://www.google.com");
                    }
                });
                game.setCategories(new category("category_" + innerI, "description_" + innerI));
                game.setGenres(new genre("genre_" + innerI, "description_" + innerI));
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

                insertGame(game);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error seeding sample games", e);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        seedSampleGames();

    }

    
}

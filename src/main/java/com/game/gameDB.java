package com.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import com.mongodb.client.model.Sorts;
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

    public static Game getGame(Integer ID) {
        //connect to the database
        gameDB.client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("products");

        //declare filter to find the game
        Bson filter = Filters.eq("id", ID);

        //find the user, return the first one
        Document doc = collection.find(filter).first();
        if (doc == null) {
            return null;
        }

        //create a new game object
        Game game = new Game(doc.toJson(), doc.getInteger("id"));
        return game;
    }


    public static boolean insertGame(Game game) {
        //connect to the database
        gameDB.client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("products");


        //append document to the document
        Document genreDoc = new Document();
        List<genre> genres = game.getGenres();
        List<Document> genreDocs = new ArrayList<Document>();

        //create new document for each genre
        for (genre g : genres) {
            genreDoc = new Document();
            genreDoc.append("id", g.ID);
            genreDoc.append("name", g.description);
            genreDocs.add(genreDoc);
        }

        // add list of genres to the document


        //create a document
        Document newGame = new Document("name", game.getName())
        .append("price", game.getInitialPrice())
        .append("description", game.getDesc())
        .append("image", game.getImages())
        .append("genre", genreDocs)
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

    public static List<Game> getAllGames() {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("products");

        //find all the documents
        List<Document> docs = collection.find().into(new ArrayList<Document>());

        //create a list of games
        List<Game> games = new ArrayList<Game>();

        //iterate through the documents
        for (Document doc : docs) {
            //create a new game object
            Game game = new Game(doc.toJson(), doc.getInteger("id"));
            games.add(game);
        }

        return games;
    }

    public static List<category> getAllCategories() {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("categories");

        //find all the documents
        List<Document> docs = collection.find().into(new ArrayList<Document>());

        //create a list of games
        List<category> categories = new ArrayList<category>();

        //iterate through the documents
        for (Document doc : docs) {
            //create a new game object
            category category = new category(doc.getInteger("id"), doc.getString("description"));
            categories.add(category);
        }

        return categories;
    }

    public static List<genre> getAllGenres() {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("genres");

        //find all the documents
        List<Document> docs = collection.find().into(new ArrayList<Document>());

        //create a list of games
        List<genre> genres = new ArrayList<genre>();

        //iterate through the documents
        for (Document doc : docs) {
            //create a new game object
            genre genre = new genre(doc.getInteger("id"), doc.getString("description"));
            genres.add(genre);
        }

        return genres;
    }

    public static List<Game> getFreeGames() {
        return getFreeGames(0);
    }
    public static List<Game> getFreeGames(Integer limit) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("products");

        //declare filter to find the game
        Bson filter = Filters.eq("is_free", true);


        //find games, return limit number of games
        //default limit being 0 means no limit
        List<Document> docs = new ArrayList<>();
        if (limit == 0) {
            docs = collection.find(filter).into(new ArrayList<Document>());
        } else {
            docs = collection.find(filter).limit(limit).into(new ArrayList<Document>());
        }

        if (docs == null) {
            return null;
        }

        //create a list of games
        List<Game> games = new ArrayList<Game>();

        //iterate through the documents
        for (Document doc : docs) {
            //create a new game object
            Game game = new Game(doc.toJson(), doc.getInteger("id"));
            games.add(game);
        }

        return games;
    }



    public static List<Game> getGamesByCategory(Integer categoryID, Integer limit) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("products");

        //declare filter to find the game
        //categories are stored as an array of object
        //so we need to use the $elemMatch operator
        Bson filter = Filters.elemMatch("categories", Filters.eq("id", categoryID));

        List<Document> docs = new ArrayList<Document>();

        //find games, return limit number of games
        //default limit being 0 means no limit
        if (limit == 0) {
            docs = collection.find(filter).into(new ArrayList<Document>());
        } else {
            docs = collection.find(filter).limit(limit).into(new ArrayList<Document>());
        }

        if (docs == null || docs.size() == 0) {
            //no games found / category not found
            LOGGER.log(Level.INFO, "No games found for category id: " + categoryID);
            return null;
        }

        //create a list of games
        List<Game> games = new ArrayList<Game>();

        //iterate through the documents
        for (Document doc : docs) {
            //create a new game object
            Game game = new Game(doc.toJson(), doc.getInteger("id"));
            games.add(game);
        }
        return games;
    }
    public static List<Game> getGamesByCategory(Integer categoryID) {
        return getGamesByCategory(categoryID, 0);
    }

    public static List<Game> getGamesByGenre(Integer genreID, Integer limit) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("products");

        //declare filter to find the game
        Bson filter = Filters.elemMatch("genres", Filters.eq("id", genreID));

        List<Document> docs = new ArrayList<Document>();

        //find games, return limit number of games
        //default limit being 0 means no limit
        if (limit == 0) {
            docs = collection.find(filter).into(new ArrayList<Document>());
        } else {
            docs = collection.find(filter).limit(limit).into(new ArrayList<Document>());
        }

        if (docs == null || docs.size() == 0) {
            //no games found / category not found
            LOGGER.log(Level.INFO, "No games found for genre id: " + genreID);
            return null;
        }

        //create a list of games
        List<Game> games = new ArrayList<Game>();

        //iterate through the documents
        for (Document doc : docs) {
            //create a new game object
            Game game = new Game(doc.toJson(), doc.getInteger("id"));
            games.add(game);
        }
        return games;
    }


    public static List<Game> getGamesByGenre(Integer genreID) {
        return getGamesByGenre(genreID, 0);
    }

    public static List<Game> sortAlphabet(List<Game> games) {

        //sort and return if games is not null
        if (games != null) {
            Collections.sort(games, new Comparator<Game>() {
                @Override
                public int compare(Game o1, Game o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            return games;
        }

        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("products");

        //find all the documents
        List<Document> docs = collection.find().sort(Sorts.ascending("name")).into(new ArrayList<Document>());

        //create a list of games
        games = new ArrayList<Game>();

        //iterate through the documents
        for (Document doc : docs) {
            //create a new game object
            Game game = new Game(doc.toJson(), doc.getInteger("id"));
            games.add(game);
        }

        return games;
    }

    public static List<Game> sortAlphabet() {
        //pull data from database and sort alphabetically
        return sortAlphabet(null);
    }

    public static List<Game> getGamesByPrice(Integer min, Integer max, Integer limit, Boolean discount) {
        //return games with price between min and max | using initial price as default
        
        //connect to the database
        MongoClient client = connect();
        
        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("products");

        
        //declare filter to find the games
        //price is nested in the price_overview object
        //3999 -> 39.99

        Bson filter = Filters.and(Filters.gte("price_overview.initial", min), Filters.lte("price_overview.initial", max));
        if (discount == true) {
            filter = Filters.and(Filters.gte("price_overview.final", min), Filters.lte("price_overview.final", max));
        }
        List<Document> docs = new ArrayList<Document>();

        //find games, return limit number of games
        //default limit being 0 means no limit
        if (limit == 0) {
            docs = collection.find(filter).into(new ArrayList<Document>());
        } else {
            docs = collection.find(filter).limit(limit).into(new ArrayList<Document>());
        }

        if (docs == null || docs.size() == 0) {
            //no games found / category not found
            LOGGER.log(Level.INFO, "No games found for price range: " + min + " - " + max);
            return null;
        }

        //create a list of games
        List<Game> games = new ArrayList<Game>();

        //iterate through the documents
        for (Document doc : docs) {
            //create a new game object
            Game game = new Game(doc.toJson(), doc.getInteger("id"));
            games.add(game);
        }
        return games;
    }

    public static void showGame(Game game) {
        System.out.println("Game ID: " + game.getID());
        System.out.println("Game Name: " + game.getName());
        System.out.println("Game Price: " + game.getInitialPrice());
        System.out.println("Game Description: " + game.getDesc());
        System.out.println("Game Images: " + game.getImages());
        System.out.println("Game Categories: " + game.getCategories());
        System.out.println("Game Genres: " + game.getGenres());
        System.out.println("Game Release Date: " + game.getReleaseDate());
        System.out.println("Game Publishers: " + game.getPublishers());
        System.out.println("Game Developers: " + game.getDevelopers());
        System.out.println("Game Rating: " + game.getRating());
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // seedSampleGames();

        try {
            
            //get all games
            // List<Game> games = getAllGames();
            
            //get all categories
            // List<category> categories = getAllCategories();
            
            //get all genres
            // List<genre> genres = getAllGenres();

            //get free games
            // List<Game> games = getFreeGames();

            //get games by category
            // List<Game> games = getGamesByCategory(9, 10);

            //get games by genre
            // List<Game> games = getGamesByGenre(3, 10);

            //sort alphabetically
            // List<Game> games = sortAlphabet();

            //get games by genre and sort alphabetically
            // List<Game> games = sortAlphabet(getGamesByGenre(3, 10));

            //get games by prices range
            //current database using USD as currency
            //3999 -> 39.99
            List<Game> games = getGamesByPrice(50 * 100, 100 * 100, 0, false);

            //show games found
            if (games != null) {
                for (Game game : games) {
                    // showGame(game);
                    System.out.println(game.getName() + ": " + game.getInitialPrice());
                }
            }
            
            dataUtils.disconnect();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error getting game", e);
            dataUtils.disconnect();
        }


    }

    
}

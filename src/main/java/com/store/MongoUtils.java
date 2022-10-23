package com.store;

import com.game.Game;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

public class MongoUtils {
    // private static final String HOST = "localhost";
    // private static final int PORT = 27017;
  
    // private static final String USERNAME = "aegis";
    // private static final String PASSWORD = "aegis";
  
    private static MongoClient client = null;

    public MongoUtils() {
        MongoUtils.client = getMongoClient_2();
    }

    private static MongoClient getMongoClient_2() {
        String uri = "mongodb+srv://aegis:aegis@baekettle.lkh9f.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uri);
        return mongoClient;
    }

    public static List<Game> getAllGames() {
        //read game data from MongoDB
        // MongoClient mongoClient = getMongoClient_2();
        MongoClient mongoClient = MongoUtils.client;
        MongoDatabase database = mongoClient.getDatabase("gameStore");
        MongoCollection<Document> collection = database.getCollection("products");

        long c = collection.countDocuments();

        if (c == 0) {
            //insert new document
            System.out.println("No document found");
            Document doc = new Document("name", "productsDetail")
                    .append("type", "database")
                    .append("count", 0)
                    .append("applist", new Document("apps", new Document()));
            collection.insertOne(doc);
            System.out.println("Document inserted");
        }
        Document doc = collection.find().first();
        List<Game> games = new ArrayList<>();
        JSONObject obj = new JSONObject(doc.toJson()).getJSONObject("applist").getJSONObject("apps");
        Iterator<String> keys = obj.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            JSONObject game = obj.getJSONObject(key);
            games.add(new Game(game.toString(), key));
        }
        
        for (Game game : games) {
            System.out.println(game.name);
        }

        return games;
    }

    public static boolean loadGameDetails(String fileName) {
        // read fileName and parse to JSON
        Path path
            = Path.of(fileName);
        try {
            String str;
            str = Files.readString(path);
            JSONObject obj = new JSONObject(str).getJSONObject("applist").getJSONObject("apps");
            List<Game> games = new ArrayList<>();
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                JSONObject gameObj = obj.getJSONObject(key);
                games.add(new Game(gameObj.toString(), key));
            }

            MongoClient mongoClient = getMongoClient_2();
            MongoDatabase database = mongoClient.getDatabase("gameStore");
            MongoCollection<Document> collection = database.getCollection("products");
            Document doc = collection.find().first();
            JSONObject apps = new JSONObject(doc.get("applist", Document.class).get("apps", Document.class).toJson());
            for (Game game : games) {
                JSONObject gameObj = game.toJson();
                apps.put(Integer.toString(game.getID()), gameObj.get(Integer.toString(game.getID())));
            }
            // collection.updateOne(doc, new Document("$set", doc));
            Bson filter = Filters.eq("name", "productsDetail");

            //JSON to BSON
            Document newDoc = Document.parse(apps.toString());            
            collection.updateOne(filter, Updates.set("applist.apps", newDoc));
            // collection.updateOne(filter, Updates.set("count", newDoc.count));
            
            System.out.println("Document updated");
            return true;

            // System.out.println(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        // return false;
    }

    public static MongoClient getMongoClient() throws UnknownHostException {
        return getMongoClient_2();
    }
  
    // Test
    
    public static boolean isValidUser(String username, String password) {
        MongoClient mongoClient = MongoUtils.client;
        MongoDatabase database = mongoClient.getDatabase("gameStore");
        MongoCollection<Document> collection = database.getCollection("users");
        Document doc = collection.find(Filters.eq("username", username)).first();
        if (doc == null) {
            return false;
        }
        String pwd = doc.getString("password");
        if (pwd.equals(password)) {
            return true;
        }
        return false;
    }

    public static boolean testConnection() {
        return true;
    }
    
    public static String alive() {
        if (MongoUtils.client == null) {
            return "false";
        }
        return "alive";
    }
    public static void main(String[] args) throws UnknownHostException {
        getAllGames();
        // loadGameDetails("gamesDetail.json");
    }
}

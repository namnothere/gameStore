package com.user;

// import java.net.UnknownHostException;
// import java.util.ArrayList;
// import java.util.Iterator;
// import java.util.List;
// import java.io.*;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.util.logging.*;
// import org.apache.log4j.Logger;

import java.util.logging.Level;
import java.util.logging.Logger;
// import org.apache.logging.log4j.Logger;
// import org.apache.logging.log4j.LogManager;

import com.dataUtils.dataUtils;

// import javax.servlet.http.HttpSession;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.bson.Document;
import org.bson.conversions.Bson;
// import org.json.JSONObject;

public class userDB {
    private static MongoClient client = null;
    private static final Logger LOGGER = Logger.getLogger(userDB.class
    .getClass().getName());


    public static class ResponseData {
        public final boolean success;
        public final user user;
    
        public ResponseData(boolean success, user user) {
            this.success = success;
            this.user = user;
        }

        public boolean getSuccess() {
            return success;
        }

        public user getUser() {
            return user;
        }

    }
    

    private static MongoClient getMongoClient() {
        String uri = "mongodb+srv://aegis:aegis@baekettle.lkh9f.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uri);
        userDB.client = mongoClient;
        return mongoClient;
    }

    public userDB() {
        userDB.client = getMongoClient();
    }

    public userDB(MongoClient client) {
        userDB.client = client;
    }

    public static void insertUser(user user) {
        MongoClient client = userDB.client;
        if (client == null) {
            LOGGER.log(Level.SEVERE, "mongoClient is null");
            client = getMongoClient();
            LOGGER.log(Level.INFO, "Successfully connected to the database");
        }
        MongoDatabase database = client.getDatabase("gameStore");
        MongoCollection<Document> collection = database.getCollection("users");

        Document doc = new Document("name", user.getName())
                .append("username", user.getUsername())
                .append("email", user.getEmail())
                .append("password", user.getPassword())
                .append("avatar", user.getAvatar());

        // collection.insertOne(doc);
        //insert new object to the database
        collection.findOneAndUpdate(doc, doc);
    }

    public static boolean deleteUser(String username) {
        MongoClient client = userDB.client;
        if (client == null) {
            LOGGER.log(Level.SEVERE, "mongoClient is null");
            client = getMongoClient();
            LOGGER.log(Level.INFO, "Successfully connected to the database");
        }
        MongoDatabase database = client.getDatabase("gameStore");
        MongoCollection<Document> collection = database.getCollection("users");

        Bson filter = Filters.eq("username", username);
        collection.deleteOne(filter);
        return true;
    }

    public static user getUser(String username) {
        MongoClient client = userDB.client;
        if (client == null) {
            LOGGER.log(Level.SEVERE, "mongoClient is null");
            client = getMongoClient();
            LOGGER.log(Level.INFO, "Successfully connected to the database");
        }
        MongoDatabase database = client.getDatabase("gameStore");
        MongoCollection<Document> collection = database.getCollection("users");

        Bson filter = Filters.eq("username", username);
        Document doc = collection.find(filter).first();
        if (doc == null) {
            return null;
        }
        user user = new user(doc.getString("name"), doc.getString("username"), doc.getString("email"), doc.getString("password"), doc.getString("avatar"));
        return user;
    }

    public static user login(String username, String password) {
        user user = getUser(username);
        if (user == null) {
            return null;
        }
        // if (user.hashPassword().equals(dataUtils.hashPassword(password))) {
        if (user.getPassword().equals(dataUtils.hashPassword(password))) {
            return user;
        }
        return null;
    }

    private static String getPassword(String username) {
        user user = getUser(username);
        if (user == null) {
            return null;
        }
        return user.getPassword();
        // return doc.getString("password");
    }

    private static String getPassword(user user) {
        return user.getPassword();
    }

    public static boolean updatePassword(String username, String oldPassword, String newPassword) {
        String oldPaString = getPassword(username);
        if (oldPaString == null) {
            return false;
        }
        
        return false;
    }

    public static ResponseData updatePassword(user user, String oldPassword, String newPassword) {
        String oldPaString = user.getPassword();
        if (oldPassword == null) {
            LOGGER.log(Level.SEVERE, "Missing old password");
            ResponseData data = new ResponseData(false, user);
            // return false;
            return data;
        }
        if (!oldPaString.equals(oldPassword)) {
            LOGGER.log(Level.SEVERE, "Old password is incorrect");
            ResponseData data = new ResponseData(false, user);
            // return false;
            return data;
        }
        MongoClient client = userDB.client;
        if (client == null) {
            LOGGER.log(Level.SEVERE, "mongoClient is null");
            client = getMongoClient();
            LOGGER.log(Level.INFO, "Successfully connected to the database");
        }
        try {
            MongoDatabase database = client.getDatabase("gameStore");
            MongoCollection<Document> collection = database.getCollection("users");
            
            Bson filter = Filters.eq("username", user.getUsername());
            Bson update = Updates.set("password", newPassword);
            Document doc = collection.findOneAndUpdate(filter, update);
            // collection.updateOne(filter, update);
            LOGGER.log(Level.INFO, "Successfully updated password");
            // user = getUser(user.username());
            user = new user(doc.getString("name"), doc.getString("username"), doc.getString("email"), doc.getString("password"), doc.getString("avatar"));
            ResponseData data = new ResponseData(true, user);
            // return true;
            // ResponseData data = new ResponseData(true, user);
            return data;
        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, oldPaString);
            // return false;
            ResponseData data = new ResponseData(false, user);
            return data;
        }
    }

    public static boolean isValidUser(String username, String password) {
        MongoClient client = userDB.client;
        if (client == null) {
            client = getMongoClient();
        }
        MongoDatabase database = client.getDatabase("gameStore");
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
    
    public static boolean isExistUser(String username) {
        MongoClient client = userDB.client;
        if (client == null) {

            LOGGER.log(Level.SEVERE, "mongoClient is null");
            client = getMongoClient();

            LOGGER.log(Level.INFO, "Successfully connected to the database");
        }
        MongoDatabase database = client.getDatabase("gameStore");
        MongoCollection<Document> collection = database.getCollection("users");

        Document doc = collection.find(Filters.exists(username)).first();
        
        //check if username exist in doc
        
        
        if (doc == null) {

            LOGGER.log(Level.INFO, "doc is null aka this username is not exist (" + username + ")");
            return false;
        }
        
        LOGGER.log(Level.INFO, username + " this username is already exist");
        return true;
    }
    
    // public static 

    public static void disconnect() {
        try {

            userDB.client.close();
            LOGGER.log(Level.INFO, "Disconnected from MongoDB");
        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, "[disconnect] " + e);
        }
    }

    // public static void 

    public static void main(String[] args) throws Exception {

        // userDB.disconnect();

        // userDB db = new userDB();
        user myUser = new user("myName", "newUser", "email", "password", "avatar");
        userDB.insertUser(myUser);
        LOGGER.log(Level.INFO, "Successfully inserted user");

        //return user
        user user2 = userDB.getUser("newUser");
        LOGGER.log(Level.INFO, "Successfully get user");
        user.showUser(user2);
        
        //update password
        user2 = userDB.updatePassword(user2, "password", "newPassword").user;
        
        //show that user again
        user.showUser(user2);


    }

}

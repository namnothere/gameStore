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

    private static void connect() {
        if (userDB.client == null) {
            LOGGER.log(Level.SEVERE, "mongoClient is null");
            getMongoClient();
            LOGGER.log(Level.INFO, "Successfully connected to the database");
        }
    }

    public static void insertUser(user user) {
        userDB.connect();
        MongoClient client = userDB.client;
        MongoDatabase database = client.getDatabase("gameStore");
        MongoCollection<Document> collection = database.getCollection("users");
        //get the first doc that contains all users
        Bson filter = Filters.eq("name", "usersDetails");
        Document doc = collection.find(filter).first();

        //check if username already exists
        if (doc != null) {
            //check if username already exists
            if (doc.containsKey(user.getUsername())) {
                LOGGER.log(Level.SEVERE, "Username already exists");
                return;
            }
        } else {
            //insert new document
            LOGGER.log(Level.INFO, "No document found");
            // doc = new Document("name", "usersDetails");
            return;
        }

        //create new user document object
        Document newUser = new Document("name", user.getName())
        .append("username", user.getUsername())
        .append("email", user.getEmail())
        .append("password", user.getPassword())
        .append("avatar", user.getAvatar());
        
        //append new user object to the document
        doc.append(user.getUsername(), newUser);

        //update the document
        Bson updateOperationDocument = new Document("$set", doc);
        collection.updateOne(filter, updateOperationDocument);

        // collection.findOneAndUpdate(doc, doc);
    }

    public static boolean deleteUser(String username) {
        userDB.connect();
        MongoClient client = userDB.client;
        MongoDatabase database = client.getDatabase("gameStore");
        MongoCollection<Document> collection = database.getCollection("users");

        Bson filter = Filters.eq("username", username);
        collection.deleteOne(filter);
        return true;
    }

    public static user getUser(String username) {
        userDB.connect();
        MongoClient client = userDB.client;
        MongoDatabase database = client.getDatabase("gameStore");
        MongoCollection<Document> collection = database.getCollection("users");

        // Bson filter = Filters.eq("username", username);
        Bson filter = Filters.eq("name", "usersDetails");
        Document doc = collection.find(filter).first();
        if (doc == null) {
            return null;
        }
        Document userDoc = (Document) doc.get(username);
        user user = new user(userDoc.getString("name"), userDoc.getString("username"), userDoc.getString("email"), userDoc.getString("password"), userDoc.getString("avatar"));
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
        if (oldPassword == null || newPassword == null || oldPassword.equals("") || newPassword.equals("")) {
            LOGGER.log(Level.SEVERE, "Missing password");
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
        userDB.connect();
        MongoClient client = userDB.client;
        try {
            MongoDatabase database = client.getDatabase("gameStore");
            MongoCollection<Document> collection = database.getCollection("users");
            
            Bson filter = Filters.eq("name", "usersDetails");

            Document doc = collection.find(filter).first();
            Document userDoc = (Document) doc.get(user.getUsername());
            userDoc.replace("password", newPassword);
            
            //update the document
            Bson updateOperationDocument = new Document("$set", doc);
            // collection.findOneAndUpdate(filter, updateOperationDocument, new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER));
            collection.updateOne(filter, updateOperationDocument);

            LOGGER.log(Level.INFO, "Successfully updated password");
            // user = getUser(user.username());
            user = new user(userDoc.getString("name"), userDoc.getString("username"), userDoc.getString("email"), userDoc.getString("password"), userDoc.getString("avatar"));
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
        userDB.connect();
        MongoClient client = userDB.client;
        try {
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
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, "[isValidUser] Error: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean isExistUser(String username) {
        userDB.connect();
        MongoClient client = userDB.client;
        try {
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
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, "[isExistUser] Error: " + e.getMessage());
            return false;
        }
    }
    
    public static void disconnect() {
        try {
            userDB.client.close();
            LOGGER.log(Level.INFO, "Disconnected from MongoDB");
        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, "[disconnect] " + e);
        }
    }

    public static void main(String[] args) throws Exception {

        // userDB.disconnect();
        // user myUser = new user("myName", "newUser", "email", "password", "avatar");
        // userDB.insertUser(myUser);
        // LOGGER.log(Level.INFO, "Successfully inserted user");

        //return user
        user user2 = userDB.getUser("newUser");
        if (user2 == null) {
            LOGGER.log(Level.SEVERE, "username is not exist");
        }
        else {
            LOGGER.log(Level.INFO, "Successfully get user");
            user.showUser(user2);
        }
        
        //update password
        // user user2 = userDB.updatePassword(myUser, "password", "mynewPassword").user;
        
        //show that user again
        // user.showUser(user2);

        //remember to disconnect lol
        //got blocked when multiple concurrent connections are alive
        userDB.disconnect();

    }

}

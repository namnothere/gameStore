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
import com.mongodb.MongoException;
// import javax.servlet.http.HttpSession;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;

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

    public userDB() {
        userDB.client = dataUtils.getMongoClientInstance();
    }

    public userDB(MongoClient client) {
        userDB.client = client;
    }

    private static MongoClient connect() {
        if (userDB.client == null) {
            LOGGER.log(Level.SEVERE, "mongoClient is null");
            userDB.client = dataUtils.getMongoClientInstance();
            LOGGER.log(Level.INFO, "Successfully connected to the database");
        }
        return userDB.client;
    }

    public static user getUser(String username) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("users");

        //declare filter to find the user
        Bson filter = Filters.eq("username", username);

        //find the user, return the first one
        Document doc = collection.find(filter).first();
        if (doc == null) {
            return null;
        }

        //create a user object from the document
        user user = new user(
            doc.getString("name"),
            doc.getString("username"),
            doc.getString("email"),
            doc.getString("password"),
            doc.getString("avatar"),
            doc.getString("role"),
            doc.getDouble("balance")
        );
        return user;
    }
    
    public static user getUserByTransactionCode(String transactionCode) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("transactions");

        //declare filter to find the user
        Bson filter = Filters.eq("transactionCode", transactionCode);

        //find the user, return the first one
        Document doc = collection.find(filter).first();
        if (doc == null) {
            return null;
        }

        //get username from the document
        String username = doc.getString("username");

        //get user from the database
        user user = getUser(username);

        return user;
    }

    public static boolean insertUser(user user) {
        //connect to the database
        MongoClient client = connect();

        MongoDatabase database = client.getDatabase("gameStore");
        MongoCollection<Document> collection = database.getCollection("users");
        try {

            //check if username exists
            if (getUser(user.getUsername()) != null) {
                LOGGER.log(Level.INFO, "Username already exists");
                return false;
            }
            //hash the password
            String hashedPassword = dataUtils.hashPassword(user.getPassword());

            //create new user document object
            Document newUser = new Document("name", user.getName())
            .append("username", user.getUsername())
            .append("email", user.getEmail())
            .append("password", hashedPassword)
            .append("avatar", user.getAvatar())
            .append("balance", user.getBalance());

            //insert new user document
            InsertOneResult result = collection.insertOne(newUser);
            // System.out.println("Success! Inserted document id: " + result.getInsertedId());
            LOGGER.log(Level.INFO, "Success! Inserted document id: " + result.getInsertedId());

            return true;
        } catch (MongoException me) {
            System.err.println("Unable to insert due to an error: " + me);
            return false;
        }
    }

    public static boolean deleteUser(String username) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("users");

        //declare filter to find the user
        Bson filter = Filters.eq("username", username);

        //delete the user
        collection.deleteOne(filter);
        return true;
    }
    public static boolean deleteUser(user user) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("users");

        //declare filter to find the user
        Bson filter = Filters.eq("username", user.getUsername());

        //delete the user
        collection.deleteOne(filter);
        return true;
    }

    public static ResponseData updatePassword(user user, String oldPassword, String newPassword) {
        //get current password
        String oldPaString = user.getPassword();
        
        //return false if any of the passwords are null or empty
        if (oldPassword == null || newPassword == null || oldPassword.equals("") || newPassword.equals("")) {
            LOGGER.log(Level.SEVERE, "Missing password");
            ResponseData data = new ResponseData(false, user);
            return data;
        }

        //hash and compare the input password with the current password
        if (!oldPaString.equals(dataUtils.hashPassword(oldPassword))) {
            LOGGER.log(Level.SEVERE, "Old password is incorrect");
            ResponseData data = new ResponseData(false, user);
            return data;
        }

        MongoClient client = connect();
        try {
            //get the database
            MongoDatabase database = client.getDatabase("gameStore");

            //get the collection
            MongoCollection<Document> collection = database.getCollection("users");
            
            //declare filter to find the user
            Bson filter = Filters.eq("username", user.getUsername());
            
            //get the user document
            Document doc = collection.find(filter).first();
            
            //hash the new password
            newPassword = dataUtils.hashPassword(newPassword);

            //update the password
            doc.replace("password", newPassword);
            
            //update the document
            Bson updateOperationDocument = new Document("$set", doc);
            collection.updateOne(filter, updateOperationDocument);

            LOGGER.log(Level.INFO, "Successfully updated password");

            //create a new user object
            user = new user(
                doc.getString("name"),
                doc.getString("username"),
                doc.getString("password"),
                doc.getString("email"),
                doc.getString("avatar"),
                doc.getString("role"),
                doc.getDouble("balance")
            );
            ResponseData data = new ResponseData(true, user);
            return data;
        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString());
            ResponseData data = new ResponseData(false, user);
            return data;
        }
    }
    
    public static void updateUserBalance(user user) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("users");

        //declare filter to find the user
        Bson filter = Filters.eq("username", user.getUsername());

        //get the user document
        Document doc = collection.find(filter).first();

        //update the document
        doc.replace("name", user.getName());
        doc.replace("email", user.getEmail());
        doc.replace("avatar", user.getAvatar());
        doc.replace("role", user.getRole());
        doc.replace("balance", user.getBalance());

        //update the document
        Bson updateOperationDocument = new Document("$set", doc);
        collection.updateOne(filter, updateOperationDocument);
    }

    public static boolean login(String username, String password) {
        //get user from db
        user user = getUser(username);
        if (user == null) {
            return false;
        }
        //compare password
        //database only contains hased password
        if (user.getPassword().equals(dataUtils.hashPassword(password))) {
            return true;
        }
        return false;
    }

    public static boolean isExistUser(String username) {
        //connect to the database
        MongoClient client = connect();

        try {
            MongoDatabase database = client.getDatabase("gameStore");
            MongoCollection<Document> collection = database.getCollection("users");
    
            Document doc = collection.find(Filters.exists(username)).first();
            
            //check if username exist in doc
            if (doc == null) {
                LOGGER.log(Level.INFO, "doc is null aka this username does not exist (" + username + ")");
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
    
    
    public static boolean seedSampleUsers() {
        //connect to the database
        // MongoClient client = connect();

        // MongoDatabase database = client.getDatabase("gameStore");
        // MongoCollection<Document> collection = database.getCollection("users");
        try {
            for (int i = 0; i < 10; i++) {
                insertUser(new user(
                    "name" + i,
                    "username" + i,
                    "password" + i,
                    "email" + i,
                    "avatar" + i,
                    "user",
                    1000.0
                ));
            }
        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, "[seedSampleUsers] " + e);
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {

        //insert user
        // user User = new user("adminAccount", "admin", "admin@gmail.com", "123456", "null");
        // boolean insert = insertUser(User);
        // if (insert) {
        //     LOGGER.log(Level.INFO, "Successfully inserted user");
        // }
        // else {
        //     LOGGER.log(Level.INFO, "Failed to insert user");
        // }
        
        //seedSample data for testing: 10 users
        //seedSampleUsers();

        // ====================================================================================================

        //get user
        // user user2 = userDB.getUser("admin");
        // if (user2 == null) {
        //     LOGGER.log(Level.SEVERE, "username is not exist");
        //     user2 = new user("adminAccount", "admin", "admin@gmail.com", "password", "null");
        //     userDB.insertUser(user2);
        //     // LOGGER.log(Level.INFO, "Successfully inserted user");
        // }
        // else {
        //     LOGGER.log(Level.INFO, "Successfully get user");
        //     user.showUser(user2);
        // }

        // ====================================================================================================

        //update user


        // ====================================================================================================

        //delete user
        // user User = userDB.getUser("zdragonz999");
        // System.out.println(User);
        // boolean del = userDB.deleteUser(User);
        // if (del) {
        //     LOGGER.log(Level.INFO, "Successfully deleted user");
        // }
        // else {
        //     LOGGER.log(Level.SEVERE, "Failed to delete user");
        // }
        
        // ====================================================================================================

        //update password
        // user User = userDB.getUser("admin");

        //testcase 1: old password is incorrect
        // ResponseData update = userDB.updatePassword(User, "password", "password");
        
        //testcase 2: new password is null
        // ResponseData update = userDB.updatePassword(User, "password", null);
        
        //testcase 3: old password is null
        // ResponseData update = userDB.updatePassword(User, null, "password");
        
        //testcase 4: both fields are correct
        // ResponseData update = userDB.updatePassword(User, "123456", "password");
        // if (update.success) {
        //     LOGGER.log(Level.INFO, "Successfully update user password");
        // }
        // else {
        //     LOGGER.log(Level.SEVERE, "Failed to update user password");
        // }
        
        // show user
        // user.showUser(User);

        //remember to disconnect lol
        //got blocked when multiple concurrent connections are alive
        dataUtils.disconnect();

    }

}

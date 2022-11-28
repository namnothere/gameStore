package com.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.dataUtils.dataUtils;
import com.game.Game;
import com.game.gameDB;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import com.user.user;
// import com.user.userDB;

public class transactionDB {
    private static MongoClient client = null;
    private static final Logger LOGGER = Logger.getLogger(transactionDB.class
    .getClass().getName());

    private static MongoClient connect() {
        if (transactionDB.client == null) {
            LOGGER.log(Level.SEVERE, "mongoClient is null");
            transactionDB.client = dataUtils.getMongoClientInstance();
            LOGGER.log(Level.INFO, "Successfully connected to the database from transactionDB");
        }
        return transactionDB.client;
    }

    public static Transaction getLastestTransaction() {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        MongoCollection<Document> collection;
        try {
            try {
                //get the collection
                collection = database.getCollection("transactions");
            }
            catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Collection not found");
                LOGGER.log(Level.SEVERE, e.getMessage());
                database.createCollection("transactions");
                LOGGER.log(Level.INFO, "transactions Collection created");

                collection = database.getCollection("transactions");


            }
    
            Document document;
            try{
                //-1 sort in descending order
                //1 sort in ascending order
                //get the lastest transaction
                document = collection.find().sort(new Document("_id", -1)).first();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "No transaction found");
                LOGGER.log(Level.SEVERE, e.getMessage());
                return null;
            }
            
            Transaction transaction = new Transaction(document);
    
            return transaction;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error getting the latest transaction " + e.getMessage());
            return null;
        }

    }

    // public static Transaction createTransaction(Transaction transaction) {
    public static boolean createTransaction(Transaction transaction) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("transactions");

        //create collection if it doesn't exist
        if (collection == null) {
            database.createCollection("transactions");
            collection = database.getCollection("transactions");
        }

        List<Integer> gameIds = transaction.getGames();

        //create a document of list of games
        List<Document> games = new ArrayList<Document>();

        //round all the game' prices in the transaction



        for (Game game : gameDB.getGamesByIDs(gameIds)) {
            //only use the game id, name, price
            Document gameDocument = new Document("ID", game.getID())
            .append("name", game.getName())
            .append("initialPrice", Math.round(game.getInitialPrice() * 100.0) / 100.0)
            .append("finalPrice", Math.round(game.getFinalPrice() * 100.0) / 100.0)
            .append("discount", game.getDiscount());
            games.add(gameDocument);
        }

        //create a document
        Document newTransaction = new Document("date", transaction.getDate())
        .append("transactionCode", transaction.getTransactionCode())
        .append("games", games)
        .append("status", transaction.getStatus())
        .append("paymentMethod", transaction.getPaymentMethod())
        .append("total", transaction.calTotal())
        .append("user", transaction.getUser().getUsername());

        try {
            //insert the document
            InsertOneResult result = collection.insertOne(newTransaction);
    
            LOGGER.log(Level.INFO, "Successfully inserted the id: " + result.getInsertedId());    
            // return transaction;
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error inserting the transaction " + e.getMessage());
            // return null;
            return false;
        }

    }

    public static Transaction getTransaction(String transactionCode) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("transactions");

        //declare filter to find the transaction
        Document filter = new Document("transactionCode", transactionCode);

        //find the user, return the first one
        Document doc = collection.find(filter).first();
        if (doc == null) {
            return null;
        }

        //create a new game object
        Transaction transaction = new Transaction(doc);

        return transaction;
    }

    public static boolean updateTransaction(Transaction transaction) {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");
        //get the collection
        MongoCollection<Document> collection = database.getCollection("transactions");

        //create a document
        Document newTransaction = new Document("date", transaction.getDate())
        .append("transactionCode", transaction.getTransactionCode())
        .append("games", transaction.getGames())
        .append("status", transaction.getStatus())
        .append("paymentMethod", transaction.getPaymentMethod())
        .append("total", transaction.getTotal());


        //update the document
        collection.updateOne(Filters.eq("transactionCode", transaction.getTransactionCode()), new Document("$set", newTransaction));

        return true;
    }

    public static boolean seedSampleTransactions() {
        try {

            user admin = new user("admin", "admin", "admin", "123456", "", "admin", 10000.0);

            for (int i = 0; i < 10; i++) {
                //get random games
                List<Game> games = gameDB.getRandom(5);
                //create a new transaction

                List<Integer> gameIds = new ArrayList<Integer>();
                for (Game game : games) {
                    gameIds.add(game.getID());
                }

                Transaction transaction = new Transaction(admin, gameIds, "cash");
                //insert the transaction
                createTransaction(transaction);
            }

        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, "[seedSampleUsers] " + e);
            return false;
        }
        return true;
    }

    public static void showTransaction(Transaction transaction) {
        if (transaction == null) {
            LOGGER.log(Level.INFO, "Transaction is null");
            return;
        }
        System.out.println("Transaction Code: " + transaction.getTransactionCode());
        System.out.println("Date: " + transaction.getDate());
        System.out.println("Games: " + transaction.getGames());
    }

    public static void main(String[] args) {
        // seedSampleTransactions();
        // Transaction t = getLastestTransaction();
        // showTransaction(t);

        // dataUtils.disconnect();
    }

}

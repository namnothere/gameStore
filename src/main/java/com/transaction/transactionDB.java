package com.transaction;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.dataUtils.dataUtils;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;

public class transactionDB {
    private static MongoClient client = null;
    private static final Logger LOGGER = Logger.getLogger(transactionDB.class
    .getClass().getName());

    private static MongoClient connect() {
        if (transactionDB.client == null) {
            LOGGER.log(Level.SEVERE, "mongoClient is null");
            transactionDB.client = dataUtils.getMongoClientInstance();
            LOGGER.log(Level.INFO, "Successfully connected to the database");
        }
        return transactionDB.client;
    }

    public static Transaction getLastestTransaction() {
        //connect to the database
        MongoClient client = connect();

        //get the database
        MongoDatabase database = client.getDatabase("gameStore");

        try {
            //get the collection
            MongoCollection<Document> collection = database.getCollection("transactions");
    
            //-1 sort in descending order
            //1 sort in ascending order
            Document myDoc = collection.find().sort(new Document("_id", -1)).first();
            
            Transaction transaction = new Transaction(myDoc);
    
            return transaction;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error getting the latest transaction");
            return null;
        }

    }

    public static Transaction createTransaction(Transaction transaction) {
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

        //create a document
        Document newTransaction = new Document("date", transaction.getDate())
        .append("transactionCode", transaction.getTransactionCode())
        .append("games", transaction.getGames());

        //insert the document
        InsertOneResult result = collection.insertOne(newTransaction);

        LOGGER.log(Level.INFO, "Successfully inserted the id: " + result.getInsertedId());

        return transaction;
    }

    public static boolean seedSampleTransactions() {
        try {
            for (int i = 0; i < 10; i++) {
                createTransaction(new Transaction());
            }

        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, "[seedSampleUsers] " + e);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // getLastestTransaction();
        seedSampleTransactions();

        dataUtils.disconnect();
    }

}

package com.cart;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.dataUtils.dataUtils;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;



public class CartDB {
    private static MongoClient client = dataUtils.getMongoClientInstance();
    private static final Logger LOGGER = Logger.getLogger(CartDB.class
    .getClass().getName());
    
    public CartDB() {
        CartDB.client = dataUtils.getMongoClientInstance();
    }

    public CartDB(MongoClient client) {
        CartDB.client = client;
    }

    private static MongoClient connect() {
        if (CartDB.client == null) {
            LOGGER.log(Level.SEVERE, "mongoClient is null");
            CartDB.client = dataUtils.getMongoClientInstance();
            LOGGER.log(Level.INFO, "Successfully connected to the database from CartDB");
        }
        return CartDB.client;
    }

    public static void insertCart(Cart cart) {
        try {
            client = CartDB.connect();
            client.getDatabase("gameStore").getCollection("cart").insertOne(cart.toDocument());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public static Cart getCart(String username) {
        try {
            client = CartDB.connect();

            MongoDatabase database = client.getDatabase("gameStore");

            MongoCollection<Document> collection = database.getCollection("cart");

            //declare filter to find the game
            Bson filter = Filters.eq("username", username);

            Document doc = collection.find(filter).first();

            if (doc == null) {
                System.out.println("Cart not found");
                return null;
            }

            System.out.println("Cart found");
            
            return new Cart(doc);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    public static void save(Cart cart) {
        try {
            client = CartDB.connect();

            //check if this cart already saved in the database
            if (findCartByUsername(cart.getUsername()) != null) {
                //update the cart
                client.getDatabase("gameStore").getCollection("cart").updateOne(new Document("username", cart.getUsername()), new Document("$set", cart.toDocument()));
            } else {
                //insert the cart
                insertCart(cart);
            }

            // client.getDatabase("gameStore").getCollection("cart").replaceOne(new Document("username", cart.getUser().getUsername()), cart.toDocument());

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public static void removeCart(Cart cart) {
        try {
            client = CartDB.connect();
            client.getDatabase("gameStore").getCollection("cart").deleteOne(new Document("username", cart.getUser().getUsername()));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public static Cart findCartByUsername(String username) {
        try {
            client = CartDB.connect();

            MongoDatabase database = client.getDatabase("gameStore");

            MongoCollection<Document> collection = database.getCollection("cart");

            //declare filter to find the game
            Bson filter = Filters.eq("username", username);

            Document doc = collection.find(filter).first();

            if (doc != null) {
                return new Cart(doc);
            }
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
        return null;
    }

    public static void main(String[] args) {
        Cart cart = CartDB.getCart("admin");
        System.out.println(cart);
    }

}

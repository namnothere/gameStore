package com.user;

import java.util.ArrayList;
// import java.io.InputStream;
// import java.io.Serializable;
import java.util.List;

import com.cart.Cart;
import com.cart.CartDB;

// import javax.servlet.http.HttpSession;

// import org.bson.Document;
// import org.bson.types.ObjectId;

import com.dataUtils.dataUtils;
import com.game.Game;
import com.game.gameDB;
import com.mongodb.client.MongoClient;
// import com.game.ProductUtils;
// import com.mongodb.client.MongoClient;
// import com.mongodb.client.MongoClients;
// import com.mongodb.client.MongoDatabase;
// import com.mongodb.client.gridfs.GridFSBucket;
// import com.mongodb.client.gridfs.GridFSBuckets;
// import com.mongodb.client.gridfs.model.GridFSFile;
// import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.mongodb.client.gridfs.*;
// import com.mongodb.client.gridfs.model.*;


import com.transaction.Transaction;

import java.util.logging.Level;
import java.util.logging.Logger;

// import org.bson.Document;
// import org.bson.types.ObjectId;

public class user {
    private static final Logger LOGGER = Logger.getLogger(user.class
    .getClass().getName());
    public static GridFSBucket bucket = GridFSBuckets.create(dataUtils.getMongoClientInstance().getDatabase("gameStoreUsers"), "avatars");
    private String name;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private String role;
    private double balance;
    private Cart cart;
    private List<Integer> ownedGames = new ArrayList<Integer>();


    public user() {
        name = "";
        email = "";
        username = "";
        password = "";
        avatar = "";
        role = "user";
        balance = 0;
        ownedGames = null;
        // cart = null;
        cart = new Cart();
        ownedGames = new ArrayList<Integer>();
        this.cart.setUsername(this.username);
    }

    public user(String name, String username, String email, String password, String avatar, String role, Double balance) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
        this.balance = balance;
        this.cart = new Cart(this);
        this.ownedGames = new ArrayList<Integer>();
    }

    public user(String name, String username, String email, String password, String avatar, String role, Double balance, List<Integer> ownedGames) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
        this.balance = balance;
        this.cart = new Cart();
        this.cart.setUsername(this.username);
        this.ownedGames = ownedGames;
    }
    public user(String name, String username, String email, String password, String avatar, String role, Double balance, List<Integer> cart, List<Integer> ownedGames) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
        this.balance = balance;
        this.cart = new Cart().castCart(cart);
        this.cart.setUsername(this.username);
        this.ownedGames = ownedGames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String base64) {
        this.avatar = base64;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
        this.cart.setUsername(this.username);
    }

    public List<Integer> getOwnedGames() {
        return ownedGames;
    }

    public void setOwnedGames(List<Integer> ownedGames) {
        this.ownedGames = ownedGames;
    }

    public void addOwnedGame(int gameID) {
        this.ownedGames.add(gameID);
    }

    public void removeOwnedGame(int gameID) {
        this.ownedGames.remove(gameID);
    }

    public void addGameToCart(Game game) {
        this.cart.addGame(game);
        this.cart.save();
    }

    public void addGameToCart(int gameID) {
        this.cart.addGame(gameID);
        System.out.println("Total after adding game: " + this.cart.getTotal());
        this.cart.save();
    }

    public void removeGameFromCart(Game game) {
        this.cart.removeGame(game);
        this.cart.save();
    }

    public void removeGameFromCart(Integer gameID) {
        this.cart.removeGame(gameID);
        this.cart.save();
    }

    public void deleteAvatar() {
        this.avatar = "";
    }

    public boolean buyGames() {
        
        if (this.cart.getGames().size() == 0) {
            return false;
        }

        if (this.balance < this.cart.getTotal()) {
            LOGGER.log(Level.SEVERE, "Insufficient balance: " + this.username + " (" + this.balance + "<" + this.cart.getTotal() + ")");
            return false;
        }
        
        List<Integer> gameIDs = this.cart.getGames();

        Transaction transaction = new Transaction(this, gameIDs, "wallet");
        transaction.setStatus("paid");
        transaction.saveTransaction();
        
        this.balance -= this.cart.getTotal();
        System.out.println("total pay: " + this.cart.getTotal());


        if (this.ownedGames == null) {
            this.ownedGames = new ArrayList<Integer>();
        }

        this.ownedGames.addAll(gameIDs);

        //round balance to 2 decimal places
        this.balance = Math.round(this.balance * 100.0) / 100.0;

        this.cart.clearCart();
        this.save();
        return true;
    }

    // public boolean purchase(Transaction transaction) {
    //     //check if user has enough balance
    //     if (this.balance >= transaction.getTotal()) {
    //         //update user balance
    //         this.balance -= transaction.getTotal();
    //         //update transaction status
    //         // transaction.setStatus("success");
    //         //update transaction payment method
    //         // transaction.setPaymentMethod("cash");
            
    //         //assign transaction to user
    //         transaction.setUser(this);

    //         //add games to user owned games
    //         for (Integer gameID : transaction.getGames()) {
    //             this.ownedGames.add(gameID);
    //         }

    //         //confirm transaction
    //         transaction.approve();
    //         //update user
    //         userDB.updateUserBalance(this);
    //         //add transaction to database
    //         // transactionDB.addTransaction(transaction);
    //         return true;
    //     }
    //     return false;
    // }

    public boolean save() {
        return userDB.save(this);
    }

    public boolean login() {
        boolean login = userDB.login(this.username, this.password);
        if (login) {
            user user = userDB.getUser(this.username);
            this.name = user.getName();
            this.email = user.getEmail();
            this.avatar = user.getAvatar();
            this.role = user.getRole();
            this.balance = user.getBalance();
            this.cart = user.getCart();
            // this.cart.setUsername(this.username);
            this.ownedGames = user.getOwnedGames();
            return true;
        }
        return false;
    }

    public String hashPassword() {
        String hashString = dataUtils.hashPassword(this.password);
        if (hashString != null && !hashString.isEmpty()) {
            return hashString;
        }
        return null;
    }

    public static void showUser(user user) {
        System.out.println("Name: " + user.getName());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Avatar: " + user.getAvatar());
        System.out.println("Role: " + user.getRole());
        System.out.println("Balance: " + user.getBalance());


        List<Integer> ownedGames = user.getOwnedGames();
        System.out.println("Owned Games: ");
        System.out.println(ownedGames);
        // for (Integer gameID : ownedGames) {
        //     Game game = gameDB.getGameByID(gameID);
        //     System.out.println(game.getName());
        // }

        Cart cart = user.getCart();
        // for (Integer gameID : cart.getGames()) {
        //     Game game = gameDB.getGameByID(gameID);
        //     System.out.println(game.getName());
        // }

        System.out.println("Cart: ");
        System.out.println(cart.getGames());

    }

    public static void main(String[] args) throws Exception {
        
        //get random games and add to cart
        // List<Game> games = gameDB.getRandom(5);

        //get user
        user user = userDB.getUser("zdragonz99999");
        user.setBalance(10);
        user.save();
        System.out.println("Total cart: " + user.getCart().calTotal());

        //Clear cart action
        // user.getCart().clearCart();
        
        //Add games to cart
        // for (Game game : games) {
        //     user.addGameToCart(game);
        // }
        
        //Add game to cart by gameID
        user.addGameToCart(546560);

        //Remove games from cart
        // user.removeGameFromCart(546560); //use gameID
        // user.removeGameFromCart(gameDB.getGame(546560)); //use gameObject

        // System.out.println("Total cart: " + user.getCart().calTotal());

        //buy games
        //scenarion 1: user has enough balance
        // user.setBalance(1000);
        user.buyGames();

        //scenarion 2: user has not enough balance
        // user.setBalance(0);
        // user.buyGames();
        
        // user = userDB.getUser("admin");
        // System.out.println("Balance: " + user.getBalance());

        //show user
        showUser(user);

        dataUtils.disconnect();

    }

}

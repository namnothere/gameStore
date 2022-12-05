package com.cart;

import java.util.ArrayList;
// import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.game.Game;
import com.game.gameDB;
import com.user.user;
// import com.user.userDB;
// import com.transaction.Transaction;
import com.user.userDB;

public class Cart {
    //will be stored in user browser
    //works like a transaction but will not be stored in the database

    private String username;
    // private List<Integer> games = new ArrayList<Integer>();
    private double total;
    private cartItems cartItems;

    public Cart() {
        this.cartItems = new cartItems();
        this.total = 0;
        this.username = null;
    }

    public Cart(user user) {
        this.cartItems = new cartItems();
        this.total = 0;
        this.username = user.getUsername();
    }

    public Cart(Document doc) {
        // List<Integer> games = doc.getList("games", Integer.class);
        // this.cartItems = new cartItems();
        this.total = Double.valueOf(doc.get("total").toString());
        this.username = doc.getString("username");

        //cartItems is a document in the cart document
        // Document cartItemsDoc = (Document) doc.get("cartItems");

        //create a new cartItems object
        this.cartItems = new cartItems(doc);

        System.out.println("Cart created from document");
        System.out.println(cartItems.getGames());

    }

    public void addGame(Game game) {
        // this.games.add(game.getID());
        cartItems.addCartItem(game.getID(), 1);

        // this.total += game.getFinalPrice();
        // this.total = Math.round(this.total * 100.0) / 100.0;
        this.total = cartItems.getTotal();

    }

    public void addGame(Integer gameID) {

        //check if game exist 
        if (gameDB.getGame(gameID) == null) {
            System.out.println("Game does not exist");
            return;
        }

        cartItems.addCartItem(gameID, 1);
        this.total = cartItems.getTotal();

    }

    public void removeGame(Game game) {
        //remove if game is in cart
        if (game == null) {
            return;
        }
        // if (this.cartItems.contains(game.getID())) {
        //     this.games.remove(game.getID());
        //     this.total -= game.getFinalPrice();
        //     this.total = Math.round(this.total * 100.0) / 100.0;
        // }
        this.cartItems.removeCartItem(game.getID());
        this.total = cartItems.getTotal();
    }

    public void removeGame(Integer gameID) {

        Game game = gameDB.getGame(gameID);
        if (game != null) {
            // if (this.games.contains(gameID)) {
            //     this.games.remove(gameID);
            //     this.total -= game.getFinalPrice();
            //     this.total = Math.round(this.total * 100.0) / 100.0;
            // }
            this.cartItems.removeCartItem(gameID);
            this.total = cartItems.getTotal();
        }
    }

    public void clearCart() {
        this.cartItems.clearCart();
        this.total = 0;
        this.save();
    }

    public void setUsername(String username) {
        try {
            this.username = username;
        } catch (Exception e) {
            System.out.println("[Cart_setUser] " + e);
        }
    }

    public String getUsername() {
        return this.username;
    }

    public user getUser() {
        return userDB.getUser(username);
    }

    public boolean save() {
        try {
            CartDB.save(this);
            return true;
        } catch (Exception e) {
            System.out.println("[Cart_save] " + e);
            return false;
        }
    }

    //cast list of integers to cart object
    public Cart castCart(List<Integer> games) {
        for (int i = 0; i < games.size(); i++) {
            this.addGame(gameDB.getGame(games.get(i)));
        }
        return this;
    }

    public double calTotal() {
        double total = 0;
        // for (Integer game : this.games) {
        //     //get the game from the database
        //     Game gameInfo = gameDB.getGameByID(game);
        //     total += gameInfo.getFinalPrice();
        // }
        total = this.cartItems.calTotal();
        this.total = Math.round(total * 100.0) / 100.0;
        return this.total;
    }

    public List<Integer> getGames() {
        return this.cartItems.getGames();
    }

    public double getTotal() {
        calTotal();
        return total;
    }

    public Document toDocument() {
        Document doc = new Document();

        Document cartItemsDoc = this.cartItems.toDocument();
        doc.append("username", this.username);
        doc.append("total", this.total);
        doc.append("cartItems", cartItemsDoc);
        
        return doc;
    }
    public cartItems getCartItems() {
        return this.cartItems;
    }

}

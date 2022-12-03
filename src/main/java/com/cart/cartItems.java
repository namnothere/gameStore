package com.cart;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.game.Game;
import com.game.gameDB;

public class cartItems {
    
    public class cartItem {
        private int gameID;
        private int quantity;
        private double price;
        private double totalPrice;
        
        public cartItem(int gameID, int quantity, double price) {
            this.gameID = gameID;
            this.quantity = quantity;
            this.price = price;
            this.totalPrice = price * quantity;

        }

        public cartItem(int gameID, int quantity) {
            this.gameID = gameID;
            this.quantity = quantity;
            this.price = gameDB.getGame(gameID).getFinalPrice();
            this.totalPrice = price * quantity;
        }

        public int getGameID() {
            return this.gameID;
        }

        public int getQuantity() {
            return this.quantity;
        }
        
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return this.price;
        }

        public double getTotalPrice() {
            return this.totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public void add() {
            this.quantity++;
            this.totalPrice = this.price * this.quantity;
        }

        public void remove() {
            this.quantity--;
            this.totalPrice = this.price * this.quantity;
        }

    }
    
    private List<cartItem> cartItems;
    private double total;
    
    public cartItems() {
        this.cartItems = new ArrayList<cartItem>();
    }

    public cartItems(Document doc) {
        this.cartItems = new ArrayList<cartItem>();
        this.total = Double.valueOf(doc.get("total").toString());
        
        // cartItems is a document contains all the cartItems

        Document cartItemsDoc = (Document) doc.get("cartItems");

        // loop through all key value pairs in the cartItems document

        for (String key : cartItemsDoc.keySet()) {
            
            Document cartItemDoc = (Document) cartItemsDoc.get(key);
            
            int gameID = cartItemDoc.getInteger("gameID");
            int quantity = cartItemDoc.getInteger("quantity");
            double price = Double.valueOf(cartItemDoc.get("price").toString());
            
            double totalPrice = Double.valueOf(cartItemDoc.get("totalPrice").toString());
            
            cartItem cartItem = new cartItem(gameID, quantity, price);
            cartItem.setTotalPrice(totalPrice);
            this.cartItems.add(cartItem);
        }
    }

    public List<cartItem> getCartItems() {
        return this.cartItems;
    }

    public List<Integer> getGames() {
        List<Integer> games = new ArrayList<Integer>();
        for (cartItem item : this.cartItems) {
            games.add(item.getGameID());
        }
        return games;
    }

    public void addCartItem(cartItem cartItem) {

        //check if game is already in cart
        for (cartItem item : this.cartItems) {
            if (item.getGameID() == cartItem.getGameID()) {
                item.add();
                this.total += cartItem.getPrice();
                this.total = Math.round(this.total * 100.0) / 100.0;
                return;
            }
        }

        //if game is not in cart, add it
        this.cartItems.add(cartItem);
        this.total += cartItem.getTotalPrice();

        //round total to 2 decimal places
        this.total = Math.round(this.total * 100.0) / 100.0;

    }

    public void addCartItem(int gameID, int quantity) {
        cartItem cartItem = new cartItem(gameID, quantity);

        //check if game is already in cart
        for (cartItem item : this.cartItems) {
            if (item.getGameID() == cartItem.getGameID()) {
                item.add();
                this.total += cartItem.getPrice();
                this.total = Math.round(this.total * 100.0) / 100.0;
                return;
            }
        }

        //if game is not in cart, add it
        this.cartItems.add(cartItem);
        this.total += cartItem.getTotalPrice();

        //round total to 2 decimal places
        this.total = Math.round(this.total * 100.0) / 100.0;

    }

    public void removeCartItem(cartItem cartItem) {

        //check if game is in cart
        for (cartItem item : this.cartItems) {
            if (item.getGameID() == cartItem.getGameID()) {

                //if quantity is 1, remove game from cart
                if (item.getQuantity() == 1) {
                    this.cartItems.remove(item);
                    this.total -= cartItem.getPrice();
                    this.total = Math.round(this.total * 100.0) / 100.0;
                    return;
                }
                
                item.remove();
                this.total -= cartItem.getPrice();
                this.total = Math.round(this.total * 100.0) / 100.0;
                return;
            }
        }
    }

    public void removeCartItem(int gameID) {
        for (cartItem cartItem : this.cartItems) {
            if (cartItem.getGameID() == gameID) {
                
                //if quantity is 1, remove game from cart
                if (cartItem.getQuantity() == 1) {
                    this.cartItems.remove(cartItem);
                    this.total -= cartItem.getPrice();
                    this.total = Math.round(this.total * 100.0) / 100.0;
                    return;
                } else {
                    cartItem.remove();
                    this.total -= cartItem.getTotalPrice();
                    this.total = Math.round(this.total * 100.0) / 100.0;
                }
                break;
            }
        }
    }

    public void clearCart() {
        this.cartItems.clear();
        this.total = 0;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double calTotal() {
        double total = 0;
        for (cartItem cartItem : this.cartItems) {
            total += cartItem.getTotalPrice();
        }
        total = Math.round(total * 100.0) / 100.0;
        this.total = total;
        return total;
    }

    public Document toDocument() {

        Document cartItemsDoc = new Document();
        // doc.append("cartItems", cartItemsDoc);

        //for each cartItem, add to cartItemsDoc
        for (cartItem cartItem : this.cartItems) {
            Document cartItemDoc = new Document();
            cartItemDoc.append("gameID", cartItem.getGameID());
            cartItemDoc.append("quantity", cartItem.getQuantity());
            cartItemDoc.append("price", cartItem.getPrice());
            cartItemDoc.append("totalPrice", cartItem.getTotalPrice());
            cartItemsDoc.append(String.valueOf(cartItem.getGameID()), cartItemDoc);
        }

        // doc.append("total", this.total);
        // return doc;
        return cartItemsDoc;
    }


    
}

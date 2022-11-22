package com.transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import com.game.Game;
import com.user.user;
import com.user.userDB;
// import com.dataUtils.dataUtils;
// import com.mongodb.client.MongoClient;
// import com.transaction.transactionDB;
public class Transaction {
    private Date date;
    private String transactionCode;
    //create a list of games
    private List<Game> games = new ArrayList<Game>();
    private String status;
    private String paymentMethod;
    private float total;
    // private float balanceBefore;
    private user user;

    public Transaction() {
        this.date = new Date();
        this.transactionCode = Transaction.generateTransactionCode();
        this.games = new ArrayList<Game>();
        this.status = "pending";
        this.paymentMethod = "cash";
        this.total = 0;
        // this.balanceBefore = 0;
        this.user = null;

    }

    public Transaction(String transactionCode, List<Game> games) {
        this.date = new Date();
        this.transactionCode = transactionCode;
        this.games = games;
    }
    public Transaction(String transactionCode, Game game) {
        this.date = new Date();
        this.transactionCode = transactionCode;
        this.games.add(game);
        // this.games = games;
    }

    public Transaction(String transactionCode, List<Game> games, String status, String paymentMethod, float total, user user) {
        this.date = new Date();
        this.transactionCode = transactionCode;
        this.games = games;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.user = user;
    }
    public Transaction(String transactionCode, List<Game> games, String status, String paymentMethod, float total, String username) {
        this.date = new Date();
        this.transactionCode = transactionCode;
        this.games = games;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.user = userDB.getUser(username);
    }
    
    public Transaction(Document doc) {
        this.date = doc.getDate("date");
        this.transactionCode = doc.getString("transactionCode");
        this.games = doc.getList("games", Game.class);
    }

    //get the lastest transaction increment the transaction code by 1
    public static String generateTransactionCode() {
        String transactionCode = "0";
        //get the lastest transaction
        Transaction lastestTransaction = transactionDB.getLastestTransaction();
        //if there is no transaction
        if (lastestTransaction == null) {
            return "1";
        }
        else {
            //get the lastest transaction code
            String lastestTransactionCode = lastestTransaction.getTransactionCode();
            //increment the transaction code by 1
            int newTransactionCode = Integer.valueOf(lastestTransactionCode) + 1;
            //convert the transaction code to string
            transactionCode = String.format("%08d", newTransactionCode);
        }
        return transactionCode;
    }



    public float getTotal() {
        return this.total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
        calTotal();
    }

    public void addGame(Game game) {
        this.games.add(game);
        this.total += game.getInitialPrice();
    }

    public void removeGame(Game game) {
        this.games.remove(game);
        this.total -= game.getInitialPrice();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getBalanceBefore() {
        return user.getBalance();
    }

    public void setBalanceBefore(float balanceBefore) {
        this.user.setBalance(balanceBefore);
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public void calTotal() {
        float total = 0;
        for (Game game : this.games) {
            total += game.getInitialPrice();
        }
        this.total = total;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("date", this.date);
        json.put("transactionCode", this.transactionCode);
        JSONArray games = new JSONArray();
        for (Game game : this.games) {
            games.put(game.toJSON());
        }
        json.put("games", games);
        return json;
    }

    public boolean approve() {
        //user.buy will call this function to approve the transaction
        //and update it in database
        setStatus("success");
        //update the transaction in database
        return transactionDB.updateTransaction(this);

        // return false;
    }

    // public static getTransaction(String transactionCode) {
    //     return transactionDB.getTransaction(transactionCode);
    // }
    public static void main(String[] args) throws Exception {
        //Load our image
        // byte[] imageBytes = LoadImage("C:/Temp/bear.bmp");
        //Connect to database
        // MongoClient client = MongoClients.create("mongodb://localhost:27017");

        

    }

}

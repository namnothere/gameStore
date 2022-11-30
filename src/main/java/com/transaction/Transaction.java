package com.transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.json.JSONArray;
// import org.json.JSONObject;

import com.game.Game;
import com.game.gameDB;
import com.user.user;
import com.user.userDB;
// import com.dataUtils.dataUtils;
// import com.mongodb.client.MongoClient;
// import com.transaction.transactionDB;
public class Transaction {
    private Date date;
    private int transactionCode;
    private List<Integer> games = new ArrayList<Integer>();
    private String status;
    private String paymentMethod;
    private double total;
    private user user;
    private Double balanceBefore = 0.0;

    public Transaction() {
        this.date = new Date();
        this.transactionCode = Transaction.generateTransactionCode();
        // this.games = new ArrayList<Game>();
        this.games = new ArrayList<Integer>();
        this.status = "pending";
        this.paymentMethod = "cash";
        this.total = 0;
        // this.balanceBefore = 0;
        this.user = null;
    }

    public Transaction(user user, List<Integer> games, String paymentMethod) {
        this.date = new Date();
        this.transactionCode = Transaction.generateTransactionCode();
        this.games = games;

        if (games != null) {
            this.total = this.calTotal();
        } else {
            this.total = 0;
        }

        this.status = "pending";
        this.paymentMethod = paymentMethod;
        this.user = user;
        this.balanceBefore = user.getBalance();
    }
    // public Transaction(user user, List<Game> games, String paymentMethod) {
    //     this.date = new Date();
    //     this.transactionCode = Transaction.generateTransactionCode();
    //     this.games = games;
    //     this.status = "pending";
    //     this.paymentMethod = paymentMethod;
    //     this.total = 0;
    //     this.user = user;
    //     this.balanceBefore = user.getBalance();
    // }
    
    public Transaction(Document doc) {
        this.date = doc.getDate("date");
        this.transactionCode = doc.getInteger("transactionCode");
        this.games = doc.getList("game", Integer.class);
        this.status = doc.getString("status");
        this.paymentMethod = doc.getString("paymentMethod");
        this.total = doc.getDouble("total").floatValue();
        this.user = userDB.getUser(doc.getString("user"));
    }

    // public List<Game> jsonArrayToList(JSONArray jsonArray) {
    //     List<Game> list = new ArrayList<Game>();
    //     for (int i = 0; i < jsonArray.length(); i++) {
    //         // list.add(new Game(jsonArray.getJSONObject(i)));

    //         list.add(new Game(jsonArray.getJSONObject(i).toString(), jsonArray.getJSONObject(i).getInt("ID")));
    //     }
    //     return list;
    // }

    //get the lastest transaction increment the transaction code by 1
    public static Integer generateTransactionCode() {
        Integer transactionCode = 0;
        //get the lastest transaction
        Transaction lastestTransaction = transactionDB.getLastestTransaction();
        //if there is no transaction
        if (lastestTransaction == null) {
            System.out.println("No transaction. Transaction code is 1");
            return 1;
        }
        else {
            //get the lastest transaction code
            int lastestTransactionCode = lastestTransaction.getTransactionCode();
            //increment the transaction code by 1
            transactionCode = lastestTransactionCode + 1;
            //convert the transaction code to string
            // transactionCode = String.format("%08d", newTransactionCode);
        }
        return transactionCode;
    }



    public double getTotal() {
        return this.total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(Integer transactionCode) {
        this.transactionCode = transactionCode;
    }

    public List<Integer> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        List<Integer> gameIds = new ArrayList<Integer>();
        for (Game game : games) {
            gameIds.add(game.getID());
        }
        this.games = gameIds;
        calTotal();
    }

    public void addGame(Game game) {
        this.games.add(game.getID());
        this.total += game.getFinalPrice();
    }

    public void removeGame(Game game) {
        this.games.remove(game.getID());
        this.total -= game.getFinalPrice();
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

    public Double getBalanceBefore() {
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

    public double calTotal() {
        double total = 0;
        for (Integer game : this.games) {
            //get the game from the database
            Game gameInfo = gameDB.getGameByID(game);
            total += gameInfo.getFinalPrice();
        }

        this.total = Math.round(total * 100.0) / 100.0;
        return total;
    }

    // public JSONObject toJSON() {
    //     JSONObject json = new JSONObject();
    //     json.put("date", this.date);
    //     json.put("transactionCode", this.transactionCode);
    //     JSONArray games = new JSONArray();
    //     for (Game game : this.games) {
    //         games.put(game.toJSON());
    //     }
    //     json.put("games", games);
    //     return json;
    // }
    // public JSONArray getGamesJSON() {
    //     JSONArray games = new JSONArray();
    //     for (Game game : this.games) {
    //         games.put(game.toJSON());
    //     }
    //     return games;
    // }

    public boolean saveTransaction() {
        return transactionDB.createTransaction(this);
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
        

    }

}

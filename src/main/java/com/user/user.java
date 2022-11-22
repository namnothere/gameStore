package com.user;

import java.io.File;
import java.io.FileInputStream;
// import java.io.InputStream;
// import java.io.Serializable;
import java.util.List;

// import javax.servlet.http.HttpSession;

// import org.bson.Document;
// import org.bson.types.ObjectId;

import com.dataUtils.dataUtils;
import com.game.Game;
// import com.game.ProductUtils;
// import com.mongodb.client.MongoClient;
// import com.mongodb.client.MongoClients;
// import com.mongodb.client.MongoDatabase;
// import com.mongodb.client.gridfs.GridFSBucket;
// import com.mongodb.client.gridfs.GridFSBuckets;
// import com.mongodb.client.gridfs.model.GridFSFile;
// import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.transaction.Transaction;


public class user {
    private String name;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private String role;
    private double balance;
    private List<Integer> ownedGames = null;


    public user() {
        name = "";
        email = "";
        username = "";
        password = "";
        avatar = "";
        role = "user";
        balance = 0;
        ownedGames = null;
    }

    public user(String name, String username, String email, String password, String avatar, String role, Double balance) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
        this.balance = balance;
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

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public boolean purchase(Transaction transaction) {
        //check if user has enough balance
        if (this.balance >= transaction.getTotal()) {
            //update user balance
            this.balance -= transaction.getTotal();
            //update transaction status
            // transaction.setStatus("success");
            //update transaction payment method
            // transaction.setPaymentMethod("cash");
            
            //assign transaction to user
            transaction.setUser(this);

            //add games to user owned games
            for (Game game : transaction.getGames()) {
                this.ownedGames.add(game.getID());
            }

            //confirm transaction
            transaction.approve();
            //update user
            userDB.updateUserBalance(this);
            //add transaction to database
            // transactionDB.addTransaction(transaction);
            return true;
        }
        return false;
    }

    public boolean login() {
        boolean login = userDB.login(this.username, this.password);
        if (login) {
            user user = userDB.getUser(this.username);
            this.name = user.getName();
            this.email = user.getEmail();
            // this.username = username;
            // this.password = password;
            this.avatar = user.getAvatar();
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

    public static byte[] LoadImage(String filePath) throws Exception {
        File file = new File(filePath);
        int size = (int)file.length();
        byte[] buffer = new byte[size];
        FileInputStream in = new FileInputStream(file);
        in.read(buffer);
        in.close();
        return buffer;
    }

    public static void showUser(user user) {
        System.out.println("Name: " + user.getName());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Avatar: " + user.getAvatar());
    }

    public static void main(String[] args) throws Exception {
        //Load our image
        // byte[] imageBytes = LoadImage("C:/Temp/bear.bmp");
        //Connect to database
        // MongoClient client = MongoClients.create("mongodb://localhost:27017");

        

    }


    // public boolean isValid() {
    //     // Verify when login
    //     return userDB.login(username, password);
    // }

    // public boolean isExist() {
    //     // Verify when register
    //     return userDB.isExistUser(username);
    // }

}

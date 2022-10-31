package com.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.store.MongoUtils;
import com.dataUtils.dataUtils;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;


public class user {
    private String name;
    private String username;
    private String email;
    private String password;
    private String avatar;

    public user() {
        name = "";
        email = "";
        username = "";
        password = "";
        avatar = "";
    }

    public user(String name, String username, String email, String password, String avatar) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
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

    public boolean login() {
        user user = userDB.login(this.username, this.password);
        if (user != null) {
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

        MongoUtils client = new MongoUtils();
        MongoClient mongoClient = client.getClient();
        
        String dbName = "GridFSTestJava";
        MongoDatabase db = mongoClient.getDatabase( dbName );
        //Create GridFS object
        // GridFSFile fs = new GridFSFile( db );
        GridFSBucket gridFSBucket = GridFSBuckets.create(db);
        //Save image into database
        // GridFSFile in = GridFSFile.createFile( imageBytes );
        // in.save();
        // InputStream inStream = new FileInputStream(imageBytes);
        String filePath = "D:\\Clip\\ytarchive-master\\ytarchive-master\\Gawr Gura Ch. hololive-EN\\a a a, mic OK, ikuyo [KARAOKE]-tk0HKYnhHY8\\a a a, mic OK, ikuyo [KARAOKE]-tk0HKYnhHY8.jpg";
        InputStream inStream = new FileInputStream(new File(filePath));
        // GridFSInputFile in = gridFSBucket.createFile(inStream);
        GridFSUploadOptions uploadOptions = new GridFSUploadOptions().chunkSizeBytes(1024).metadata(new Document("type", "image").append("content_type", "image/png"));

        String fileName = "goob";
        ObjectId fileId = gridFSBucket.uploadFromStream(fileName, inStream, uploadOptions);

        System.out.println("File ID: " + fileId);

    }


    public boolean isValid() {
        // Verify when login
        return userDB.isValidUser(username, password);
    }

    public boolean isExist() {
        // Verify when register
        return userDB.isExistUser(username);
    }

}

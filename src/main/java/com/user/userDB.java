package com.user;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

public class userDB {
    private static MongoClient client = null;

    public userDB() {
        userDB.client = getMongoClient();
    }

    public userDB(MongoClient client) {
        userDB.client = client;
    }

    private static MongoClient getMongoClient() {
        String uri = "mongodb+srv://aegis:aegis@baekettle.lkh9f.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uri);
        return mongoClient;
    }

}

package com.game;

import org.json.JSONArray;
import org.json.JSONObject;

public class Game {
    public int ID;
    public String name;
    public String desc;
    public JSONArray videos;
    public JSONArray images;
    public JSONObject prices;
    public boolean isFree;

    public Game(String json, String ID) {
        // JSONObject obj = new JSONObject(json).getJSONObject("data");
        // the first key is the ID
        // System.out.println(json);
        JSONObject game = new JSONObject(json);
        // Iterator<String> keys = obj.keys();
        // String key = keys;
        // String id = String.valueOf(ID);
        // JSONObject game = obj.getJSONObject(ID);
        
        

        // this.ID = obj.getInt("steam_appid");
        // this.name = obj.getString("name");
        // this.desc = obj.getString("detailed_description");

        this.ID = Integer.valueOf(ID);
        this.name = game.getString("name");
        this.desc = game.getString("desc");

        if (game.has("videos")) {
            this.videos = game.getJSONArray("videos");
        }

        this.images = game.getJSONArray("images");
        if (game.has("prices")) {
            this.prices = game.getJSONObject("prices");
        }
        else {
            this.prices = null;
        }

        if (game.has("is_free")) {
            this.isFree = game.getBoolean("is_free");
        }
        else {
            this.isFree = false;
        }

        // System.out.println("+ Name: " + this.name);
    }

    public Game(int ID, String name, String desc, JSONArray videos, JSONArray images, JSONObject prices) {
        this.ID = ID;
        this.name = name;
        this.desc = desc;
        this.videos = videos;
        this.images = images;
        this.prices = prices;
    }


    public float getPrice(String region) {
        return this.prices.getFloat(region);
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }
    
    public JSONArray getVideos() {
        return this.videos;
    }

    public JSONArray getImages() {
        return this.images;
    }

    public JSONObject getPrices() {
        return this.prices;
    }

    public JSONObject toJson() {
        JSONObject obj = new JSONObject();

        
        obj.put("ID", this.ID);

        JSONObject gameInfos = new JSONObject();
        gameInfos.put("name", this.name);
        gameInfos.put("desc", this.desc);
        gameInfos.put("videos", this.videos);
        gameInfos.put("images", this.images);
        gameInfos.put("prices", this.prices);
        gameInfos.put("isFree", this.isFree);

        obj.put(Integer.toString(this.ID), gameInfos);

        return obj;
    }

}

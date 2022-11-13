package com.game;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Game {
    public int ID;
    public String name;
    public String desc;
    public List<String> videos = new ArrayList<String>();
    public List<String> images = new ArrayList<String>();
    public Float initialPrice = (float) 0.0;
    public Float finalPrice = (float) 0.0;
    public boolean isFree;
    public List<String> publishers = new ArrayList<String>();
    public List<String> developers = new ArrayList<String>();
    public int rating = 0;
    public List<category> categories = new ArrayList<category>();
    public List<genre> genres = new ArrayList<genre>();
    public String releaseDate;
    public String background_raw; // url to the raw image

    public Game() {

    }

    public Game(String json, Integer ID) {
        JSONObject game = new JSONObject(json);

        this.ID = Integer.valueOf(ID);
        this.name = game.getString("name");
        this.desc = game.getString("desc");

        if (game.has("videos")) {
            this.videos = jsonArrayToList(game.getJSONArray("videos"));
        }

        this.images = jsonArrayToList(game.getJSONArray("images"));
        if (game.has("price_overview")) {
            this.initialPrice = game.getJSONObject("price_overview").getFloat("initial") / 100;
            // this.initialPrice = game.getJSONObject("price_overview").getFloat("initial");
            this.finalPrice = game.getJSONObject("price_overview").getFloat("final") / 100;
        }
        else {
            this.initialPrice = (float) 0;
            this.finalPrice = (float) 0;
        }

        if (game.has("is_free")) {
            this.isFree = game.getBoolean("is_free");
        }
        else {
            this.isFree = false;
        }

        if (game.has("publishers")) {
            this.publishers = jsonArrayToList(game.getJSONArray("publishers"));
        }
        // this.publishers = jsonArrayToList(game.getJSONArray("publishers"));

        if (game.has("developers")) {
            this.developers = jsonArrayToList(game.getJSONArray("developers"));
        }
        // this.developers = jsonArrayToList(game.getJSONArray("developers"));

        // this.rating = game.getJSONObject("rating").getInt("score");
        //check if the game has a rating
        try {
            if (game.has("rating")) {
                this.rating = game.getJSONObject("rating").getInt("score");
            }
            else {
                this.rating = 0;
            }
        } catch (Exception e) {
            this.rating = 0;
        }
        if (game.has("categories")) {
            this.categories = jsonArrayToCategoryList(game.getJSONArray("categories"));
        }
        if (game.has("genres")) {
            this.genres = jsonArrayToGenreList(game.getJSONArray("genres"));
        }

        this.releaseDate = game.getString("releaseDate");
        if (game.has("background_raw")) {
            this.background_raw = game.getString("background_raw");
        }
        else {
            this.background_raw = "";
        }
    }

    public Game(int ID, String name, String desc, List<String> videos, List<String> images, Float initialprice) {
        this.ID = ID;
        this.name = name;
        this.desc = desc;
        this.videos = videos;
        this.images = images;
        this.initialPrice = initialprice;
        this.finalPrice = initialprice;
        //leave the rest empty
        this.isFree = false;
        this.publishers = new ArrayList<String>();
        this.developers = new ArrayList<String>();
        this.rating = 0;
        this.categories = new ArrayList<category>();
        this.genres = new ArrayList<genre>();
        this.releaseDate = "";
        this.background_raw = "";
    }

    

    public float getInitialPrice() {
        return this.initialPrice;
    }

    public void setInitialPrice(float initialprice) {
        this.initialPrice = initialprice;
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
    
    public List<String> getVideos() {
        return this.videos;
    }

    public List<String> getImages() {
        return this.images;
    }

    public List<String> getPublishers() {
        return this.publishers;
    }

    public List<String> getDevelopers() {
        return this.developers;
    }

    public int getRating() {
        return this.rating;
    }

    public List<category> getCategories() {
        return this.categories;
    }

    public List<genre> getGenres() {
        return this.genres;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public String getBackground_raw() {
        return this.background_raw;
    }

    public boolean getIsFree() {
        return this.isFree;
    }

    public boolean setInitialPrice(Float initialprice) {
        this.initialPrice = initialprice;
        return true;
    }

    public boolean setFinalPrice(Float finalprice) {
        this.finalPrice = finalprice;
        return true;
    }

    public boolean setID(int ID) {
        this.ID = ID;
        return true;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }


    public boolean setDesc(String desc) {
        this.desc = desc;
        return true;
    }

    public boolean setVideos(List<String> videos) {
        this.videos = videos;
        return true;
    }

    public boolean setImages(List<String> images) {
        this.images = images;
        return true;
    }

    public boolean setFree(boolean isFree) {
        this.isFree = isFree;
        return true;
    }

    public boolean setPublishers(List<String> publishers) {
        this.publishers = publishers;
        return true;
    }

    public boolean setDevelopers(List<String> developers) {
        this.developers = developers;
        return true;
    }

    public boolean setrating(int rating) {
        this.rating = rating;
        return true;
    }

    public boolean setCategories(List<category> categories) {
        this.categories = categories;
        return true;
    }
    public boolean setCategories(category category) {
        this.categories.add(category);
        return true;
    }

    public boolean setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return true;
    }

    public boolean setBackgroundRaw(String background_raw) {
        this.background_raw = background_raw;
        return true;
    }

    public boolean setGenres(List<genre> genres) {
        this.genres = genres;
        return true;
    }

    public boolean setGenres(genre genre) {
        this.genres.add(genre);
        return true;
    }

    public boolean setRating(int i) {
        this.rating = i;
        return true;
    }

    public List<String> jsonArrayToList(JSONArray jsonArray) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }

    public List<category> jsonArrayToCategoryList(JSONArray jsonArray) {
        List<category> list = new ArrayList<category>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            Integer id = obj.getInt("id");
            String description = obj.getString("description");
            list.add(new category(id, description));
        }
        return list;
    }
    public List<genre> jsonArrayToGenreList(JSONArray jsonArray) {
        //return jsonArrayToCategoryList but with genre instead of category
        List<genre> list = new ArrayList<genre>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            Integer id = obj.getInt("id");
            String description = obj.getString("description");
            list.add(new genre(id, description));
        }
        return list;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();

        obj.put("ID", this.ID);

        JSONObject gameInfos = new JSONObject();
        gameInfos.put("name", this.name);
        gameInfos.put("desc", this.desc);
        gameInfos.put("videos", this.videos);
        gameInfos.put("images", this.images);
        gameInfos.put("initialPrice", this.initialPrice);
        gameInfos.put("finalPrice", this.finalPrice);
        gameInfos.put("isFree", this.isFree);
        gameInfos.put("publishers", this.publishers);
        gameInfos.put("developers", this.developers);
        gameInfos.put("categories", this.categories);
        gameInfos.put("genres", this.genres);
        gameInfos.put("releaseDate", this.releaseDate);
        gameInfos.put("background_raw", this.background_raw);
        gameInfos.put("rating", this.rating);


        obj.put(Integer.toString(this.ID), gameInfos);

        return obj;
    }

}

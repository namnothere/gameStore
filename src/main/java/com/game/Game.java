package com.game;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Game {
    public int ID;
    public String name;
    public String desc;
    public List<String> videos;
    public List<String> images;
    public Float priceInitial;
    public Float priceFinal;
    public boolean isFree;
    public List<String> publishers;
    public List<String> developers;
    public int metacritic;
    public List<category> categories = new ArrayList<category>();
    public List<genre> genres = new ArrayList<genre>();
    public String releaseDate;
    public String background_raw; // url to the raw image

    public Game() {

    }

    public Game(String json, String ID) {
        JSONObject game = new JSONObject(json);

        this.ID = Integer.valueOf(ID);
        this.name = game.getString("name");
        this.desc = game.getString("description");

        if (game.has("videos")) {
            this.videos = jsonArrayToList(game.getJSONArray("videos"));
        }

        this.images = jsonArrayToList(game.getJSONArray("image"));
        if (game.has("price_overview")) {
            this.priceInitial = game.getJSONObject("price_overview").getFloat("initial") / 100;
            this.priceFinal = game.getJSONObject("price_overview").getFloat("final") / 100;
        }
        else {
            this.priceInitial = null;
            this.priceFinal = null;
        }

        if (game.has("is_free")) {
            this.isFree = game.getBoolean("is_free");
        }
        else {
            this.isFree = false;
        }

        this.publishers = jsonArrayToList(game.getJSONArray("publishers"));
        this.developers = jsonArrayToList(game.getJSONArray("developers"));
        this.metacritic = game.getJSONObject("metacritic").getInt("score");
        this.categories = jsonArrayToCategoryList(game.getJSONArray("categories"));
        this.releaseDate = game.getString("release_date");
        this.background_raw = game.getString("background_raw");
    }

    public Game(int ID, String name, String desc, List<String> videos, List<String> images, Float priceInitial, Float priceFinal) {
        this.ID = ID;
        this.name = name;
        this.desc = desc;
        this.videos = videos;
        this.images = images;
        this.priceInitial = priceInitial;
        this.priceFinal = priceFinal;
    }


    public float getPriceInitial() {
        return this.priceInitial;
    }
    public float getPriceFinal() {
        return this.priceFinal;
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

    public int getMetacritic() {
        return this.metacritic;
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

    public boolean setPriceInitial(Float priceInitial) {
        this.priceInitial = priceInitial;
        return true;
    }
    public boolean setPriceFinal(float priceFinal) {
        this.priceFinal = priceFinal;
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

    public boolean setMetacritic(int metacritic) {
        this.metacritic = metacritic;
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
        this.metacritic = i;
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
            String id = obj.getString("id");
            String description = obj.getString("description");
            list.add(new category(id, description));
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
        gameInfos.put("priceInitial", this.priceInitial);
        gameInfos.put("priceFinal", this.priceFinal);
        gameInfos.put("isFree", this.isFree);

        obj.put(Integer.toString(this.ID), gameInfos);

        return obj;
    }

}

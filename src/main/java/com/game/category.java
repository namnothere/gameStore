package com.game;

public class category {
    public Integer ID;
    public String description;

    public Integer getID() {
        return this.ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public category() {

    }

    public category(Integer ID, String description) {
        this.ID = ID;
        this.description = description;
    }

}

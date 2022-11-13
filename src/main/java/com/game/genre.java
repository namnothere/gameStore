package com.game;

public class genre {
    public String ID;
    public String description;

    public genre() {

    }

    public String getDescription(){
        return description;
    }
    public genre(String ID, String description) {
        this.ID = ID;
        this.description = description;
    }
}

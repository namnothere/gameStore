package com.game;

import java.util.List;

public class cartGame extends Game {
    private int quantity;

    public cartGame() {
        super();
        quantity = 0;
    }

    public cartGame(int ID, String name, String desc, List<String> videos, List<String> images, Float price, int quantity) {
        super(ID, name, desc, videos, images, price);
        this.quantity = quantity;
    }

    //int ID, String name, String desc, List<String> videos, List<String> images, Float price

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

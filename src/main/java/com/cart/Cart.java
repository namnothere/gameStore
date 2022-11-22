package com.cart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.game.Game;
import com.user.user;
import com.user.userDB;
import com.transaction.Transaction;

public class Cart extends Transaction {
    //will be stored in user browser
    //works like a transaction but will not be stored in the database

    private user user;
    private List<Game> games = new ArrayList<Game>();
    private float total;

    public Cart() {
        this.games = new ArrayList<Game>();
        this.total = 0;
        this.user = null;
    }

    public Cart(user user) {
        this.games = new ArrayList<Game>();
        this.total = 0;
        this.user = user;
    }

}

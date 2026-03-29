package org.example.player;

import java.util.ArrayList;
import java.util.List;

import org.example.map.Lane;
import org.example.map.Node;

class Player {

    private String name;
    private int money;
    private int score;
    private List<Snowplow> snowplows = new ArrayList<>();
    private Bus bus;

    public void moveBus() {
    }

    public void moveSnowplow(Snowplow sp, Node target, Lane via) {
    }

    public void addSnowplow(Snowplow sp) {
    }

    public boolean spendMoney(int amount) {
        return false;
    }

    public int getMoney() {
        return 0;
    }

    public void addMoney(int amount) {
    }

    public int getScore() {
        return 0;
    }

    public void addScore(int amount) {
    }
}

package org.example.Player;

import org.example.Map.Lane;
import org.example.Map.Node;

import java.util.ArrayList;
import java.util.List;

class Player {
    private String name;
    private int money;
    private int score;
    private List<Snowplow> snowplows = new ArrayList<>();
    private Bus bus;

    public void moveBus() {}
    public void moveSnowplow(Snowplow sp, Node target, Lane via) {}
    public void addSnowplow(Snowplow sp) {}
    public boolean spendMoney(int amount) { return false; }
    public int getMoney() { return 0; }
    public void addMoney(int amount) {}
    public int getScore() { return 0; }
    public void addScore(int amount) {}
}
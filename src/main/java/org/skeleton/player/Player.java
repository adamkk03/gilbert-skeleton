package org.skeleton.player;

import java.util.ArrayList;
import java.util.List;

import org.skeleton.map.Lane;
import org.skeleton.map.Node;
import org.skeleton.vehicle.Bus;

public class Player {

    private String name;
    private int money;
    private int score;
    private List<Snowplow> snowplows;
    private Bus bus;

    public Player(String name) {
        this.name = name;
        this.snowplows = new ArrayList<>();
    }

    public void moveBus() {
        // Logika a busz mozgatására
    }

    public void moveSnowplow(Snowplow sp, Node target, Lane via) {
        sp.move(target, via);
    }

    public void addSnowplow(Snowplow sp) {
        snowplows.add(sp);
    }

    public boolean spendMoney(int amount) {
        if (money >= amount) {
            money -= amount;
            return true;
        }
        return false;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int amount) {
        this.score += amount;
    }

    public void resetState() {
        // Lépéspontok és egyéb kör eleji értékek visszaállítása
    }

    public void addEquipment(String itemType) {
        // Új PlowHead létrehozása és inventory-hoz adása a string alapján
    }
}

package org.skeleton.player;

import java.util.ArrayList;
import java.util.List;

import org.skeleton.map.Lane;
import org.skeleton.map.Node;
import org.skeleton.plowhead.*;
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

    public void moveBus(Lane destination) {
        if (this.bus != null) {
            this.bus.playTurn(destination);
        }
    }

    public void moveSnowplow(Snowplow sp, Node target, Lane via) {
        sp.move(target, via);
    }

    public void addSnowplow(Snowplow sp) {
        snowplows.add(sp);
        sp.setOwner(this);
    }

    public boolean spendMoney(int amount) {
        if (money >= amount) {
            money -= amount;
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
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
        for (Snowplow sp : snowplows) {
            sp.resetMoves();
        }
    }

    public void addEquipment(Snowplow sp, String itemType) {
        PlowHead newHead = switch (itemType.toLowerCase()) {
            case "salter" -> new Salter();
            case "sweeper" -> new Sweeper();
            case "thrower" -> new Thrower();
            case "dragon" -> new Dragon();
            case "icebreaker" -> new Icebreaker();
            case "graveler" -> new Graveler();
            default -> null;
        };

        if (newHead != null && snowplows.contains(sp)) {
            sp.getInventory().addHead(newHead);
        }
    }
}

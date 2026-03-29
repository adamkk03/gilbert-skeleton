package org.example.player;

import java.util.ArrayList;
import java.util.List;

import org.example.Logger;
import org.example.Questioner;
import org.example.map.Lane;
import org.example.map.Node;
import org.example.vehicle.Bus;

public class Player {

    private String name;
    private int money;
    private int score;
    private List<Snowplow> snowplows = new ArrayList<>();
    private Bus bus;

    public void moveBus() {
        Logger.call("Player", "moveBus()");
        if (bus != null) {
            bus.move(null);
        }
        Logger.retVoid();
    }

    public void moveSnowplow(Snowplow sp, Node target, Lane via) {
        Logger.call("Player", "moveSnowplow(sp, target, via)");
        if (sp != null) {
            sp.move(target, via);
        }
        Logger.retVoid();
    }

    public void addSnowplow(Snowplow sp) {
        Logger.call("Player", "addSnowplow(sp)");
        snowplows.add(sp);
        Logger.retVoid();
    }

    public boolean spendMoney(int amount) {
        Logger.call("Player", "spendMoney(" + amount + ")");
        // Szkeleton interaktivitás: Megkérdezzük a tesztelőt
        boolean canSpend = Questioner.ask("Van a játékosnak elég pénze a tranzakcióhoz?");
        if (canSpend) {
            money -= amount;
        }
        Logger.ret("boolean", String.valueOf(canSpend));
        return canSpend;
    }

    public int getMoney() {
        Logger.call("Player", "getMoney()");
        Logger.ret("int", String.valueOf(money));
        return money;
    }

    public void addMoney(int amount) {
        Logger.call("Player", "addMoney(" + amount + ")");
        money += amount;
        Logger.retVoid();
    }

    public int getScore() {
        Logger.call("Player", "getScore()");
        Logger.ret("int", String.valueOf(score));
        return score;
    }

    public void addScore(int amount) {
        Logger.call("Player", "addScore(" + amount + ")");
        score += amount;
        Logger.retVoid();
    }
}

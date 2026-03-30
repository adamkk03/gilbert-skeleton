package org.example.player;

import java.util.ArrayList;
import java.util.List;

import org.example.Logger;
import org.example.Questioner;
import org.example.map.Lane;
import org.example.map.Node;
import org.example.vehicle.Bus;

/**
 * A játékost reprezentáló entitás. Felelőssége a megszerzett pontszám és pénz
 * nyilvántartása, valamint a birtokolt járművek (hókotrók és buszok) irányítása
 * és a vásárlások kezdeményezése.
 */
public class Player {

    private String name;
    private int money;
    private int score;
    private List<Snowplow> snowplows = new ArrayList<>();
    private Bus bus;

    /**
     * A játékos buszának mozgatását kezdeményezi.
     */
    public void moveBus() {
        Logger.call("Player", "moveBus()");
        if (bus != null) {
            bus.move(null);
        }
        Logger.retVoid();
    }

    /**
     * A kiválasztott hókotrót utasítja mozgásra a megadott útvonalon.
     *
     * @param sp A mozgatni kívánt hókotró
     * @param target A cél csomópont
     * @param via Az útvonal (sáv) amin halad
     */
    public void moveSnowplow(Snowplow sp, Node target, Lane via) {
        Logger.call("Player", "moveSnowplow(sp, target, via)");
        if (sp != null) {
            sp.move(target, via);
        }
        Logger.retVoid();
    }

    /**
     * Felvesz egy új hókotrót a játékoshoz.
     *
     * @param sp Az új hókotró
     */
    public void addSnowplow(Snowplow sp) {
        Logger.call("Player", "addSnowplow(sp)");
        snowplows.add(sp);
        Logger.retVoid();
    }

    /**
     * Elvégzi a fizetést, és igazzal tér vissza ha sikeres a tranzakció.
     *
     * @param amount A levonandó összeg
     * @return Igaz, ha volt elég pénz és a tranzakció sikeres.
     */
    public boolean spendMoney(int amount) {
        Logger.call("Player", "spendMoney(" + amount + ")");
        boolean canSpend = Questioner.ask("Van a játékosnak elég pénze (" + amount + ") a tranzakcióhoz?");
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

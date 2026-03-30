package org.example.player;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.map.Map;
import org.example.map.Node;
import org.example.plowhead.PlowHead;
import org.example.plowhead.Sweeper;
import org.example.resource.Resource;
import org.example.vehicle.Vehicle;

/**
 * A játékos által vezérelt munkagép. A csomópontok között mozogva, az utakat
 * takarítja a felszerelt kotrófejjel a lépéspontjai terhére.
 */
public class Snowplow extends Vehicle {

    private PlowHead activeHead = new Sweeper();
    private Inventory inventory = new Inventory();

    private int remainingMoves;
    private Node currentNode;

    /**
     * Lecseréli az aktuálisan felszerelt kotrófejet a paraméterben kapott új
     * fejre.
     *
     * @param head Az újonnan felszerelt kotrófej
     */
    public void changeHead(PlowHead head) {
        Logger.call("Snowplow", "changeHead(head)");
        this.activeHead = head;
        Logger.retVoid();
    }

    /**
     * A hókotró átlép a megadott csomópontra. Áthaladás közben utasítja az utat
     * a takarításra, paraméterként átadva a saját kotrófejét.
     *
     * @param targetNode A cél csomópont
     * @param viaLane A sáv, amin keresztül halad
     * @return Igaz, ha a lépés sikeres volt.
     */
    public boolean move(Node targetNode, Lane viaLane) {
        Logger.call("Snowplow", "move(targetNode, viaLane)");

        boolean cleanSuccess = viaLane.clean(this.activeHead, this.inventory);

        boolean moveSuccess = false;
        if (cleanSuccess) {
            moveSuccess = viaLane.acceptVehicle(this);
        }

        Logger.ret("boolean", String.valueOf(moveSuccess));
        return moveSuccess;
    }

    /**
     * A járművektől örökölt move metódus. Hókotró esetén a specifikusabb mozgás
     * használatos.
     */
    @Override
    public boolean move(Map map) {
        return false;
    }

    /**
     * Hozzáadja a saját inventory-jához az adott nyersanyagot.
     *
     * @param type Nyersanyag típusa
     * @param amount Nyersanyag mennyisége
     */
    public void addResource(Resource type, int amount) {
        Logger.call("Snowplow", "addResource(type, amount)");
        Logger.retVoid();
    }
}

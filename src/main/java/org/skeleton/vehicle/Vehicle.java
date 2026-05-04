package org.skeleton.vehicle;

import org.skeleton.map.Lane;
import org.skeleton.map.Node;

/**
 * Absztrakt osztály a játékban szereplő járművek alapvető tulajdonságainak és viselkedésének leírására.
 */
public abstract class Vehicle {

    private Lane currentLane;
    private Node currentNode;
    private boolean isStuck;

    /**
     * Megpróbálja elmozdítani a járművet a megadott sávra.
     * @param destination A cél sáv.
     * @return true, ha a mozgás sikeres volt, egyébként false.
     */
    public boolean move(Lane destination) {
        if (isStuck) {
            return false;
        }
        if (destination.acceptVehicle(this)) {
            if (currentLane != null) {
                currentLane.removeVehicle(this);
            }
            currentLane = destination;
            return true;
        }
        return false;
    }

    /**
     * A jármű megcsúszik, aminek következtében beragad (isStuck = true).
     */
    public void slip() {
        this.isStuck = true;
    }

    /**
     * Kiszabadítja a járművet a beragadt állapotból.
     */
    public void free() {
        this.isStuck = false;
    }

    /**
     * A jármű balesetet szenved, aminek következtében beragad (isStuck = true).
     */
    public void crash() {
        this.isStuck = true;
    }

    /**
     * Visszaadja a csomópontot, ahol a jármű tartózkodik (ha épp egy csomóponton van).
     * @return A Node objektum.
     */
    public Node getCurrentNode() {
        return currentNode;
    }

    /**
     * Beállítja az aktuális csomópontot.
     * @param node A Node objektum.
     */
    public void setCurrentNode(Node node) {
        this.currentNode = node;
    }

    /**
     * Visszaadja a sávot, ahol a jármű tartózkodik.
     * @return A Lane objektum.
     */
    public Lane getCurrentLane() {
        return currentLane;
    }

    /**
     * Beállítja az aktuális sávot.
     * @param lane A Lane objektum.
     */
    public void setCurrentLane(Lane lane) {
        this.currentLane = lane;
    }

    /**
     * Ellenőrzi, hogy a jármű be van-e ragadva.
     * @return true, ha be van ragadva, egyébként false.
     */
    public boolean isStuck() {
        return this.isStuck;
    }
}

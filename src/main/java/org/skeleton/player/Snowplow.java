package org.skeleton.player;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.map.Node;
import org.skeleton.plowhead.PlowHead;
import org.skeleton.resource.Resource;
import org.skeleton.vehicle.Vehicle;

public class Snowplow extends Vehicle {

    private PlowHead activeHead;
    private Inventory inventory;
    private int remainingMoves;
    private final int MAX_MOVES = 3;

    public Snowplow() {
        this.inventory = new Inventory();
        this.remainingMoves = MAX_MOVES;
    }

    public void changeHead(PlowHead head) {
        if (this.activeHead != null) {
            inventory.addHead(this.activeHead);
        }
        this.activeHead = head;
        inventory.removeHead(head);
    }

    public boolean move(Node targetNode, Lane viaLane) {
        if (remainingMoves > 0) {
            remainingMoves--;
            viaLane.clean(activeHead, inventory);
            if (this.getCurrentLane() != null) {
                this.getCurrentLane().removeVehicle(this);
            }
            this.setCurrentLane(viaLane);
            this.setCurrentNode(targetNode);
            viaLane.acceptVehicle(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean move(Lane destination) {
        // A hókotrónál a csomópontos move van használatban az útvonaltakarítás miatt
        return super.move(destination);
    }

    public void addResource(Resource type, int amount) {
        inventory.addResource(type, amount);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void resetMoves() {
        this.remainingMoves = MAX_MOVES;
    }
}

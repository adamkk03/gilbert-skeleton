package org.skeleton.player;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.map.Node;
import org.skeleton.plowhead.PlowHead;
import org.skeleton.plowhead.Sweeper;
import org.skeleton.resource.Resource;
import org.skeleton.vehicle.Vehicle;

public class Snowplow extends Vehicle {

    private PlowHead activeHead;
    private Inventory inventory;
    private int remainingMoves;
    private Node currentNode;

    public Snowplow() {
        this.inventory = new Inventory();
        this.activeHead = new Sweeper();
    }

    public PlowHead getCurrentHead() {
        return activeHead;
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
            this.currentNode = targetNode;
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

    public void setCurrentNode(Node node) {
        this.currentNode = node;
    }
}

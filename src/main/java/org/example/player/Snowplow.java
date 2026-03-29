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

public class Snowplow extends Vehicle {

    private PlowHead activeHead = new Sweeper();
    private Inventory inventory = new Inventory();

    private int remainingMoves;
    private Node currentNode;

    public void changeHead(PlowHead head) {
        Logger.call("Snowplow", "changeHead(head)");
        this.activeHead = head;
        Logger.retVoid();
    }

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

    @Override
    public boolean move(Map map) {
        return false;
    }

    public void addResource(Resource type, int amount) {
        Logger.call("Snowplow", "addResource(type, amount)");
        Logger.retVoid();
    }
}

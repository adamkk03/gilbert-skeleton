package org.skeleton.vehicle;

import org.skeleton.map.Lane;
import org.skeleton.map.Node;
import org.skeleton.player.Player;

public class Bus extends Vehicle {

    private Player owner;
    private Node endpointA;
    private Node endpointB;
    private int completedTours;
    private int stuckCounter;

    public void playTurn(Lane destination) {
        if (stuckCounter > 0) {
            stuckCounter--;
            return;
        }
        if (this.move(destination)) {
            Node currentNode = this.getCurrentNode();
            if (currentNode != null && (currentNode.equals(endpointA) || currentNode.equals(endpointB))) {
                completedTours++;
            }
        }
    }

    @Override
    public void slip() {
        super.slip();
        this.stuckCounter = 3;
    }
}

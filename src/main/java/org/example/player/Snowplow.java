package org.example.player;

import org.example.Inventory;
import org.example.map.Lane;
import org.example.map.Node;
import org.example.plowhead.PlowHead;
import org.example.resource.Resource;

public class Snowplow {

    private Inventory inventory;
    private PlowHead activeHead;
    private int remainingMoves;
    private Node currentNode;

    public boolean move(Node targetNode, Lane vialane) {
        return false;
    }

    public void changeHead(PlowHead newHead) {
    }

    public void addResource(Resource type, int amount) {
    }
}

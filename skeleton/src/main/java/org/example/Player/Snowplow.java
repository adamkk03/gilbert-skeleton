package org.example.Player;

import org.example.Inventory;
import org.example.Map.Lane;
import org.example.Map.Node;
import org.example.Plowhead.PlowHead;
import org.example.Resource.Resource;

class Snowplow {
    private Inventory inventory;
    private PlowHead activeHead;
    private int remainingMoves;
    private Node currentNode;

    public boolean move(Node targetNode, Lane vialane) { return false; }
    public void changeHead(PlowHead newHead) {}
    public void addResource(Resource type, int amount) {}
}
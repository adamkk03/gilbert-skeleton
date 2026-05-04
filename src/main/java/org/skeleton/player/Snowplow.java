package org.skeleton.player;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.map.Node;
import org.skeleton.plowhead.PlowHead;
import org.skeleton.plowhead.Sweeper;
import org.skeleton.plowhead.Thrower;
import org.skeleton.resource.Resource;
import org.skeleton.vehicle.Vehicle;

/**
 * Specialized vehicle for cleaning snow from lanes.
 * Equipped with interchangeable plow heads and an inventory for resources.
 */
public class Snowplow extends Vehicle {

    /** The currently equipped plow head. */
    private PlowHead activeHead;
    /** The inventory for storing extra heads and resources. */
    private Inventory inventory;
    /** Remaining moves for the current turn. */
    private int remainingMoves;
    /** Maximum moves allowed per turn. */
    private final int MAX_MOVES = 3;
    /** The player who owns this snowplow. */
    private Player owner;

    /**
     * Constructs a new Snowplow with default equipment.
     */
    public Snowplow() {
        this.inventory = new Inventory();
        this.remainingMoves = MAX_MOVES;
        this.activeHead = new Thrower();
    }

    /**
     * Gets the currently active plow head.
     * @return The active plow head.
     */
    public PlowHead getCurrentHead() {
        return activeHead;
    }

    /**
     * Changes the active plow head.
     * The old head is moved to the inventory.
     * @param head The new head to equip.
     */
    public void changeHead(PlowHead head) {
        if (this.activeHead != null) {
            inventory.addHead(this.activeHead);
        }
        this.activeHead = head;
        inventory.removeHead(head);
    }

    /**
     * Moves the snowplow through a lane to a target node.
     * Cleans the lane during movement.
     * @param targetNode The destination node.
     * @param viaLane The lane used for travel.
     * @return true if movement was successful, false otherwise.
     */
    public boolean move(Node targetNode, Lane viaLane) {
        if (remainingMoves > 0) {
            remainingMoves--;
            boolean wasCleaned = viaLane.clean(activeHead, inventory);
            if (wasCleaned && owner != null) {
                owner.addMoney(100);
            }
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
        // Snowplows primarily use the node-based move for route cleaning
        return super.move(destination);
    }

    /**
     * Adds a resource to the snowplow's inventory.
     * @param type The resource type.
     * @param amount The amount to add.
     */
    public void addResource(Resource type, int amount) {
        inventory.addResource(type, amount);
    }

    /**
     * Gets the snowplow's inventory.
     * @return The inventory instance.
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Resets the movement points for a new turn.
     */
    public void resetMoves() {
        this.remainingMoves = MAX_MOVES;
    }

    /**
     * Sets the owner of this snowplow.
     * @param p The owner player.
     */
    public void setOwner(Player p) {
        this.owner = p;
    }
}

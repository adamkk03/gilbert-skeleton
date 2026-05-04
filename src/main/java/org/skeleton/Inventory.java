package org.skeleton;

import java.util.ArrayList;
import java.util.List;

import org.skeleton.plowhead.PlowHead;
import org.skeleton.resource.BioKerosene;
import org.skeleton.resource.Gravel;
import org.skeleton.resource.Resource;
import org.skeleton.resource.Salt;

/**
 * Represents the inventory of a snowplow or player.
 * Stores plow heads and resources like salt, kerosene, and gravel.
 */
public class Inventory {

    /** The salt resource storage. */
    private Resource salt;
    /** The bio-kerosene resource storage. */
    private Resource kerosene;
    /** The gravel resource storage. */
    private Resource gravel;
    /** List of stored plow heads. */
    private List<PlowHead> storedHeads;

    /**
     * Constructs a new empty inventory with initialized resources.
     */
    public Inventory() {
        this.storedHeads = new ArrayList<>();
        this.salt = new Salt();
        this.kerosene = new BioKerosene();
        this.gravel = new Gravel();
    }

    /**
     * Adds a plow head to the inventory.
     * @param h The plow head to add.
     */
    public void addHead(PlowHead h) {
        storedHeads.add(h);
    }

    /**
     * Removes a plow head from the inventory.
     * @param h The plow head to remove.
     */
    public void removeHead(PlowHead h) {
        storedHeads.remove(h);
    }

    /**
     * Consumes one unit of salt if available.
     * @return true if salt was consumed, false otherwise.
     */
    public boolean consumeSalt() {
        if (salt != null && !salt.isEmpty()) {
            salt.consume();
            return true;
        }
        return false;
    }

    /**
     * Consumes one unit of kerosene if available.
     * @return true if kerosene was consumed, false otherwise.
     */
    public boolean consumeKerosene() {
        if (kerosene != null && !kerosene.isEmpty()) {
            kerosene.consume();
            return true;
        }
        return false;
    }

    /**
     * Consumes one unit of gravel if available.
     * @return true if gravel was consumed, false otherwise.
     */
    public boolean consumeGravel() {
        if (gravel != null && !gravel.isEmpty()) {
            gravel.consume();
            return true;
        }
        return false;
    }

    /**
     * Adds a specified resource to the inventory.
     * @param type The type of resource to add.
     * @param amount The amount to add.
     */
    public void addResource(Resource type, int amount) {
        if (type != null) {
            type.fillInventory(this, amount);
        }
    }

    /**
     * Increases the amount of salt in the inventory.
     * @param amount The amount of salt to add.
     */
    public void addSalt(int amount) {
        if (this.salt != null) {
            this.salt.addAmount(amount);
        }
    }

    /**
     * Increases the amount of kerosene in the inventory.
     * @param amount The amount of kerosene to add.
     */
    public void addKerosene(int amount) {
        if (this.kerosene != null) {
            this.kerosene.addAmount(amount);
        }
    }

    /**
     * Increases the amount of gravel in the inventory.
     * @param amount The amount of gravel to add.
     */
    public void addGravel(int amount) {
        if (this.gravel != null) {
            this.gravel.addAmount(amount);
        }
    }
}

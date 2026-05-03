package org.skeleton.resource;

import org.skeleton.Inventory;

public class Gravel extends Resource {

    public Gravel() {
        this.amount = 10;
        this.price = 50;
    }

    @Override
    public void fillInventory(Inventory inv, int amount) {
        inv.addGravel(amount); // Visszaszól az Inventory-nak
    }
}

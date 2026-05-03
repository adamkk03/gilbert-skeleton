package org.skeleton.resource;

import org.skeleton.Inventory;

public class BioKerosene extends Resource {

    public BioKerosene() {
        this.amount = 10;
        this.price = 100;
    }

    @Override
    public void fillInventory(Inventory inv, int amount) {
        inv.addKerosene(amount); // Visszaszól az Inventory-nak
    }
}

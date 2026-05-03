package org.skeleton.resource;

import org.skeleton.Inventory;

public class Salt extends Resource {

    public Salt() {
        this.amount = 10;
        this.price = 50;
    }

    @Override
    public void fillInventory(Inventory inv, int amount) {
        inv.addSalt(amount);
    }
}

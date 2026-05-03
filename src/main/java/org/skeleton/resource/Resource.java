package org.skeleton.resource;

import org.skeleton.Inventory;

public abstract class Resource {

    protected int amount;
    protected int price;

    public void consume() {
        if (amount > 0) {
            amount--;
        }
    }

    public boolean isEmpty() {
        return amount <= 0;
    }

    public void addAmount(int extraAmount) {
        this.amount += extraAmount;
    }

    public abstract void fillInventory(Inventory inv, int amount);
}

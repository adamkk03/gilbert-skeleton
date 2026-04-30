package org.skeleton.resource;

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
}

package org.example.resource;

public abstract class Resource {

    protected int amount;
    protected int price;

    public void consume() {
    }

    public boolean isEmpty() {
        return false;
    }
}

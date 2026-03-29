package org.example.resource;

import org.example.Logger;

public abstract class Resource {

    protected int amount;
    protected int price;

    public void consume() {
        Logger.call(this.getClass().getSimpleName(), "consume()");
        if (amount > 0) {
            amount--;
        }
        Logger.retVoid();
    }

    public boolean isEmpty() {
        Logger.call(this.getClass().getSimpleName(), "isEmpty()");
        boolean empty = amount <= 0;
        Logger.ret("boolean", String.valueOf(empty));
        return empty;
    }
}

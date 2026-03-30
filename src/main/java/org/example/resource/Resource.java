package org.example.resource;

import org.example.Logger;

public abstract class Resource {

    protected int amount;
    protected int price;

    public void consume() {
        Logger.call(this.getClass().getSimpleName(), "consume()");
        Logger.retVoid();
    }

    public boolean isEmpty() {
        Logger.call(this.getClass().getSimpleName(), "isEmpty()");
        Logger.ret("boolean", "false");
        return false;
    }
}

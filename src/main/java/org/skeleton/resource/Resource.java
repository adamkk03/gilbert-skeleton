package org.skeleton.resource;

import org.skeleton.Logger;

/**
 * A speciális kotrófejek működéséhez szükséges fogyóeszközök absztrakt
 * ősosztálya.
 */
public abstract class Resource {

    protected int amount;
    protected int price;

    /**
     * Csökkenti a rendelkezésre álló mennyiséget használat során.
     */
    public void consume() {
        Logger.call(this.getClass().getSimpleName(), "consume()");
        if (amount > 0) {
            amount--;
        }
        Logger.retVoid();
    }

    /**
     * Visszaadja, hogy a nyersanyag elfogyott-e.
     * @return Igaz, ha az aktuális mennyiség 0 vagy kevesebb.
     */
    public boolean isEmpty() {
        Logger.call(this.getClass().getSimpleName(), "isEmpty()");
        boolean empty = amount <= 0;
        Logger.ret("boolean", String.valueOf(empty));
        return empty;
    }
}

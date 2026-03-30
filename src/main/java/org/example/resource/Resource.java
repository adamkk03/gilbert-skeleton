package org.example.resource;

import org.example.Logger;

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
        Logger.retVoid();
    }

    /**
     * Visszaadja, hogy a nyersanyag elfogyott-e.
     * @return Igaz, ha az aktuális mennyiség 0 vagy kevesebb.
     */
    public boolean isEmpty() {
        Logger.call(this.getClass().getSimpleName(), "isEmpty()");
        Logger.ret("boolean", "false");
        return false;
    }
}

package org.example;

import java.util.ArrayList;
import java.util.List;

import org.example.plowhead.PlowHead;
import org.example.resource.BioKerosene;
import org.example.resource.Resource;
import org.example.resource.Salt;

/**
 * A hókotróhoz tartozó tároló. Tárolja a speciális takarításhoz szükséges
 * megvásárolt nyersanyagokat (sót és biokerozint) és a kotrófejeket. Elzárja a
 * hókotró elől a nyersanyagokat, és kiszolgálja az éppen aktív kotrófejek
 * erőforrás-igényét a takarítás során, valamint tárolja a lecserélt fejeket.
 */
public class Inventory {

    private List<PlowHead> storedHeads = new ArrayList<>();
    private Salt salt = new Salt();
    private BioKerosene kerosene = new BioKerosene();

    /**
     * Új kotrófej felvétele a tárolóba (vásárláskor a Bolt hívja meg, vagy
     * fejcsere esetén a lecserélt fej kerül ide).
     *
     * @param h A hozzáadandó kotrófej
     */
    public void addHead(PlowHead h) {
        Logger.call("Inventory", "addHead(h)");
        Logger.retVoid();
    }

    /**
     * Kotrófej kivétele a tároló listájából (amikor a játékos felszereli azt a
     * gépre aktív fejként).
     *
     * @param h Az eltávolítandó kotrófej
     */
    public void removeHead(PlowHead h) {
        Logger.call("Inventory", "removeHead(h)");
        Logger.retVoid();
    }

    /**
     * Ellenőrzi a belső Salt objektumot, és ha van benne só, fogyaszt belőle,
     * majd true-val tér vissza.
     *
     * @return Igaz, ha sikeres volt a só fogyasztás
     */
    public boolean consumeSalt() {
        Logger.call("Inventory", "consumeSalt()");
        if (Questioner.ask("Van még elegendő só a raktárban?")) {
            Logger.ret("boolean", "true");
            return true;
        }
        Logger.ret("boolean", "false");
        return false;
    }

    /**
     * Ellenőrzi a belső BioKerosene objektumot, és ha van benne kerozin,
     * fogyaszt belőle, majd true-val tér vissza.
     *
     * @return Igaz, ha sikeres volt a kerozin fogyasztás
     */
    public boolean consumeKerosene() {
        Logger.call("Inventory", "consumeKerosene()");
        if (Questioner.ask("Van még elegendő kerozin a raktárban?")) {
            Logger.ret("boolean", "true");
            return true;
        }
        Logger.ret("boolean", "false");
        return false;
    }

    /**
     * A típus alapján a megfelelő belső nyersanyagon meghívja a hozzáadást.
     *
     * @param type A hozzáadandó nyersanyag típusa
     * @param amount A mennyiség
     */
    public void addResource(Resource type, int amount) {
        Logger.call("Inventory", "addResource(type, " + amount + ")");
        Logger.retVoid();
    }
}

package org.example;

import org.example.player.Player;
import org.example.player.Snowplow;
import org.example.plowhead.PlowHead;
import org.example.resource.Resource;

/**
 * A vásárlási tranzakciókért felelős hely. Közvetíti a játékos pénzköltését,
 * beszerzi és a megfelelő hókotrónak az inventory-jához rendeli az újonnan
 * vásárolt kotrófejeket vagy nyersanyagokat. Itt lehet több hókotrót is venni.
 */
public class Shop {

    /**
     * Levonja a fej árát a játékostól, és az újonnan megvásárolt kotrófejet a
     * megadott snowplow raktárába (Inventory) helyezi el.
     *
     * @param p A vásárló játékos
     * @param sp A hókotró, amire a fej kerül
     * @param newHead A megvásárolt új kotrófej
     */
    public void buyHead(Player p, Snowplow sp, PlowHead newHead) {
        Logger.call("Shop", "buyHead(p, sp, newHead)");
        if (p != null && p.spendMoney(100)) {
            if (sp != null) {
                sp.changeHead(newHead);
            }
        }
        Logger.retVoid();
    }

    /**
     * Levonja a nyersanyag árát a játékostól, és az újonnan megvásárolt
     * nyersanyagokat a megadott snowplow raktárába (Inventory) helyezi el.
     *
     * @param p A vásárló játékos
     * @param sp A hókotró, ami a nyersanyagot kapja
     * @param type A nyersanyag típusa
     * @param amount A mennyiség
     */
    public void buyResource(Player p, Snowplow sp, Resource type, int amount) {
        Logger.call("Shop", "buyResource(p, sp, type, amount)");
        if (p != null && p.spendMoney(50)) {
            if (sp != null) {
                sp.addResource(type, amount);
            }
        }
        Logger.retVoid();
    }

    /**
     * Új hókotró vásárlása az adott játékos számára.
     *
     * @param p A vásárló játékos
     */
    public void buySnowplow(Player p) {
        Logger.call("Shop", "buySnowplow(p)");
        if (p != null && p.spendMoney(500)) {
            p.addSnowplow(new Snowplow());
        }
        Logger.retVoid();
    }
}

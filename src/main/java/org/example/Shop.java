package org.example;

import org.example.Logger;
import org.example.player.Player;
import org.example.player.Snowplow;
import org.example.plowhead.PlowHead;
import org.example.resource.Resource;

public class Shop {

    public void buyHead(Player p, Snowplow sp, PlowHead newHead) {
        Logger.call("Shop", "buyHead(p, sp, newHead)");
        // A 7. SD (Vásárlás a boltban) alapján levonódik a pénz
        if (p != null && p.spendMoney(100)) {  // Dummy ár
            if (sp != null) {
                sp.changeHead(newHead);
            }
        }
        Logger.retVoid();
    }

    public void buyResource(Player p, Snowplow sp, Resource type, int amount) {
        Logger.call("Shop", "buyResource(p, sp, type, amount)");
        // Levonódik a pénz és hozzáadódik az erőforrás
        if (p != null && p.spendMoney(amount * 10)) {  // Dummy ár
            if (sp != null) {
                sp.addResource(type, amount);
            }
        }
        Logger.retVoid();
    }

    public void buySnowplow(Player p) {
        Logger.call("Shop", "buySnowplow(p)");
        // A 7. SD (Hókotró vásárlása) alapján levonódik a pénz
        if (p != null && p.spendMoney(500)) {  // Dummy ár
            Snowplow newSp = new Snowplow();
            p.addSnowplow(newSp);
        }
        Logger.retVoid();
    }
}

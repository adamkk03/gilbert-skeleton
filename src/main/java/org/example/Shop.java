package org.example;

import org.example.player.Player;
import org.example.player.Snowplow;
import org.example.plowhead.PlowHead;
import org.example.resource.Resource;

public class Shop {

    public void buyHead(Player p, Snowplow sp, PlowHead newHead) {
        Logger.call("Shop", "buyHead(p, sp, newHead)");
        if (p != null && p.spendMoney(100)) {
            if (sp != null) {
                sp.changeHead(newHead);
            }
        }
        Logger.retVoid();
    }

    public void buyResource(Player p, Snowplow sp, Resource type, int amount) {
        Logger.call("Shop", "buyResource(p, sp, type, amount)");
        if (p != null && p.spendMoney(50)) {
            if (sp != null) {
                sp.addResource(type, amount);
            }
        }
        Logger.retVoid();
    }

    public void buySnowplow(Player p) {
        Logger.call("Shop", "buySnowplow(p)");
        if (p != null && p.spendMoney(500)) {
            p.addSnowplow(new Snowplow());
        }
        Logger.retVoid();
    }
}

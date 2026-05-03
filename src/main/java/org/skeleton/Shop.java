package org.skeleton;

import org.skeleton.player.Player;
import org.skeleton.player.Snowplow;
import java.util.HashMap;

public class Shop {

    private java.util.Map<String, Integer> prices;

    public Shop() {
        prices = new HashMap<>();
    }

    public boolean buySnowplow(Player p) {
        Integer price = prices.get("Snowplow");
        if (price != null && p.spendMoney(price)) {
            Snowplow newSp = new Snowplow();
            p.addSnowplow(newSp);
            return true;
        }
        return false;
    }

    public boolean sellEquipment(Player p, String itemType) {
        Integer price = prices.get(itemType);
        if (price != null && p.spendMoney(price)) {
            return true;
        }
        return false;
    }

    public void fillInventory() {
        prices.put("Snowplow", 5000);
        prices.put("Sweeper", 1000);
        prices.put("Thrower", 1500);
        prices.put("Icebreaker", 2000);
        prices.put("Salter", 2500);
        prices.put("Graveler", 2500);
        prices.put("Dragon", 3000);
        prices.put("Salt", 50);
        prices.put("Biokerosene", 100);
        prices.put("Gravel", 50);
    }
}

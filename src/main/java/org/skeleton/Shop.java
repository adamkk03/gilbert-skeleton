package org.skeleton;

import org.skeleton.player.Player;
import org.skeleton.player.Snowplow;
import java.util.HashMap;

/**
 * Represents the equipment shop in the game.
 * Players can purchase snowplows, plow heads, and resources here.
 */
public class Shop {

    /** Map of item names to their prices. */
    private java.util.Map<String, Integer> prices;

    /**
     * Constructs a new empty Shop.
     */
    public Shop() {
        prices = new HashMap<>();
    }

    /**
     * Purchases a new snowplow for a player.
     * @param p The player making the purchase.
     * @return true if the purchase was successful, false otherwise.
     */
    public boolean buySnowplow(Player p) {
        Integer price = prices.get("Snowplow");
        if (price != null && p.spendMoney(price)) {
            Snowplow newSp = new Snowplow();
            p.addSnowplow(newSp);
            return true;
        }
        return false;
    }

    /**
     * Sells equipment or resources to a player.
     * @param p The player making the purchase.
     * @param itemType The type of item to purchase.
     * @return true if the purchase was successful, false otherwise.
     */
    public boolean sellEquipment(Player p, String itemType) {
        Integer price = prices.get(itemType);
        if (price != null && p.spendMoney(price)) {
            return true;
        }
        return false;
    }

    /**
     * Fills the shop inventory with default items and prices.
     */
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

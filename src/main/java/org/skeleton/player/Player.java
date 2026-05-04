package org.skeleton.player;

import java.util.ArrayList;
import java.util.List;

import org.skeleton.map.Lane;
import org.skeleton.map.Node;
import org.skeleton.plowhead.*;
import org.skeleton.vehicle.Bus;

/**
 * Represents a player in the game.
 * Manages the player's assets, score, and actions (moving bus and snowplows).
 */
public class Player {

    /** The name of the player. */
    private String name;
    /** The amount of money the player currently has. */
    private int money;
    /** The current score of the player. */
    private int score;
    /** List of snowplows owned by the player. */
    private List<Snowplow> snowplows;
    /** The bus used by the player for transportation. */
    private Bus bus;

    /**
     * Constructs a new Player with a given name.
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.snowplows = new ArrayList<>();
    }

    /**
     * Moves the player's bus to a destination lane.
     * @param destination The target lane.
     */
    public void moveBus(Lane destination) {
        if (this.bus != null) {
            this.bus.playTurn(destination);
        }
    }

    /**
     * Moves a specific snowplow owned by the player.
     * @param sp The snowplow to move.
     * @param target The target node.
     * @param via The lane used for the movement.
     */
    public void moveSnowplow(Snowplow sp, Node target, Lane via) {
        sp.move(target, via);
    }

    /**
     * Adds a snowplow to the player's collection.
     * @param sp The snowplow to add.
     */
    public void addSnowplow(Snowplow sp) {
        snowplows.add(sp);
        sp.setOwner(this);
    }

    /**
     * Attempts to spend a certain amount of money.
     * @param amount The amount to spend.
     * @return true if the player had enough money, false otherwise.
     */
    public boolean spendMoney(int amount) {
        if (money >= amount) {
            money -= amount;
            return true;
        }
        return false;
    }

    /**
     * Gets the player's name.
     * @return The name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the player's current balance.
     * @return The amount of money.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Adds money to the player's balance.
     * @param amount The amount to add.
     */
    public void addMoney(int amount) {
        this.money += amount;
    }

    /**
     * Gets the player's current score.
     * @return The score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Adds to the player's score.
     * @param amount The amount to add.
     */
    public void addScore(int amount) {
        this.score += amount;
    }

    /**
     * Resets player state for a new turn.
     */
    public void resetState() {
        // Reset movement points and other per-turn values
        for (Snowplow sp : snowplows) {
            sp.resetMoves();
        }
    }

    /**
     * Adds equipment to a specific snowplow.
     * @param sp The snowplow to equip.
     * @param itemType The type of equipment (e.g., "salter", "sweeper").
     */
    public void addEquipment(Snowplow sp, String itemType) {
        PlowHead newHead = switch (itemType.toLowerCase()) {
            case "salter" -> new Salter();
            case "sweeper" -> new Sweeper();
            case "thrower" -> new Thrower();
            case "dragon" -> new Dragon();
            case "icebreaker" -> new Icebreaker();
            case "graveler" -> new Graveler();
            default -> null;
        };

        if (newHead != null && snowplows.contains(sp)) {
            sp.getInventory().addHead(newHead);
        }
    }
}

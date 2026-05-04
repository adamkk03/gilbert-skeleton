package org.skeleton;

import org.skeleton.map.Map;
import org.skeleton.map.Road;
import org.skeleton.map.Lane;
import org.skeleton.player.Player;
import org.skeleton.vehicle.Car;
import org.skeleton.vehicle.Vehicle;

import java.util.List;

/**
 * Controller class for the snowplow game.
 * Manages the game loop, turns, weather generation, and win conditions.
 */
public class Game {

    /** List of players participating in the game. */
    private List<Player> players;
    /** The game map containing nodes, roads, and lanes. */
    private Map map;
    /** The shop where players can buy equipment. */
    private Shop shop;
    /** Indicates if the game is currently running. */
    private boolean isRunning;
    /** Index of the player whose turn it currently is. */
    private int activePlayerIndex;
    /** Counter for the number of turns passed. */
    private int turnCounter = 0;
    /** Maximum number of turns before the game ends. */
    private final int MAX_TURNS = 100;
    /** Score limit required to win the game. */
    private final int WINNING_SCORE_LIMIT = 1000;

    /**
     * Constructs a new Game instance.
     * 
     * @param players List of players in the game.
     * @param map     The game map.
     * @param shop    The equipment shop.
     */
    public Game(List<Player> players, Map map, Shop shop) {
        this.players = players;
        this.map = map;
        this.shop = shop;
    }

    /**
     * Initializes and starts the game.
     * Resets player states, generates the map, and fills the shop inventory.
     */
    public void startGame() {
        for (Player player : players) {
            player.resetState();
        }
        map.generate();
        shop.fillInventory();
        activePlayerIndex = 0;
        isRunning = true;
    }

    /**
     * Advances the game to the next turn.
     * If all players have moved, it processes NPCs, weather, and checks win
     * conditions.
     */
    public void nextTurn() {
        activePlayerIndex++;
        if (activePlayerIndex >= players.size()) {
            activePlayerIndex = 0;
            turnCounter++;
            moveNPCs();
            generateWeather();
            if (checkWinCondition()) {
                isRunning = false;
                endGame();
            }
        }
    }

    /**
     * Moves non-player characters (NPCs) like cars towards their destinations.
     */
    private void moveNPCs() {
        for (Car car : map.getCars()) {
            car.moveTowardsDestination(map);
        }
    }

    /**
     * Generates snow on all lanes of the map to simulate weather effects.
     */
    private void generateWeather() {
        for (Road road : map.getRoads()) {
            for (Lane lane : road.getLanes()) {
                lane.addSnow(1);
            }
        }
    }

    /**
     * Checks if any win condition has been met (score limit or turn limit).
     * 
     * @return true if the game should end, false otherwise.
     */
    private boolean checkWinCondition() {
        for (Player p : players) {
            if (p.getScore() >= WINNING_SCORE_LIMIT) {
                return true;
            }
        }
        if (turnCounter >= MAX_TURNS) {
            return true;
        }
        return false;
    }

    /**
     * Finalizes the game, identifies the winner, and prints the results.
     */
    private void endGame() {
        Player winner = null;
        for (Player p : players) {
            if (winner == null || p.getScore() > winner.getScore()) {
                winner = p;
            }
        }

        if (winner != null) {
            System.out.println(
                    "A játék véget ért! A győztes: " + winner.getName() + " with " + winner.getScore() + " ponttal.");
        } else {
            System.out.println("A játék véget ért! Nincs győztes.");
        }
    }

    /**
     * Gets the equipment shop.
     * 
     * @return The shop instance.
     */
    public Shop getShop() {
        return shop;
    }
}

package org.skeleton;

import org.skeleton.map.Map;
import org.skeleton.map.Road;
import org.skeleton.map.Lane;
import org.skeleton.player.Player;
import org.skeleton.vehicle.Car;
import org.skeleton.vehicle.Vehicle;

import java.util.List;

public class Game {

    private List<Player> players;
    private Map map;
    private Shop shop;
    private boolean isRunning;
    private int activePlayerIndex;
    private int turnCounter = 0;
    private final int MAX_TURNS = 100;
    private final int WINNING_SCORE_LIMIT = 1000;

    public Game(List<Player> players, Map map, Shop shop) {
        this.players = players;
        this.map = map;
        this.shop = shop;
    }

    public void startGame() {
        for (Player player : players) {
            player.resetState();
        }
        map.generate();
        shop.fillInventory();
        activePlayerIndex = 0;
        isRunning = true;
    }

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

    private void moveNPCs() {
        for (Car car : map.getCars()) {
            car.moveTowardsDestination(map);
        }
    }

    private void generateWeather() {
        for (Road road : map.getRoads()) {
            for (Lane lane : road.getLanes()) {
                lane.addSnow(1);
            }
        }
    }

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

    private void endGame() {
        Player winner = null;
        for (Player p : players) {
            if (winner == null || p.getScore() > winner.getScore()) {
                winner = p;
            }
        }

        if (winner != null) {
            // Megjegyzés: Ehhez a Player osztályba be kell tenni a getName() metódust!
            System.out.println("A játék véget ért! A győztes: " + winner.getName() + " " + winner.getScore() + " ponttal.");
        } else {
            System.out.println("A játék véget ért! Nincs győztes.");
        }
    }

    public Shop getShop() {
        return shop;
    }
}

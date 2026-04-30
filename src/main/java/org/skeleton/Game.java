package org.skeleton;

import org.skeleton.map.Map;
import org.skeleton.map.Road;
import org.skeleton.map.Lane;
import org.skeleton.player.Player;
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
        for (Vehicle car : map.getCars()) {
            Lane nextLane = map.getShortestPath(car.getCurrentNode(), ((org.skeleton.vehicle.Car) car).getWorkplace());
            if (nextLane != null) {
                car.move(nextLane);
            }
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
        System.out.println("A játék véget ért!");
    }

    public Shop getShop() {
        return shop;
    }
}

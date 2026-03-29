package org.example;

import java.util.ArrayList;
import java.util.List;

import org.example.Logger;
import org.example.map.Map;
import org.example.player.Player;

public class Game {

    private Map map;
    private List<Player> players = new ArrayList<>();
    private Shop shop;

    public void startGame() {
        Logger.call("Game", "startGame()");
        // A rendszer inicializálása
        map = new Map();
        shop = new Shop();
        // Játékosok létrehozása
        Player player1 = new Player();
        players.add(player1);
        Logger.retVoid();
    }

    public void passTurn() {
        Logger.call("Game", "passTurn()");
        // A kör léptetése: időjárás, NPC mozgás
        if (map != null) {
            map.weatherTick();
            map.moveNPCs();
        }
        Logger.retVoid();
    }
}

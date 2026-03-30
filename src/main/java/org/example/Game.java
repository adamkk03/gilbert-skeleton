package org.example;

import java.util.ArrayList;
import java.util.List;

import org.example.map.Map;
import org.example.player.Player;

/**
 * A játékmenet átfogó vezérléséért felelős fogalom. Számon tartja a
 * résztvevőket, fogadja a felhasználói cselekvéseket, és a körök végén
 * elindítja a havazást, valamint a városi forgalom (NPC-k) mozgását.
 */
public class Game {

    private Map map;
    private List<Player> players = new ArrayList<>();
    private Shop shop;

    /**
     * A rendszer inicializálását végző belépési pont. Létrehozza a Shop-ot és a
     * Map-et, utasítja a térképet a felépülésre, majd létrehozza a játékosokat,
     * elhelyezi a buszokat/hókotrókat és az NPC járműveket a kezdőpozícióikra.
     */
    public void startGame() {
        Logger.call("Game", "startGame()");
        map = new Map();
        shop = new Shop();
        Player player1 = new Player();
        players.add(player1);
        Logger.retVoid();
    }

    /**
     * A kontroller hívja meg a kör végén. Elindítja a térképen a havazást, majd
     * lépteti az NPC járműveket, majd odaadja a playernek az irányítást.
     */
    public void passTurn() {
        Logger.call("Game", "passTurn()");
        if (map != null) {
            map.weatherTick();
            map.moveNPCs();
        }
        Logger.retVoid();
    }
}

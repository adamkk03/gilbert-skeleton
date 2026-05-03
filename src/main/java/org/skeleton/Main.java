package org.skeleton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.skeleton.map.Lane;
import org.skeleton.map.Node;
import org.skeleton.map.Road;
import org.skeleton.player.Player;
import org.skeleton.player.Snowplow;
import org.skeleton.plowhead.Dragon;
import org.skeleton.plowhead.Graveler;
import org.skeleton.plowhead.Icebreaker;
import org.skeleton.plowhead.Salter;
import org.skeleton.plowhead.Sweeper;
import org.skeleton.plowhead.Thrower;
import org.skeleton.surface.BlockedSurface;
import org.skeleton.surface.CleanSurface;
import org.skeleton.surface.IcySurface;
import org.skeleton.surface.SnowySurface;
import org.skeleton.vehicle.Car;
import org.skeleton.vehicle.Vehicle;

public class Main {

    // Globális regiszterek az objektumok azonosítók kollekciójához
    private static HashMap<String, Node> nodes = new HashMap<>();
    private static HashMap<String, Road> roads = new HashMap<>();
    private static HashMap<String, Lane> lanes = new HashMap<>();
    private static HashMap<String, Vehicle> vehicles = new HashMap<>();
    private static HashMap<String, Player> players = new HashMap<>();
    private static HashMap<String, Snowplow> snowplows = new HashMap<>();

    private static boolean isRandomOn = true;

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("      Snowplow Game Prototípus - Tesztkörnyezet  ");
        System.out.println("=================================================");
        System.out.println("A rendszer inicializálása megtörtént. A tesztadatok betöltve.");
        System.out.println("Írd be, hogy 'help' az elérhető parancsok listájához.");
        System.out.println("=================================================\n");

        // Teszteléshez néhány alap objektum inicializálása
        setupMockData();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line;
            System.out.print("> ");
            while ((line = reader.readLine()) != null) {
                processCommand(line.trim());
                System.out.print("> "); // Prompt jelzés a következő parancshoz
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processCommand(String line) {
        if (line.isEmpty() || line.startsWith("#")) {
            return; // Üres sorok és kommentek átugrása
        }
        String[] parts = line.split("\\s+");
        String cmd = parts[0].toLowerCase();

        try {
            switch (cmd) {
                case "help":
                    handleHelp();
                    break;
                case "node":
                    nodes.put(parts[1], new Node());
                    break;
                case "road":
                    handleRoad(parts);
                    break;
                case "surface":
                    handleSurface(parts);
                    break;
                case "snow":
                    handleSnow(parts);
                    break;
                case "modifier":
                    handleModifier(parts);
                    break;
                case "load":
                    handleLoad(parts[1]);
                    break;
                case "move":
                    handleMove(parts);
                    break;
                case "stat":
                    handleStat(parts[1]);
                    break;
                case "equip":
                    handleEquip(parts);
                    break;
                case "weather":
                    handleWeather(parts);
                    break;
                case "set_money":
                    handleSetMoney(parts);
                    break;
                case "buy":
                    handleBuy(parts);
                    break;
                case "random":
                    isRandomOn = !parts[1].equalsIgnoreCase("off");
                    System.out.println("Véletlenszerűség beállítva: " + (isRandomOn ? "ON" : "OFF"));
                    break;
                case "exit":
                case "quit":
                    System.out.println("Kilépés...");
                    System.exit(0);
                    break;
                default:
                    System.out
                            .println("Ismeretlen parancs: '" + cmd + "'. Írd be, hogy 'help' a parancsok listájához.");
            }
        } catch (Exception e) {
            System.out.println("Hiba a parancs végrehajtása közben: " + line);
            System.out.println("Ellenőrizd a szintaxist! (Írd be: 'help')");
        }
    }

    private static void handleHelp() {
        System.out.println("\n--- Elérhető parancsok ---");
        System.out.println("Pályaépítés:");
        System.out.println("  node <id>                                     - Létrehoz egy csomópontot.");
        System.out
                .println("  road <id> <nodeA> <nodeB> <sávok_száma>       - Létrehoz egy utat a két csomópont között.");
        System.out.println(
                "  surface <út_id> <sáv_index> <felület_típus>   - Beállítja a sáv felületét (IcySurface, SnowySurface, BlockedSurface, CleanSurface).");
        System.out.println("  snow <út_id> <sáv_index> <vastagság>          - Havat ad az adott sávhoz.");
        System.out.println("  modifier <út_id> <sáv_index> <gravel|salt>    - Zúzalékot vagy sót tesz a sávra.");
        System.out.println("\nJátékmenet és tesztelés:");
        System.out.println(
                "  load <fájlnév>                                - Parancsok beolvasása és futtatása txt fájlból.");
        System.out.println("  move <jármű_id> <sáv_id>                      - Jármű mozgatása a megadott sávra.");
        System.out.println(
                "  equip <hókotró_id> <fej_típus>                - Kotrófej felszerelése (salter, sweeper, thrower, dragon, icebreaker, graveler).");
        System.out.println(
                "  weather <mennyiség>                           - Minden sávra esik a megadott mennyiségű hó.");
        System.out.println("  set_money <játékos_id> <összeg>               - Játékos egyenlegének beállítása.");
        System.out.println("  buy <játékos_id> head <hókotró_id> <típus>    - Új fej vásárlása egy adott hókotróra.");
        System.out.println("\nLekérdezés és Rendszer:");
        System.out.println(
                "  stat <objektum_id>                            - Objektum (jármű, sáv, játékos) állapotának lekérdezése.");
        System.out.println("  random <on|off>                               - Véletlenszerűség be- vagy kikapcsolása.");
        System.out.println("  help                                          - Ez a súgó.");
        System.out.println("  exit / quit                                   - Kilépés a programból.");
        System.out.println("--------------------------\n");
    }

    private static void handleRoad(String[] parts) {
        String id = parts[1];
        Node nA = nodes.get(parts[2]);
        Node nB = nodes.get(parts[3]);
        int laneCount = Integer.parseInt(parts[4]);

        Road r = new Road(nA, nB);
        roads.put(id, r);

        for (int i = 1; i <= laneCount; i++) {
            Lane l = new Lane();
            r.getLanes().add(l);
            lanes.put(id + "_lane_" + i, l);
        }
    }

    private static void handleSurface(String[] parts) {
        Lane l = lanes.get(parts[1] + "_lane_" + parts[2]);
        if (l == null) {
            return;
        }

        switch (parts[3].toLowerCase()) {
            case "icysurface":
                l.setSurface(new IcySurface());
                break;
            case "snowysurface":
                l.setSurface(new SnowySurface());
                break;
            case "blockedsurface":
                l.setSurface(new BlockedSurface());
                break;
            case "cleansurface":
                l.setSurface(new CleanSurface());
                break;
        }
    }

    private static void handleSnow(String[] parts) {
        Lane l = lanes.get(parts[1] + "_lane_" + parts[2]);
        if (l != null) {
            l.addSnow(Integer.parseInt(parts[3]));
        }
    }

    private static void handleModifier(String[] parts) {
        Lane l = lanes.get(parts[1] + "_lane_" + parts[2]);
        if (l != null) {
            if (parts[3].equalsIgnoreCase("gravel")) {
                l.setGraveled(true);
            }
            if (parts[3].equalsIgnoreCase("salt")) {
                l.setSalted(true);
            }
        }
    }

    private static void handleMove(String[] parts) {
        Vehicle v = vehicles.get(parts[1]);
        Lane dest = lanes.get(parts[2]);
        if (v != null && dest != null) {
            v.move(dest);
        }
    }

    private static void handleEquip(String[] parts) {
        Snowplow sp = snowplows.get(parts[1]);
        if (sp != null) {
            switch (parts[2].toLowerCase()) {
                case "salter":
                    sp.changeHead(new Salter());
                    break;
                case "sweeper":
                    sp.changeHead(new Sweeper());
                    break;
                case "thrower":
                    sp.changeHead(new Thrower());
                    break;
                case "dragon":
                    sp.changeHead(new Dragon());
                    break;
                case "icebreaker":
                    sp.changeHead(new Icebreaker());
                    break;
                case "graveler":
                    sp.changeHead(new Graveler());
                    break;
            }
        }
    }

    private static void handleWeather(String[] parts) {
        int amount = Integer.parseInt(parts[1]);
        for (Lane l : lanes.values()) {
            l.addSnow(amount);
        }
    }

    private static void handleSetMoney(String[] parts) {
        Player p = players.get(parts[1]);
        if (p != null) {
            p.addMoney(Integer.parseInt(parts[2]) - p.getMoney());
        }
    }

    private static void handleBuy(String[] parts) {
        Player p = players.get(parts[1]);
        Snowplow sp = snowplows.get(parts[3]);
        if (p != null && sp != null) {
            if (p.spendMoney(1000)) {
                sp.changeHead(new Thrower());
            }
        }
    }

    private static void handleLoad(String filename) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                // A betöltött parancsokat is végrehajtjuk, mintha a felhasználó gépelte volna
                // be
                System.out.println("Futtatás: " + line);
                processCommand(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Nem található a fájl: " + filename);
        }
    }

    private static void handleStat(String id) {
        if (vehicles.containsKey(id)) {
            Vehicle v = vehicles.get(id);
            String laneId = getLaneId(v.getCurrentLane());
            System.out.println(id + ": position=" + laneId + ", isStuck=" + v.isStuck());
        } else if (lanes.containsKey(id)) {
            Lane l = lanes.get(id);
            String surfaceName = l.getSurface().getClass().getSimpleName();
            System.out.println(id + ": surface=" + surfaceName + ", isGraveled=" + l.isGraveled()
                    + ", isSalted=" + l.isSalted() + ", snowThickness=" + l.getSnowThickness());
        } else if (players.containsKey(id)) {
            Player p = players.get(id);
            System.out.println(id + ": money=" + p.getMoney());
        } else if (snowplows.containsKey(id)) {
            System.out.println(id + ": activeHead=CurrentHead");
        } else {
            System.out.println("Nincs ilyen objektum: " + id);
        }
    }

    private static String getLaneId(Lane l) {
        for (java.util.Map.Entry<String, Lane> entry : lanes.entrySet()) {
            if (entry.getValue().equals(l)) {
                return entry.getKey();
            }
        }
        return "null";
    }

    private static void setupMockData() {
        lanes.put("lane_1", new Lane());
        lanes.put("lane_2", new Lane());

        Car car1 = new Car();
        car1.setCurrentLane(lanes.get("lane_1"));
        vehicles.put("car1", car1);

        Snowplow sp1 = new Snowplow();
        vehicles.put("sp1", sp1);
        snowplows.put("sp1", sp1);

        players.put("player1", new Player("Player 1"));
    }
}

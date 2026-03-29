package org.example;

import java.util.Scanner;

import org.example.map.Lane;
import org.example.map.Map;
import org.example.map.Node;
import org.example.player.Player;
import org.example.player.Snowplow;
import org.example.plowhead.Dragon;
import org.example.plowhead.Icebreaker;
import org.example.plowhead.Salter;
import org.example.plowhead.Sweeper;
import org.example.plowhead.Thrower;
import org.example.resource.Salt;
import org.example.vehicle.Car;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n--- Szkeleton Teszt Menü ---");
            System.out.println("1. Hókotró takarít (Söprő fejjel)");
            System.out.println("2. Hókotró takarít (Hányó fejjel)");
            System.out.println("3. Hókotró jeget tör");
            System.out.println("4. Hókotró sót szór");
            System.out.println("5. Hókotró havat olvaszt sárkány fejjel");
            System.out.println("6. Autó letapossa a havat");
            System.out.println("7. Autó elakad a hóban");
            System.out.println("8. Jármű megcsúszik a jégen");
            System.out.println("9. Havazás");
            System.out.println("10. Só elolvasztja a jeget");
            System.out.println("11. Játékos felszerelést vásárol");
            System.out.println("12. Elakadt autó továbbhalad");
            System.out.println("13. Busz útvonalat választ");
            System.out.println("14. Hókotró sávot választ takarításra");
            System.out.println("0. Kilépés");
            System.out.print("Válassz egy tesztesetet (0-14): ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Kérlek számot adj meg!");
                continue;
            }

            switch (choice) {
                case 1:
                    runSoproFejTeszt();
                    break;
                case 2:
                    runHanyoFejTeszt();
                    break;
                case 3:
                    runJegtoroTeszt();
                    break;
                case 4:
                    runSoSzoroTeszt();
                    break;
                case 5:
                    runSarkanyFejTeszt();
                    break;
                case 6:
                    runAutoLetapossaHavatTeszt();
                    break;
                case 7:
                    runAutoElakadHobanTeszt();
                    break;
                case 8:
                    runJarmuMegcsuszikJegenTeszt();
                    break;
                case 9:
                    runHavazasTeszt();
                    break;
                case 10:
                    runSoElolvasztjaJegetTeszt();
                    break;
                case 11:
                    runJatekosFelszerelestVasarolTeszt();
                    break;
                case 12:
                    runElakadtAutoTovabbhaladTeszt();
                    break;
                case 13:
                    runBuszUtvonalatValasztTeszt();
                    break;
                case 14:
                    runHokotroSavotValasztTeszt();
                    break;
                case 0:
                    System.out.println("Kilépés...");
                    break;
                default:
                    System.out.println("Érvénytelen választás!");
            }
        }
    }

    private static void runSoproFejTeszt() {
        System.out.println("\n--- 1. Hókotró takarít (Söprő fejjel) indítása ---");
        Snowplow sp = new Snowplow();
        sp.changeHead(new Sweeper());
        Node node = new Node();
        Lane l2 = new Lane();
        sp.move(node, l2);
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runHanyoFejTeszt() {
        System.out.println("\n--- 2. Hókotró takarít (Hányó fejjel) indítása ---");
        Snowplow sp = new Snowplow();
        sp.changeHead(new Thrower());
        Node node = new Node();
        Lane l2 = new Lane();
        sp.move(node, l2);
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runJegtoroTeszt() {
        System.out.println("\n--- 3. Hókotró jeget tör indítása ---");
        Snowplow sp = new Snowplow();
        sp.changeHead(new Icebreaker());
        Node node = new Node();
        Lane l3 = new Lane();
        sp.move(node, l3);
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runSoSzoroTeszt() {
        System.out.println("\n--- 4. Hókotró sót szór indítása ---");
        Snowplow sp = new Snowplow();
        sp.changeHead(new Salter());
        Node node = new Node();
        Lane l2 = new Lane();
        sp.move(node, l2);
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runSarkanyFejTeszt() {
        System.out.println("\n--- 5. Hókotró havat olvaszt sárkány fejjel indítása ---");
        Snowplow sp = new Snowplow();
        sp.changeHead(new Dragon());
        Node node = new Node();
        Lane l2 = new Lane();
        sp.move(node, l2);
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runAutoLetapossaHavatTeszt() {
        System.out.println("\n--- 6. Autó letapossa a havat indítása ---");
        Car car = new Car();
        Map map = new Map();
        car.move(map);
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runAutoElakadHobanTeszt() {
        System.out.println("\n--- 7. Autó elakad a hóban indítása ---");
        Car car = new Car();
        Map map = new Map();
        car.move(map);
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runJarmuMegcsuszikJegenTeszt() {
        System.out.println("\n--- 8. Jármű megcsúszik a jégen indítása ---");
        Car car = new Car();
        Map map = new Map();
        car.move(map);
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runHavazasTeszt() {
        System.out.println("\n--- 9. Havazás indítása ---");
        Map map = new Map();
        map.weatherTick();
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runSoElolvasztjaJegetTeszt() {
        System.out.println("\n--- 10. Só elolvasztja a jeget indítása ---");
        Map map = new Map();
        map.weatherTick();
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runJatekosFelszerelestVasarolTeszt() {
        System.out.println("\n--- 11. Játékos felszerelést vásárol indítása ---");
        Player player = new Player();
        Shop shop = new Shop();
        Snowplow sp = new Snowplow();
        Salt salt = new Salt();
        shop.buyResource(player, sp, salt, 1);
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runElakadtAutoTovabbhaladTeszt() {
        System.out.println("\n--- 12. Elakadt autó továbbhalad indítása ---");
        Snowplow sp = new Snowplow();
        Node node = new Node();
        Lane lane = new Lane();
        sp.move(node, lane);
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runBuszUtvonalatValasztTeszt() {
        System.out.println("\n--- 13. Busz útvonalat választ indítása ---");
        Player player = new Player();
        player.moveBus();
        System.out.println("--- Teszt vége ---\n");
    }

    private static void runHokotroSavotValasztTeszt() {
        System.out.println("\n--- 14. Hókotró sávot választ takarításra indítása ---");
        Player player = new Player();
        Snowplow sp = new Snowplow();
        Node targetNode = new Node();
        Lane viaLane = new Lane();
        player.moveSnowplow(sp, targetNode, viaLane);
        System.out.println("--- Teszt vége ---\n");
    }
}

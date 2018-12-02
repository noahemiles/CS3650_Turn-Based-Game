package CS3650_Project;

import java.util.Scanner;

public class Menu {

    public static void clearScreen() {
        System.out.println(new String(new char[100]).replace("\0", "\r\n"));
    }

    public void startMenu() {
        int choice;
        String name;
        Player player = null;
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to our demo.");
        while (true) {
            System.out.println("(1) Create Player\n");
            System.out.println("(2) Create Monster\n");
            System.out.println("(3) Battle\n");
            System.out.println("(4) Display Player Info\n");
            System.out.println("(5) Exit\n");
            System.out.print("Enter an option (1-5):");
            choice = kb.nextInt();
            switch (choice) {
                case 1:
                    clearScreen();
                    System.out.print("Please enter a name: ");
                    name = kb.next();
                    player = new Player(name);
                    player.displayInfo();
                    System.out.println("\n");
                    break;
                case 2:
                    clearScreen();
                    System.out.println("Choose a default Monster");
                    System.out.println("(1) Angry Pigeon");
                    System.out.println("(2) Ravaging Ghoul");
                    System.out.println("(3) Unkillable Behemoth");
                    System.out.println("Enter an option (1-3): ");
                    choice = kb.nextInt();
                    while (choice < 1 || choice > 3) {
                        clearScreen();
                        System.out.println("Invalid choice.");
                        System.out.println("Choose a default Monster");
                        System.out.println("(1) Angry Pigeon");
                        System.out.println("(2) Ravaging Ghoul");
                        System.out.println("(3) Unkillable Behemoth");
                        System.out.println("Enter an option (1-3): ");
                        choice = kb.nextInt();
                    }
                    switch (choice) {
                        case 1:
                            Monster AngryPigeon = new Monster(Type.NEUTRAL, "Angry Pigeon", 1, 10, 10, 1, 0, ID.MONSTER);
                            AngryPigeon.displayInfo();
                            break;
                        case 2:
                            Monster RavagingGhoul = new Monster(Type.UNDEAD, "Ravaging Ghoul", 2, 10, 10, 1, 0, ID.MONSTER);
                            RavagingGhoul.displayInfo();
                            break;
                        case 3:
                            Monster UnkillableBehemoth = new Monster(Type.FIRE, "Unkillable Behemoth", 99, 999, 999, 100, 100, ID.MONSTER);
                            UnkillableBehemoth.displayInfo();
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    clearScreen();
                    Arena battleArena = new Arena();
                    battleArena.BattleArena(player, new Monster(Type.NEUTRAL, "Angry Pigeon", 1, 10, 10, 1, 0, ID.MONSTER)); //Can implement random monster generation here
                                                                                                                             //Using test monster for now.
                    break;
                case 4:
                    clearScreen();
                    try {
                        player.displayInfo();
                    } catch (NullPointerException e) {
                        System.out.println("You must create a player first!");
                    }
                    break;
                case 5:
                    clearScreen();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    clearScreen();
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}

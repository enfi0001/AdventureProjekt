import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Adventure adventure = new Adventure();


    public void userInterface() {
        boolean game = true;
        Scanner input = new Scanner(System.in);


        System.out.println("Welcome to 'ESCAPE PETER'.\n" +
                "Peter is gone astray in the dark forrest.\n " +
                "Your mission is to escape Peter from the forrest. You can move Peter north, east, south, west");

        System.out.println("Type [help] for (commands, exit game)");


        while (game) {
            System.out.print("Type your decision here: ");
            String brugervalg = input.nextLine().toLowerCase();  // Brugeren input



            if (brugervalg.startsWith("take ")) {
                String itemName = brugervalg.substring(5).trim();
                Item item = adventure.getCurrentRoom().itemFinder(itemName);

                if (item != null) {
                    adventure.getPeter().takeItem(item);
                    System.out.println("You have added " + item.getName() + " to your inventory");
                } else {
                    System.out.println("There is nothing like '" + itemName + "' to take around here.");
                }
            } else if (brugervalg.startsWith("drop ")) {
                String itemName = brugervalg.substring(5).trim();
                Item item = adventure.getPeter().itemFinderInventory(itemName);

                if (item != null) {
                    adventure.getPeter().dropItem(item);
                    System.out.println("You have dropped " + item.getName() + " from your inventory");
                } else {
                    System.out.println("You don't have anything like '" + itemName + "' in your inventory.");
                }
            } else if (brugervalg.startsWith("equip ")) {
                String weaponName = brugervalg.substring(6).trim();
                Item item = adventure.getPeter().itemFinderInventory(weaponName);

                if (item != null && item instanceof Weapon) {
                    adventure.getPeter().equipWeapon((Weapon) item);
                    System.out.println("You have equipped " + item.getName());
                } else if (item != null) {
                    System.out.println(item.getName() + " is not a weapon.");
                } else {
                    System.out.println("You don't have such a weapon in your inventory.");
                }
            } else if (brugervalg.startsWith("attack ")) {
                String enemyName = brugervalg.substring(7).trim();
                Room currentRoom = adventure.getCurrentRoom();
                Enemy enemy = currentRoom.enemyFinder(enemyName);  // Hent fjenden i rummet

                if (enemy == null) {
                    System.out.println("There is no enemy named '" + enemyName + "' here to attack.");
                } else {
                    // Peter angriber fjenden
                    String attackResult = adventure.getPeter().attackEnemy(enemy);
                    System.out.println(attackResult);  // Udskriv resultatet af angrebet

                    // Hvis fjenden stadig er i live, angriber den Peter
                    if (enemy.isAlive()) {
                        int damage = enemy.enemyAttack();
                        adventure.getPeter().decreaseHealth(damage);
                        System.out.println(enemy.getName() + " attacked you for " + damage + " damage.");
                        System.out.println("You now have " + adventure.getPeter().getHealthPoint() + " HP left.");

                        if (adventure.getPeter().getHealthPoint() <= 0) {
                            System.out.println("You have died. Game Over.");
                            game = false;
                        }
                    }
                }

            } else if (brugervalg.startsWith("eat ")) {
                String foodName = brugervalg.substring(4).trim();
                Item food = adventure.getCurrentRoom().itemFinder(foodName);
                if (food == null) {
                    food = adventure.getPeter().itemFinderInventory(foodName);
                }

                if (food != null && food instanceof Food) {
                    Food edible = (Food) food;
                    adventure.getPeter().increaseHealth(edible.getFoodHp());
                    System.out.println("You ate " + foodName + " and increased your health by " + edible.getFoodHp() + " points.");

                    // Remove food from inventory or room
                    if (adventure.getPeter().getInventory().contains(edible)) {
                        adventure.getPeter().dropItem(edible);
                    } else {
                        adventure.getCurrentRoom().removeItems(edible);
                    }
                } else if (food != null) {
                    System.out.println("You cannot eat " + foodName + ".");
                } else {
                    System.out.println("There is no such food around here.");
                }
            } else {

                switch (brugervalg) {
                    case "go north", "north", "n", "go east", "east", "e", "go south", "south", "s", "go west", "west",
                         "w" -> {

                        if (adventure.movePeter(brugervalg)) {
                            System.out.println("You have moved Peter to: " + adventure.getCurrentRoom().getName());
                            System.out.println(adventure.getCurrentRoom().getDescription());
                        } else {
                            System.out.println("You cannot go that way, you are at the edge of a cliff.");
                        }
                    }


                    case "look" -> {
                        Room currentRoom = adventure.getCurrentRoom();
                        System.out.println("You are in room " + currentRoom.getName());
                        System.out.println(currentRoom.getDescription());

                        if (!currentRoom.getEnemies().isEmpty())
                        System.out.println("Be careful, there is an " + currentRoom.getEnemies());

                        else if (currentRoom.getItems().isEmpty() && currentRoom.getEnemies().isEmpty()) {
                            System.out.println("There are no items in this room.");
                            System.out.println("There are no enemies in this room.");
                        } else {
                            System.out.println(currentRoom.getItems());
                        }
                    }

                    case "health", "hp" -> {
                        int hP = adventure.getPeter().getHealthPoint();

                        if (hP == 100) {
                            System.out.println("Your health is " + hP + "% -> You can easily fight in this stage");
                        } else if (hP > 50) {
                            System.out.println("Your health is " + hP + "% -> Your are doing well.");
                        } else if (hP == 0) {
                            System.out.println("You health is " +  hP + "% -> You have died:( Try again");
                        }else if (hP <= 50)
                            System.out.println("Your health is " + hP + "% -> You should not fight in this stage");
                    }
                    case "inventory", "i" -> {
                        ArrayList<Item> inventory = adventure.getPeter().getInventory();
                       if (adventure.getPeter().showInventory().isEmpty()){
                           System.out.println("Your inventory is empty");
                       }else
                           System.out.println("Your inventory contains: ");
                        for (Item item : inventory) {
                            System.out.println("- " + item.getName() + ": " + item.getDescription());
                        }
                        Weapon equippedWeapon = adventure.getPeter().getEquippedWeapon();
                        if (equippedWeapon != null) {
                            System.out.println("Equipped Weapon: " + equippedWeapon.getName());
                        }
                    }


                    case "help" -> System.out.println(
                            "Type [go north], [north], [n] --> move Peter North\n" +
                                    "Type [go east], [east], [e] --> move Peter East\n" +
                                    "Type [go south], [south], [s] --> move Peter South\n" +
                                    "Type [go west], [west], [w] --> move Peter West\n" +
                                    "Type [look] --> description of your location\n" +
                                    "Type [take <item name> ], [t] --> add item to inventory\n" +
                                    "Type [drop <item name> ], [d] --> drop item\n" +
                                    "Type [eat <item name> ] --> eat item\n" +
                                    "Type [equip <weapon name> ] --> equip weapon\n" +
                                    "Type [attack <enemy name> ] --> Attack enemy\n" +
                                    "Type [inventory], [i] --> look at inventory\n" +
                                    "Type [health], [hp] --> Health status\n" +
                                    "Type [exit] --> exiting game");

                    case "exit" -> game = false;

                    default -> System.out.println("Invalid input. Type [help] for available commands");
                }
            }
        }

    }

}

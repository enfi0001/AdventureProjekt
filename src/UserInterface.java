import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
   private Adventure adventure = new Adventure();


    public void userInterface(){
        boolean game = true;
        Scanner input = new Scanner(System.in);


        System.out.println("Welcome to escape Peter. Peter is gone astray in the dark forrest " +
                "Your mission is to escape Peter from the forrest. You can move Peter north, east, south, west");

        System.out.println("Type [help] for (commands, exit game)");


        while (game){
            System.out.print("Type your decision here: ");
        String brugervalg = input.nextLine().toLowerCase();





        switch(brugervalg) {
            case "go north", "north", "n" -> adventure.movePeter(brugervalg);
          case "go east", "east", "e" -> adventure.movePeter(brugervalg);
            case "go south", "south", "s" -> adventure.movePeter(brugervalg);
            case "go west", "west", "w" -> adventure.movePeter(brugervalg);

            case "look" -> {
                Room currentRoom = adventure.getCurrentRoom();
                System.out.println("You are in room " + currentRoom.getName());
                System.out.println(currentRoom.getDescription());

                if (currentRoom.getItems().isEmpty()) {
                    System.out.println("There are no items in this room.");
                } else {
                    System.out.println(currentRoom.getItems());
                }


            }
            case "help" -> System.out.println(
                    "Type [go north], [north], [n] --> move Peter North\n" +
                            "Type [go east], [east], [e] --> move Peter east\n" +
                            "Type [go south], [south], [s] --> move Peter south\n" +
                            "Type [go west],[west], [w] --> move Peter West)\n" +
                            "Type [look] --> description of your location\n" +
                            "Type [take <item name> ], [t] --> add item to inventory\n" +
                            "Type [inventory], [i] --> look at inventory\n" +
                            "Type [drop <item name> ], [d] --> drop item\n" +
                            "Type exit --> exiting game");

            case "take", "t" -> {

                String itemName = brugervalg.substring(5).trim();
                Item item = adventure.getCurrentRoom().itemFinder(itemName);

                if(item != null){
                    adventure.getPeter().takeItem(item);
                    System.out.println("You have taken " + itemName);
                }
                else {
                    System.out.println(itemName + "cannot be found" );
                }
            }

            case "inventory", "i" -> adventure.getPeter().showInventory();

            case "drop", "d" -> {

                String itemName = brugervalg.substring(5).trim();
                Item item = adventure.getCurrentRoom().itemFinder(itemName);

                if(item != null){
                    adventure.getPeter().dropItem(item);
                    System.out.println("You have taken " + itemName);
                }
                else {
                    System.out.println(itemName + "cannot be found" );
                }


            }

            case "exit" -> game = false;

            default -> System.out.println("Invalid input. Type [help] for available commands");
        }

        }
        System.out.println("You are exiting the game - goodbye:)");





    }



}

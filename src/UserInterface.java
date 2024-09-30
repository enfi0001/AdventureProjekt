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
            }
            case "help" -> System.out.println(
                    "Type [go north], [north], [n] to move Peter North\n" +
                            "Type [go east], [east], [e] to move Peter east\n" +
                            "Type [go south], [south], [s] to move Peter south\n" +
                            "Type [go west],[west], [w] to move Peter West)\n" +
                            "Type look for description of your location\n" +
                            "Type exit - exiting game");

            case "exit" -> game = false;


            default -> System.out.println("Invalid input. Type [help] for available commands");
        }

        }



        System.out.println("You are exiting the game - goodbye:)");





    }



}

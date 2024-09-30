public class Peter {
    private Room currentRoom;

    public Peter(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }


    //metode til at flytte til et nyt rum:
    public void moveRoom(String directions){
        Room nextRoom = switch (directions) {
            case "go north", "north", "n" -> currentRoom.getNorth();
            case "go east", "east", "e" -> currentRoom.getEast();
            case "go south", "south", "s" -> currentRoom.getSouth();
            case "go west", "west", "w" -> currentRoom.getWest();
            default -> null;
        };

        if (nextRoom != null){
            currentRoom = nextRoom;
            System.out.println("You have moved Peter to: " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());
        }
        else {
            System.out.println("You cannot go that way, you are at the edge of a cliff.");
        }


    }
}

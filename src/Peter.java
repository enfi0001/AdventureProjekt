import java.util.ArrayList;

public class Peter {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int healthPoint;
    private Weapon equippedWeapon;


    public Peter(Room currentRoom /*int healthPoint*/) {
        this.currentRoom = currentRoom;
        //this.healthPoint = healthPoint;

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

//    public void setCurrentRoom(Room currentRoom) {
//        this.currentRoom = currentRoom;
//    }


    //metode til at flytte til et nyt rum:
    public boolean moveRoom(String directions) {
        Room nextRoom = switch (directions) {
            case "go north", "north", "n" -> currentRoom.getNorth();
            case "go east", "east", "e" -> currentRoom.getEast();
            case "go south", "south", "s" -> currentRoom.getSouth();
            case "go west", "west", "w" -> currentRoom.getWest();
            default -> null;
        };


        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        } else
            return false;

    }


    public void takeItem(Item item) {
        inventory.add(item);
        currentRoom.removeItems(item);
    }


    public void dropItem(Item item) {
        inventory.remove(item);
        currentRoom.addItems(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public String showInventory() {

        if (inventory.isEmpty()) {
            return "";

        } else {
            for (Item item : inventory) {
                return (item.getName());
            }

            return "";
        }
    }

    public Item itemFinderInventory(String name) {
        for (Item item : inventory) {

            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;

    }

    public void increaseHealth(int increase){
        healthPoint += increase;
        if (healthPoint > 100){
            healthPoint = 100; // max health er 100
        } else if (healthPoint < 0){
            healthPoint = 0; //minimum health er 0
        }
    }


    public int getHealthPoint() {
        return healthPoint;
    }


    public void equipWeapon(Weapon weapon){
        this.equippedWeapon = weapon;
    }


    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }
}






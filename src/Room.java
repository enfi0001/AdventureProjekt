import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private ArrayList<Item> items = new ArrayList();


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    public void setRoomExit(Room north, Room east, Room south, Room west) {

        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public void addItems(String name, String description) {
        items.add(new Item(name, description));
    }

    public void addItems(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void removeItems(Item item) {
        items.remove(item);
    }

    public Item itemFinder(String name) {

        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }

        }
        return null;
    }



}










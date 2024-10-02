import java.util.ArrayList;

public class Map {
    public Room createRooms() {
        Room room1 = new Room("room1", "description kommer");
        Room room2 = new Room("room2", "description kommer");
        Room room3 = new Room("room3", "description kommer");
        Room room4 = new Room("room4", "description kommer");
        Room room5 = new Room("room5", "description kommer");
        Room room6 = new Room("room6", "description kommer");
        Room room7 = new Room("room7", "description kommer");
        Room room8 = new Room("room8", "description kommer");
        Room room9 = new Room("room9", "description kommer");


        room1.setRoomExit(null, room2, room4, null);
        room2.setRoomExit(null, room3, null, room1);
        room3.setRoomExit(null, null, room6, room2);
        room4.setRoomExit(room1, null, room7, null);
        room5.setRoomExit(null, null, room8, null);
        room6.setRoomExit(null, room2, room4, null);
        room7.setRoomExit(room3, null, room9, null);
        room8.setRoomExit(room5, room9, null, room7);
        room9.setRoomExit(room6, null, null, room8);

        room1.addItems("Sword", "description kommer");
        room2.addItems("Item 2", "description kommer");
        room3.addItems("Item 3", "description kommer");

        return room1; //start rummet spileren er i

    }
}

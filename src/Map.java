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


 //--------------------------------------------------------------------------------------------------------------------//
        Item item1 = new Item("Book", "description kommer");
        Item item2 = new Item("Computer", "description kommer");
        Item item3 = new Item("Old picture", "description kommer");


        room1.addItems(item1);
        room2.addItems(item2);
        room3.addItems(item3);


//----------------------------------------------------------------------------------------------------------------------//

        Food food1 = new Food("Honey", "Increase your health (50Hp)", 50);
        Food food2 = new Food("Rotten meat","This could affect your health",-20);


        room1.addItems(food1);
        room4.addItems(food2);



//-----------------------------------------------------------------------------------------------------------------------//

        Weapon weapon1 = new MeleeWeapon("branch", "a thick branch, use it to damage your enemy");
        Weapon weapon2 = new RangedWeapon("bow", " Old bow made of wood with 10 arrows, use it to damage your enemy", 10);

        room1.addItems(weapon1);
        room1.addItems(weapon2);


//-----------------------------------------------------------------------------------------------------------------------//

        Enemy enemy1 = new Enemy("Witch","who protects her domain",100, new RangedWeapon("Magic", "1", 10));

        room4.addEnemy(enemy1);






        return room1; //start rummet spileren er i

    }
}

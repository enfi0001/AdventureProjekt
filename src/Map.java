import java.util.ArrayList;

public class Map {
    public Room createRooms() {
        Room room1 = new Room("Forest Clearing", "A serene clearing in the forest with tall trees surrounding it.");
        Room room2 = new Room("Dense Forest", "A thick forest filled with tall trees and underbrush, making it hard to navigate.");
        Room room3 = new Room("Riverside", "A peaceful riverside with the sound of flowing water and rocks scattered around.");
        Room room4 = new Room("Old Cabin", "An abandoned cabin in the woods, with broken windows and a creaking door.");
        Room room5 = new Room("Cave Entrance", "A dark cave entrance that looks eerie and inviting at the same time.");
        Room room6 = new Room("Overgrown Trail", "A narrow, overgrown trail that seems to lead deeper into the forest.");
        Room room7 = new Room("Abandoned Campsite", "A deserted campsite with remnants of a fire and scattered belongings.");
        Room room8 = new Room("Ancient Tree", "A massive, ancient tree that feels alive, with strange markings on its bark.");
        Room room9 = new Room("Hidden Grove", "A secluded grove filled with vibrant flowers and a tranquil atmosphere.");


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
        Item item1 = new Item("Wooden Stick", "A sturdy stick, could be useful");
        Item item2 = new Item("Compass", "An old compass that still points north, useful for navigation.");
        Item item3 = new Item("Map", "A crumpled map of the forest, showing trails and landmarks.");
        Item item4 = new Item("First Aid Kit", "A small first aid kit with basic medical supplies.");
        Item item5 = new Item("Flashlight", "A handy flashlight, though the batteries might be low.");


        room4.addItems(item1);
        room2.addItems(item2);
        room1.addItems(item3);
        room7.addItems(item4);
        room8.addItems(item5);


//----------------------------------------------------------------------------------------------------------------------//

        Food food1 = new Food("Honey", "Increase your health (50Hp)", 50);
        Food food2 = new Food("Rotten meat","This could affect your health",-20);
        Food food3 = new Food("Wild Berries", "Freshly picked berries that can restore some health (30Hp).", 30);
        Food food4 = new Food("Mushrooms", "Some mushrooms that could either heal you or make you sick (random effect).", 10);
        Food food5 = new Food("Fresh Fish", "Caught from the river, restores a good amount of health (40Hp).", 40);


        room1.addItems(food1);
        room4.addItems(food2);
        room3.addItems(food3);
        room2.addItems(food4);
        room6.addItems(food5);






//-----------------------------------------------------------------------------------------------------------------------//

        Weapon weapon1 = new MeleeWeapon("branch", "a thick branch, use it to damage your enemy");
        Weapon weapon2 = new RangedWeapon("bow", " Old bow made of wood with 10 arrows, use it to damage your enemy", 10);

        room1.addItems(weapon1);
        room1.addItems(weapon2);


//-----------------------------------------------------------------------------------------------------------------------//

        Enemy enemy1 = new Enemy("Wild Boar", "A fierce boar protecting its territory.", 70, new MeleeWeapon("Tusks", "Sharp tusks ready to attack."));
        Enemy enemy2 = new Enemy("Forest Bandit", "A sneaky bandit hiding in the trees, looking to ambush travelers.", 80, new MeleeWeapon("Dagger", "A quick dagger for swift attacks."));
        Enemy enemy3 = new Enemy("Giant Spider", "A large spider lurking in the shadows, waiting to trap its prey.", 90, new MeleeWeapon("Webbing", "A sticky web that can ensnare victims."));
        Enemy enemy4 = new Enemy("Witch","who protects her domain",100, new MeleeWeapon("Magic stick", "Attack with spells"));


        room6.addEnemy(enemy1);
        room4.addEnemy(enemy2);
        room8.addEnemy(enemy3);
        room4.addEnemy(enemy4);



        return room1; //start rummet spileren er i

    }
}

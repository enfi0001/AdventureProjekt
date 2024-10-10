import javax.xml.namespace.QName;
import java.time.Period;

public class Adventure {
    private Peter peter;

    public Adventure(){
        Map map = new Map();
        Room startRoom = map.createRooms();
        peter = new Peter(startRoom);

    }
    public Peter getPeter() {
        return peter;
    }


    public boolean movePeter(String move){
        return peter.moveRoom(move);

    }

    public Room getCurrentRoom(){
        return peter.getCurrentRoom();
    }
}

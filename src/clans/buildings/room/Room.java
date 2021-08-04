package clans.buildings.room;

import clans.buildings.room.roomobjects.Roomobjects;
import clans.buildings.room.roomobjects.WrongRoomException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Room {

    private RoomE roomE;
    protected List<Roomobjects> inventar;
    private int roomSize;

    public Room(RoomE roomE, int roomSize) {
        this.roomE = roomE;
        this.roomSize = roomSize;
        inventar = new ArrayList<>();
    }

    public RoomE whichRoomAmI(){
        return roomE;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public boolean putInventarInRoom(Roomobjects r){
        if(!isRoomSpaceAvailable(r)) return false;
        if(!isThisTheRightRoom(r)) throw new WrongRoomException();
        inventar.add(r);
        return true;
    }
    public int freeRoomSpace(){
        int returnMe = roomSize;
        for(Roomobjects t : inventar){
            returnMe = returnMe - t.getSize();

        }
        return returnMe;
    }
    private boolean isRoomSpaceAvailable(Roomobjects r){
        return freeRoomSpace() >= r.getSize();
    }
    private boolean isThisTheRightRoom(Roomobjects r){
        return roomE == r.getUsedIn();
    }

}

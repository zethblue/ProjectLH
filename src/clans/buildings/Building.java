package clans.buildings;

import clans.buildings.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private List<Room> rooms;
    private int buildingSize;

    public Building(int buildingSize) {
        this.buildingSize = buildingSize;
        rooms = new ArrayList<>();
    }

    public boolean createNewRoom(Room r){
        if(!isBuildingSpaceAvailable(r)) return false;
        rooms.add(r);
        return true;
    }
    public int freeBuildingSize(){
        int returnMe = buildingSize;
        for (Room r : rooms){
            returnMe = returnMe - r.getRoomSize();
        }
        return returnMe;
    }
    private boolean isBuildingSpaceAvailable(Room r){
        return freeBuildingSize() >= r.getRoomSize();
    }

    public List<Room> getRooms() {
        return rooms;
    }

}

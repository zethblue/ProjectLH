package clans.buildings.room.roomobjects;

/*
 * Everything that can be in a Room. Luxury Beds or mats? Training Dummys? Mage Books for Training?
 */

import clans.buildings.room.RoomE;

public class Roomobjects {


    private final RoomE usedIn;
    private final RobjectName robjectName;
    private final int size;


    /**
     *
     * @param usedIn - Which Room shall the Object to be used in
     * @param robjectName - What is the Name of the Object
     * @param size - how much space does the Object need
     */
    public Roomobjects(RoomE usedIn, RobjectName robjectName, int size) {
        this.usedIn = usedIn;
        this.robjectName = robjectName;
        this.size = size;
    }

    public RoomE getUsedIn() {
        return usedIn;
    }
    public RobjectName getRobjectName() {
        return robjectName;
    }
    public int getSize() {
        return size;
    }
}
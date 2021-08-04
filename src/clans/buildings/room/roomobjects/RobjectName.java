package clans.buildings.room.roomobjects;

import clans.buildings.room.RoomE;

public enum RobjectName {
    MATTRESS("Mattress", "Simple Mattress for sleeping", RoomE.SLEEP),
    WBED("wooden Bed", "A solid bed made of wood", RoomE.SLEEP),
    DBED("bunk bed", "a bunkbed - two beds with the size of one", RoomE.SLEEP); //Stockbett

    private final String name;
    private final String description;
    private final RoomE whichRoom;

    RobjectName(String name, String description, RoomE whichRoom) {
        this.name = name;
        this.description = description;
        this.whichRoom = whichRoom;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public RoomE getWhichRoom() {
        return whichRoom;
    }
}

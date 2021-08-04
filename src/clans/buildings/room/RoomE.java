package clans.buildings.room;

public enum RoomE {
    SLEEP("Room for your Follower to sleep in"),
    TRAINW("Room for training and teaching followers Weapon Skills"),
    TRAINM("Room for training and teaching followers Magic Skills"),
    BLACKS("Room for Blacksmiths to Craft"),
    ALCHE("Room for Alches to potion"),
    STORA("Storage for Items"),
    HEALW("Hospital Area for the sick");

    private final String description;

    RoomE(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

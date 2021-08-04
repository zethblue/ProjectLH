package test.clans.buildings;

import clans.buildings.Building;
import clans.buildings.room.Room;
import clans.buildings.room.RoomE;
import clans.buildings.room.roomobjects.RobjectName;
import clans.buildings.room.roomobjects.Roomobjects;
import clans.buildings.room.roomobjects.WrongRoomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class BuildingTests {

    @Test
    public void createBuildingsTestRoomSizes100(){
        Building building = new Building(100);
        Assertions.assertTrue(building.createNewRoom(new Room(RoomE.BLACKS, 30)));
        Assertions.assertTrue(building.createNewRoom(new Room(RoomE.SLEEP, 65)));
        Assertions.assertFalse(building.createNewRoom(new Room(RoomE.STORA, 25)));

        Assertions.assertTrue(building.freeBuildingSize() > 0);
        Assertions.assertEquals(building.getRooms().size(),2);

    }

    @Test
    public void wrongObjectinRoom(){
        Building building = new Building(100);
        Room r = new Room(RoomE.HEALW, 35);
        boolean x = building.createNewRoom(r);
        Roomobjects o = new Roomobjects(RoomE.SLEEP, RobjectName.WBED,3);
        assertThrows(WrongRoomException.class, () -> r.putInventarInRoom(o));
    }
}

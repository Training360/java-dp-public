package command;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationServiceTest {

    LocationService locationService = new LocationService();

    @Test
    void testCreate() {
        String id = UUID.randomUUID().toString();
        locationService.receiveCommand(new CreateLocationCommand(id, "Location1", 10, 10));
        Location location = locationService.findById(id);
        assertEquals("Location1", location.getName());
    }

    @Test
    void testChangeName() {
        String id = UUID.randomUUID().toString();
        locationService.receiveCommand(new CreateLocationCommand(id, "Location1", 10, 10));
        locationService.receiveCommand(new ChangeNameCommand(id, "Location2"));
        Location location = locationService.findById(id);
        assertEquals("Location2", location.getName());
    }

    @Test
    void testMoveTo() {
        String id = UUID.randomUUID().toString();
        locationService.receiveCommand(new CreateLocationCommand(id, "Location1", 10, 10));
        locationService.receiveCommand(new MoveToCommand(id, 20, 20));
        Location location = locationService.findById(id);
        assertEquals(20, location.getX());
    }

    @Test
    void testMoveToTwice() {
        String id = UUID.randomUUID().toString();
        locationService.receiveCommand(new CreateLocationCommand(id, "Location1", 10, 10));
        locationService.receiveCommand(new MoveToCommand(id, 20, 20));
        locationService.receiveCommand(new MoveToCommand(id, 30, 30));
        Location location = locationService.findById(id);
        assertEquals(30, location.getX());
        assertEquals(30, location.getY());
    }

    @Test
    void testMoveToRelative() {
        String id = UUID.randomUUID().toString();
        locationService.receiveCommand(new CreateLocationCommand(id, "Location1", 10, 10));
        locationService.receiveCommand(new MoveRelativeCommand(id, +20, -20));
        Location location = locationService.findById(id);
        assertEquals(30, location.getX());
        assertEquals(-10, location.getY());
    }

    @Test
    void testUndo() {
        String id = UUID.randomUUID().toString();
        locationService.receiveCommand(new CreateLocationCommand(id, "Location1", 10, 10));
        locationService.receiveCommand(new MoveToCommand(id, 20, 20));
        locationService.receiveCommand(new MoveToCommand(id, 30, 30));
        locationService.undo(id);
        Location location = locationService.findById(id);
        assertEquals(20, location.getX());
        assertEquals(20, location.getY());
    }
}

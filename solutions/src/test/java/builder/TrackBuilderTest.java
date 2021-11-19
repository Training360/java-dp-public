package builder;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrackBuilderTest {

    @Test
    void testBuildTrack() {
        Track track = new TrackBuilder()
                .withName("Test Track")
                .withTrackType(TrackType.HIKING)
                .withPoint(47.49801, 19.03991, 130, LocalDateTime.now())
                .withPoint(47.49802, 19.03992, 131, LocalDateTime.now())
                .build();

        assertEquals("Test Track", track.getName());
        assertEquals(TrackType.HIKING, track.getTrackType());
        assertEquals(47.49801, track.getPoints().get(0).getLat());
        assertEquals(131.0, track.getPoints().get(1).getElevation());
    }

    @Test
    void testEmptyName() {
        assertThrows(IllegalStateException.class,
                () -> new TrackBuilder().build());
    }

    @Test
    void testIllegalLatLower() {

        assertThrows(IllegalArgumentException.class,
                () -> new TrackBuilder().withName("Test Track").withPoint(-91, 0,0, LocalDateTime.now()));
    }

    @Test
    void testIllegalLatHigher() {
        assertThrows(IllegalArgumentException.class,
                () ->  new TrackBuilder().withName("Test Track").withPoint(91, 0,0, LocalDateTime.now()));
    }

    @Test
    void testIllegalLonLower() {
        assertThrows(IllegalArgumentException.class,
                () -> new TrackBuilder().withName("Test Track").withPoint(0, -181,0, LocalDateTime.now()));
    }

    @Test
    void testIllegalLonHigher() {
        assertThrows(IllegalArgumentException.class,
                () -> new TrackBuilder().withName("Test Track").withPoint(0, 181,0, LocalDateTime.now()));
    }
}

package flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class RectangleTest {

    @Test
    void create() {
        Rectangle r1 = Rectangle.getInstance(100, 200);
        assertEquals(100, r1.getWidth());
        assertEquals(200, r1.getHeight());

        Rectangle r2 = Rectangle.getInstance(100, 200);
        assertSame(r2, r1);
    }
}

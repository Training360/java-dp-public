package state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeatHeaterStateTest {

    @Test
    void testOffNext() {
        SeatHeaterState state = SeatHeaterState.OFF;
        state = state.next();
        assertEquals(SeatHeaterState.THREE, state);
        assertEquals(3, state.getPower());
    }

    @Test
    void testThreeNext() {
        SeatHeaterState state = SeatHeaterState.THREE;
        state = state.next();
        assertEquals(SeatHeaterState.TWO, state);
        assertEquals(2, state.getPower());
    }

    @Test
    void testTwoNext() {
        SeatHeaterState state = SeatHeaterState.TWO;
        state = state.next();
        assertEquals(SeatHeaterState.ONE, state);
        assertEquals(1, state.getPower());
    }

    @Test
    void testOneNext() {
        SeatHeaterState state = SeatHeaterState.ONE;
        state = state.next();
        assertEquals(SeatHeaterState.OFF, state);
        assertEquals(0, state.getPower());
    }
}

package flyweight;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void testComputeIfEmpty() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.calculateDistances(Collections.emptyList(), 200));
        assertEquals(0, calculator.calculateDistances(List.of(Rectangle.getInstance(100, 20)), 200));
    }

    @Test
    void testComputeIfNotFit() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Calculator().calculateDistances(List.of(Rectangle.getInstance(100, 100),
                Rectangle.getInstance(100, 20)), 50));
        assertEquals("Not fit", e.getMessage());
    }

    @Test
    void testCompute() {
        assertEquals(20, new Calculator().calculateDistances(List.of(Rectangle.getInstance(100, 100),
                Rectangle.getInstance(100, 20)), 220));
    }

    @Test
    void testComputeMore() {
        List<Rectangle> rectangles = IntStream
                .range(0, 100)
                .mapToObj(i -> Rectangle.getInstance(10, 5))
                .collect(Collectors.toList());
        assertEquals(2, new Calculator().calculateDistances(rectangles, 1200));
    }
}

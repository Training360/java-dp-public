package interpreter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitySelectorTest {

    @Test
    public void selectNames() {
        List<City> cities = List.of(
                new City("Budapest", "", 1_752_704),
                new City("Debrecen", "Hajdú-Bihar", 201_981),
                new City("Szeged", "Csongrád", 161_137),
                new City("Miskolc", " Borsod-Abaúj-Zemplén", 157_177),
                new City("Pécs", "Baranya", 144_675)
        );

        List<String> names = new CitySelector(cities).selectNames("#this.?[population gt 200000].![name]");
        assertEquals(List.of("Budapest", "Debrecen"), names);
    }
}

package facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Configuration.class)
class JdbcFacadeTest {

    @Autowired
    DataSource dataSource;

    @Test
    void testQueryForObjectTooMany() {
        JdbcFacade facade = new JdbcFacade(dataSource);

        assertThrows(IllegalStateException.class,
                () -> facade.queryForObject("select id, name, lat, lon from locations",
                rs -> {
                    try {
                        return new Location(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getDouble("lat"),
                                rs.getDouble("lon"));
                    } catch (SQLException sqle) {
                        throw new IllegalStateException("Error selecting", sqle);
                    }
                }).get());
    }

    @Test
    void testQueryForObjectEmpty() {
        JdbcFacade facade = new JdbcFacade(dataSource);

        Optional<Location> result = facade.queryForObject("select id, name, lat, lon from locations where name = 'Foo'",
                rs -> {
                    try {
                        return new Location(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getDouble("lat"),
                                rs.getDouble("lon"));
                    } catch (SQLException sqle) {
                        throw new IllegalStateException("Error selecting", sqle);
                    }
                });

        assertFalse(result.isPresent());
    }

    @Test
    void testQueryForObject() {
        JdbcFacade facade = new JdbcFacade(dataSource);

        Location location = facade.queryForObject("select id, name, lat, lon from locations where name = 'Budapest'",
                rs -> {
                    try {
                        return new Location(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getDouble("lat"),
                                rs.getDouble("lon"));
                    } catch (SQLException sqle) {
                        throw new IllegalStateException("Error selecting", sqle);
                    }
                }).get();

        assertEquals("Budapest", location.getName());
        assertEquals(47.4979, location.getLat());
    }
}

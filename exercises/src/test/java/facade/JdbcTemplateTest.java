package facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Configuration.class)
class JdbcTemplateTest {

    @Autowired
    DataSource dataSource;

    @Test
    void testQuery() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Location location = jdbcTemplate.queryForObject("select id, name, lat, lon from locations where name = 'Budapest'",
                (rs, i) -> new Location(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getDouble("lat"),
                        rs.getDouble("lon")));

        assertEquals("Budapest", location.getName());
        assertEquals(47.4979, location.getLat());

    }
}

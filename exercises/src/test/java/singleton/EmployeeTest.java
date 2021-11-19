package singleton;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Configuration.class)
class EmployeeTest {

    @Autowired
    AddEmployeeController addEmployeeController;

    @Autowired
    ListEmployeeController listEmployeeController;

    @Test
    @DirtiesContext
    void addAndListEmployee() {
        addEmployeeController.addEmployee("John Doe");
        assertEquals(List.of("John Doe"), listEmployeeController.listEmployees());
    }

    @Test
    @DirtiesContext
    void addAndListMoreEmployee() {
        addEmployeeController.addEmployee("John Doe");
        addEmployeeController.addEmployee("Jack Doe");
        assertEquals(List.of("John Doe", "Jack Doe"), listEmployeeController.listEmployees());
    }
}

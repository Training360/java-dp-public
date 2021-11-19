package observer;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillItemTest {

    int diff;

    @Test
    void testAccess() {
        BillItem billItem = new BillItem(10);
        billItem.onChange(e -> diff = e.getDiff());
        billItem.setPrice(20);
        assertEquals(10, diff);
    }
}

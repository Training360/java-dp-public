package observer;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillTest {

    @Test
    void testEmpty() {
        Bill bill = new Bill();
        assertEquals(0, bill.getSum());
    }

    @Test
    void testAdd() {
        Bill bill = new Bill();
        bill.addBillItem(new BillItem(10));
        assertEquals(10, bill.getSum());
    }

    @Test
    void testAddItems() {
        Bill bill = new Bill();
        bill.addBillItem(new BillItem(10));
        bill.addBillItem(new BillItem(20));
        assertEquals(30, bill.getSum());
    }

    @Test
    void testChangeItem() {
        Bill bill = new Bill();
        bill.addBillItem(new BillItem(10));
        bill.addBillItem(new BillItem(20));
        bill.getBillItemAt(1).setPrice(10);
        assertEquals(20, bill.getSum());
    }

}

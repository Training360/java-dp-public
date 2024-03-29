package templatemethod;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummarizeTest {

    Bill bill = new Bill(List.of(
            new BillItem("Abstract factory", BigDecimal.valueOf(10.02)),
            new BillItem("Adapter", BigDecimal.valueOf(10.05)),
            new BillItem("Bridge", BigDecimal.valueOf(10.08)),
            new BillItem("Builder", BigDecimal.valueOf(10.09)),
            new BillItem("Chain of responsibility", BigDecimal.valueOf(11.00)),
            new BillItem("Command", BigDecimal.valueOf(11.02)),
            new BillItem("Composite", BigDecimal.valueOf(11.05)),
            new BillItem("Decorator", BigDecimal.valueOf(10.01)),
            new BillItem("Facade", BigDecimal.valueOf(10.02)),
            new BillItem("Factory method", BigDecimal.valueOf(10.01)),
            new BillItem("Flyweight", BigDecimal.valueOf(10.01))

    ));

    @Test
    void testVat10HalfEventRound() {
        assertEquals(BigDecimal.valueOf(11.32), bill.sum(new Vat10HalfEvenRoundSummarize()));
    }

    @Test
    void testVat27MathRound() {
        assertEquals(BigDecimal.valueOf(30.61), bill.sum(new Vat27MathRoundSummarize()));
    }

}

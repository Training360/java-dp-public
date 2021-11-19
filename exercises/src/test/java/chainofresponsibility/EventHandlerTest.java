package chainofresponsibility;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventHandlerTest {

    @Test
    void handleEvent() {
        HandlerNode root = new HandlerNode();
        SimpleNode s1 = new SimpleNode();
        root.addChild(s1);
        HandlerNode s2 = new HandlerNode();
        root.addChild(s2);
        HandlerNode s11 = new HandlerNode();
        s1.addChild(s11);
        SimpleNode s21 = new SimpleNode();
        s2.addChild(s21);
        SimpleNode s22 = new SimpleNode();
        s2.addChild(s22);

        s1.handleEvent("event0");
        s11.handleEvent("event1");
        s11.handleEvent("event2");
        assertEquals(List.of("event1", "event2"), s11.getEvents());
        assertEquals(List.of("event0"), root.getEvents());


        s2.handleEvent("event3");
        s21.handleEvent("event4");
        s22.handleEvent("event5");
        assertEquals(List.of("event3", "event4", "event5"), s2.getEvents());
        assertEquals(List.of("event0"), root.getEvents());

    }
}

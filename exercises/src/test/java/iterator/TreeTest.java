package iterator;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TreeTest {

    @Test
    void testIterator() {
        Tree<String> tree = new Tree<>();
        tree.createRoot("a");
        tree.addChild("a", "a1");
        tree.addChild("a", "a2");
        tree.addChild("a1", "a11");
        tree.addChild("a1", "a12");

        List<String> l = new ArrayList<>();
        for (String s : tree) {
            l.add(s);
        }

        assertEquals(List.of("a", "a1", "a11", "a12", "a2"), l);
    }
}

package decorator;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ByteFilterInputStreamTest {

    @Test
    void testFilter() throws IOException {
        InputStream is = new ByteFilterInputStream(new ByteArrayInputStream("abacda".getBytes(StandardCharsets.UTF_8)),
                i -> i != 'a');
        byte[] chars = new byte[10];
        int i = is.read(chars);
        assertEquals(3, i);
        assertEquals("bcd", new String(chars, 0, 3));
    }
}

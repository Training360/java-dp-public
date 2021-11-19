package simplefactory;

import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReadBookTest {

    @Test
    void testReadCsv() {
        Book book = new BookReaderFactory()
                .reader("csv")
                .readBook(new InputStreamReader(ReadBookTest.class.getResourceAsStream("book.csv"), StandardCharsets.UTF_8));
        assertEquals("Erich Gamma", book.getAuthors());
        assertEquals("Design Patterns", book.getTitle());
    }

    @Test
    void testReadXml() {
        Book book = new BookReaderFactory()
                .reader("xml")
                .readBook(new InputStreamReader(ReadBookTest.class.getResourceAsStream("book.xml"), StandardCharsets.UTF_8));
        assertEquals("Erich Gamma", book.getAuthors());
        assertEquals("Design Patterns", book.getTitle());
    }

    @Test
    void testReadUnknownFileType() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new BookReaderFactory().reader("json"));
        assertEquals("Invalid file type", e.getMessage());
    }
}

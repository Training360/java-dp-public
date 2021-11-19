package factorymethod;

import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReadBookTest {

    BookReaderFactoryProvider bookReaderFactoryProvider = new BookReaderFactoryProvider();

    @Test
    void testReadCsv() {
        Book book = bookReaderFactoryProvider
                .getBookReaderFactory("csv")
                .create()
                .readBook(new InputStreamReader(ReadBookTest.class.getResourceAsStream("book.csv"), StandardCharsets.UTF_8));
        assertEquals("Erich Gamma", book.getAuthors());
        assertEquals("Design Patterns", book.getTitle());
    }

    @Test
    void testReadXml() {
        Book book = bookReaderFactoryProvider
                .getBookReaderFactory("xml")
                .create()
                .readBook(new InputStreamReader(ReadBookTest.class.getResourceAsStream("book.xml"), StandardCharsets.UTF_8));
        assertEquals("Erich Gamma", book.getAuthors());
        assertEquals("Design Patterns", book.getTitle());
    }

    @Test
    void testReadUnknownFileType() {

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> bookReaderFactoryProvider.getBookReaderFactory("json"));
        assertEquals("Illegal format: json", e.getMessage());
    }
}

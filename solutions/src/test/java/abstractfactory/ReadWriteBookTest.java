package abstractfactory;

import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReadWriteBookTest {

    BookIoFactoryProvider bookIoFactoryProvider = new BookIoFactoryProvider();

    @Test
    void testReadCsv() {
        Book book = bookIoFactoryProvider
                .getBookIoFactory("csv")
                .createBookReader()
                .readBook(new InputStreamReader(ReadWriteBookTest.class.getResourceAsStream("book.csv"), StandardCharsets.UTF_8));
        assertEquals("Erich Gamma", book.getAuthors());
        assertEquals("Design Patterns", book.getTitle());
    }

    @Test
    void testReadXml() {
        Book book = bookIoFactoryProvider
                .getBookIoFactory("xml")
                .createBookReader()
                .readBook(new InputStreamReader(ReadWriteBookTest.class.getResourceAsStream("book.xml"), StandardCharsets.UTF_8));
        assertEquals("Erich Gamma", book.getAuthors());
        assertEquals("Design Patterns", book.getTitle());
    }

    @Test
    void testWriteCsv() {
        StringWriter writer = new StringWriter();
        bookIoFactoryProvider
                .getBookIoFactory("csv")
                .createBookWriter()
                .writeBook(new Book("Erich Gamma", "Design Patterns"), writer);
        assertEquals("Erich Gamma;Design Patterns", writer.toString());
    }

    @Test
    void testWriteXml() {
        StringWriter writer = new StringWriter();
        bookIoFactoryProvider
                .getBookIoFactory("xml")
                .createBookWriter()
                .writeBook(new Book("Erich Gamma", "Design Patterns"), writer);
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><book><authors>Erich Gamma</authors><title>Design Patterns</title></book>";
        assertEquals(xml, writer.toString());
    }
}

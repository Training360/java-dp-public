package composite;

import org.junit.jupiter.api.Test;

import java.io.StringWriter;

import static org.assertj.core.api.Assertions.assertThat;

class DocumentWriterTests {

    @Test
    void write() {
        Document document = new Document();
        document.getHeader().addEntry("header1", "value1");
        document.getHeader().addEntry("header2", "value2");


        Title title = new Title("Title 1");
        document.getBody().addDocumentPart(title);
        Paragraph paragraph = new Paragraph("Lorem ipsum");
        document.getBody().addDocumentPart(paragraph);

        StringWriter sWriter = new StringWriter();
        new DocumentWriter().write(document, sWriter);
        String result = sWriter.toString();
        assertThat(result)
                .contains("---\nheader1: value1")
                .contains("# Title 1\n")
                .contains("Lorem ipsum\n");
    }
}

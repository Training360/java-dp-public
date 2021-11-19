package bridge;

import bridge.asciidoc.AsciiDocDocument;
import bridge.docbook.DocBookDocument;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.assertThat;

class DocumentWriterTest {

    @Test
    void testAsciiDoc() throws IOException {
        StringWriter sWriter = new StringWriter();
        try (AsciiDocDocument doc = new AsciiDocDocument(sWriter)) {
            DocumentWriter docWriter = new DocumentWriter(doc);
            docWriter.writeTitle("Header 1");
            docWriter.writeParagraph("Lorem ipsum.");
            docWriter.writeTitle("Header 2");
            docWriter.writeParagraph("dolor sit amet");
            docWriter.writeParagraph("consectetur adipiscing elit");
        }
        String result = sWriter.toString();

        assertThat(result)
                .contains("= Header 1\n")
                .contains("consectetur adipiscing elit\n\n");
    }

    @Test
    void testDocBook() throws IOException {
        StringWriter sWriter = new StringWriter();
        try (DocBookDocument doc = new DocBookDocument(sWriter)) {
            DocumentWriter docWriter = new DocumentWriter(doc);
            docWriter.writeTitle("Header 1");
            docWriter.writeParagraph("Lorem ipsum.");
            docWriter.writeTitle("Header 2");
            docWriter.writeParagraph("dolor sit amet");
            docWriter.writeParagraph("consectetur adipiscing elit");
        }
        String result = sWriter.toString();
        assertThat(result)
                .contains("<title>Header 1</title>")
                .contains("<para>consectetur adipiscing elit</para>")
                .contains("</article>");
    }
}

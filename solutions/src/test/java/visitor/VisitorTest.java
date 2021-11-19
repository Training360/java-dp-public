package visitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitorTest {

    @Test
    void testUpperCaseVisitor() {
        Document document = new Document();
        Title title = new Title("Header 1");
        document.addItem(title);
        Paragraph paragraph = new Paragraph("Lorem ipsum.");
        document.addItem(paragraph);
        Title title2 = new Title("Header 2");
        document.addItem(title2);
        Paragraph paragraph2 = new Paragraph("dolor sit amet");
        document.addItem(paragraph2);

        UpperCaseItemVisitor upperCaseItemVisitor = new UpperCaseItemVisitor();
        document.visit(upperCaseItemVisitor);

        assertEquals("HEADER 1", ((Title) document.getChildren().get(0)).getText());
        assertEquals("DOLOR SIT AMET", ((Paragraph) document.getChildren().get(3)).getText());

    }
}

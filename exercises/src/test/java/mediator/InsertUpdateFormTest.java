package mediator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertUpdateFormTest {

    InsertUpdateForm insertUpdateForm = new InsertUpdateForm();

    @Test
    void testInsert() {
        assertEquals("", insertUpdateForm.getId().getValue());
        assertFalse(insertUpdateForm.getId().isVisible());
        assertEquals("", insertUpdateForm.getAuthor().getValue());
        assertEquals("", insertUpdateForm.getTitle().getValue());
        assertEquals("Insert", insertUpdateForm.getSubmit().getValue());
    }

    @Test
    void testSubmitInsert() {
        insertUpdateForm.getAuthor().setValue("GoF");
        insertUpdateForm.getTitle().setValue("Design Patterns");
        Book book = insertUpdateForm.submit();

        assertEquals("GoF", book.getAuthor());
        assertEquals("Design Patterns", book.getTitle());
    }

    @Test
    void testUpdate() {
        insertUpdateForm.toUpdate(new Book(20L, "GoF", "Design Patterns"));
        assertEquals("20", insertUpdateForm.getId().getValue());
        assertTrue(insertUpdateForm.getId().isVisible());
        assertEquals("GoF", insertUpdateForm.getAuthor().getValue());
        assertEquals("Design Patterns", insertUpdateForm.getTitle().getValue());
        assertEquals("Update", insertUpdateForm.getSubmit().getValue());
    }

    @Test
    void testUpdateSubmit() {
        insertUpdateForm.toUpdate(new Book(20L, "GoF", "Design Patterns"));
        insertUpdateForm.getAuthor().setValue("Gang of Four");
        Book book = insertUpdateForm.submit();

        assertEquals("Gang of Four", book.getAuthor());
    }

    @Test
    void testReset() {
        insertUpdateForm.toUpdate(new Book(20L, "GoF", "Design Patterns"));
        insertUpdateForm.toInsert();

        assertEquals("", insertUpdateForm.getId().getValue());
        assertFalse(insertUpdateForm.getId().isVisible());
        assertEquals("", insertUpdateForm.getAuthor().getValue());
        assertEquals("", insertUpdateForm.getTitle().getValue());
        assertEquals("Insert", insertUpdateForm.getSubmit().getValue());
    }
}

package prototype;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MailTest {

    @Test
    void createMail() {
        Mail mail = new Mail(List.of(new Address("test", "test@training360.com")),
                new Address("info", "info@training360.com"),
                "test subject",
                new MailContent("text/plain", "test content"));
        assertEquals(1, mail.getTo().size());
        assertEquals("test@training360.com", mail.getTo().get(0).getEmail());
        assertEquals("info", mail.getFrom().getName());
        assertEquals("test subject", mail.getSubject());
        assertEquals("text/plain", mail.getMailContent().getMimeType());
    }

    @Test
    void cloneMail() {
        Mail template = new Mail(List.of(new Address("test", "test@training360.com")),
                new Address("info", "info@training360.com"),
                "test subject",
                new MailContent("text/plain", "test content"));

        Mail newMail = new Mail(template);
        newMail.setSubject("test subject 2");
        newMail.getTo().add(new Address("test2", "test2@training360.com"));

        assertEquals("test subject 2", newMail.getSubject());
        assertEquals(2, newMail.getTo().size());
        assertEquals(1, template.getTo().size());

        newMail.getMailContent().setText("test content 2");
        assertEquals("test content 2", newMail.getMailContent().getText());
        assertEquals("test content", template.getMailContent().getText());
    }
}

package facade;

import jakarta.xml.bind.*;
import java.io.StringWriter;

public class XmlWriter {

    public String writeXml(Object object) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(object, writer);
            return writer.toString();
        }
        catch (JAXBException je) {
            throw new IllegalStateException("Cannot write to xml", je);
        }
    }
}

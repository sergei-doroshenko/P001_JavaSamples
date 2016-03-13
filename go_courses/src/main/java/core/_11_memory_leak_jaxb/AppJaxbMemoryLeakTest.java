package core._11_memory_leak_jaxb;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by Sergei_Admin on 12.03.2016.
 */
public class AppJaxbMemoryLeakTest {
    public static void main(String[] args) throws JAXBException, IOException {
        /*
        JAXBService service = new JAXBService();
        Customer customer = new Customer();
        customer.setId(100);
        customer.setName("Adam");
        customer.setAge(29);

        service.toXml(customer, "E:\\projects\\idea_projects\\GoCourses\\customer.xml");*/

        int counter = 0;
        while(true) {
            JAXBService service = new JAXBService();
            Customer customerFromXml = service.fromXml("E:\\projects\\idea_projects\\GoCourses\\customer.xml");
            System.out.println(counter++ + " " + customerFromXml);
        }

        /*JAXBService service = new JAXBService();
        service.generateSchema();*/
    }
}

package org.sergei._0_core._11_memory_leak_jaxb;

import javax.xml.bind.*;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sergei_Admin on 12.03.2016.
 */
public class JAXBService {

    public void toXml(Customer customer, String filepath) {
        try {

            File file = new File(filepath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customer, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public Customer fromXml(String filepath) {
        Customer customer = null;
        try {
            File file = new File(filepath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            customer = (Customer) jaxbUnmarshaller.unmarshal(file);

            return customer;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void generateSchema() throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        SchemaOutputResolver sor = new SchemaOutputResolver(){

            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                File file = new File(suggestedFileName);
                StreamResult result = new StreamResult(file);
                result.setSystemId(file.toURI().toURL().toString());
                return result;
            }
        };

        jaxbContext.generateSchema(sor);
    }

    public Customer fromSchema() {
        Customer customer = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("org.w3._2016.sergei");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            URL url = new URL("http://bdoughan.blogspot.com/atom.xml");
            InputStream xml = url.openStream();
//            JAXBElement<Customer> feed = unmarshaller.unmarshal(new StreamSource(xml), FeedType.class);
            xml.close();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customer;
    }
}

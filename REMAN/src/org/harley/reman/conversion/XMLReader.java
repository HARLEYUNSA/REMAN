package org.harley.reman.conversion;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLReader<T> {
    final Class<T> typeParameterClass;
    File database;
    
    public XMLReader(Class<T> typeParameterClass) {
        this.database = new File("src/org/harley/reman/database");
        this.typeParameterClass = typeParameterClass;
        database.mkdirs();
    }

    public void writeXML(String archivo, T result){
        try {
            File xmlFile = new File(database, archivo + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(typeParameterClass);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(result, xmlFile);
            jaxbMarshaller.marshal(result, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    public T openXML(String archivo){
        try {
            File xmlFile = new File(database, archivo + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(typeParameterClass);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            T custom = (T) jaxbUnmarshaller.unmarshal(xmlFile);
            return custom;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
package org.harley.reman.conversion;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLReader<T> {
    final Class<T> typeParameterClass;
    File tempDir;
    
    public XMLReader(Class<T> typeParameterClass) {
        this.tempDir = new File("temp", ".");
        this.typeParameterClass = typeParameterClass;
        tempDir.mkdirs();
    }

    public void writeXML(String archivo, T result){
        try {
            File xmlFile = new File(tempDir, archivo +".xml");
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
            File xmlFile = new File(tempDir, archivo +".xml");
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
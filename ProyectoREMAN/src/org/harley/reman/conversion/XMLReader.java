package org.harley.reman.conversion;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Clase que permite leer y escribir documentos xml.
 * @author Gonzalo
 * @param <T> Tipo de objeto para instanciar la clase
 */
public class XMLReader<T> {
    final Class<T> typeParameterClass;
    File database;
    
    /**
     * Constructor de la clase <code>XMLReader</code>
     * @param typeParameterClass 
     */
    public XMLReader(Class<T> typeParameterClass, File directory) {
        this.database = directory;
        this.typeParameterClass = typeParameterClass;
    }

    /**
     * Escribe los atributos de un objeto en un archivo xml
     * @param nombreArchivo Nombre del archivo xml destino
     * @param objeto        Objeto con atributos a escribir
     */
    public void writeXML(String nombreArchivo, T objeto){
        try {
            File xmlFile = new File(database, nombreArchivo + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(typeParameterClass);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(objeto, xmlFile);
            
            //Imprime en pantalla el archivo xml
            //jaxbMarshaller.marshal(objeto, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Abre un archivo xml y lo guarda en un objeto.
     * @param nombreArchivo Nombre del archivo xml origen.
     * @return Objeto que contiene la información del archivo xml.
     */
    public T openXML(String nombreArchivo){
        try {
            File xmlFile = new File(database, nombreArchivo + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(typeParameterClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
            T object = (T) jaxbUnmarshaller.unmarshal(xmlFile);
            return object;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}

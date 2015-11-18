package org.harley.reman.conversion;

import java.io.File;

public class FileManager<T> {
    final Class<T> typeParameterClass;
    XMLReader<T> reader;
    XMLConverter factory;
    String clase;
    
    public FileManager(Class<T> typeParameterClass, File directory) {
        this.typeParameterClass = typeParameterClass;
        this.clase = typeParameterClass.getSimpleName();
        this.reader = new XMLReader(typeParameterClass, directory);
        this.factory = new XMLConverter(directory);
    }

    public void escribirXML(String archivo, T obj){
        reader.writeXML(archivo, obj);
    }
    
    public T leerXML(String archivo) {
        T esp = reader.openXML(archivo);
        return esp;
    }

    public void exportarPDF(String archivo) {
        factory.convert(clase, archivo);
    }
    
    public void exportarPDF(String xml, String destino, String nombre) {
        factory.convert(clase, xml, destino, nombre);
    }
}

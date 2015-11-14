package org.harley.reman.conversion;

public class FileManager<T> {
    final Class<T> typeParameterClass;
    XMLReader<T> reader;
    XMLConverter factory;
    String clase;
    
    public FileManager(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
        this.clase = typeParameterClass.getName().substring(24);
        this.reader = new XMLReader(typeParameterClass);
        this.factory = new XMLConverter();
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
    
    public void exportarPDF(String archivoXML, String nombre) {
        factory.convert(clase, archivoXML, nombre);
    }
}

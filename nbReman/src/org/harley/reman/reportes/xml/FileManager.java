package org.harley.reman.reportes.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileManager<T> {
    final Class<T> typeParameterClass;
    XMLReader<T> reader;
    XMLConverter factory;
    File directory;
    String clase;
    
    public FileManager(Class<T> typeParameterClass, File directory) {
        this.typeParameterClass = typeParameterClass;
        this.clase = typeParameterClass.getSimpleName();
        this.reader = new XMLReader(typeParameterClass, directory);
        this.factory = new XMLConverter(directory);
        this.directory = directory;
    }

    public File getDirectory() {
        return directory;
    }

    public void setDirectory(File directory) {
        this.directory = directory;
    }
 
    public void escribirXML(String archivo, T obj){
        reader.writeXML(archivo, obj);
    }
    
    public void borrarXML(String archivo){
        reader.deleteXML(archivo);
    }
    
    public T leerXML(String archivo) {
        T esp = reader.openXML(archivo);
        return esp;
    }

    public void borrarDirectorio(){
        directory.delete();
    }    

    public void exportarPDF(String xml, String destino, String nombre) {
        factory.convert(xml, destino, nombre);
    }
    
    public void copiarFicheros(File f1, File f2){
        try {
            InputStream in = new FileInputStream(f1);
            OutputStream out = new FileOutputStream(f2);

            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            in.close();
            out.close();

    } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void copiarDirectorios(File f1, File f2){
        if (f1.isDirectory()){
            if (!f2.exists()){                              
                f2.mkdir();
            }
            String[] ficheros = f1.list();
            for (String fichero : ficheros) {
                copiarDirectorios(new File(f1, fichero), new File(f2, fichero));
            }
        } else {
            copiarFicheros(f1,f2);
        }
    }
}

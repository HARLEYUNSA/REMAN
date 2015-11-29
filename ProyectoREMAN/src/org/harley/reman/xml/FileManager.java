package org.harley.reman.xml;

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

    public void exportarPDF(String archivo) {
        factory.convert(clase, archivo);
    }
    
    public void exportarPDF(String xml, String destino, String nombre) {
        factory.convert(clase, xml, destino, nombre);
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

            System.out.println("Copiando fichero " + f1.toString());

    } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void copiarDirectorios(File d1, File d2){

            // Comprobamos que es un directorio
            if (d1.isDirectory()){
                    //Comprobamos si existe el directorio destino, si no lo creamos
                    if (!d2.exists()){                              
                            d2.mkdir();
                            System.out.println("Creando directorio " + d2.toString());
                    }

                    // Sacamos todos los ficheros del directorio
                    String[] ficheros = d1.list();
                    for (int x=0;x<ficheros.length;x++) {
                            // Por cada fichero volvemos a llamar recursivamente a la copa de directorios
                            copiarDirectorios(new File(d1,ficheros[x]),new File(d2,ficheros[x]));                           
                    }


            } else {
                    copiarFicheros(d1,d2);
            }

    }
}

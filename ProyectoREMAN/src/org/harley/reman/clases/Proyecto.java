package org.harley.reman.clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.harley.reman.conversion.FileManager;

public class Proyecto {
    String name;
    Properties properties;
    File directory;
    File dirPro;
    File dirEdu;
    File dirAct;
    File dirEsp;

    FileManager<LibroEspecificacion> managerEsp;
    FileManager<LibroActores> managerActores;
    FileManager<LibroEduccion> managerEduccion;
    
    /**
     * Constructor de la clase Proyecto
     * @param name Nombre del proyecto
     */
    public Proyecto(String name){
        this.name = name;
        this.directory = new File(this.name);
        this.dirPro = new File(directory, "project");
        this.dirAct = new File(directory, "libroAct");
        this.dirEsp = new File(directory, "libroEsp");
        this.dirEdu = new File(directory, "libroEdu");
        this.properties = new Properties();
        this.managerEsp = new FileManager(LibroEspecificacion.class, this.dirEsp);
        this.managerActores = new FileManager(LibroEspecificacion.class, this.dirAct);
        this.managerEduccion = new FileManager(LibroEspecificacion.class, this.dirEdu);
    }
    
    public void createProject(){
        createDirectory();
        createProperties();  
    }
    
    public void loadProject(){
        loadProperties();
    }
    
    public void deleteProject(){
        
    }
    
    private void createDirectory(){
        directory.mkdir();
        dirPro.mkdir();
        dirAct.mkdir();
        dirEsp.mkdir();
        dirEdu.mkdir();
    }
    
    /**
     * Crea el archivo properties insertando los valores del proyecto
     */
    private void createProperties(){
        OutputStream salida = null;

        try {
            File output = new File(dirPro, "configuracion.properties");
            salida = new FileOutputStream(output);

            properties.setProperty("name", name);
            properties.store(salida, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    } 
   
    public void loadProperties(){
        InputStream entrada = null;
        try {

            File input = new File(directory, "configuracion.properties");
            entrada = new FileInputStream(input);

            properties.load(entrada);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void exportarEsp(String origen, String destino, String nombre) {
        managerEsp.exportarPDF(origen, destino , nombre);
    }
    
    public void createEsp(LibroEspecificacion obj, String nombre) {
        managerEsp.escribirXML(nombre, obj);
    }
}

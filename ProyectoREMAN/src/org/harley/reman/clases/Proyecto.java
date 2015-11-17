package org.harley.reman.clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.harley.reman.conversion.FileManager;

public class Proyecto {
    String name;
    Properties properties;
    String location;
    File directory;

    FileManager<LibroEspecificacion> managerEsp;
    FileManager<LibroActores> managerActores;
    FileManager<LibroEduccion> managerEduccion;
    FileManager<LibroHistorico> managerHistorico;
    
    /**
     * Constructor de la clase Proyecto
     * @param name Nombre del proyecto
     * @param location Ubicación del proyecto
     */
    public Proyecto(String name){
        this.name = name;
        this.location = name;
        this.directory = new File(this.location);
        createDirectory();
        this.properties = new Properties();
        createProperties();
        managerEsp = new FileManager(LibroEspecificacion.class, this.location + "\\libroEsp");
    }
    
    private void createDirectory(){
        this.directory.mkdir();
        System.out.println("Se creo el proyecto " + this.name);
    }
    
    /**
     * Crea el archivo properties insertando valores
     */
    private void createProperties(){
        OutputStream salida = null;

        try {
            File output = new File(directory, "configuracion.properties");
            salida = new FileOutputStream(output);

            // asignamos los valores a las propiedades
            properties.setProperty("name", name);

            // guardamos el archivo de propiedades en la carpeta de aplicación
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

            // cargamos el archivo de propiedades
            properties.load(entrada);

            // obtenemos las propiedades y las imprimimos
            System.out.println(properties.getProperty("name"));

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

    public void exportarEsp(String version, String nombre) {
        managerEsp.exportarPDF(version, nombre);
    }
    public void createEsp(LibroEspecificacion obj, String nombre) {
        managerEsp.escribirXML(nombre, obj);
    }
}

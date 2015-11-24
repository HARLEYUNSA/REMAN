package org.harley.reman.clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.harley.reman.conversion.FileManager;

public class Proyecto {
    String name;
    Properties properties;
    File directory;
    File dirPro;
    File dirEdu;
    File dirEli;
    File dirEsp;
    File dirOrg;
    File dirRnf;
    
    FileManager<LibroEduccion> managerEdu;
    FileManager<LibroEspecificacion> managerEsp;
    FileManager<Educciones> manEdu;

    List<Educciones> verEdu;
    LibroEduccion libroEdu;
    LibroEspecificacion libroEsp;
    /**
     * Constructor de la clase Proyecto
     * @param name Nombre del proyecto
     */
    public Proyecto(String name){
        this.name = name;
        this.directory = new File(this.name);
        this.dirPro = new File(directory, "remanproject");
        this.dirEdu = new File(directory, "src//edu");
        this.dirEli = new File(directory, "src//eli");
        this.dirEsp = new File(directory, "src//esp");
        this.dirOrg = new File(directory, "src//org");
        this.dirRnf = new File(directory, "src//rnf");  
        this.properties = new Properties();
        this.managerEdu = new FileManager(LibroEduccion.class, this.dirEdu);
        this.managerEsp = new FileManager(LibroEspecificacion.class, this.dirEsp);
        this.libroEdu = new LibroEduccion(this.dirEdu);
        this.libroEsp = new LibroEspecificacion(this.dirEsp);
        this.verEdu = new ArrayList<>();
        this.manEdu = new FileManager(Educciones.class, dirEdu);
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
        File tmp = new File(directory,"src");
        tmp.mkdir();
        dirPro.mkdir();
        dirEdu.mkdir();
        dirEli.mkdir();
        dirEsp.mkdir();
        dirOrg.mkdir();
        dirRnf.mkdir();
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
            File input = new File(dirPro, "configuracion.properties");
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

    public void exportarLibroEsp(String origen, String destino, String nombre){
        managerEsp.exportarPDF(origen, destino , nombre);
    }
    
    public void createEsp(String nombre){
        managerEsp.escribirXML(nombre, libroEsp);
    }
    
    public void addEsp(Especificacion esp){
        if (libroEsp.isEmpty()){
            libroEsp.addEspecificacion(esp);
            createEsp("esp");
        }
        else {
            libroEsp.addEspecificacion(esp);
        }
    }
    
    public void exportarLibroEdu(String origen, String destino, String nombre){
        managerEdu.exportarPDF(origen, destino , nombre);
    }
    
    public void createEdu(String nombre){
        managerEdu.escribirXML(nombre, libroEdu);
    }
    
    public void addEdu(Educcion edu){
        Educciones ver = new Educciones(dirEdu);
        ver.newEdu(edu);
        String codEdu = edu.getEduccionNombre().getCodigo();
        File tmp = new File(dirEdu, codEdu);
        verEdu.add(ver);
        manEdu.escribirXML("edu"+codEdu, ver);
    }

    public Educcion getEdu(String name) {
        Educciones x = new Educciones();
        x = manEdu.leerXML(name);
        return x.getLast();
    }

    public void modEdu(Educcion edu, String razon) {
        Educciones x = new Educciones();
        String cod = edu.getEduccionNombre().getCodigo();
        x = manEdu.leerXML("edu"+cod);
        x.modEdu(edu, razon);
        manEdu.escribirXML("edu"+cod, x);
    }
}

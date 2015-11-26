package org.harley.reman.clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
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
        this.manEdu = new FileManager(Educciones.class, dirEdu);
    }
    
    public void createProject(String empDes, String empCli, String lidPro, String estPro, String fecIni, String fecFin) {
        createDirectory();
        createProperties(empDes, empCli, lidPro, estPro, fecIni, fecFin);
    }
    
    public void loadProject(){
        loadProperties();
    }
    
    public void deleteProject(){
        try {
            FileUtils.deleteDirectory(directory);
        } catch (IOException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void createProperties(String empDes, String empCli, String lidPro, String estPro, String fecIni, String fecFin) {
OutputStream salida = null;
        try {
            File output = new File(dirPro, "configuracion.properties");
            salida = new FileOutputStream(output);
            properties.setProperty("name", name);
            properties.setProperty("empDes", empDes);
            properties.setProperty("empCli", empCli);
            properties.setProperty("lidPro", lidPro);
            properties.setProperty("estPro", estPro);
            properties.setProperty("fecIni", fecIni);
            properties.setProperty("fecFin", fecFin);
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

    public void createLibEdu(String nombre){
        managerEdu.escribirXML(nombre, libroEdu);
    }
    
    public void exportarLibroEdu(String destino, String nombre){
         for (final File fileEntry : dirEdu.listFiles()) {
            String name = fileEntry.getName().split("\\.")[0];
            libroEdu.addEduccion(getLastEdu(name));
        }
        createLibEdu("libEdu");
        managerEdu.exportarPDF("libEdu", destino , nombre);
    }
    
    public void addEdu(Educcion edu){
        Educciones ver = new Educciones(dirEdu);
        ver.newEdu(edu);
        String codEdu = edu.getEduccionNombre().getCodigo();
        File tmp = new File(dirEdu, codEdu);
        manEdu.escribirXML(codEdu, ver);
    }

    public List<Historico> getHistEdu(String cod){
        Educciones edu;
        edu = manEdu.leerXML(cod);
        return edu.getHistoricos();
    }
    
    public void restoreEdu(String cod, String version){
        Educciones edus;
        edus = manEdu.leerXML(cod);
        Educcion edu = edus.getVer(version);
        modEdu(edu);
    }
    
    public Educcion getLastEdu(String name) {
        Educciones edu;
        edu = manEdu.leerXML(name);
        return edu.getLast();
    }
    
    public Educcion getActEdu(String name) {
        Educciones edu;
        edu = manEdu.leerXML(name);
        return edu.getActual();
    }

    public void modEdu(Educcion edu) {
        Educciones edus;
        String cod = edu.getEduccionNombre().getCodigo();
        edus = manEdu.leerXML(cod);
        edus.modEdu(edu);
        manEdu.escribirXML(cod, edus);
    }
    
    public void verEdu(Educcion edu, String ver, String razon) {
        modEdu(edu);
        Educciones x;
        String cod = edu.getEduccionNombre().getCodigo();
        x = manEdu.leerXML(cod);
        x.verEdu(ver, razon);
        manEdu.escribirXML(cod, x);
    }
}
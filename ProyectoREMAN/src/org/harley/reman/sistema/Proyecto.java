package org.harley.reman.sistema;

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
import org.harley.reman.xml.FileManager;

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
    File dirVerEdu;
    
    FileManager<LibroEduccion> managerEdu;
    FileManager<LibroEspecificacion> managerEsp;
    FileManager<Educciones> manEdu;
    FileManager<LibroHistorico> manHisEdu;
    LibroEduccion libroEdu;
    LibroEspecificacion libroEsp;
    /**
     * Constructor de la clase Proyecto
     * @param name Nombre del proyecto
     */
    public Proyecto(){
    }
    
    public void iniciar(String nombre){
        this.directory = new File(nombre);
        this.dirPro = new File(directory, "remanproject");
        this.dirEdu = new File(directory, "src//edu");
        this.dirEli = new File(directory, "src//eli");
        this.dirEsp = new File(directory, "src//esp");
        this.dirOrg = new File(directory, "src//org");
        this.dirRnf = new File(directory, "src//rnf");
        this.dirVerEdu = new File(directory, "verlib//edu");
        this.properties = new Properties();
        this.managerEdu = new FileManager(LibroEduccion.class, this.dirEdu);
        this.managerEsp = new FileManager(LibroEspecificacion.class, this.dirEsp);
        this.manHisEdu = new FileManager(LibroHistorico.class, this.dirVerEdu);
        this.libroEdu = new LibroEduccion(this.dirEdu);
        this.libroEsp = new LibroEspecificacion(this.dirEsp);
        this.manEdu = new FileManager(Educciones.class, dirEdu);
    }

    //Interfaz
    public void ingresoPrograma(){
        
    }
    public void salirPrograma(){
        
    }
    
    //Abrir proyecto
    public void ingresarProyecto(String dir){
        this.directory = new File(dir);
        iniciar(dir);
        loadProperties();
    }
    
    //Cerrar libros
    public void salirProyecto(){
        saveProperties();
        this.name = null;
        this.directory = null;
        this.dirPro = null;
        this.dirEdu = null;
        this.dirEli = null;
        this.dirEsp = null;
        this.dirOrg = null;
        this.dirRnf = null;
        this.properties = null;
        this.managerEdu = null;
        this.managerEsp = null;
        this.libroEdu = null;
        this.libroEsp = null;
        this.manEdu = null;
    }
    
    public void agregarEduccion(String nom, String fueNom, String fueCar,
            String fueTip, String espNom, String espEsp, String espTip, 
            String espExp, String eduTip, String eduObj, String eduFec,
            String des, String obs) 
    {
        Educcion edu = new Educcion(nom, fueNom, fueCar, fueTip, espNom,
                espEsp, espTip, espExp, eduTip, eduObj, eduFec, espTip, obs);
        Educciones nueva = new Educciones(dirEdu);
        nueva.newEdu(edu);
        String codEdu = edu.getEduccionNombre().getCodigo();
        manEdu.escribirXML(codEdu, nueva);
        properties.setProperty("numEdu", Integer.toString(Educcion.getNumero()));
    }
    
    public void modificarEduccion(String cod, String nom, String ver, String fueNom, 
            String fueCar,  String fueTip, String espNom, String espEsp, 
            String espTip, String espExp, String eduTip, String eduObj,
            String eduFec, String des, String obs)
    {
        Educcion edu = new Educcion(cod, nom, ver, fueNom, fueCar, fueTip, espNom,
                espEsp, espTip, espExp, eduTip, eduObj, eduFec, espTip, obs);
        Educciones versiones;
        versiones = manEdu.leerXML(cod);
        versiones.modEdu(edu);
        manEdu.escribirXML(cod, versiones);
    }
    
    public void modificarEduccion(Educcion edu){
        Educciones versiones;
        String cod = edu.getEduccionNombre().getCodigo();
        versiones = manEdu.leerXML(cod);
        versiones.modEdu(edu);
        manEdu.escribirXML(cod, versiones);
    }
    
    public void eliminarEduccion(String cod) {
        manEdu.borrarXML(cod);
    }
    
    public Educcion mostrarEduccion(String cod) {
        Educciones edu;
        edu = manEdu.leerXML(cod);
        return edu.getActual();
    }
    
    public void verEdu(String cod, String nom, String ver, String fueNom, 
            String fueCar,  String fueTip, String espNom, String espEsp, 
            String espTip, String espExp, String eduTip, String eduObj,
            String eduFec, String des, String obs, String razon, String version){
        
        Educcion edu = new Educcion(cod, nom, ver, fueNom, fueCar, fueTip, espNom,
                espEsp, espTip, espExp, eduTip, eduObj, eduFec, espTip, obs);
        Educciones versiones;
        versiones = manEdu.leerXML(cod);
        versiones.modEdu(edu);
        versiones.verEdu(ver, razon);
        manEdu.escribirXML(cod, versiones);
    }
    
    public void restaurarEduccion(String cod, String version){
        Educciones edus;
        edus = manEdu.leerXML(cod);
        Educcion edu = edus.getVer(version);
        modificarEduccion(edu);
    }
    
    public void verLibroEdu(String version, String razon) {
        File cp = new File(dirVerEdu, "edu"+version);
        managerEdu.copiarDirectorios(dirEdu, cp);
        System.out.println("Origen:"+dirEdu);
        System.out.println("Destino"+cp);
    }
    
    public void crearProyecto(String nomPro, String empDes, String empCli, String lidPro, String estPro, String fecIni, String fecFin) {
        iniciar(nomPro);
        createDirectory();
        createProperties(nomPro, empDes, empCli, lidPro, estPro, fecIni, fecFin);
        createHistorics();
    }
    
    public void eliminarProyecto(){
        try {
            FileUtils.deleteDirectory(directory);
        } catch (IOException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createHistorics(){
        LibroHistorico lib = new LibroHistorico();
        manHisEdu.escribirXML("eduhis", lib);
    }
    
    private void createDirectory(){
        directory.mkdir();
        dirVerEdu.mkdirs();
        dirPro.mkdir();
        dirEdu.mkdirs();
        dirEli.mkdir();
        dirEsp.mkdir();
        dirOrg.mkdir();
        dirRnf.mkdir();
    }
    
    private void saveProperties(){
        OutputStream salida = null;
        try {    
            File output = new File(dirPro, "configuracion.properties");
            salida = new FileOutputStream(output);
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
    
    /**
     * Crea el archivo properties insertando los valores del proyecto
     */
    private void createProperties(String nomPro, String empDes, String empCli, String lidPro, String estPro, String fecIni, String fecFin) {
        OutputStream salida = null;
        try {
            File output = new File(dirPro, "configuracion.properties");
            salida = new FileOutputStream(output);
            name = nomPro;
            properties.setProperty("name", nomPro);
            properties.setProperty("empDes", empDes);
            properties.setProperty("empCli", empCli);
            properties.setProperty("lidPro", lidPro);
            properties.setProperty("estPro", estPro);
            properties.setProperty("fecIni", fecIni);
            properties.setProperty("fecFin", fecFin);
            properties.setProperty("numEdu", "0");
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
            this.name = properties.getProperty("name");
            Educcion.setNumero(Integer.parseInt(properties.getProperty("numEdu")));
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
    
    public List<Historico> getHistEdu(String cod){
        Educciones edu;
        edu = manEdu.leerXML(cod);
        return edu.getHistoricos();
    }
     
    public Educcion getLastEdu(String name) {
        Educciones edu;
        edu = manEdu.leerXML(name);
        return edu.getLast();
    }

    public void verLibroEdu(String version, String razon, String autor) {
        File cp = new File(dirVerEdu, "edu"+version);
        managerEdu.copiarDirectorios(dirEdu, cp);
        LibroHistorico libH = manHisEdu.leerXML("eduhis");
        libH.createHistorico(version, razon, autor);
        manHisEdu.escribirXML("eduhis", libH);
        System.out.println("Origen:"+dirEdu);
        System.out.println("Destino"+cp);
    }
    
    public void resLibroEdu(String version){
        File cp = new File(dirVerEdu, "edu"+version);
        try {
            FileUtils.deleteDirectory(dirEdu);
        } catch (IOException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        managerEdu.copiarDirectorios(cp, dirEdu);
        System.out.println("Origen:"+cp);
        System.out.println("Destino"+dirEdu);
    }

    public List<Historico> getHistLibEdu() {
        LibroHistorico libH = manHisEdu.leerXML("eduhis");
        return libH.getHistoricos();
    }
    
    

}
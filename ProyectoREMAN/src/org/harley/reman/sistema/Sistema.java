package org.harley.reman.sistema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.harley.reman.xml.FileManager;

public class Sistema {

    Proyecto pro;
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
     *
     * @param name Nombre del proyecto
     */
    public Sistema() {
    }

    public void iniciarDirectorios(String dirPrincipal) {
        this.dirPro = new File(dirPrincipal, "remanproject");
        this.dirEdu = new File(dirPrincipal, "src//edu");
        this.dirEli = new File(dirPrincipal, "src//eli");
        this.dirEsp = new File(dirPrincipal, "src//esp");
        this.dirOrg = new File(dirPrincipal, "src//org");
        this.dirRnf = new File(dirPrincipal, "src//rnf");
        this.dirVerEdu = new File(dirPrincipal, "verlib//edu");
        this.managerEdu = new FileManager(LibroEduccion.class, this.dirEdu);
        this.managerEsp = new FileManager(LibroEspecificacion.class, this.dirEsp);
        this.manHisEdu = new FileManager(LibroHistorico.class, this.dirVerEdu);
        this.libroEdu = new LibroEduccion();
        this.libroEsp = new LibroEspecificacion(this.dirEsp);
        this.manEdu = new FileManager(Educciones.class, dirEdu);
        this.pro.setDirectory(dirPro);
    }

    //Interfaz
    public void ingresoPrograma() {

    }

    public void salirPrograma(boolean estado) {
        if (estado){
            guardarProyecto();
        }
    }

    //Abrir proyecto
    public void ingresarProyecto(String dirPrincipal) {
        pro = new Proyecto();
        iniciarDirectorios(dirPrincipal);
        pro.loadProperties();
        Educcion.setNumero(Integer.parseInt(pro.getProperty("numEdu")));
    }

    //Cerrar libros
    public void salirProyecto() {
        this.dirPro = null;
        this.dirEdu = null;
        this.dirEli = null;
        this.dirEsp = null;
        this.dirOrg = null;
        this.dirRnf = null;
        this.managerEdu = null;
        this.managerEsp = null;
        this.libroEdu = null;
        this.libroEsp = null;
        this.manEdu = null;
    }

    public void agregarEduccion(String nom, String ver, String fueNom, String fueCar,
            String fueTip, String espNom, String espEsp, String espTip,
            String espExp, String eduTip, String eduObj, String eduFec,
            String des, String obs) {
        Educcion edu = new Educcion(nom, ver, fueNom, fueCar, fueTip, espNom,
                espEsp, espTip, espExp, eduTip, eduObj, eduFec, espTip, obs);
        Educciones nueva = new Educciones(dirEdu);
        nueva.newEdu(edu);
        String codEdu = edu.getEduccionNombre().getCodigo();
        manEdu.escribirXML(codEdu, nueva);
        pro.setProperty("numEdu", Integer.toString(Educcion.getNumero()));
        pro.saveProperties();
    }

    public void modificarEduccion(String cod, String nom, String ver, String fueNom,
            String fueCar, String fueTip, String espNom, String espEsp,
            String espTip, String espExp, String eduTip, String eduObj,
            String eduFec, String des, String obs) {
        Educcion edu = new Educcion(cod, nom, ver, fueNom, fueCar, fueTip, espNom,
                espEsp, espTip, espExp, eduTip, eduObj, eduFec, espTip, obs);
        Educciones versiones;
        versiones = manEdu.leerXML(cod);
        versiones.modEdu(edu);
        manEdu.escribirXML(cod, versiones);
    }

    public void modificarEduccion(Educcion edu) {
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

    public boolean versionarEduccion(String cod, String nom, String ver, String fueNom,
            String fueCar, String fueTip, String espNom, String espEsp,
            String espTip, String espExp, String eduTip, String eduObj,
            String eduFec, String des, String obs, String razon, String version) {
        
        if (Utils.Compara(ver, version)){
            Educcion edu = new Educcion(cod, nom, version, fueNom, fueCar, fueTip, espNom,
                    espEsp, espTip, espExp, eduTip, eduObj, eduFec, espTip, obs);
            Educciones versiones;
            versiones = manEdu.leerXML(cod);
            versiones.modEdu(edu);
            versiones.verEdu(version, razon);
            manEdu.escribirXML(cod, versiones);
            return true;
        }
        return false;
    }

    public void restaurarEduccion(String cod, String version) {
        Educciones edus;
        edus = manEdu.leerXML(cod);
        Educcion edu = edus.getVer(version);
        modificarEduccion(edu);
    }

    /**
     * CU-035. CREAR UN PROYECTO
     * Crear un nuevo proyecto REMAN
     * @param nomPro Nombre del Proyecto
     * @param empDes Empresa desarrolladora
     * @param empCli Empresa cliente
     * @param lidPro Líder del proyecto
     * @param estPro Estado del proyecto
     * @param fecIni Fecha inicial
     * @param fecFin Fecha final
     * @param ubiPro Ubicación del proyecto
     * @return Un valor booleano que indica si la función se realizó correctamente
     */
    public boolean crearProyecto(String nomPro, String empDes, String empCli, String lidPro, String estPro, String fecIni, String fecFin, String ubiPro) {
        try {
            this.pro = new Proyecto(nomPro, empDes, empCli, lidPro, estPro, fecIni, fecFin);
            createDirectory(ubiPro);
            pro.createProperties();
            createHistorics();
            agregarOrganizacion(empDes);    //Falta implementar
            agregarOrganizacion(empCli);    //Falta implementar
            agregarActor(lidPro);           //Falta implementar
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    public void eliminarProyecto() {
        try {
            FileUtils.deleteDirectory(pro.getDirectory());
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createHistorics() {
        LibroHistorico lib = new LibroHistorico();
        manHisEdu.escribirXML("eduhis", lib);
    }

    private void createDirectory(String ubiPro) {
        iniciarDirectorios(ubiPro);
        dirVerEdu.mkdirs();
        dirPro.mkdir();
        dirEdu.mkdirs();
        dirEli.mkdir();
        dirEsp.mkdir();
        dirOrg.mkdir();
        dirRnf.mkdir();
    }

    public Caratula crearCaratula(String libro) {
        Caratula car = new Caratula();
        car.setTitulo(libro);
        car.setPro(pro);
        car.setFecAct("09 de noviembre del 2015");
        return car;
    }

    public void createLibEdu(String nombre) {
        managerEdu.escribirXML(nombre, libroEdu);
    }

    public void exportarLibroEdu(String destino, String nombre) {
        for (final File fileEntry : dirEdu.listFiles()) {
            String name = fileEntry.getName().split("\\.")[0];
            libroEdu.addEduccion(getLastEdu(name));
            libroEdu.setIntro(crearCaratula("EDUCCIÓN DE REQUERIMIENTOS"));
        }
        createLibEdu("libEdu");
        managerEdu.exportarPDF("libEdu", destino, nombre);
    }

    public List<Historico> getHistEdu(String cod) {
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
        File cp = new File(dirVerEdu, "edu" + version);
        managerEdu.copiarDirectorios(dirEdu, cp);
        LibroHistorico libH = manHisEdu.leerXML("eduhis");
        libH.createHistorico(version, razon, autor);
        manHisEdu.escribirXML("eduhis", libH);
        System.out.println("Origen:" + dirEdu);
        System.out.println("Destino" + cp);
    }

    public void resLibroEdu(String version) {
        File cp = new File(dirVerEdu, "edu" + version);
        try {
            FileUtils.deleteDirectory(dirEdu);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        managerEdu.copiarDirectorios(cp, dirEdu);
        System.out.println("Origen:" + cp);
        System.out.println("Destino" + dirEdu);
    }

    public List<Historico> getHistLibEdu() {
        LibroHistorico libH = manHisEdu.leerXML("eduhis");
        return libH.getHistoricos();
    }

    public void agregarOrganizacion(String nom) {
        /*Organizacion org = new Organizacion(nom);
        String codOrg = org.getOrganizacionNombre().getCodigo();
        manOrg.escribirXML(codOrg, org);
        pro.setProperty("numOrg", Integer.toString(Organizacion.getNumero()));
        pro.saveProperties();*/
    }
    
    public void agregarActor(String nom) {
        /*Actor act = new Actor(nom);
        String codAct = org.getActorNombre().getCodigo();
        manAct.escribirXML(codAct, act);
        pro.setProperty("numOrg", Integer.toString(Actor.getNumero()));
        pro.saveProperties();*/
    }

    private void guardarProyecto() {
        pro.saveProperties();
    }
}
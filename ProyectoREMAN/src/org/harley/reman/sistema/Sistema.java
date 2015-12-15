package org.harley.reman.sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.harley.reman.xml.FileManager;

public class Sistema {
    
    Properties propiedades;
    String dirPrincipal;
    FileManager<LibroEduccion> manLibEdu;
    FileManager<LibroElicitacion> manLibEli;
    FileManager<LibroEspecificacion> manLibEsp;
    FileManager<LibroActores> manLibAct;
    FileManager<LibroHistorico> manHisEdu;
    FileManager<LibroHistorico> manHisEli;
    FileManager<Educciones> manVerEdu;
    FileManager<Elicitaciones> manVerEli;
    FileManager<Especificaciones> manVerEsp;
    
    /**
     * Constructor de la clase Sistema
     */
    public Sistema() {
           propiedades = new Properties();
    }

    /**
     * Crear el archivo propiedades del proyecto
     * @param proNom Nombre del Proyecto
     * @param prdNom Nombre del Producto
     * @param empDes Empresa desarrolladora
     * @param empCli Empresa cliente
     * @param proLid Líder del proyecto
     * @param fecIni Fecha inicial
     * @param fecFin Fecha final
     * @param proUbi Ubicación del proyecto 
     */
    public void crearPropiedades(String proNom,String prdNom, String empDes, 
            String empCli, String proLid, String fecIni, String fecFin, 
            String proUbi) {
        OutputStream salida = null;
        try {
            salida = new FileOutputStream(proUbi +
                    "//remanproject//configuracion.properties");
            propiedades.setProperty("proNom", proNom);
            propiedades.setProperty("prdNom", prdNom);
            propiedades.setProperty("empDes", empDes);
            propiedades.setProperty("empCli", empCli);
            propiedades.setProperty("proLid", proLid);
            propiedades.setProperty("proEst", "En desarrollo");
            propiedades.setProperty("fecIni", fecIni);
            propiedades.setProperty("fecFin", fecFin);
            propiedades.setProperty("numEdu", "0");
            propiedades.setProperty("numEli", "0");
            propiedades.setProperty("numEsp", "0");
            propiedades.setProperty("numRnf", "0");
            propiedades.setProperty("numOrg", "0");
            propiedades.setProperty("numSth", "0");
            propiedades.setProperty("numPry", "0");
            propiedades.store(salida, null);
        } catch (IOException io) {
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    /**
     * Crear los directorios del proyecto
     * @param dirPrincipal Directorio principal del proyecto
     */
    public void crearDirectorios(String dirPrincipal){
        this.dirPrincipal = dirPrincipal;
        new File(dirPrincipal).mkdir();
        new File(dirPrincipal,"remanproject").mkdir();
        new File(dirPrincipal,"src//edu").mkdirs();
        new File(dirPrincipal,"src//eli").mkdir();
        new File(dirPrincipal,"src//esp").mkdir();
        new File(dirPrincipal,"src//org").mkdir();
        new File(dirPrincipal,"src//rnf").mkdir();
        new File(dirPrincipal,"verlib//edu").mkdirs();
        new File(dirPrincipal,"verlib//eli").mkdir();
        new File(dirPrincipal,"verlib//esp").mkdir();
        new File(dirPrincipal,"verlib//rnf").mkdir();
    }
    
    /**
     * 
     * @param proUbi Ubicación del proyecto
     * @throws IOException 
     */
    public void iniciarHistoricos(String proUbi) throws IOException{
        new File(proUbi+"//verlib//edu//eduhis.xml").createNewFile();
        new File(proUbi+"//verlib//eli//elihis.xml").createNewFile();
        new File(proUbi+"//verlib//eli//esphis.xml").createNewFile();
    }

    /**
     * 
     * @param proUbi 
     */
    public void iniciarManagers(String proUbi){
        manVerEdu = new FileManager<>(Educciones.class, 
                new File(proUbi + "//src//edu"));
        manLibEdu = new FileManager<>(LibroEduccion.class, 
                new File(proUbi + "//src//edu"));
        manVerEli = new FileManager<>(Elicitaciones.class, 
                new File(proUbi + "//src//eli"));
        manLibEli = new FileManager<>(LibroElicitacion.class, 
                new File(proUbi + "//src//eli"));
        manVerEsp = new FileManager<>(Especificaciones.class, 
                new File(proUbi + "//src//esp"));
        manLibEsp = new FileManager<>(LibroEspecificacion.class, 
                new File(proUbi + "//src//esp"));
    }

    /**
     * CU-035. CREAR UN PROYECTO
     * Crear un nuevo proyecto REMAN
     * @param proNom Nombre del Proyecto
     * @param prdNom Nombre del Producto
     * @param empDes Empresa desarrolladora
     * @param empCli Empresa cliente
     * @param proLid Líder del proyecto
     * @param fecIni Fecha inicial
     * @param fecFin Fecha final
     * @param proUbi Ubicación del proyecto
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean crearProyecto(String proNom,String prdNom, String empDes, 
            String empCli, String proLid, String fecIni, String fecFin, 
            String proUbi){
        try {
            crearDirectorios(proUbi);
            crearPropiedades(proNom, prdNom, empDes, empCli, 
                    proLid, fecIni, fecFin, proUbi);
            iniciarHistoricos(proUbi);
            iniciarManagers(proUbi);
            //crearOrganizacion(empDes);    
            //crearOrganizacion(empCli);    
            agregarActor(proLid, empDes);           
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    /**
     * CU-035. CREAR UNA EDUCCIÓN
     * Crear una educción
     * @param eduNom Nombre de la educción
     * @param eduVer Versión de la educción
     * @param eduTip Tipo de educción
     * @param eduObj Objetivo de educción
     * @param eduFec Fecha de creación de la educción
     * @param eduFueNom Nombre de la fuente
     * @param eduFueCar Cargo de la fuente
     * @param eduFueTip Tipo de la fuente
     * @param eduEspNom Nombre del especialista
     * @param eduEspEsp Especialidad del especialista
     * @param eduEspExp Experiencia del especialista
     * @param eduEspCar Cargo del especialista
     * @param eduDes Descripción de la educción
     * @param eduObs Observaciones de la educción
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean crearEduccion(String eduNom, String eduVer, String eduTip, 
            String eduObj, String eduFec, String eduFueNom, String eduFueCar, 
            String eduFueTip, String eduEspNom, String eduEspEsp,
            String eduEspExp, String eduEspCar, String eduDes, String eduObs) {
        try {
            Educcion edu = new Educcion(eduNom, eduVer, eduTip, eduObj, eduFec, 
                    eduFueNom, eduFueCar, eduFueTip, eduEspNom, eduEspEsp, 
                    eduEspExp, eduEspCar, eduDes, eduObs);
            Educciones verEdu = new Educciones();
            verEdu.newEdu(edu);
            manVerEdu.escribirXML(edu.getEduNom().getEduCod(), verEdu);
            propiedades.setProperty("numEdu", 
                    Integer.toString(Educcion.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    /**
     * 
     * Devolver el conjunto de nombres de todas las fuentes del proyecto
     * @return 
     */
    /*public ArrayList<String> getFuenteNombres(){
        LibroStakeholder stkh;
        stkh = manStk.leerXML("libStk");
        return stkh.getNombres();
    }*/
    
    /**
     * 
     * @return 
     */
    /*public ArrayList<String> getFuenteCodigo(){
        LibroStakeholder stkh;
        stkh = manStk.leerXML("libStk");
        return stkh.getCodigo();
    }*/
    
    /**
     * 
     * Recuperar los datos de una educción
     * @param eduCod Cógio de la educción
     * @return Un objeto Educcion que contiene métodos accesores y mutadores 
     */
    public Educcion recuperarEduccion(String eduCod) {
        Educciones verEdu;
        verEdu = manVerEdu.leerXML(eduCod);
        return verEdu.getActual();
    }
    
    /**
     * 
     * Modifica una educción
     * @param eduCod Código de la educción
     * @param eduNom Nombre de la educción
     * @param eduVer Versión de la educción
     * @param eduTip Tipo de educción
     * @param eduObj Objetivo de educción
     * @param eduFec Fecha de creación de la educción
     * @param eduFueNom Nombre de la fuente
     * @param eduFueCar Cargo de la fuente
     * @param eduFueTip Tipo de la fuente
     * @param eduEspNom Nombre del especialista
     * @param eduEspEsp Especialidad del especialista
     * @param eduEspExp Experiencia del especialista
     * @param eduEspCar Cargo del especialista
     * @param eduDes Descripción de la educción
     * @param eduObs Observaciones de la educción
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean modificarEduccion(String eduCod, String eduNom, 
            String eduVer, String eduTip, String eduObj, String eduFec, 
            String eduFueNom, String eduFueCar, String eduFueTip, 
            String eduEspNom, String eduEspEsp, String eduEspExp, 
            String eduEspCar, String eduDes, String eduObs) {
        try {
            Educcion edu = new Educcion(eduCod, eduNom, eduVer, eduTip, eduObj,
                    eduFec, eduFueNom, eduFueCar, eduFueTip, eduEspNom, 
                    eduEspEsp, eduEspExp, eduEspCar, eduDes, eduObs);
            Educciones verEdu;
            verEdu = manVerEdu.leerXML(eduCod);
            verEdu.modEdu(edu);
            manVerEdu.escribirXML(eduCod, verEdu);
            return true;
        }
        catch(Exception ex){
            return false;
        }   
    }
    
    /**
     * Versionar una educción
     * @param verVer
     * @param verFec
     * @param verEsp
     * @param verRazCam
     * @param eduCod Código de la educción
     * @param eduNom Nombre de la educción
     * @param eduVer Versión de la educción
     * @param eduTip Tipo de educción
     * @param eduObj Objetivo de educción
     * @param eduFec Fecha de creación de la educción
     * @param eduFueNom Nombre de la fuente
     * @param eduFueCar Cargo de la fuente
     * @param eduFueTip Tipo de la fuente
     * @param eduEspNom Nombre del especialista
     * @param eduEspEsp Especialidad del especialista
     * @param eduEspExp Experiencia del especialista
     * @param eduEspCar Cargo del especialista
     * @param eduDes Descripción de la educción
     * @param eduObs Observaciones de la educción
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean versionarEduccion(String verVer, String verFec, 
            String verEsp, String verRazCam, String eduCod, String eduNom, 
            String eduVer,  String eduTip, String eduObj, String eduFec, 
            String eduFueNom, String eduFueCar, String eduFueTip, 
            String eduEspNom, String eduEspEsp, String eduEspExp,
            String eduEspCar, String eduDes, String eduObs) {
        String ultVer = "edu0000";
        //ultver = Educcion.getLastVersion();
        try{
            if (Tools.CompararVersiones(ultVer, verVer)){
                Educcion edu = new Educcion(eduCod, eduNom, eduVer, eduTip, 
                        eduObj, eduFec, eduFueNom, eduFueCar, eduFueTip, 
                        eduEspNom, eduEspEsp, eduEspExp, eduEspCar, eduDes, 
                        eduObs);
                Educciones verEdu;
                verEdu = manVerEdu.leerXML(eduCod);
                verEdu.modEdu(edu);
                verEdu.verEdu(verVer, verFec, verEsp, verRazCam);
                manVerEdu.escribirXML(eduCod, verEdu);
                return true;
            }
            return false;
        }
        catch(Exception ex){
            return false;
        }  
    }
    
    /**
     * 
     * Elimina una educción de un proyecto
     * @param eduCod
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean eliminarEduccion(String eduCod) {
        try {
            //verificar uso en elicitacion
            manVerEdu.borrarXML(eduCod);
            return true;
        }
        catch(Exception ex){
            return false;
        }  
    }
    
    /**
     * 
     * Devolver el conjunto de históricos del elemento del libro seleccionado
     * @param libTip Tipo de libro
     * @param eduCod Código de la educción
     * @return Un ArrayList que contiene un conjunto de objetos Historico con 
     *         métodos accesores y mutadores
     */
    public List<Historico> getHistEdu(int libTip, String eduCod) {
        switch(libTip){
            case 0:
                Educciones edu;
                edu = manVerEdu.leerXML(eduCod);
                return edu.getHistoricos();    
        }
        return null;
    }
    
    /**
     * 
     * Restaurar una versión al estado actual
     * @param verCod Código de la versión
     * @param eduCod Código de la educción
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean restaurarVersionEduccion(String verCod, String eduCod) {
        try {
            Educciones verEdu;
            verEdu = manVerEdu.leerXML(eduCod);
            Educcion edu = verEdu.getVer(verCod);
            modificarEduccion(edu);
            return true;
        }
        catch(Exception ex){
            return false;
        }  
    }
    
    /**
     * Abre un proyecto
     * @param proUbi Ubicación del proyecto
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean ingresarProyecto(String proUbi) {
        try {
            dirPrincipal = proUbi;
            cargarPropiedades(proUbi);
            Educcion.setNumero(
                    Integer.parseInt(propiedades.getProperty("numEdu")));
            iniciarManagers(proUbi);
            return true;
        }
        catch(Exception ex){
            return false;
        } 
    }

    /**
     * Carga el archivo de propiedades
     * @param proUbi Ubicación del proyecto
     */
    public void cargarPropiedades(String proUbi){
        InputStream entrada = null;
        try {
            File input = new File(proUbi + 
                    "//remanproject//configuracion.properties");
            entrada = new FileInputStream(input);
            propiedades.load(entrada);
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
    
    /**
     * Guarda el archivo de propiedades
     * @param proUbi Ubicación del proyecto
     */
    public void guardarPropiedades(String proUbi){
        OutputStream salida = null;
        try {    
            File output = new File(proUbi +
                    "//remanproject//configuracion.properties");
            salida = new FileOutputStream(output);
            propiedades.store(salida, null);
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
    
    //Cerrar libros
    public void salirProyecto() {
        this.manLibEdu = null;
        this.manLibEli = null;
        this.manVerEdu = null;
    }

    public void modificarEduccion(Educcion edu) {
        Educciones versiones;
        String cod = edu.getEduNom().getEduCod();
        versiones = manVerEdu.leerXML(cod);
        versiones.modEdu(edu);
        manVerEdu.escribirXML(cod, versiones);
    }

    /**
     * Elimina la carpeta del proyecto
     */
    public void eliminarProyecto() {
        try {
            FileUtils.deleteDirectory(new File(dirPrincipal));
        } catch (IOException ex) {
        }
    }

    
    public void createLibEdu(String nombre, LibroEduccion lib) {
        manLibEdu.escribirXML(nombre, lib);
    }

    public void exportarLibroEdu(String destino, String nombre) {
        LibroEduccion lib = new LibroEduccion();
        File[] ficheros = new File(dirPrincipal+"//src//edu").listFiles();
        for (File fichero : ficheros) {
            lib.addEduccion(getLastEdu(fichero.getName().split("\\.")[0]));
            lib.setIntro(crearCaratula("EDUCCIÓN DE REQUERIMIENTOS"));
        }
        createLibEdu("libEdu", lib);
        manLibEdu.exportarPDF("libEdu", destino, nombre);
    }  

    public Educcion getLastEdu(String name) {
        Educciones edu;
        edu = manVerEdu.leerXML(name);
        return edu.getLast();
    }

    public void verLibroEdu(String version, String razon, String autor) {
        manLibEdu.copiarDirectorios(new File(dirPrincipal + "//src//edu"), 
                new File(dirPrincipal + "//verlib//edu//edu" + version));
        LibroHistorico libH = manHisEdu.leerXML("eduhis");
        libH.createHistorico(version, razon, autor);
        manHisEdu.escribirXML("eduhis", libH);
    }

    public void resLibroEdu(String version) {
        try {
            FileUtils.deleteDirectory(new File(dirPrincipal + "//src//edu"));
        } catch (IOException ex) {
        }
        manLibEdu.copiarDirectorios(
                new File(dirPrincipal + "//verlib//edu//edu" + version), 
                new File(dirPrincipal + "//src//edu")
        );
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
    
    public void agregarActor(String tpyNom, String tpyOrg) {
        TeamProyect tpy = new TeamProyect(tpyNom, tpyOrg);
        LibroActores libAct = new LibroActores();
        //libAct.addActor(tpy);
        manLibAct.escribirXML("libAct", libAct);
        propiedades.setProperty("numStk", 
                Integer.toString(TeamProyect.getNumero()));
        guardarPropiedades(dirPrincipal);    
    }
    
    public Caratula crearCaratula(String libro) {
        Caratula car = new Caratula(libro, propiedades.getProperty("proNom"),
                propiedades.getProperty("empDes"), 
                propiedades.getProperty("empCli"),
                propiedades.getProperty("proLid"), 
                propiedades.getProperty("proEst"),
                propiedades.getProperty("fecIni"), 
                propiedades.getProperty("fecFin"),
                "09 de noviembre del 2015", "Arequipa, Peru");
        return car;
    }
    
    public void guardarProyecto() {
        guardarPropiedades(dirPrincipal);
    }
    
     
    public void createLibEli(String nombre, LibroElicitacion lib) {
        manLibEli.escribirXML(nombre, lib);
    }

    public void exportarLibroEli(String destino, String nombre) {
        LibroElicitacion lib = new LibroElicitacion();
        File dirEli = new File(dirPrincipal+"//src//eli");
        File[] ficheros = dirEli.listFiles();
        for (File fichero : ficheros) {
            String name = fichero.getName().split("\\.")[0];
            lib.addElicitacion(getLastEli(name));
            lib.setIntro(crearCaratula("ELICITACION DE REQUERIMIENTOS"));
        }
        createLibEli("libEli", lib);
        manLibEli.exportarPDF("libEli", destino, nombre);
    }  

    public Elicitacion getLastEli(String name) {
        Elicitaciones eli;
        eli = manVerEli.leerXML(name);
        return eli.getLast();
    }

    public void verLibroEli(String version, String razon, String autor) {
        File dirVerEli = new File(dirPrincipal+"//verlib//eli");
        File dirEli = new File(dirPrincipal+"//src//eli");
        File cp = new File(dirVerEli, "eli" + version);
        manLibEli.copiarDirectorios(dirEli, cp);
        LibroHistorico libH = manHisEli.leerXML("elihis");
        libH.createHistorico(version, razon, autor);
        manHisEli.escribirXML("elihis", libH);
        System.out.println("Origen:" + dirEli);
        System.out.println("Destino" + cp);
    }

    public void resLibroEli(String version) {
        File dirVerEli = new File(dirPrincipal + "//verlib//eli");
        File dirEli = new File(dirPrincipal + "//src//eli");
        File cp = new File(dirVerEli, "eli" + version);
        try {
            FileUtils.deleteDirectory(dirEli);
        } catch (IOException ex) {
        }
        manLibEli.copiarDirectorios(cp, dirEli);
        System.out.println("Origen:" + cp);
        System.out.println("Destino" + dirEli);
    }

    public List<Historico> getHistLibEli() {
        LibroHistorico libH = manHisEli.leerXML("elihis");
        return libH.getHistoricos();
    }
    
    public void modificarElicitacion(Elicitacion eli) {
        Elicitaciones versiones;
        String cod = eli.getEliNom().getEliCod();
        versiones = manVerEli.leerXML(cod);
        versiones.modEli(eli);
        manVerEli.escribirXML(cod, versiones);
    }

    public boolean crearElicitacion(String eliNom, String eliEduCod, 
            String eliVer, String eliFec, String eliFueNom, String eliFueCar,
            String eliFueTip, String eliEspNom, String eliEspEsp,
            String eliEspExp, String eliEspCar, String eliDep, String eliDes, 
            String eliPre, ArrayList<Paso> eliSec, String eliPos, 
            ArrayList<Paso> eliExc, 
            String eliObs) { 
        try {
            Elicitacion eli = new Elicitacion(eliNom, eliEduCod, eliVer, eliFec, 
                    eliFueNom, eliFueCar, eliFueTip, eliEspNom, eliEspEsp,
                    eliEspExp, eliEspCar, eliDep, eliDes, eliPre, eliSec, 
                    eliPos, eliExc, eliObs);
            Elicitaciones verEli = new Elicitaciones();
            verEli.newEli(eli);
            manVerEli.escribirXML(eli.getEliNom().getEliCod(), verEli);
            propiedades.setProperty("numEdu", 
                    Integer.toString(Elicitacion.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
}
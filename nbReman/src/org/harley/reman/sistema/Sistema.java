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
	Properties stateReman;
    String dirPrincipal;
    FileManager<LibroEduccion> manLibEdu;
    FileManager<LibroElicitacion> manLibEli;
    FileManager<LibroEspecificacion> manLibEsp;
    FileManager<LibroRequisitoNF> manLibRnf;
    FileManager<LibroStakeholder> manLibSth;
    FileManager<LibroProyectTeam> manLibPyt;
    FileManager<LibroOrganizacion> manLibOrg;
    FileManager<LibroHistorico> manHisEdu;
    FileManager<LibroHistorico> manHisEli;
    FileManager<LibroHistorico> manHisEsp;
    FileManager<LibroHistorico> manHisRnf;
    FileManager<Educciones> manVerEdu;
    FileManager<Elicitaciones> manVerEli;
    FileManager<Especificaciones> manVerEsp;
    FileManager<ReqNoFuncionales> manVerRnf;
    FileManager<Organizaciones> manVerOrg;
    FileManager<Stakeholders> manVerSth;
    FileManager<ProyectTeams> manVerPyt;
	
    /**
     * Constructor de la clase Sistema
     */
    public Sistema(String dirProyect) {
        propiedades = new Properties();
        stateReman =  new Properties();
        cargarStateReman();
        setStateRemanDir(dirProyect);
        guardarStateReman();
        dirPrincipal = dirProyect;
    }
    
    /**
     * Constructor de la clase Sistema
     */
    public Sistema() {
        propiedades = new Properties();
        stateReman =  new Properties();
        cargarStateReman();
        dirPrincipal = getDirPrincipal();
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
            propiedades.setProperty("numPyt", "0");
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
    
	public void crearStateReman(String dir) {
        OutputStream salida = null;
        try {
            salida = new FileOutputStream("stateReman.properties");
            stateReman.setProperty("dirAct", dir);
            stateReman.store(salida, null);
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
    
    public void cargarStateReman(){
        InputStream entrada = null;
        try {
            File input = new File("stateReman.properties");
            entrada = new FileInputStream(input);
            stateReman.load(entrada);
            dirPrincipal = stateReman.getProperty("dirAct");
        } catch (IOException ex) {          
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                }
            }
        }
    }
    public void guardarStateReman(){
        OutputStream salida = null;
        try {    
            File output = new File("stateReman.properties");
            salida = new FileOutputStream(output);
            stateReman.store(salida, null);
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
    
    
    
    public void setStateRemanDir(String newDir){
        cargarStateReman();
        stateReman.setProperty("dirAct", newDir);
        dirPrincipal = newDir;
        guardarStateReman();
        
    }

    public String getStateRemanDir() {
        cargarStateReman();
        return stateReman.getProperty("dirAct");
    }
	
    /**
     * Crear los directorios del proyecto
     * @param dirPrincipal Directorio principal del proyecto
     */
    public void crearDirectorios(String dirPrincipal){
        this.dirPrincipal = dirPrincipal;
        new File(dirPrincipal).mkdir();
        new File(dirPrincipal, "remanproject").mkdir();
        new File(dirPrincipal, "src//edu").mkdirs();
        new File(dirPrincipal, "src//eli").mkdir();
        new File(dirPrincipal, "src//esp").mkdir();
        new File(dirPrincipal, "src//rnf").mkdir();
        new File(dirPrincipal, "src//org//org").mkdirs();
        new File(dirPrincipal, "src//org//sth").mkdir();
        new File(dirPrincipal, "src//org//pyt").mkdir();
        new File(dirPrincipal, "verlib//edu").mkdirs();
        new File(dirPrincipal, "verlib//eli").mkdir();
        new File(dirPrincipal, "verlib//esp").mkdir();
        new File(dirPrincipal, "verlib//rnf").mkdir();
    }
    
	/**
     * Modifica el Directorio Principal
     * @param dirPrincipal url del directorio principal
     */
    public void setDirPrincipal(String dirPrincipal) {
        setStateRemanDir(dirPrincipal);
        this.dirPrincipal = dirPrincipal;
    }

    /**
     * retorna la direccion del Directorio Principal
     * @return 
     */
    public String getDirPrincipal() {
        return dirPrincipal;
    }
	
    /**
     * 
     * @param proUbi Ubicación del proyecto
     * @throws IOException 
     */
    public void iniciarHistoricos(String proUbi) throws IOException{
        new File(proUbi + "//verlib//edu//eduhis.xml").createNewFile();
        new File(proUbi + "//verlib//eli//elihis.xml").createNewFile();
        new File(proUbi + "//verlib//eli//esphis.xml").createNewFile();
        new File(proUbi + "//verlib//rnf//rnfhis.xml").createNewFile();
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
        manVerRnf = new FileManager<>(ReqNoFuncionales.class, 
                new File(proUbi + "//src//rnf"));
        manLibRnf = new FileManager<>(LibroRequisitoNF.class, 
                new File(proUbi + "//src//rnf"));
        manVerOrg = new FileManager<>(Organizaciones.class, 
                new File(proUbi + "//src//org//org"));
        manLibOrg = new FileManager<>(LibroOrganizacion.class, 
                new File(proUbi + "//src//org//org"));
        manVerSth = new FileManager<>(Stakeholders.class, 
                new File(proUbi + "//src//org//sth"));
        manLibSth = new FileManager<>(LibroStakeholder.class, 
                new File(proUbi + "//src//org//sth"));
        manVerPyt = new FileManager<>(ProyectTeams.class, 
                new File(proUbi + "//src//org//pyt"));
        manLibPyt = new FileManager<>(LibroProyectTeam.class, 
                new File(proUbi + "//src//org//pyt")); 
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
            crearOrganizacion(empDes, "", "", "", "", "");    
            crearOrganizacion(empCli, "", "", "", "", "");    
            crearProyectTeam(proLid, empDes, "", "", "", "", "");           
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
            manVerEdu.escribirXML(edu.getEduNombre().getEduCod(), verEdu);
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
     * Recuperar los datos de una educción
     * @param eduCod Cógio de la educción
     * @return Un objeto Educcion que contiene métodos accesores y mutadores 
     */
    public Educcion recuperarEduccion(String eduCod) {
        Educciones verEdu = manVerEdu.leerXML(eduCod);
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
            Educciones verEdu = manVerEdu.leerXML(eduCod);
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
        try{
            Educciones verEdu = manVerEdu.leerXML(eduCod);
            String ultVer = verEdu.getLast().eduNombre.eduCod;
            if (ToolsSystem.CompararVersiones(ultVer, verVer)){
                Educcion edu = new Educcion(eduCod, eduNom, eduVer, eduTip, 
                        eduObj, eduFec, eduFueNom, eduFueCar, eduFueTip, 
                        eduEspNom, eduEspEsp, eduEspExp, eduEspCar, eduDes, 
                        eduObs);
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
     * @param codigo Código del libro
     * @return Un ArrayList que contiene un conjunto de objetos Historico con 
     *         métodos accesores y mutadores
     */
    public List<Historico> getHist(int libTip, String codigo) {
        switch(libTip){
            case 0:
                Educciones edu = manVerEdu.leerXML(codigo);
                return edu.getHistoricos();
            case 1:
                Elicitaciones eli = manVerEli.leerXML(codigo);
                return eli.getHistoricos();
            case 2:
                Especificaciones esp = manVerEsp.leerXML(codigo);
                return esp.getHistoricos();
            case 3:
                ReqNoFuncionales rnq = manVerRnf.leerXML(codigo);
                return rnq.getHistoricos();
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
            Educciones verEdu = manVerEdu.leerXML(eduCod);
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
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean ingresarProyecto() {
        try {
            cargarPropiedades(dirPrincipal);
            Educcion.setNumero(
                    Integer.parseInt(propiedades.getProperty("numEdu")));
            Elicitacion.setNumero(
                    Integer.parseInt(propiedades.getProperty("numEli")));
            Especificacion.setNumero(
                    Integer.parseInt(propiedades.getProperty("numEsp")));
            ReqNoFuncional.setNumero(
                    Integer.parseInt(propiedades.getProperty("numRnf")));
            Organizacion.setNumero(
                    Integer.parseInt(propiedades.getProperty("numOrg")));
            Stakeholder.setNumero(
                    Integer.parseInt(propiedades.getProperty("numSth")));
            ProyectTeam.setNumero(
                    Integer.parseInt(propiedades.getProperty("numPyt")));
            iniciarManagers(dirPrincipal);
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
        String cod = edu.getEduNombre().getEduCod();
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
        File[] ficheros = new File(dirPrincipal + "//src//edu").listFiles();
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

    public void verLibroEdu(String version, String fecha, String razon, 
            String autor) {
        manLibEdu.copiarDirectorios(new File(dirPrincipal + "//src//edu"), 
                new File(dirPrincipal + "//verlib//edu//edu" + version));
        LibroHistorico libH = manHisEdu.leerXML("eduhis");
        libH.createHistorico(version, fecha, razon, autor);
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

    public void exportarLibro(int libTip, String destino, String nombre){
        switch (libTip){
            case 0: exportarLibroEdu(destino, nombre);
                break;
            case 1: exportarLibroEli(destino, nombre);
                break;
            case 2: exportarLibroEsp(destino, nombre);
                break;
            case 3: exportarLibroRnf(destino, nombre);
                break;
            case 4: exportarLibroOrg(destino, nombre);
                break;
    //        case 5: exportarLibroSth(destino, nombre);
    //            break;
            case 6: exportarLibroPyt(destino, nombre);
                break;
        }
    }
    
    public void exportarLibroEli(String destino, String nombre) {
        LibroElicitacion lib = new LibroElicitacion();
        File[] ficheros = new File(dirPrincipal + "//src//eli").listFiles();
        for (File fichero : ficheros) {
            String name = fichero.getName().split("\\.")[0];
            lib.addElicitacion(getLastEli(name));
            lib.setIntro(crearCaratula("ELICITACION DE REQUERIMIENTOS"));
        }
        createLibEli("libEli", lib);
        manLibEli.exportarPDF("libEli", destino, nombre);
    }  

    public Elicitacion getLastEli(String codEli) {
        Elicitaciones eli = manVerEli.leerXML(codEli);
        return eli.getLast();
    }
    
    public void verLibroEli(String version, String fecha, String razon, String autor) {
        manLibEli.copiarDirectorios(new File(dirPrincipal+"//src//eli"), 
                new File(dirPrincipal+"//verlib//eli//eli" + version));
        LibroHistorico libH = manHisEli.leerXML("elihis");
        libH.createHistorico(version, fecha, razon, autor);
        manHisEli.escribirXML("elihis", libH);
    }

    
    public void resLibroEli(String version) {
        try {
            FileUtils.deleteDirectory(new File(dirPrincipal + "//src//eli"));
        } catch (IOException ex) {
        }
        manLibEli.copiarDirectorios(
                new File(dirPrincipal + "//verlib//eli//eli" + version),
                new File(dirPrincipal + "//src//eli")
        );
    }

    public List<Historico> getHistLibEli() {
        LibroHistorico libH = manHisEli.leerXML("elihis");
        return libH.getHistoricos();
    }
    
    public void modificarElicitacion(Elicitacion eli) {
        Elicitaciones versiones;
        String cod = eli.getEliNombre().getEliCod();
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
            manVerEli.escribirXML(eli.getEliNombre().getEliCod(), verEli);
            propiedades.setProperty("numEdu", 
                    Integer.toString(Elicitacion.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public Elicitacion recuperarElicitacion(String eliCod) {
        Elicitaciones verEli;
        verEli = manVerEli.leerXML(eliCod);
        return verEli.getActual();
    }
    
    public boolean modificarElicitacion(String eliCod, String eliNom, 
            String eliEduCod, String eliVer, String eliFec, String eliFueNom, 
            String eliFueCar, String eliFueTip, String eliEspNom,
            String eliEspEsp, String eliEspExp, String eliEspCar, String eliDep,
            String eliDes, String eliPre, ArrayList<Paso> eliSec, String eliPos, 
            ArrayList<Paso> eliExc, 
            String eliObs) { 
        try {
            Elicitacion eli = new Elicitacion(eliCod, eliNom, eliEduCod, eliVer,
                    eliFec, eliFueNom, eliFueCar, eliFueTip, eliEspNom, 
                    eliEspEsp,eliEspExp, eliEspCar, eliDep, eliDes, eliPre, 
                    eliSec, eliPos, eliExc, eliObs);
            Elicitaciones verEli = manVerEli.leerXML(eliCod);
            verEli.modEli(eli);
            manVerEli.escribirXML(eliCod, verEli);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public boolean versionarElicitacion(String verVer, String verFec, 
            String verEsp, String verRazCam, String eliCod, String eliNom, 
            String eliEduCod, String eliVer, String eliFec, String eliFueNom, 
            String eliFueCar, String eliFueTip, String eliEspNom,
            String eliEspEsp, String eliEspExp, String eliEspCar, String eliDep,
            String eliDes, String eliPre, ArrayList<Paso> eliSec, String eliPos, 
            ArrayList<Paso> eliExc, 
            String eliObs) { 
        try {
            String ultVer = "eli0000";
        //ultver = Educcion.getLastVersion();
            if (ToolsSystem.CompararVersiones(ultVer, verVer)){
                Elicitacion eli = new Elicitacion(eliCod, eliNom, eliEduCod, eliVer,
                        eliFec, eliFueNom, eliFueCar, eliFueTip, eliEspNom, 
                        eliEspEsp,eliEspExp, eliEspCar, eliDep, eliDes, eliPre, 
                        eliSec, eliPos, eliExc, eliObs);
                Elicitaciones verEli = manVerEli.leerXML(eliCod);
                verEli.modEli(eli);
                verEli.verEli(verVer, verFec, verEsp, verRazCam);
                manVerEli.escribirXML(eliCod, verEli);
                return true;
            }
            return false;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public boolean restaurarVersionElicitacion(String verCod, String eliCod) {
        try {
            Elicitaciones verEli = manVerEli.leerXML(eliCod);
            Elicitacion eli = verEli.getVer(verCod);
            modificarElicitacion(eli);
            return true;
        }
        catch(Exception ex){
            return false;
        }  
    }
    
    public boolean crearEspecificacion(String espNom, String espEliCod, 
            String espVer, String espFec, String espFueNom, String espFueCar, 
            String espFueTip, String espEspNom, String espEspEsp, 
            String espEspExp, String espEspCar, String espDep, String espDes,
            String espPre, String espPos, ArrayList<Paso> espExc, 
            String espObs) { 
        try {
            Especificacion esp = new Especificacion(espNom, espEliCod, espVer,
            espFec, espFueNom, espFueCar, espFueTip, espEspNom,
            espEspEsp, espEspExp, espEspCar, espDep, espDes,
            espPre, espPos, espExc, espObs);
            Especificaciones verEsp = new Especificaciones();
            verEsp.newEsp(esp);
            manVerEsp.escribirXML(esp.getEspNombre().getEspCod(), verEsp);
            propiedades.setProperty("numEsp", 
                    Integer.toString(Especificacion.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public Especificacion recuperarEspecificacion(String espCod) {
        Especificaciones verEsp;
        verEsp = manVerEsp.leerXML(espCod);
        return verEsp.getActual();
    }
    
    public boolean modificarEspecificacion(String espCod, String espNom, String espEliCod, 
            String espVer, String espFec, String espFueNom, String espFueCar, 
            String espFueTip, String espEspNom, String espEspEsp, 
            String espEspExp, String espEspCar, String espDep, String espDes,
            String espPre, String espPos, ArrayList<Paso> espExc, 
            String espObs) { 
        try {
            Especificacion esp = new Especificacion(espCod, espNom, espEliCod, 
                    espVer, espFec, espFueNom, espFueCar, espFueTip, espEspNom,
                    espEspEsp, espEspExp, espEspCar, espDep, espDes,
                    espPre, espPos, espExc, espObs);
            Especificaciones verEsp = manVerEsp.leerXML(espCod);
            verEsp.modEsp(esp);
            manVerEsp.escribirXML(espCod, verEsp);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public boolean versionarEspecificacion(String verVer, String verFec, 
            String verEsp, String verRazCam, String espCod, String espNom,
            String espEliCod, String espVer, String espFec, String espFueNom, 
            String espFueCar, String espFueTip, String espEspNom, 
            String espEspEsp, String espEspExp, String espEspCar, String espDep, 
            String espDes, String espPre, String espPos, ArrayList<Paso> espExc, 
            String espObs) { 
        try {
            String ultVer = "ESP0000";
        //ultver = Educcion.getLastVersion();
            if (ToolsSystem.CompararVersiones(ultVer, verVer)){
                Especificacion esp = new Especificacion(espCod, espNom, espEliCod, 
                    espVer, espFec, espFueNom, espFueCar, espFueTip, espEspNom,
                    espEspEsp, espEspExp, espEspCar, espDep, espDes,
                    espPre, espPos, espExc, espObs);
                Especificaciones verEsps = manVerEsp.leerXML(espCod);
                verEsps.modEsp(esp);
                verEsps.verEsp(verVer, verFec, verEsp, verRazCam);
                manVerEsp.escribirXML(espCod, verEsps);
                return true;
            }
            return false;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public boolean restaurarVersionEspecificacion(String verCod, String espCod) {
        try {
            Especificaciones verEsp = manVerEsp.leerXML(espCod);
            Especificacion esp = verEsp.getVer(verCod);
            modificarEspecificacion(esp);
            return true;
        }
        catch(Exception ex){
            return false;
        }  
    }
        
    public void exportarLibroEsp(String destino, String nombre) {
        LibroEspecificacion lib = new LibroEspecificacion();
        File[] ficheros = new File(dirPrincipal + "//src//esp").listFiles();
        for (File fichero : ficheros) {
            String name = fichero.getName().split("\\.")[0];
            lib.addEspecificacion(getLastEsp(name));
            lib.setIntro(crearCaratula("ESPECIFICACIÓN DE REQUERIMIENTOS"));
        }
        createLibEsp("libEsp", lib);
        manLibEsp.exportarPDF("libEsp", destino, nombre);
    }  

    public void createLibEsp(String nombre, LibroEspecificacion lib) {
        manLibEsp.escribirXML(nombre, lib);
    }
    
    public Especificacion getLastEsp(String name) {
        Especificaciones esp = manVerEsp.leerXML(name);
        return esp.getLast();
    }
    
    public void verLibroEsp(String version, String fecha, String razon, 
            String autor) {
        manLibEsp.copiarDirectorios(new File(dirPrincipal+"//src//esp"), 
                new File(dirPrincipal+"//verlib//esp//esp" + version));
        LibroHistorico libH = manHisEsp.leerXML("esphis");
        libH.createHistorico(version, fecha, razon, autor);
        manHisEsp.escribirXML("esphis", libH);
    }
    
    public void resLibroEsp(String version) {
        try {
            FileUtils.deleteDirectory(new File(dirPrincipal + "//src//esp"));
        } catch (IOException ex) {
        }
        manLibEli.copiarDirectorios(
                new File(dirPrincipal + "//verlib//esp//esp" + version),
                new File(dirPrincipal + "//src//esp")
        );
    }

    public List<Historico> getHistLibEsp() {
        LibroHistorico libH = manHisEsp.leerXML("elihis");
        return libH.getHistoricos();
    }
    
    public void exportarLibroRnf(String destino, String nombre) {
        LibroRequisitoNF lib = new LibroRequisitoNF();
        File[] ficheros = new File(dirPrincipal + "//src//rnf").listFiles();
        for (File fichero : ficheros) {
            String name = fichero.getName().split("\\.")[0];
            lib.addReqNoFuncional(getLastRnf(name));
            lib.setIntro(crearCaratula("REQUISITOS NO FUNCIONALES"));
        }
        createLibRnf("libRnf", lib);
        manLibRnf.exportarPDF("libRnf", destino, nombre);
    }  

    public void createLibRnf(String nombre, LibroRequisitoNF lib) {
        manLibRnf.escribirXML(nombre, lib);
    }
    
    public ReqNoFuncional getLastRnf(String name) {
        ReqNoFuncionales rnf = manVerRnf.leerXML(name);
        return rnf.getLast();
    }
    
    public void verLibroRnf(String version, String fecha, String razon, 
            String autor) {
        manLibEsp.copiarDirectorios(new File(dirPrincipal+"//src//rnf"), 
                new File(dirPrincipal+"//verlib//rnf//rnf" + version));
        LibroHistorico libH = manHisRnf.leerXML("rnfhis");
        libH.createHistorico(version, fecha, razon, autor);
        manHisRnf.escribirXML("rnfhis", libH);
    }
    
    public void resLibroRnf(String version) {
        try {
            FileUtils.deleteDirectory(new File(dirPrincipal + "//src//rnf"));
        } catch (IOException ex) {
        }
        manLibRnf.copiarDirectorios(
                new File(dirPrincipal + "//verlib//rnf//rnf" + version),
                new File(dirPrincipal + "//src//rnf")
        );
    }

    public List<Historico> getHistLibRnf() {
        LibroHistorico libH = manHisRnf.leerXML("rnfhis");
        return libH.getHistoricos();
    }
    
    public void modificarEspecificacion(Especificacion esp) {
        Especificaciones versiones;
        String espCod = esp.getEspNombre().getEspCod();
        versiones = manVerEsp.leerXML(espCod);
        versiones.modEsp(esp);
        manVerEsp.escribirXML(espCod, versiones);
    }
    
    public void modificarRequisitoNF(ReqNoFuncional rnf) {
        ReqNoFuncionales versiones;
        String rnfCod = rnf.getRnfNombre().getRnfCod();
        versiones = manVerRnf.leerXML(rnfCod);
        versiones.modRnf(rnf);
        manVerRnf.escribirXML(rnfCod, versiones);
    }
    
    public boolean crearReqNoFuncional(String rnfNom, String rnfVer, 
            String rnfTip, String rnfObj, String rnfFec, String rnfFueNom,
            String rnfFueCar, String rnfFueTip, String rnfEspNom, 
            String rnfEspEsp, String rnfEspExp, String rnfEspCar, String rnfDep,
            String rnfDes, String rnfObs) { 
        try {
            ReqNoFuncional rnf = new ReqNoFuncional(rnfNom, rnfVer, rnfTip, 
                    rnfObj, rnfFec, rnfFueNom, rnfFueCar, rnfFueTip, rnfEspNom,
                    rnfEspEsp, rnfEspExp, rnfEspCar, rnfDep, rnfDes, rnfObs);
            
            ReqNoFuncionales verRnf = new ReqNoFuncionales();
            verRnf.newRnf(rnf);
            manVerRnf.escribirXML(rnf.getRnfNombre().getRnfCod(), verRnf);
            propiedades.setProperty("numRnf", 
                    Integer.toString(ReqNoFuncional.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public boolean modificarReqNoFuncional(String rnfCod, String rnfNom, String rnfVer, 
            String rnfTip, String rnfObj, String rnfFec, String rnfFueNom,
            String rnfFueCar, String rnfFueTip, String rnfEspNom, 
            String rnfEspEsp, String rnfEspExp, String rnfEspCar, String rnfDep,
            String rnfDes, String rnfObs) { 
        try {
            ReqNoFuncional rnf = new ReqNoFuncional(rnfCod, rnfNom, rnfVer, 
            rnfTip, rnfObj, rnfFec, rnfFueNom, rnfFueCar, rnfFueTip, rnfEspNom, 
            rnfEspEsp, rnfEspExp, rnfEspCar, rnfDep, rnfDes, rnfObs);
            ReqNoFuncionales verRnf = manVerRnf.leerXML(rnfCod);
            verRnf.modRnf(rnf);
            manVerRnf.escribirXML(rnfCod, verRnf);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public boolean crearOrganizacion(String orgNom, String orgDir, 
            String orgTel, String orgPagWeb, String orgCorEle, String orgCom) { 
        try {
            Organizacion org = new Organizacion(orgNom, orgDir, orgTel, 
                    orgPagWeb, orgCorEle, orgCom);
            Organizaciones verOrg = new Organizaciones();
            verOrg.setActual(org);
            manVerOrg.escribirXML(org.getOrgNom().getOrgCod(), verOrg);
            propiedades.setProperty("numRnf", 
                    Integer.toString(ReqNoFuncional.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public boolean modificarOrganizacion(String orgCod, String orgNom, 
            String orgDir, String orgTel, String orgPagWeb, String orgCorEle, 
            String orgCom) { 
        try {
            Organizacion org = new Organizacion(orgCod, orgNom, orgDir, orgTel, 
                    orgPagWeb, orgCorEle, orgCom);
            Organizaciones verOrg = manVerOrg.leerXML(orgCod);
            verOrg.setActual(org);
            manVerOrg.escribirXML(orgCod, verOrg);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public void exportarLibroOrg(String destino, String nombre) {
        LibroOrganizacion lib = new LibroOrganizacion();
        File[] ficheros = new File(dirPrincipal + "//src//org//org").listFiles();
        for (File fichero : ficheros) {
            String name = fichero.getName().split("\\.")[0];
            lib.addOrg(getLastOrg(name));
            lib.setIntro(crearCaratula("ORGANIZACIONES"));
        }
        createLibOrg("libOrg", lib);
        manLibEli.exportarPDF("libOrg", destino, nombre);
    }
    
    public Organizacion getLastOrg(String codOrg) {
        Organizaciones org = manVerOrg.leerXML(codOrg);
        return org.getActual();
    }
    
    public void createLibOrg(String nombre, LibroOrganizacion lib) {
        manLibOrg.escribirXML(nombre, lib);
    }
    
    public boolean crearProyectTeam(String pytNom, String pytOrg, String pytEsp, 
            String pytExp, String pytCar, String pytCor, String pytCom) { 
        try {
            ProyectTeam pyt = new ProyectTeam(pytNom, pytOrg, pytEsp, pytExp,
                    pytCar, pytCor, pytCom);
            ProyectTeams verPyt = new ProyectTeams();
            verPyt.setActual(pyt);
            manVerPyt.escribirXML(pyt.getTeamNombre().getPytCod(), verPyt);
            propiedades.setProperty("numPyt", 
                    Integer.toString(ProyectTeam.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public void exportarLibroPyt(String destino, String nombre) {
        LibroProyectTeam lib = new LibroProyectTeam();
        File[] ficheros = new File(dirPrincipal + "//src//org//pyt").listFiles();
        for (File fichero : ficheros) {
            String name = fichero.getName().split("\\.")[0];
            lib.addPyt(getLastPyt(name));
            lib.setIntro(crearCaratula("PROYECTTEAM"));
        }
        createLibPyt("libPyt", lib);
        manLibEli.exportarPDF("libPyt", destino, nombre);
    }
    
    public ProyectTeam getLastPyt(String codOrg) {
        ProyectTeams pyt = manVerPyt.leerXML(codOrg);
        return pyt.getActual();
    }
    
    public void createLibPyt(String nombre, LibroProyectTeam lib) {
        manLibPyt.escribirXML(nombre, lib);
    }
    
    /**
     * 
     * Devolver el conjunto de nombres de todas las fuentes del proyecto
     * @return 
     */
    /*public List<String> getFuenteNombres(){
        LibroStakeholder libStk = manLibAct.leerXML("libAct");
        return libStk.getFueNom();
    }*/
    
    /**
     * 
     * @return 
     */
    /*public List<String> getFuenteCodigo(){
        LibroStakeholder libStk = manLibAct.leerXML("libAct");
        return libStk();
    }*/
}

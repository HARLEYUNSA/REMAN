package org.harley.reman.sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.harley.reman.reportes.xml.FileManager;

public class Sistema {

    Properties propiedades;
    Properties stateReman;
    String dirPrincipal;
    FileManager<LibroEduccion> manLibEdu;
    FileManager<LibroElicitacion> manLibEli;
    FileManager<LibroEspecificacion> manLibEsp;
    FileManager<LibroRequisitoNF> manLibRnf;
    FileManager<LibroActor> manLibAct;
    FileManager<LibroOrganizacion> manLibOrg;
    FileManager<LibroHistorico> manHisEdu;
    FileManager<LibroHistorico> manHisEli;
    FileManager<LibroHistorico> manHisEsp;
    FileManager<LibroHistorico> manHisRnf;
    FileManager<Educciones> manVerEdu;
    FileManager<Elicitaciones> manVerEli;
    FileManager<Especificaciones> manVerEsp;
    FileManager<RequisitosNF> manVerRnf;
    FileManager<Organizacion> manOrg;
    FileManager<Stakeholder> manSth;
    FileManager<ProyectTeam> manPyt;

    /**
     * Constructor de la clase Sistema
     */
    public Sistema() {
        propiedades = new Properties();
        stateReman = new Properties();
        dirPrincipal = getStateReman();
        File f = new File(dirPrincipal);
        if (f.exists())
            ingresarProyecto();
    }

    /**
     * Crear el archivo propiedades del proyecto
     *
     * @param proNom Nombre del Proyecto
     * @param prdNom Nombre del Producto
     * @param empDes Empresa desarrolladora
     * @param empCli Empresa cliente
     * @param proLid Líder del proyecto
     * @param fecIni Fecha inicial
     * @param fecFin Fecha final
     * @param proUbi Ubicación del proyecto
     */
    public void crearPropiedades(String proNom, String prdNom, String empDes,
            String empCli, String proLid, String fecIni, String fecFin,
            String proUbi) {
        OutputStream salida = null;
        try {
            salida = new FileOutputStream(proUbi
                    + "//remanproject//configuracion.properties");
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

    private void crearFileRem(String name) {
        OutputStream salida = null;
        try {
            salida = new FileOutputStream(dirPrincipal + "\\" + name + ".rem");
            salida.close();
        } catch (Exception e) {
        }
    }

    /**
     * Crea un archivo q almacena la ubicacion del ultimo proyecto utilizado
     *
     * @param dir directorio del ultimo proyecto
     */
    public void crearStateReman() {
        OutputStream salida = null;
        try {
            salida = new FileOutputStream("stateReman.properties");
            stateReman.setProperty("dirAct", dirPrincipal);
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

    public String getStateReman() {
        InputStream entrada = null;
        String rpt = "\\";
        try {
            File input = new File("stateReman.properties");
            entrada = new FileInputStream(input);
            stateReman.load(entrada);
            rpt = stateReman.getProperty("dirAct");
        } catch (IOException ex) {
        }
        return rpt;
    }

    public void setStateReman(String path) {
        OutputStream salida = null;
        try {
            salida = new FileOutputStream("stateReman.properties");
            stateReman.setProperty("dirAct", path);
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

    /**
     * Crear los directorios del proyecto
     */
    public void crearDirectorios() {
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
     *
     * @param dirPrincipal url del directorio principal
     */
    public void setDirPrincipal(String dirPrincipal) {
        this.dirPrincipal = dirPrincipal;
    }

    /**
     * retorna la direccion del Directorio Principal
     *
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
    public void iniciarHistoricos() {
        LibroHistorico libH = new LibroHistorico();
        manHisEdu.escribirXML("eduhis", libH);
        manHisEli.escribirXML("elihis", libH);
        manHisEsp.escribirXML("esphis", libH);
        manHisRnf.escribirXML("rnfhis", libH);
    }

    public void iniciarManagers() {
        manVerEdu = new FileManager<>(Educciones.class,
                new File(dirPrincipal + "//src//edu"));
        manLibEdu = new FileManager<>(LibroEduccion.class,
                new File(dirPrincipal + "//src//edu"));
        manHisEdu = new FileManager<>(LibroHistorico.class,
                new File(dirPrincipal + "//verlib//edu"));
        manVerEli = new FileManager<>(Elicitaciones.class,
                new File(dirPrincipal + "//src//eli"));
        manLibEli = new FileManager<>(LibroElicitacion.class,
                new File(dirPrincipal + "//src//eli"));
        manHisEli = new FileManager<>(LibroHistorico.class,
                new File(dirPrincipal + "//verlib//eli"));
        manVerEsp = new FileManager<>(Especificaciones.class,
                new File(dirPrincipal + "//src//esp"));
        manLibEsp = new FileManager<>(LibroEspecificacion.class,
                new File(dirPrincipal + "//src//esp"));
        manHisEsp = new FileManager<>(LibroHistorico.class,
                new File(dirPrincipal + "//verlib//esp"));
        manVerRnf = new FileManager<>(RequisitosNF.class,
                new File(dirPrincipal + "//src//rnf"));
        manLibRnf = new FileManager<>(LibroRequisitoNF.class,
                new File(dirPrincipal + "//src//rnf"));
        manHisRnf = new FileManager<>(LibroHistorico.class,
                new File(dirPrincipal + "//verlib//rnf"));
        manOrg = new FileManager<>(Organizacion.class,
                new File(dirPrincipal + "//src//org//org"));
        manLibOrg = new FileManager<>(LibroOrganizacion.class,
                new File(dirPrincipal + "//src//org//org"));
        manSth = new FileManager<>(Stakeholder.class,
                new File(dirPrincipal + "//src//org//sth"));
        manPyt = new FileManager<>(ProyectTeam.class,
                new File(dirPrincipal + "//src//org//pyt"));
        manLibAct = new FileManager<>(LibroActor.class,
                new File(dirPrincipal + "//src//org"));
    }

    /**
     * CU-035. CREAR UN PROYECTO Crear un nuevo proyecto REMAN
     *
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
    public boolean crearProyecto(String proNom, String prdNom, String empDes,
            String empCli, String proLid, String fecIni, String fecFin,
            String proUbi) {
        try {
            crearDirectorios();
            crearPropiedades(proNom, prdNom, empDes, empCli,
                    proLid, fecIni, fecFin, proUbi);
            ingresarProyecto();
            crearFileRem(proNom);
            iniciarManagers();
            iniciarHistoricos();
            crearOrganizacion(empDes, "Direccion Desconocida", "Desconocido", "www.empDes.com", "example@domain.com", "Autogenerado");
            crearOrganizacion(empCli, "Direccion Desconocida", "Desconocido", "www.empCli,com", "example@domain.com", "Autogenerado");
            crearProyectTeam(proLid, empDes, "Desconocida", "Desconocida", "Lider", "example@domain.com", "Autogenerado");
            crearStakeholder("Cliente", empCli, "Jefe", "Interno", "example@domain.com", "Autogenerado");
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * CU-035. CREAR UNA EDUCCIÓN Crear una educción
     *
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
            manVerEdu.escribirXML(edu.getEduNombre().getCodigo(), verEdu);
            propiedades.setProperty("numEdu",
                    Integer.toString(Educcion.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * Recuperar los datos de una educción
     *
     * @param eduCod Código de la educción
     * @return Un objeto Educcion que contiene métodos accesores y mutadores
     */
    public Educcion recuperarEduccion(String eduCod) {
        Educciones verEdu = manVerEdu.leerXML(eduCod);
        return verEdu.getActual();
    }

    /**
     *
     * Modificar una educción
     *
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
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Versionar una educción
     *
     * @param verVer Versión de la educción
     * @param verFec Fecha de la versión
     * @param verEsp Especialista que versiona
     * @param verRazCam Razón de cambió
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
            String eduVer, String eduTip, String eduObj, String eduFec,
            String eduFueNom, String eduFueCar, String eduFueTip,
            String eduEspNom, String eduEspEsp, String eduEspExp,
            String eduEspCar, String eduDes, String eduObs) {
        try {
            Educciones verEdu = manVerEdu.leerXML(eduCod);
            String ultVer = verEdu.getLast().getEduNombre().getCodigo();
            if (ToolsSystem.CompararVersiones(ultVer, verVer)) {
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
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * Eliminar una educción
     *
     * @param eduCod
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean eliminarEduccion(String eduCod) {
        try {
            //verificar uso en elicitacion
            manVerEdu.borrarXML(eduCod);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * Devolver el conjunto de históricos del elemento del libro seleccionado
     *
     * @param libTip Tipo de libro
     * @param codigo Código del libro
     * @return Un ArrayList que contiene un conjunto de objetos Historico con
     * métodos accesores y mutadores
     */
    public ArrayList<Historico> getHist(int libTip, String codigo) {
        switch (libTip) {
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
                RequisitosNF rnq = manVerRnf.leerXML(codigo);
                return rnq.getHistoricos();
        }
        return null;
    }

    /**
     *
     * Restaurar una educción
     *
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
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Abre un proyecto
     *
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean ingresarProyecto() {
        try {
            cargarPropiedades();
            Educcion.setNumero(
                    Integer.parseInt(propiedades.getProperty("numEdu")));
            Elicitacion.setNumero(
                    Integer.parseInt(propiedades.getProperty("numEli")));
            Especificacion.setNumero(
                    Integer.parseInt(propiedades.getProperty("numEsp")));
            RequisitoNF.setNumero(
                    Integer.parseInt(propiedades.getProperty("numRnf")));
            Organizacion.setNumero(
                    Integer.parseInt(propiedades.getProperty("numOrg")));
            Stakeholder.setNumero(
                    Integer.parseInt(propiedades.getProperty("numSth")));
            ProyectTeam.setNumero(
                    Integer.parseInt(propiedades.getProperty("numPyt")));
            iniciarManagers();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void cargarPropiedades() {
        InputStream entrada = null;
        try {
            File input = new File(dirPrincipal
                    + "//remanproject//configuracion.properties");
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
     *
     * @param proUbi Ubicación del proyecto
     */
    public void guardarPropiedades(String proUbi) {
        OutputStream salida = null;
        try {
            File output = new File(proUbi
                    + "//remanproject//configuracion.properties");
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
        String cod = edu.getEduNombre().getCodigo();
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

    /**
     * Crear el libro de educción
     *
     * @param nombre Nombre del libro
     * @param lib Objeto LibroEduccion a guardar
     */
    public void createLibEdu(String nombre, LibroEduccion lib) {
        manLibEdu.escribirXML(nombre, lib);
    }

    /**
     * Exportar el libro de educción
     *
     * @param destino Destino del pdf
     * @param nombre Nombre del libro
     */
    public void exportarLibroEdu(String destino, String nombre) {
        LibroEduccion lib = new LibroEduccion();
        File[] ficheros = new File(dirPrincipal + "//src//edu").listFiles();
        for (File fichero : ficheros) {
            lib.addEduccion(getLastEdu(fichero.getName()));
            lib.setIntro(crearCaratula("EDUCCIÓN DE REQUERIMIENTOS"));
        }
        createLibEdu("libEdu", lib);
        manLibEdu.exportarPDF("libEdu", destino, nombre);
    }

    /**
     * Obtener la educción actual
     *
     * @param codigo Código de la educción
     */
    public Educcion getLastEdu(String codigo) {
        Educciones edu = manVerEdu.leerXML(codigo);
        return edu.getLast();
    }

    /**
     * Versionar un libro
     *
     * @param libTip Tipo de libro
     * @param version Versión del libro
     * @param fecha Fecha de la versión
     * @param razon Razón de cambio del libro
     * @param autor Autor de la versión
     */
    public void versionarLibro(int libTip, String version, String fecha,
            String razon, String autor) {
        switch (libTip) {
            case 0:
                verLibroEdu(version, fecha, razon, autor);
                break;
            case 1:
                verLibroEli(version, fecha, razon, autor);
                break;
            case 2:
                verLibroEsp(version, fecha, razon, autor);
                break;
            case 3:
                verLibroRnf(version, fecha, razon, autor);
                break;
        }
    }

    /**
     * Restaurar un libro
     *
     * @param libTip Tipo de libro
     * @param version Versión de la educción
     */
    public void restaurarLibro(int libTip, String version) {
        switch (libTip) {
            case 0:
                resLibroEdu(version);
                break;
            case 1:
                resLibroEli(version);
                break;
            case 2:
                resLibroEsp(version);
                break;
            case 3:
                resLibroRnf(version);
                break;
        }
    }

    /**
     * Versionar libro de educción
     *
     * @param version Versión de la educción
     * @param fecha Fecha de la versión
     * @param razon Razón de cambio de la educción
     * @param autor Autor de la versión
     */
    public void verLibroEdu(String version, String fecha, String razon,
            String autor) {
        manLibEdu.copiarDirectorios(new File(dirPrincipal + "//src//edu"),
                new File(dirPrincipal + "//verlib//edu//edu" + version));
        LibroHistorico libH = manHisEdu.leerXML("eduhis");
        libH.createHistorico(version, fecha, razon, autor);
        manHisEdu.escribirXML("eduhis", libH);
    }

    /**
     * Restaurar libro de educción
     *
     * @param version Versión de la educción
     */
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

    /**
     * Obtener el histórico de libro de educción
     *
     * @return Lista con los históricos de libro educción
     */
    public ArrayList<Historico> getHistLibEdu() {
        LibroHistorico libH = manHisEdu.leerXML("eduhis");
        return libH.getHistoricos();
    }

    /**
     * Crear carátula para los libros
     *
     * @param libNom Nombre del libro
     *
     */
    public Caratula crearCaratula(String libNom) {
        Caratula car = new Caratula(libNom, propiedades.getProperty("proNom"),
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

    /**
     * Crear el libro de elicitación
     *
     * @param nombre Nombre del libro
     * @param lib Objeto LibroElicitacion a guardar
     */
    public void createLibEli(String nombre, LibroElicitacion lib) {
        manLibEli.escribirXML(nombre, lib);
    }

    /**
     * Exportar un libro
     *
     * @param libTip Tipo de libro
     * @param destino Destino del pdf
     * @param nombre Nombre del libro
     */
    public void exportarLibro(int libTip, String destino, String nombre) {
        switch (libTip) {
            case 0:
                exportarLibroEdu(destino, nombre);
                break;
            case 1:
                exportarLibroEli(destino, nombre);
                break;
            case 2:
                exportarLibroEsp(destino, nombre);
                break;
            case 3:
                exportarLibroRnf(destino, nombre);
                break;
            case 4:
                exportarLibroOrg(destino, nombre);
                break;
            case 5:
                exportarLibroAct(destino, nombre);
                break;
        }
    }

    /**
     * Exportar el libro de elicitación
     *
     * @param destino Destino del pdf
     * @param nombre Nombre del libro
     */
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

    /**
     * Obtener la elicitación actual
     *
     * @param codEli Código de la elicitación
     * @return Elicitación recuperada
     */
    public Elicitacion getLastEli(String codEli) {
        Elicitaciones eli = manVerEli.leerXML(codEli);
        return eli.getLast();
    }

    /**
     * Versionar libro de elicitación
     *
     * @param version Versión de la elicitación
     * @param fecha Fecha de la versión
     * @param razon Razón de cambio de la elicitación
     * @param autor Autor de la versión
     */
    public void verLibroEli(String version, String fecha, String razon, String autor) {
        manLibEli.copiarDirectorios(new File(dirPrincipal + "//src//eli"),
                new File(dirPrincipal + "//verlib//eli//eli" + version));
        LibroHistorico libH = manHisEli.leerXML("elihis");
        libH.createHistorico(version, fecha, razon, autor);
        manHisEli.escribirXML("elihis", libH);
    }

    /**
     * Restaurar libro de elicitación
     *
     * @param version Versión de la elicitación
     */
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

    /**
     * Obtener el histórico de libro de elicitación
     *
     * @return Lista con los históricos de libro educción
     */
    public ArrayList<Historico> getHistLibEli() {
        LibroHistorico libH = manHisEli.leerXML("elihis");
        return libH.getHistoricos();
    }

    public void modificarElicitacion(Elicitacion eli) {
        Elicitaciones versiones;
        String cod = eli.getEliNombre().getCodigo();
        versiones = manVerEli.leerXML(cod);
        versiones.modEli(eli);
        manVerEli.escribirXML(cod, versiones);
    }

    /**
     * CU-035. CREAR UNA ELICITACIÓN Crear una elicitación
     *
     * @param eliNom Nombre de la elicitación
     * @param eliEduCod Código de la educción
     * @param eliVer Versión de la elicitación
     * @param eliFec Fecha de creación de la elicitación
     * @param eliFueNom Nombre de la fuente
     * @param eliFueCar Cargo de la fuente
     * @param eliFueTip Tipo de la fuente
     * @param eliEspNom Nombre del especialista
     * @param eliEspEsp Especialidad del especialista
     * @param eliEspExp Experiencia del especialista
     * @param eliEspCar Cargo del especialista
     * @param eliDep Dependencias de la elicitación
     * @param eliDes Descripción de la elicitación
     * @param eliPre Precondición de la elicitación
     * @param eliSec Secuencia normal de la elicitación
     * @param eliPos Postcondición de la elicitación
     * @param eliExc Secuencia excepción de la elicitación
     * @param eliObs Observaciones de la elicitación
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean crearElicitacion(String eliNom, String eliEduCod,
            String eliVer, String eliFec, String eliFueNom, String eliFueCar,
            String eliFueTip, String eliEspNom, String eliEspEsp,
            String eliEspExp, String eliEspCar, String eliDep, String eliDes,
            String eliPre, ArrayList<Paso> eliSec, String eliPos,
            ArrayList<Paso> eliExc, String eliObs) {
        try {
            Elicitacion eli = new Elicitacion(eliNom, eliEduCod, eliVer, eliFec,
                    eliFueNom, eliFueCar, eliFueTip, eliEspNom, eliEspEsp,
                    eliEspExp, eliEspCar, eliDep, eliDes, eliPre, eliSec,
                    eliPos, eliExc, eliObs);
            Elicitaciones verEli = new Elicitaciones();
            verEli.newEli(eli);
            manVerEli.escribirXML(eli.getEliNombre().getCodigo(), verEli);
            propiedades.setProperty("numEdu",
                    Integer.toString(Elicitacion.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * Recuperar los datos de una elicitación
     *
     * @param eliCod Código de la elicitación
     * @return Un objeto Elicitacion que contiene métodos accesores y mutadores
     */
    public Elicitacion recuperarElicitacion(String eliCod) {
        Elicitaciones verEli;
        verEli = manVerEli.leerXML(eliCod);
        return verEli.getActual();
    }

    /**
     * Modificar una elicitación
     *
     * @param eliCod Código de la elicitación
     * @param eliNom Nombre de la elicitación
     * @param eliEduCod Código de la educción
     * @param eliVer Versión de la elicitación
     * @param eliFec Fecha de creación de la elicitación
     * @param eliFueNom Nombre de la fuente
     * @param eliFueCar Cargo de la fuente
     * @param eliFueTip Tipo de la fuente
     * @param eliEspNom Nombre del especialista
     * @param eliEspEsp Especialidad del especialista
     * @param eliEspExp Experiencia del especialista
     * @param eliEspCar Cargo del especialista
     * @param eliDep Dependencias de la elicitación
     * @param eliDes Descripción de la elicitación
     * @param eliPre Precondición de la elicitación
     * @param eliSec Secuencia normal de la elicitación
     * @param eliPos Postcondición de la elicitación
     * @param eliExc Secuencia excepción de la elicitación
     * @param eliObs Observaciones de la elicitación
     * @return Un booleano que indica si la función se realizó correctamente
     */
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
                    eliEspEsp, eliEspExp, eliEspCar, eliDep, eliDes, eliPre,
                    eliSec, eliPos, eliExc, eliObs);
            Elicitaciones verEli = manVerEli.leerXML(eliCod);
            verEli.modEli(eli);
            manVerEli.escribirXML(eliCod, verEli);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * Eliminar una elicitación
     *
     * @param eliCod
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean eliminarElicitacion(String eliCod) {
        try {
            //verificar uso en especificacion
            manVerEli.borrarXML(eliCod);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * Versionar una elicitación
     *
     * @param verVer Versión de la elicitación
     * @param verFec Fecha de la versión
     * @param verEsp Especialista que versiona
     * @param verRazCam Razón de cambio
     * @param eliCod Código de la elicitación
     * @param eliNom Nombre de la elicitación
     * @param eliEduCod Código de la educción
     * @param eliVer Versión de la elicitación
     * @param eliFec Fecha de creación de la elicitación
     * @param eliFueNom Nombre de la fuente
     * @param eliFueCar Cargo de la fuente
     * @param eliFueTip Tipo de la fuente
     * @param eliEspNom Nombre del especialista
     * @param eliEspEsp Especialidad del especialista
     * @param eliEspExp Experiencia del especialista
     * @param eliEspCar Cargo del especialista
     * @param eliDep Dependencias de la elicitación
     * @param eliDes Descripción de la elicitación
     * @param eliPre Precondición de la elicitación
     * @param eliSec Secuencia normal de la elicitación
     * @param eliPos Postcondición de la elicitación
     * @param eliExc Secuencia excepción de la elicitación
     * @param eliObs Observaciones de la elicitación
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean versionarElicitacion(String verVer, String verFec,
            String verEsp, String verRazCam, String eliCod, String eliNom,
            String eliEduCod, String eliVer, String eliFec, String eliFueNom,
            String eliFueCar, String eliFueTip, String eliEspNom,
            String eliEspEsp, String eliEspExp, String eliEspCar, String eliDep,
            String eliDes, String eliPre, ArrayList<Paso> eliSec, String eliPos,
            ArrayList<Paso> eliExc, String eliObs) {
        try {
            Elicitaciones verEli = manVerEli.leerXML(eliCod);
            String ultVer = verEli.getLast().getEliNombre().getCodigo();
            if (ToolsSystem.CompararVersiones(ultVer, verVer)) {
                Elicitacion eli = new Elicitacion(eliCod, eliNom, eliEduCod, eliVer,
                        eliFec, eliFueNom, eliFueCar, eliFueTip, eliEspNom,
                        eliEspEsp, eliEspExp, eliEspCar, eliDep, eliDes, eliPre,
                        eliSec, eliPos, eliExc, eliObs);
                verEli.modEli(eli);
                verEli.verEli(verVer, verFec, verEsp, verRazCam);
                manVerEli.escribirXML(eliCod, verEli);
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * Restaurar una elicitación
     *
     * @param verCod Código de la versión
     * @param eliCod Código de la elicitación
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean restaurarVersionElicitacion(String verCod, String eliCod) {
        try {
            Elicitaciones verEli = manVerEli.leerXML(eliCod);
            Elicitacion eli = verEli.getVer(verCod);
            modificarElicitacion(eli);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * CU-035. CREAR UNA ESPECIFICACIÓN Crear una especificación
     *
     * @param espNom Nombre de la especificación
     * @param espEliCod Código de la educción
     * @param espVer Versión de la especificación
     * @param espFec Fecha de creación de la especificación
     * @param espFueNom Nombre de la fuente
     * @param espFueCar Cargo de la fuente
     * @param espFueTip Tipo de la fuente
     * @param espEspNom Nombre del especialista
     * @param espEspEsp Especialidad del especialista
     * @param espEspExp Experiencia del especialista
     * @param espEspCar Cargo del especialista
     * @param espDep Dependencias de la especificación
     * @param espDes Descripción de la especificación
     * @param espPre Precondición de la especificación
     * @param espPos Postcondición de la especificación
     * @param espExc Secuencia excepción de la especificación
     * @param espObs Observaciones de la especificación
     * @return Un booleano que indica si la función se realizó correctamente
     */
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
            manVerEsp.escribirXML(esp.getEspNombre().getCodigo(), verEsp);
            propiedades.setProperty("numEsp",
                    Integer.toString(Especificacion.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * Recuperar los datos de una especificación
     *
     * @param espCod Código de la especificación
     * @return Un objeto Elicitacion que contiene métodos accesores y mutadores
     */
    public Especificacion recuperarEspecificacion(String espCod) {
        Especificaciones verEsp;
        verEsp = manVerEsp.leerXML(espCod);
        return verEsp.getActual();
    }

    /**
     * Modificar una especificación
     *
     * @param espCod Código de la especificación
     * @param espNom Nombre de la especificación
     * @param espEliCod Código de la educción
     * @param espVer Versión de la especificación
     * @param espFec Fecha de creación de la especificación
     * @param espFueNom Nombre de la fuente
     * @param espFueCar Cargo de la fuente
     * @param espFueTip Tipo de la fuente
     * @param espEspNom Nombre del especialista
     * @param espEspEsp Especialidad del especialista
     * @param espEspExp Experiencia del especialista
     * @param espEspCar Cargo del especialista
     * @param espDep Dependencias de la especificación
     * @param espDes Descripción de la especificación
     * @param espPre Precondición de la especificación
     * @param espPos Postcondición de la especificación
     * @param espExc Secuencia excepción de la especificación
     * @param espObs Observaciones de la especificación
     * @return Un booleano que indica si la función se realizó correctamente
     */
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
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * Eliminar una especificación
     *
     * @param espCod
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean eliminarEspecificacion(String espCod) {
        try {
            manVerEsp.borrarXML(espCod);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * Versionar una especificación
     *
     * @param verVer Versión de la especificación
     * @param verFec Fecha de la versión
     * @param verEsp Especialista que versiona
     * @param verRazCam Razón de cambio
     * @param espCod Código de la especificación
     * @param espNom Nombre de la especificación
     * @param espEliCod Código de la elicitación
     * @param espVer Versión de la especificación
     * @param espFec Fecha de creación de la especificación
     * @param espFueNom Nombre de la fuente
     * @param espFueCar Cargo de la fuente
     * @param espFueTip Tipo de la fuente
     * @param espEspNom Nombre del especialista
     * @param espEspEsp Especialidad del especialista
     * @param espEspExp Experiencia del especialista
     * @param espEspCar Cargo del especialista
     * @param espDep Dependencias de la especificación
     * @param espDes Descripción de la especificación
     * @param espPre Precondición de la especificación
     * @param espPos Postcondición de la especificación
     * @param espExc Secuencia excepción de la especificación
     * @param espObs Observaciones de la especificación
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean versionarEspecificacion(String verVer, String verFec,
            String verEsp, String verRazCam, String espCod, String espNom,
            String espEliCod, String espVer, String espFec, String espFueNom,
            String espFueCar, String espFueTip, String espEspNom,
            String espEspEsp, String espEspExp, String espEspCar, String espDep,
            String espDes, String espPre, String espPos, ArrayList<Paso> espExc,
            String espObs) {
        try {
            Especificaciones verEsps = manVerEsp.leerXML(espCod);
            String ultVer = verEsps.getLast().getEspNombre().getCodigo();
            if (ToolsSystem.CompararVersiones(ultVer, verVer)) {
                Especificacion esp = new Especificacion(espCod, espNom, espEliCod,
                        espVer, espFec, espFueNom, espFueCar, espFueTip, espEspNom,
                        espEspEsp, espEspExp, espEspCar, espDep, espDes,
                        espPre, espPos, espExc, espObs);
                verEsps.modEsp(esp);
                verEsps.verEsp(verVer, verFec, verEsp, verRazCam);
                manVerEsp.escribirXML(espCod, verEsps);
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * Restaurar una especificación
     *
     * @param verCod Código de la versión
     * @param espCod Código de la especificación
     * @return Un booleano que indica si la función se realizó correctamente
     */
    public boolean restaurarVersionEspecificacion(String verCod, String espCod) {
        try {
            Especificaciones verEsp = manVerEsp.leerXML(espCod);
            Especificacion esp = verEsp.getVer(verCod);
            modificarEspecificacion(esp);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Exportar el libro de especificación
     *
     * @param destino Destino del pdf
     * @param nombre Nombre del libro
     */
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

    /**
     * Crear el libro de especificación
     *
     * @param nombre Nombre del libro
     * @param lib Objeto LibroEspecificacion a guardar
     */
    public void createLibEsp(String nombre, LibroEspecificacion lib) {
        manLibEsp.escribirXML(nombre, lib);
    }

    public Especificacion getLastEsp(String name) {
        Especificaciones esp = manVerEsp.leerXML(name);
        return esp.getLast();
    }

    public void verLibroEsp(String version, String fecha, String razon,
            String autor) {
        manLibEsp.copiarDirectorios(new File(dirPrincipal + "//src//esp"),
                new File(dirPrincipal + "//verlib//esp//esp" + version));
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

    public ArrayList<Historico> getHistLibEsp() {
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

    public RequisitoNF getLastRnf(String name) {
        RequisitosNF rnf = manVerRnf.leerXML(name);
        return rnf.getLast();
    }

    public void verLibroRnf(String version, String fecha, String razon,
            String autor) {
        manLibEsp.copiarDirectorios(new File(dirPrincipal + "//src//rnf"),
                new File(dirPrincipal + "//verlib//rnf//rnf" + version));
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

    public ArrayList<Historico> getHistLibRnf() {
        LibroHistorico libH = manHisRnf.leerXML("rnfhis");
        return libH.getHistoricos();
    }

    public void modificarEspecificacion(Especificacion esp) {
        Especificaciones versiones;
        String espCod = esp.getEspNombre().getCodigo();
        versiones = manVerEsp.leerXML(espCod);
        versiones.modEsp(esp);
        manVerEsp.escribirXML(espCod, versiones);
    }

    public void modificarRequisitoNF(RequisitoNF rnf) {
        RequisitosNF versiones;
        String rnfCod = rnf.getRnfNombre().getCodigo();
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
            RequisitoNF rnf = new RequisitoNF(rnfNom, rnfVer, rnfTip,
                    rnfObj, rnfFec, rnfFueNom, rnfFueCar, rnfFueTip, rnfEspNom,
                    rnfEspEsp, rnfEspExp, rnfEspCar, rnfDep, rnfDes, rnfObs);

            RequisitosNF verRnf = new RequisitosNF();
            verRnf.newRnf(rnf);
            manVerRnf.escribirXML(rnf.getRnfNombre().getCodigo(), verRnf);
            propiedades.setProperty("numRnf",
                    Integer.toString(RequisitoNF.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean modificarReqNoFuncional(String rnfCod, String rnfNom, String rnfVer,
            String rnfTip, String rnfObj, String rnfFec, String rnfFueNom,
            String rnfFueCar, String rnfFueTip, String rnfEspNom,
            String rnfEspEsp, String rnfEspExp, String rnfEspCar, String rnfDep,
            String rnfDes, String rnfObs) {
        try {
            RequisitoNF rnf = new RequisitoNF(rnfCod, rnfNom, rnfVer,
                    rnfTip, rnfObj, rnfFec, rnfFueNom, rnfFueCar, rnfFueTip, rnfEspNom,
                    rnfEspEsp, rnfEspExp, rnfEspCar, rnfDep, rnfDes, rnfObs);
            RequisitosNF verRnf = manVerRnf.leerXML(rnfCod);
            verRnf.modRnf(rnf);
            manVerRnf.escribirXML(rnfCod, verRnf);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean eliminarRequisitoNF(String rnfCod) {
        try {
            manVerRnf.borrarXML(rnfCod);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean crearOrganizacion(String orgNom, String orgDir,
            String orgTel, String orgPagWeb, String orgCorEle, String orgCom) {
        try {
            Organizacion org = new Organizacion(orgNom, orgDir, orgTel,
                    orgPagWeb, orgCorEle, orgCom);
            manOrg.escribirXML(org.getOrgNombre().getCodigo(), org);
            propiedades.setProperty("numOrg",
                    Integer.toString(Organizacion.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean modificarOrganizacion(String orgCod, String orgNom,
            String orgDir, String orgTel, String orgPagWeb, String orgCorEle,
            String orgCom) {
        try {
            Organizacion org = new Organizacion(orgCod, orgNom, orgDir, orgTel,
                    orgPagWeb, orgCorEle, orgCom);
            manOrg.escribirXML(orgCod, org);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean eliminarOrganizacion(String orgCod) {
        try {
            manOrg.borrarXML(orgCod);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void exportarLibroOrg(String destino, String nombre) {
        LibroOrganizacion lib = new LibroOrganizacion();
        File[] ficheros = new File(dirPrincipal + "//src//org//org").listFiles();
        for (File fichero : ficheros) {
            String name = fichero.getName().split("\\.")[0];
            lib.addOrg(getOrg(name));
            lib.setIntro(crearCaratula("ORGANIZACIONES"));
        }
        createLibOrg("libOrg", lib);
        manLibOrg.exportarPDF("libOrg", destino, nombre);
    }

    public Organizacion getOrg(String codOrg) {
        Organizacion org = manOrg.leerXML(codOrg);
        return org;
    }

    public void createLibOrg(String nombre, LibroOrganizacion lib) {
        manLibOrg.escribirXML(nombre, lib);
    }

    public boolean crearStakeholder(String sthNom, String sthOrg, String sthCar,
            String sthTip, String sthCorEle, String sthCom) {
        try {
            Stakeholder sth = new Stakeholder(sthNom, sthOrg, sthCar, sthTip,
                    sthCorEle, sthCom);
            manSth.escribirXML(sth.getSthNombre().getCodigo(), sth);
            propiedades.setProperty("numSth",
                    Integer.toString(Stakeholder.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean modificarStakeholder(String sthCod, String sthNom,
            String sthOrg, String sthCar, String sthTip, String sthCorEle,
            String sthCom) {
        try {
            Stakeholder sth = new Stakeholder(sthCod, sthNom, sthOrg, sthCar,
                    sthTip, sthCorEle, sthCom);
            manSth.escribirXML(sthCod, sth);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Stakeholder getStakeholder(String codSth) {
        Stakeholder sth = manSth.leerXML(codSth);
        return sth;
    }

    public boolean eliminarStakeholder(String sthCod) {
        try {
            manSth.borrarXML(sthCod);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean crearProyectTeam(String pytNom, String pytOrg, String pytEsp,
            String pytExp, String pytCar, String pytCor, String pytCom) {
        try {
            ProyectTeam pyt = new ProyectTeam(pytNom, pytOrg, pytEsp, pytExp,
                    pytCar, pytCor, pytCom);
            manPyt.escribirXML(pyt.getPytNombre().getCodigo(), pyt);
            propiedades.setProperty("numPyt",
                    Integer.toString(ProyectTeam.getNumero()));
            guardarPropiedades(dirPrincipal);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean modificarProyectTeam(String pytCod, String pytNom,
            String pytOrg, String pytEsp, String pytExp, String pytCar,
            String pytCor, String pytCom) {
        try {
            ProyectTeam pyt = new ProyectTeam(pytCod, pytNom, pytOrg, pytEsp,
                    pytExp, pytCar, pytCor, pytCom);
            manPyt.escribirXML(pytCod, pyt);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public ProyectTeam getProyectTeam(String codPyt) {
        ProyectTeam pyt = manPyt.leerXML(codPyt);
        return pyt;
    }

    public boolean eliminarProyectTeam(String pytCod) {
        try {
            manPyt.borrarXML(pytCod);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void exportarLibroAct(String destino, String nombre) {
        LibroActor lib = new LibroActor();
        File[] stakes = new File(dirPrincipal + "//src//org//sth").listFiles();
        for (File fichero : stakes) {
            String name = fichero.getName().split("\\.")[0];
            lib.addStake(getStakeholder(name));
        }
        File[] proyects = new File(dirPrincipal + "//src//org//pyt").listFiles();
        for (File fichero : proyects) {
            String name = fichero.getName().split("\\.")[0];
            lib.addTeam(getProyectTeam(name));
        }
        lib.setIntro(crearCaratula("Actores"));
        createLibAct("libAct", lib);
        manLibAct.exportarPDF("libAct", destino, nombre);
    }

    public void createLibAct(String nombre, LibroActor lib) {
        manLibAct.escribirXML(nombre, lib);
    }

    /**
     * devuelve los nombres de las fuentes del proyecto REMAN
     *
     * @return ArrayList<String> fuentes
     */
    public ArrayList<String> getFuenteNombres() {
        ArrayList<String> rpt = new ArrayList<>();
        String name;
        try {
            File[] ficheros;
            ficheros = new File(dirPrincipal + "\\src\\org\\sth").listFiles();
            for (File fichero : ficheros) {
                name = fichero.getName();
                rpt.add(getStakeholder(name).getSthNombre().getNombre());
            }
        } catch (Exception e) {
        }
        return rpt;
    }

    /**
     * devuelve los codigos de las fuentes del proyecto REMAN
     *
     * @return ArrayList<String> fuentes codigo
     */
    public ArrayList<String> getFuenteCodigos() {
        ArrayList<String> rpt = new ArrayList<>();
        String name;
        try {
            File[] ficheros;
            ficheros = new File(dirPrincipal + "\\src\\org\\sth").listFiles();
            for (File fichero : ficheros) {
                name = fichero.getName();
                rpt.add(getStakeholder(name).getSthNombre().getCodigo());
            }
        } catch (Exception e) {
        }
        return rpt;
    }

    /**
     * Funcion que retorna todos los datos de todas las fuentes existentes en el
     * proyecto ArrayList<String> (0) -> codigo ArrayList<String> (1) -> nombre
     * ArrayList<String> (2) -> organizacion ArrayList<String> (3) -> cargo
     * ArrayList<String> (4) -> tipo ArrayList<String> (5) -> email
     * ArrayList<String> (6) -> comentarios
     *
     * @return ArrayList<ArrayList<String>> rpt con todos los atributos
     */
    public ArrayList<ArrayList<String>> getFuentes() {
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        ArrayList<String> codigo = new ArrayList<>();
        ArrayList<String> nombre = new ArrayList<>();
        ArrayList<String> organizacion = new ArrayList<>();
        ArrayList<String> cargo = new ArrayList<>();
        ArrayList<String> tipo = new ArrayList<>();
        ArrayList<String> email = new ArrayList<>();
        ArrayList<String> comentarios = new ArrayList<>();
        String name;
        try {
            File[] ficheros;
            ficheros = new File(dirPrincipal + "\\src\\org\\sth").listFiles();
            for (File fichero : ficheros) {
                name = fichero.getName();
                codigo.add(getStakeholder(name).getSthNombre().getCodigo());
                nombre.add(getStakeholder(name).getSthNombre().getNombre());
                organizacion.add(getStakeholder(name).getSthOrg());
                cargo.add(getStakeholder(name).getSthCar());
                tipo.add(getStakeholder(name).getSthTip());
                email.add(getStakeholder(name).getSthCorEle());
                comentarios.add(getStakeholder(name).getSthCom());
            }
        } catch (Exception e) {
        }
        datos.add(codigo);
        datos.add(nombre);
        datos.add(organizacion);
        datos.add(cargo);
        datos.add(tipo);
        datos.add(email);
        datos.add(comentarios);
        return datos;
    }

    public ArrayList<String> getEspecialistaNombres() {
        ArrayList<String> rpt = new ArrayList<>();
        String name;
        try {
            File[] ficheros;
            ficheros = new File(dirPrincipal + "\\src\\org\\pyt").listFiles();
            for (File fichero : ficheros) {
                name = fichero.getName();
                rpt.add(getProyectTeam(name).getPytNombre().getNombre());
            }
        } catch (Exception e) {
        }
        return rpt;
    }

    public ArrayList<String> getEspecialistaCodigos() {
        ArrayList<String> rpt = new ArrayList<>();
        String name;
        try {
            File[] ficheros;
            ficheros = new File(dirPrincipal + "\\src\\org\\pyt").listFiles();
            for (File fichero : ficheros) {
                name = fichero.getName();
                rpt.add(getProyectTeam(name).getPytNombre().getCodigo());
            }
        } catch (Exception e) {
        }
        return rpt;
    }

    /**
     * Funcion que retorna todos los datos de todos los especialistas existentes
     * en el proyecto ArrayList<String> (0) -> codigo ArrayList<String> (1) ->
     * nombre ArrayList<String> (2) -> organizacion ArrayList<String> (3) ->
     * especialidad ArrayList<String> (4) -> experiencia ArrayList<String> (5)
     * -> cargo ArrayList<String> (6) -> email ArrayList<String> (7) ->
     * comentarios
     *
     * @return ArrayList<ArrayList<String>> rpt con todos los atributos
     * @return
     */
    public ArrayList<ArrayList<String>> getEspecialistas() {
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        ArrayList<String> codigo = new ArrayList<>();
        ArrayList<String> nombre = new ArrayList<>();
        ArrayList<String> organizacion = new ArrayList<>();
        ArrayList<String> especialidad = new ArrayList<>();
        ArrayList<String> experiencia = new ArrayList<>();
        ArrayList<String> cargo = new ArrayList<>();
        ArrayList<String> email = new ArrayList<>();
        ArrayList<String> comentarios = new ArrayList<>();
        String name;
        try {
            File[] ficheros;
            ficheros = new File(dirPrincipal + "\\src\\org\\pyt").listFiles();
            for (File fichero : ficheros) {
                name = fichero.getName();
                codigo.add(getProyectTeam(name).getPytNombre().getCodigo());
                nombre.add(getProyectTeam(name).getPytNombre().getNombre());
                organizacion.add(getProyectTeam(name).getPytOrg());
                especialidad.add(getProyectTeam(name).getPytEsp());
                experiencia.add(getProyectTeam(name).getPytExp());
                cargo.add(getProyectTeam(name).getPytCar());
                email.add(getProyectTeam(name).getPytCor());
                comentarios.add(getProyectTeam(name).getPytCom());
            }
        } catch (Exception e) {
        }
        datos.add(codigo);
        datos.add(nombre);
        datos.add(organizacion);
        datos.add(especialidad);
        datos.add(experiencia);
        datos.add(cargo);
        datos.add(email);
        datos.add(comentarios);
        return datos;
    }

    public ArrayList<String> getOrgNombres() {
        ArrayList<String> rpt = new ArrayList<>();
        String name;
        try {
            File[] ficheros;
            ficheros = new File(dirPrincipal + "\\src\\org\\org").listFiles();
            for (File fichero : ficheros) {
                name = fichero.getName();
                rpt.add(getOrg(name).getOrgNombre().getNombre());
            }
        } catch (Exception e) {
        }
        return rpt;
    }

    public String getNextEdu() {
        return ToolsSystem.IncrementarCodigo(Educcion.getCodigo());
    }

    public String getNextSth() {
        return ToolsSystem.IncrementarCodigo(Stakeholder.getCodigo());
    }

    public String getNextPyt() {
        return ToolsSystem.IncrementarCodigo(ProyectTeam.getCodigo());
    }
    
    public String getNextOrg() {
        return ToolsSystem.IncrementarCodigo(Organizacion.getCodigo());
    }
    
    

    //Facilitadores de acceso
    public static final int ESP_CODIGO = 0;
    public static final int ESP_NOMBRE = 1;
    public static final int ESP_ORGANIZACION = 2;
    public static final int ESP_ESPECIALIDAD = 3;
    public static final int ESP_EXPERIENCIA = 4;
    public static final int ESP_CARGO = 5;
    public static final int ESP_EMAIL = 6;
    public static final int ESP_COMENTARIOS = 7;

    public static final int FUE_CODIGO = 0;
    public static final int FUE_NOMBRE = 1;
    public static final int FUE_ORGANIZACION = 2;
    public static final int FUE_CARGO = 3;
    public static final int FUE_TIPO = 4;
    public static final int FUE_EMAIL = 5;
    public static final int FUE_COMENTARIOS = 6;
}

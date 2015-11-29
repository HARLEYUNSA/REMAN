package org.harley.reman;

import org.harley.reman.sistema.Proyecto;
import org.harley.reman.sistema.Educcion;
import org.harley.reman.sistema.Historico;
import java.util.List;
import org.harley.reman.sistema.LibroHistorico;

/**
 *
 * @author Gonzalo
 */
public class Reman {
    Proyecto pro;

    private void crearProyecto(String nombreProyecto, String empDes, 
            String empCli, String lidPro, String estPro, String fecIni, 
            String fecFin) 
    {
        pro = new Proyecto(nombreProyecto);
        pro.createProject(empDes, empCli, lidPro, estPro, fecIni, fecFin);
    }
    
    private void ingresarProyecto(String nom){
        pro = new Proyecto(nom);
        pro.loadProject();
    }
    
    private void eliminarProyecto(String nom){
        pro.deleteProject();
    }
    
    private void agregarEdu(String nom, String ver, String fueNom, String fueCar,
            String fueTip, String espNomb, String espEsp, String espTip, 
            String espExp, String eduTip, String eduObj, String eduFec,
            String des, String obs) 
    {
        Educcion edu = new Educcion(nom, ver, fueNom, fueCar, fueTip, espNomb,
                espEsp, espTip, espExp, eduTip, eduObj, eduFec, espTip, obs);
        pro.addEdu(edu);
    }
    
    private Educcion mostrarEdu(String cod) {
        return pro.getActEdu(cod);
    }
    
    private void eliminarEdu(String cod) {
        pro.delActEdu(cod);
    }
    
    private void modificarEdu(String cod, String nom, String ver, String fueNom, 
            String fueCar,  String fueTip, String espNomb, String espEsp, 
            String espTip, String espExp, String eduTip, String eduObj,
            String eduFec, String des, String obs)
    {
        Educcion edu = new Educcion(cod, nom);
        edu.setVersion(ver);
        edu.setFuenteNombre(fueNom);
        edu.setFuenteCargo(fueCar);
        edu.setFuenteTipo(fueTip);
        edu.setEspecialNombre(espNomb);
        edu.setEspecialEspecial(espEsp);
        edu.setEspecialTipo(espTip);
        edu.setEspecialExp(espExp);
        edu.setEduccionTipo(eduTip);
        edu.setEduccionObj(eduObj);
        edu.setEduccionFecha(eduFec);
        edu.setDescripcion(des);
        edu.setObservaciones(obs);
        pro.modEdu(edu);
    }
    
    private void verEdu(String cod, String nom, String ver, String fueNom, 
            String fueCar,  String fueTip, String espNomb, String espEsp, 
            String espTip, String espExp, String eduTip, String eduObj,
            String eduFec, String des, String obs, String razon, String version)
    {
        Educcion edu = new Educcion(cod, nom);
        edu.setVersion(ver);
        edu.setFuenteNombre(fueNom);
        edu.setFuenteCargo(fueCar);
        edu.setFuenteTipo(fueTip);
        edu.setEspecialNombre(espNomb);
        edu.setEspecialEspecial(espEsp);
        edu.setEspecialTipo(espTip);
        edu.setEspecialExp(espExp);
        edu.setEduccionTipo(eduTip);
        edu.setEduccionObj(eduObj);
        edu.setEduccionFecha(eduFec);
        edu.setDescripcion(des);
        edu.setObservaciones(obs);
        pro.verEdu(edu, version , razon);
    }
    
    private List<Historico> histEdu(String name){
        return pro.getHistEdu(name);
    }
    
    private void resEdu(String cod, String ver){
        pro.restoreEdu(cod, ver);
    }
    
    private void exportarPDF(int opc, String ubicacion, String nombre) {
        switch (opc){
            case 1:
                pro.exportarLibroEdu(ubicacion, nombre);
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
    
    private void salirProyecto(){
        pro.close();
    }

    private void verLibro(int opc, String version, String razon, String autor){
        switch (opc){
            case 0: pro.verLibroEdu(version, razon, autor); break;
        }
    }
    
    private List<Historico> histLibEdu(){
        return pro.getHistLibEdu();
    }
    
    private void resLibro(int opc, String version){
        switch (opc){
            case 0: pro.resLibroEdu(version); break;
        }
    }

    private void verLibro(int opc, String version, String razon){
        switch (opc){
            case 0: pro.verLibroEdu(version, razon); break;
        }
    }
    
    public static void main(String[] args) {
        
        Reman rem = new Reman();
        rem.ingresarProyecto("REMAN");
        /*rem.crearProyecto("REMAN", "HARLEY", "UNSA", "Incalla Nina Christian",
                "Terminado", "01/01/0001", "30/12/2015");*/
        
        //rem.eliminarProyecto("REMAN");
               
        /*rem.agregarEdu("Nombre", "0.01", "Primario", "Objectivo acà", "01/01/2016",
        
        rem.verLibro(0, "0.1", "2 educciones");
        
        rem.agregarEdu("Nombre", "0.01", "Primario", "Objectivo acà", "01/01/2016",
                "Cristiano Lòpez", "Usuario", "Interno", "Luna Luza Gonzalo",
                "Ing. Requisitos", "Alta", "Programador", "Descripción aquí",
                "Observaciones y/o comentarios con respecto al requerimiento.");*/
        
        //rem.verLibro(0, "0.1", "1 educcion", "gonzalo");

        /*rem.agregarEdu("Nombre", "0.01", "Primario", "Objectivo acà", "01/01/2016",
                "Cristiano Lòpez", "Usuario", "Interno", "Luna Luza Gonzalo",
                "Ing. Requisitos", "Alta", "Programador", "Descripción aquí",
                "Observaciones y/o comentarios con respecto al requerimiento.");*/
        
        //rem.verLibro(0, "0.2", "2 educciones", "luis");
        
        /*List<Historico> lista = rem.histLibEdu();
        for(Historico x : lista){
            System.out.println(x.getVersion() + " " + x.getRazon());
        }
        rem.resLibro(0, "0.1");

        rem.salirProyecto();*/
        //rem.verLibro(0, "0.3", "Prueba");
        
        /*rem.verEdu("edu0001", "Nombre", "0.01", "Primario", "Objectivo acà", "01/01/2016",
                "Cristiano Lòpez", "Usuario", "Externo", "Luna Luza Gonzalo",
                "Ing. Requisitos", "Alta", "Programador", "Descripción aquí",
                "Observaciones y/o comentarios con respecto al requerimiento.",
                "se cambio la fuente", "0.02");*/
        //rem.eliminarEdu("edu0002");
        /*List<Historico> lista = rem.histEdu("edu0001");
        for(Historico x : lista){
            System.out.println(x.getVersion() + " " + x.getRazon());
        rem.verLibro(0, "0.2", "3 educciones");

        rem.salirProyecto();
        //rem.verLibro(0, "0.3", "Prueba");
        
        /*rem.verEdu("edu0001", "Nombre", "0.01", "Primario", "Objectivo acà", "01/01/2016",
                "Cristiano Lòpez", "Usuario", "Externo", "Luna Luza Gonzalo",
                "Ing. Requisitos", "Alta", "Programador", "Descripción aquí",
                "Observaciones y/o comentarios con respecto al requerimiento.",
                "se cambio la fuente", "0.02");*/
        //rem.eliminarEdu("edu0002");
        /*List<Historico> lista = rem.histEdu("edu0001");
        for(Historico x : lista){
            System.out.println(x.getVersion() + " " + x.getRazon());
        }*/
        
        //rem.resEdu("edu0001", "0.01");
        
        
        //Educcion modificar = rem.mostrarEdu("edu0001");
        /*rem.modEdu("edu0001", "Nombre", "0.01", "Primario", "Objectivo acà", "01/01/2016",
                "Cristiano Lòpez", "Usuario", "Externo", "Luna Luza Gonzalo",
                "Ing. Requisitos", "Alta", "Programador", "Descripción aquí",
                "Observaciones y/o comentarios con respecto al requerimiento.");*/
        //rem.exportarPDF(1,"D:\\Informe", "LibroEduccion");
    }
}
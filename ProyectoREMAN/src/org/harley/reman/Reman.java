package org.harley.reman;

import org.harley.reman.clases.*;
import org.harley.reman.conversion.FileManager;

/**
 *
 * @author Gonzalo
 */
public class Reman {

    public static LibroEduccion crearEduccion() {
        LibroEduccion nuevo = new LibroEduccion();
        Educcion edu = new Educcion();
        Nombre nom = new Nombre();
        Version ver = new Version();
        
        nom.setCodigo("0001");
        nom.setNombre("Nombre del requisito");
        
        edu.setActor("Christian");
        edu.setCargo("Usuario");
        edu.setEspecialista("Gonzalo Luna");
        edu.setEspecialEspecial("Ing Requisitos");
        edu.setEspecialTipo("Programador");
        edu.setEspecialExp("Experiencia");
        edu.setEduccionTipo("Primario");
        edu.setEduccionObj("Objeto del Requisito");
        edu.setEduccionFecha("23/09/2015");
        edu.setDescripcion("Descripcion de requerimiento a educcionar");
        edu.setObservaciones("Observaciones del requisito");
        
        ver.setvMax(1);
        ver.setvMin(2);
        edu.setEduccionNombre(nom);
        edu.setVersion(ver);
        nuevo.setTitulo("Libro de Educcion");
        nuevo.setIntro("Plantilla de Educción de Requisitos");
        nuevo.addEduccion(edu);
        nuevo.addEduccion(edu);
        return nuevo;
    }
    
    public static LibroActores crearActor(){
        LibroActores nuevo = new LibroActores();
        Actor act = new Actor();
        Nombre nom = new Nombre();
        nom.setCodigo("0001");
        nom.setNombre("Gonzalo");
        act.setOrg("Harley");
        act.setCargo("Jefe de oficina");
        act.setTipo("Desarrollador");
        act.setCorreo("glunaluza@gmail.com");
        act.setComentarios("Comentarios");
        act.setActorNombre(nom);
        nuevo.setIntro("Libro de Actores");
        nuevo.addActor(act);
        return nuevo;
    }
    
    public static LibroHistorico crearHistorico(){
        LibroHistorico nuevo = new LibroHistorico();
        Historico hist = new Historico();
        hist.setVersion("1.2");
        hist.setFecha("03/09/2015");
        hist.setRazon("Cambio 1");
        hist.setAutor("Gonzalo");
        nuevo.setTitulo("Libro Histórico");
        nuevo.setIntro("Plantilla de Libro Histórico");
        nuevo.addHistorico(hist);
        return nuevo;
    }
    
    public static LibroEspecificacion crearEspecificacion(int v1, int v2){
        LibroEspecificacion libro = new LibroEspecificacion();
        Especificacion esp = new Especificacion();
        Nombre nom = new Nombre();
        Version ver = new Version();
        Elemento excep = new Elemento(); 
        nom.setCodigo("001");
        nom.setNombre("especificacion ads");

        ver.setvMax(v1);
        ver.setvMin(v2);

        libro.setTitulo("Libro de Especificación");
        libro.setIntro("Plantilla de especificación");
        libro.addEspecificacion(esp);

        excep.setEleNumero(1);
        excep.setEleDescripcion("el sistema");
        esp.addExcepcion(excep);

        esp.setEspecificacionNombre(nom);
        esp.setEliNombre("ELI001");
        esp.setVersion(ver);
        esp.setAutor("Gonzalo");
        esp.setFuente("Jose");
        esp.setDependencias("dependencia");
        esp.setDescripcion("Descripcion");
        esp.addPrecondicion("precondicion1");
        esp.addPostcondicion("postcondicion1");
        esp.setComentarios("comentarios dasdsada");
        
        return libro;
    }    
    
    public static void main(String[] args) {
        String project = "Proyecto1";
        Reman rem = new Reman();
        Proyecto nuevo = rem.crearProyecto(project);

        LibroEspecificacion ej = crearEspecificacion(1,0);
        nuevo.createEsp(ej,"libroEspecificacion1");
        nuevo.exportarEsp("libroEspecificacion1", "LibroEspec");
        
        //obj.managerEsp.escribirXML("Educcion1.0", ej);
        //ej = crearEspecificacion(1,1);
        //obj.managerEsp.escribirXML("Educcion1.1", ej);
        //obj.managerEsp.exportarPDF("Educcion1.0", "Educcion0");
        //obj.managerEsp.exportarPDF("Educcion1.1", "Educcion1");
    }
    
    public Proyecto crearProyecto(String project){
        Proyecto pro = new Proyecto(project);
        return pro;
    }
    
    private void abrirProyecto() {
    }
}
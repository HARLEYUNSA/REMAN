package org.harley.reman;

import org.harley.reman.clases.*;

/**
 *
 * @author Gonzalo
 */
public class Reman {

    public static LibroEduccion crearEduccion() {
        LibroEduccion nuevo = new LibroEduccion();
        Educcion edu = new Educcion();
        Nombre nom = new Nombre();
        
        nom.setCodigo("0001");
        nom.setNombre("Nombre del requisito");
        
        edu.setFuente("Christiano López");
        edu.setVersion("0.1");
        edu.setCargo("Usuario");
        edu.setEspecialNombre("Gonzalo Luna");
        edu.setEspecialEspecial("Ing Requisitos");
        edu.setEspecialTipo("Programador");
        edu.setEspecialExp("Alta");
        edu.setEduccionTipo("Primario");
        edu.setEduccionObj("Objeto del Requisito");
        edu.setEduccionFecha("01/01/2016");
        edu.setDescripcion("Descripcion de requerimiento a educcionar");
        edu.setObservaciones("Observaciones del requisito");
    
        edu.setEduccionNombre(nom);
        nuevo.setTitulo("Libro de Educcion");
        nuevo.setIntro("Plantilla de Educción de Requisitos");
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
    
    public static Especificacion nuevoEsp(){
        Especificacion esp = new Especificacion();
        Nombre nom = new Nombre();
        Elemento excep = new Elemento(); 
        nom.setCodigo("001");
        nom.setNombre("especificacion ads");

        excep.setEleNumero(1);
        excep.setEleDescripcion("el sistema");
        esp.addExcepcion(excep);

        esp.setEspecificacionNombre(nom);
        esp.setEliNombre("ELI001");
        esp.setAutor("Gonzalo");
        esp.setFuente("Jose");
        esp.setDependencias("dependencia");
        esp.setDescripcion("Descripcion");
        esp.addPrecondicion("precondicion1");
        esp.addPostcondicion("postcondicion1");
        esp.setComentarios("comentarios dasdsada");
        
        return esp;
    }    
    
    public static void main(String[] args) {
        Reman rem = new Reman();
        
        String nombreProyecto = "Proyecto1";
        
        Proyecto project = rem.crearProyecto(nombreProyecto);

        project.addEsp(nuevoEsp());
        
       // project.exportarLibroEsp("esp1", "D:\\Informe", "LibroEspecificacion");
        
    }
   
    public Proyecto crearProyecto(String project){
        Proyecto pro = new Proyecto(project);
        pro.createProject();
        return pro;
    }
    
    private void abrirProyecto() {
        
    }
}
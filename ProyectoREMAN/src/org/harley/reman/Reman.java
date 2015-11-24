package org.harley.reman;

import org.harley.reman.clases.*;

/**
 *
 * @author Gonzalo
 */
public class Reman {

    public static Educcion nuevoEdu(String cod) {
        Educcion edu = new Educcion();
        Nombre nom = new Nombre();
        
        nom.setCodigo(cod);
        nom.setNombre("Nombre del requisito");
        edu.setVersion("0.01");
        edu.setFuenteNombre("Christiano López");
        edu.setFuenteCargo("Usuario");
        edu.setFuenteTipo("Interno");
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
        return edu;
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
        
        String nombreProyecto = "NombreProyecto";
        //Proyecto project = rem.crearProyecto(nombreProyecto);
        
        Proyecto project = rem.abrirProyecto(nombreProyecto);
        //project.addVer(nuevoEdu("0001"));
        //project.addVer(nuevoEdu("0002"));
        /*Educcion z = project.getEdu("edu0001");
        z.setVersion("0.02");
        String razon = "se cambio la version";
        project.modEdu(z, razon);*/
        
        project.exportarLibroEdu("D:\\Informe", "LibroEduccion");
    }
   
    public Proyecto crearProyecto(String project){
        Proyecto pro = new Proyecto(project);
        pro.createProject();
        return pro;
    }
    
    private Proyecto abrirProyecto(String nom) {
        Proyecto pro = new Proyecto(nom);
        pro.loadProject();
        return pro;
    }
}
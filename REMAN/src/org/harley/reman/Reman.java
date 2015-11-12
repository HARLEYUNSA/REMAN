package org.harley.reman;

import org.harley.reman.clases.*;
import org.harley.reman.conversion.XMLConverter;
import org.harley.reman.conversion.XMLReader;

/**
 *
 * @author Gonzalo
 */
public class Reman {

     public static LibroEduccion crearEduccion() {
        LibroEduccion nuevo = new LibroEduccion();
        Educcion edu = new Educcion();
        Version ver = new Version();
        
        edu.setId("0001");
        edu.setEduccionNombre("Nombre del requisito");
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

        edu.setVersion(ver);
        
        nuevo.setTitulo("Libro de Educcion");
        nuevo.setIntro("Plantilla de Educción de Requisitos");
        nuevo.addEduccion(edu);
        return nuevo;
    }
    
    public static LibroActores crearActor(){
        LibroActores nuevo = new LibroActores();
        Actor act = new Actor();
        act.setNombre("Gonzalo");
        act.setOrg("Harley");
        act.setCargo("Jefe de oficina");
        act.setTipo("Desarrollador");
        act.setCorreo("glunaluza@gmail.com");
        act.setComentarios("Comentarios");
        nuevo.addActor(act);
        return nuevo;
    }
    
    public static LibroEspecificacion inicialize(){
        LibroEspecificacion libro = new LibroEspecificacion();
        Especificacion esp = new Especificacion();
        Nombre nom = new Nombre();
        Version ver = new Version();
        Excepcion excep = new Excepcion(); 
        Paso pas = new Paso();
        nom.setEspNombre("ESP001");
        nom.setEspDes("especificacion ads");

        ver.setvMax(1);
        ver.setvMin(2);

        libro.setTitulo("Esp01");
        libro.setIntro("introduccion");
        libro.addEspecificacion(esp);

        pas.setPasoNum(1);
        pas.setPasoDes("el sistema");
        excep.add(pas);

        esp.setRequisito(nom);
        esp.setEliNombre("ELI001");
        esp.setVersion(ver);
        esp.setAutor("Gonzalo");
        esp.setFuente("Jose");
        esp.setDependencias("dependencia");
        esp.setDescripcion("Descripcion");
        esp.addPrecondicion("precondicion1");
        esp.addPostcondicion("postcondicion1");
        esp.addExcepcion(excep);
        esp.setComentarios("comentarios dasdsada");
        
        return libro;
    }
    
    public static void main(String[] args) {
        String educcion = "libroEduccion";
        XMLReader<LibroEduccion> reader = new XMLReader(LibroEduccion.class);
        reader.writeXML(educcion, crearEduccion());
       
        LibroEduccion abierto = reader.openXML(educcion);
        //String educcion = "libroEduccion";
        //String elicitacion = "libroElicitacion";
        /*String actores = "actores";
        String proyecto = "proyecto";
        String historico = "historico";
        String organizacion = "organizacion";*/
        XMLConverter factory = new XMLConverter();
        //factory.convert(educcion);
        //factory.convert(elicitacion);
        factory.convert(educcion);
        //factory.convert(actores);
        //factory.convert(proyecto);
        //factory.convert(historico);
        //factory.convert(organizacion);       
    }
}

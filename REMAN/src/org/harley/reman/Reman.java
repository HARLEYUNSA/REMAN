package org.harley.reman;

import org.harley.reman.clases.*;
import org.harley.reman.conversion.XMLConverter;
import org.harley.reman.conversion.XMLReader;

/**
 *
 * @author Gonzalo
 */
public class Reman {

    public static LibroActores iniciar(){
        LibroActores nuevo = new LibroActores();
        LibroActores.Actores act = new LibroActores.Actores();
        
        act.setActor("Gonzalo");
        act.setOrg("Harley");
        act.setCargo("Jefe de oficina");
        act.setTipo("Desarrollador");
        act.setCorreo("glunaluza@gmail.com");
        act.setComentarios("Comentarios");
        
        nuevo.setTitulo("Libro de Actores");
        nuevo.setIntro("Plantilla de Actores");
        nuevo.setActores(act);
        
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
        libro.setEsp(esp);

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
        String actores = "actores";
        XMLReader<LibroActores> reader = new XMLReader(LibroActores.class);
        reader.writeXML(actores, iniciar());
        
        LibroActores abierto = reader.openXML(actores);
        //String educcion = "libroEduccion";
        //String elicitacion = "libroElicitacion";
        /*String actores = "actores";
        String proyecto = "proyecto";
        String historico = "historico";
        String organizacion = "organizacion";*/
        XMLConverter factory = new XMLConverter();
        //factory.convert(educcion);
        //factory.convert(elicitacion);
        factory.convert("actores");
        //factory.convert(actores);
        //factory.convert(proyecto);
        //factory.convert(historico);
        //factory.convert(organizacion);       
    }
}

package org.harley.reman;

import java.util.ArrayList;
import org.harley.reman.sistema.*;

public class Reman {
    
    public static void main(String[] args) {
        
        Sistema sis = new Sistema();
        /*sis.crearProyecto("REMAN", "REMAN", "HARLEY", "UNSA", 
        "Incalla Nina Christian", "01/01/0001", 
        "30/12/2015","REMAN");*/
       
        sis.ingresarProyecto("REMAN");
        
        /*sis.crearEduccion("Nombre3", "0.01", "Primario", "Objectivo acà", 
                "01/01/2016", "Cristiano Lòpez", "Usuario", "Interno", 
                "Luna Luza Gonzalo", "Ing. Requisitos", "Alta", "Programador",
                "Descripción aquí", "Observaciones y/o comentarios.");*/
               
        //sis.exportarLibroEdu("D:\\Informe", "LibroEduccion");
         
        Paso x = new Paso("1", "el sistema ....");
        ArrayList<Paso> pas = new ArrayList<>();
        pas.add(x);
        
        sis.crearElicitacion("Nombre", "EDU0001","0.02", "01/01/2016", "Cristiano López", 
                "Usuario", "interno", "Luna Luza Gonzalo", "Ing. Requisitos", 
                "Alta", "Programador", "Área relacionada", "Dscripción", 
                "Precondicion", pas, "postcondicion", pas, "observaciones");
        
        //Versionar restaurar Libro
        /*sis.verLibroEdu("0.3", "Prueba", "Gonzalo");
        List<Historico> lista = sis.getHistLibEdu();
        for(Historico x : lista){
            System.out.println(x.getVersion() + " " + x.getRazon());
        }
        sis.resLibroEdu("0.3");*/

        //sis.eliminarEduccion("edu0002");
        
        //Restaurar
        /*List<Historico> lista = sis.getHistEdu("edu0001");
        for(Historico x : lista){
            System.out.println(x.getVersion() + " " + x.getRazon());
        }
        sis.restaurarEduccion("edu0001", "0.01");*/
        
        //Versionar modificar
        /*Educcion modificar = sis.recuperarEduccion("edu0001");
        sis.versionarEduccion("edu0001", "Nombre", "0.01", "Primario", "Objectivo acà", "01/01/2016",
                "Cristiano Lòpez", "Usuario", "Externo", "Luna Luza Gonzalo",
                "Ing. Requisitos", "Alta", "Programador", "Descripción aquí",
                "Observaciones y/o comentarios con respecto al requerimiento.",
                "se cambio la fuente", "0.02");
        sis.modificarEduccion("edu0001", "Nombre40", "0.01", "Secundario", "Objectivo acà", "01/01/2016",
                "Cristiano Lòpez", "Usuario", "Externo", "Luna Luza Gonzalo",
                "Ing. Requisitos", "Alta", "Programador", "Descripción aquí",
                "Observaciones y/o comentarios con respecto al requerimiento.");*/
        
    }
}
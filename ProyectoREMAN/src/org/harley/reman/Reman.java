package org.harley.reman;

import java.util.List;
import org.harley.reman.sistema.*;

/**
 *
 * @author Gonzalo
 */
public class Reman {
    

    public static void main(String[] args) {
        
        Sistema sis = new Sistema();
        sis.crearProyecto("REMAN", "HARLEY", "UNSA", "Incalla Nina Christian", "Terminado", "01/01/0001", "30/12/2015","REMAN");
       
        //sis.ingresarProyecto("D:\\REMAN");
        
        sis.agregarEduccion("Nombre1", "0.01", "Primario", "Objectivo acà", "01/01/2016",
                "Cristiano Lòpez", "Usuario", "Interno", "Luna Luza Gonzalo",
                "Ing. Requisitos", "Alta", "Programador", "Descripción aquí",
                "Observaciones y/o comentarios con respecto al requerimiento.");
        
        sis.agregarEduccion("Nombre1", "0.01", "Primario", "Objectivo acà", "01/01/2016",
                "Cristiano Lòpez", "Usuario", "Interno", "Luna Luza Gonzalo",
                "Ing. Requisitos", "Alta", "Programador", "Descripción aquí",
                "Observaciones y/o comentarios con respecto al requerimiento.");
        
        sis.agregarEduccion("Nombre2", "0.01", "Primario", "Objectivo acà", "01/01/2016",
                "Cristiano Lòpez", "Usuario", "Interno", "Luna Luza Gonzalo",
                "Ing. Requisitos", "Alta", "Programador", "Descripción aquí",
                "Observaciones y/o comentarios con respecto al requerimiento.");
        
        //sis.exportarLibroEdu("D:\\Informe", "LibroEduccion");
         
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
        /*Educcion modificar = sis.mostrarEduccion("edu0001");
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
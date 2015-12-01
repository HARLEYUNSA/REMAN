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
    

    public static void main(String[] args) {
        Proyecto pro = new Proyecto();
        pro.crearProyecto("REMAN", "HARLEY", "UNSA", "Incalla Nina Christian",
                "Terminado", "01/01/0001", "30/12/2015");
       
        //pro.ingresarProyecto("REMAN");
        
        //rem.eliminarProyecto("REMAN");
               
        /*rem.agregarEdu("Nombre", "0.01", "Primario", "Objectivo acà", "01/01/2016",
        
        rem.verLibro(0, "0.1", "2 educciones");*/
        
        pro.agregarEduccion("Nombre1", "Primario", "Objectivo acà", "01/01/2016",
                "Cristiano Lòpez", "Usuario", "Interno", "Luna Luza Gonzalo",
                "Ing. Requisitos", "Alta", "Programador", "Descripción aquí",
                "Observaciones y/o comentarios con respecto al requerimiento.");
        
        pro.exportarLibroEdu("D:\\Informe", "LibroEduccion");

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
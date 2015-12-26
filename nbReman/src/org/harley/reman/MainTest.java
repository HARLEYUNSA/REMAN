package org.harley.reman;

import java.util.ArrayList;
import org.harley.reman.sistema.Paso;
import org.harley.reman.sistema.Sistema;

public class MainTest {
    public static void main(String[] args) {
        Sistema test = new Sistema();
        test.setDirPrincipal(test.getStateReman());
        test.ingresarProyecto();
        ArrayList<String> x = test.getFuenteNombres();
        for (String x1 : x) {
            System.out.println(x1);
        }
        /*ArrayList<Paso> pas = new ArrayList<>();
        Paso p = new Paso("1","El sistema");
        pas.add(p);
        Paso p1 = new Paso("2","El usuario");
        pas.add(p1);*/
        //test.crearEduccion("Gonzal", "1.0", "asd", "ad", "a", "b", "c", "d", "e", "f", "g", "g", "a", "a");
        
        //test.crearElicitacion("Gonzal", "1.0", "asd", "ad", "a", "b", "c", "d", "e", "f", "g", "g", "a", "a", pas,"b",pas,"o");
        //test.crearEspecificacion("Gonzal", "1.0", "asd", "ad", "a", "b", "c", "d", "e", "f", "g", "g", "a", "a", "b", pas,"b");
        //test.crearReqNoFuncional("Gonzal", "1.0", "asd", "ad", "a", "b", "c", "d", "e", "f", "g", "g", "a", "a","b");
        
        //test.crearStakeholder("Gonzal", "1.0", "asd", "ad","d","e");
       // test.crearProyectTeam("Gonzal", "1.0", "asd", "ad","d","e","f");
        //test.crearOrganizacion("Gonzal", "1.0", "asd", "ad","d","e");
        
        /*test.exportarLibro(5, "D://informes", "LibroAct");
        test.exportarLibro(4, "D://informes", "LibroOrg");
        test.exportarLibro(3, "D://informes", "LibroRnf");
        test.exportarLibro(2, "D://informes", "LibroEsp");
        test.exportarLibro(1, "D://informes", "LibroEli");*/
        test.exportarLibro(0, "D://informes", "LibroEdu");
        
        //        test.versionarLibro(0,"1.1","02/03", "yo", "razon"); //
//        test.versionarEduccion("1.1","02","Yo", "nada", "EDU0001", "Gonzal", "1.0", "zxv", "ad", "a", "b", "c", "d", "e", "f", "g", "g", "a", "a");
//        test.versionarLibro(0,"1.2","02/03", "alguien", "razon"); //1 educcion 2 versiones
//        test.restaurarLibro(0, "1.1"); //1 educcion 1 version
    }
}

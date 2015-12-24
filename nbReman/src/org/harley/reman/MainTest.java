package org.harley.reman;

import org.harley.reman.sistema.Sistema;

public class MainTest {
    public static void main(String[] args) {
        Sistema test = new Sistema();
        test.crearProyecto("REMAN", "remanPr", "HARLEY", "UNSA", "Incalla", "11/12/2015", "31/12/2015", "D:\\GG");
        test.crearEduccion("Gonzal", "1.0", "asd", "ad", "a", "b", "c", "d", "e", "f", "g", "g", "a", "a");
        test.versionarLibro(0,"1.1","02/03", "yo", "razon"); //
        test.versionarEduccion("1.1","02","Yo", "nada", "EDU0001", "Gonzal", "1.0", "zxv", "ad", "a", "b", "c", "d", "e", "f", "g", "g", "a", "a");
        test.versionarLibro(0,"1.2","02/03", "alguien", "razon"); //1 educcion 2 versiones
        test.restaurarLibro(0, "1.1"); //1 educcion 1 version
        test.exportarLibro(0, "D://informes", "LibroEdu");
    }
}

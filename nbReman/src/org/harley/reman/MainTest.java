package org.harley.reman;

import org.harley.reman.sistema.Sistema;

public class MainTest {
    public static void main(String[] args) {
        Sistema test = new Sistema();
        test.crearProyecto("REMAN", "remanPr", "HARLEY", "UNSA", "Incalla", "11/12/2015", "31/12/2015", "D:\\GG");
    }
}

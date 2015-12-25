package org.harley.reman;

import org.harley.reman.interfaz.interfaces.VPrincipal;
import org.harley.reman.sistema.Sistema;

/**
 * @author CHRISTIAN
 */
public class Reman {

    public static void main(String args[]) {
        /* Modo de vist de Diseño : Windows */
        //<editor-fold defaultstate="collapsed" desc=" Codigo de DiseÃ±o de Vista (opcional) ">  
        //escribir aqui
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //pantalla principal
                new VPrincipal(new Sistema()).setVisible(true);
            }
        });
    }
}

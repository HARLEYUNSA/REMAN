package org.harley.reman;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import org.harley.reman.interfaz.interfaces.VPrincipal;
import org.harley.reman.interfaz.utilitario.ToolsInterface;
import org.harley.reman.sistema.Sistema;
import org.harley.reman.sistema.ToolsSystem;

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
                new VPrincipal(new Sistema()).setVisible(true);
            }
        });
    }
}

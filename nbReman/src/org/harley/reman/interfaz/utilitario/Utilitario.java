
package org.harley.reman.interfaz.utilitario;

import java.util.ArrayList;
import javax.swing.JComboBox;
/**
 *
 * @author Joel Mendoza
 */

public class Utilitario {

    public static void llenaCombo(JComboBox ComboBox,ArrayList<String> arr){
        for (String arr1 : arr) {
            ComboBox.addItem(arr1);
        }
    }
    
    public static void vaciaCombo(JComboBox ComboBox,ArrayList<String> arr){
        ComboBox.removeAllItems();
    }
        
}

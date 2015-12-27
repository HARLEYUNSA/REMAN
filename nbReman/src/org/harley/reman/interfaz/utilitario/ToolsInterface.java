package org.harley.reman.interfaz.utilitario;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Joel Mendoza
 */
public class ToolsInterface {

    public static void addItems2JComboBox(JComboBox ComboBox, ArrayList<String> arr) {
        ComboBox.removeAllItems();
        for (String arr1 : arr) {
            ComboBox.addItem(arr1);
        }
    }

    public static void vaciaCombo(JComboBox ComboBox, ArrayList<String> arr) {
        ComboBox.removeAllItems();
    }

    public static void msjError(Component frame, String msj) {
        JOptionPane.showMessageDialog(frame, msj, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static void msjInfo(Component frame, String title, String msj) {
        JOptionPane.showMessageDialog(frame, msj, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Devuelve un Jtree que almacena los elementos xml de un directorio
     *
     * @param rootName Nombre del Jtree
     * @param titleBook Nombre del Directorio Principal del JTree
     * @param url Directorio de los archivos xml
     * @return JTree con los elementos
     */
    public static JTree generateJTreeBook(String rootName, String titleBook, String url) {
        ArrayList<String> datos = new ArrayList<>();
        datos.addAll(findFiles(url, "xml", false));

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootName);
        DefaultTreeModel modelo = new DefaultTreeModel(root);
        JTree tree = new JTree(modelo);
        DefaultMutableTreeNode book = new DefaultMutableTreeNode(titleBook);
        modelo.insertNodeInto(book, root, 0);

        DefaultMutableTreeNode treeNode;

        for (int i = 0; i < datos.size(); i++) {
            treeNode = new DefaultMutableTreeNode(datos.get(i));
            modelo.insertNodeInto(treeNode, book, i);
        }
        return tree;
    }

    /**
     * Genera el Jtree de Org con organizaciones, stakeholders, proyectTeam
     *
     * @param urlOrg Direccion de la carpeta org principal
     * @return JTree con los elementos
     */
    public static JTree generateJTreeOrg(String urlOrg) {
        ArrayList<String> datosOrg = new ArrayList<>();
        datosOrg.addAll(findFiles(urlOrg + "\\" + "org", "xml", false));
        ArrayList<String> datosSth = new ArrayList<>();
        datosSth.addAll(findFiles(urlOrg + "\\" + "sth", "xml", false));
        ArrayList<String> datosPyt = new ArrayList<>();
        datosPyt.addAll(findFiles(urlOrg + "\\" + "pyt", "xml", false));
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Documentos de la Organización");
        DefaultTreeModel modelo = new DefaultTreeModel(root);
        JTree tree = new JTree(modelo);

        DefaultMutableTreeNode org = new DefaultMutableTreeNode("Organización");
        modelo.insertNodeInto(org, root, 0);
        DefaultMutableTreeNode act = new DefaultMutableTreeNode("Actores");
        modelo.insertNodeInto(act, root, 1);

        DefaultMutableTreeNode pyt = new DefaultMutableTreeNode("Especialista");
        modelo.insertNodeInto(pyt, act, 0);
        DefaultMutableTreeNode sth = new DefaultMutableTreeNode("Fuente");
        modelo.insertNodeInto(sth, act, 1);

        DefaultMutableTreeNode treeNode;

        for (int i = 0; i < datosOrg.size(); i++) {
            treeNode = new DefaultMutableTreeNode(datosOrg.get(i));
            modelo.insertNodeInto(treeNode, org, i);
        }

        for (int i = 0; i < datosPyt.size(); i++) {
            treeNode = new DefaultMutableTreeNode(datosPyt.get(i));
            modelo.insertNodeInto(treeNode, pyt, i);
        }

        for (int i = 0; i < datosSth.size(); i++) {
            treeNode = new DefaultMutableTreeNode(datosSth.get(i));
            modelo.insertNodeInto(treeNode, sth, i);
        }
        return tree;
    }

    /**
     * Busca elementos de una determinada extension y los devuelve en un
     * arraylist con o sin esta
     *
     * @param url Directorio de los archivos xml
     * @param extension extension a buscar
     * @param opt true: archivo.extension false: archivo
     * @return ArrayList con el nombre de los elementos de la extension
     * espesificada
     */
    public static ArrayList<String> findFiles(String url, String extension, boolean opt) {
        ArrayList<String> rpt = new ArrayList<>();
        int lengthExt = extension.length();
        String temp;
        try {
            File[] ficheros = new File(url).listFiles();
            if (opt) {
                for (File fichero : ficheros) {
                    temp = fichero.getName();
                    if ((temp.length() > lengthExt) && (temp.substring(temp.length() - lengthExt, temp.length()).equals(extension))) {

                        rpt.add(fichero.getName());
                    }
                }
            } else {
                for (File fichero : ficheros) {
                    temp = fichero.getName();
                    if ((temp.length() > lengthExt) && (temp.substring(temp.length() - lengthExt, temp.length()).equals(extension))) {

                        rpt.add(temp.substring(0, temp.length() - lengthExt - 1));
                    }
                }
            }
        } catch (Exception e) {
        }
        return rpt;
    }

    /**
     * Devuelve si encuentra la expresion regular en el texto indicado
     *
     * @param expReg expresion regular
     * @param text texto en donde se busca
     * @return true: encontro la exp Regular false: no encontro la exp Regular
     */
    public static boolean checkExpReg(String expReg, String text) {
        Pattern pat = Pattern.compile(expReg);
        Matcher mat = pat.matcher(text);
        return mat.find();
    }

    public static boolean isNumber(String number) {
        char letter;
        for (int i = 0; i < number.length(); i++) {
            letter = number.charAt(i);
            if (!Character.isDigit(letter) && letter != '_' && letter != ' ' && letter != '-') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphabetic(String number) {
        char letter;
        for (int i = 0; i < number.length(); i++) {
            letter = number.charAt(i);
            if (!Character.isAlphabetic(letter) && letter != '_' && letter != ' ' && letter != '-') {
                return false;
            }
        }
        return true;
    }

    /**
     * verifica si la extension es correcta y si le falta la misma
     *
     * @param nameFile nombre del archivo a revisar
     * @return
     */
    public static String addExtensionPdf(String nameFile) {
        int lenght = nameFile.length();
        char letter;
        int point = 0;
        for (int i = 0; i < lenght; i++) {
            letter = nameFile.charAt(i);
            if (letter == '.') {
                point = i;
                break;
            }
        }
        //si no existe punto no existe extension
        if (point == 0) {
            return nameFile;
        } else {
            //la extension es mayor o menor a 4 chars ".pdf"
            if (lenght - point != 4) {
                return "error";
            } else {
                //la extension es correcta
                if (nameFile.charAt(point + 1) == 'p' &&  nameFile.charAt(point + 2) == 'd' && nameFile.charAt(point + 3) == 'f'){
                    return nameFile.substring(0,point);
                }
                else{
                    return "error";
                }
            }
        }

    }
    
    public static boolean verificarVersion(String version){
        int lenght = version.length();
        if(lenght == 0){
            return false;
        }
        if(!Character.isDigit(version.charAt(0))){
            return false;
        }
        
        for (int i = 1; i < lenght; i++) {
            if(!Character.isDigit(version.charAt(i)) && !Character.isAlphabetic(version.charAt(i)) && version.charAt(i) != '.'){
                return false;
            }
        }
        return true;
    }
}

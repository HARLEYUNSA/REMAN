package org.harley.reman.interfaz.utilitario;

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

    public static void llenarJComboBox(JComboBox ComboBox, ArrayList<String> arr) {
        ComboBox.removeAllItems();
        for (String arr1 : arr) {
            ComboBox.addItem(arr1);
        }
    }

    public static void vaciaCombo(JComboBox ComboBox, ArrayList<String> arr) {
        ComboBox.removeAllItems();
    }

    public static void msjError(String msj) {
        JOptionPane.showMessageDialog(null, msj);
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

    public static boolean validaProyecto(String proNom, String prdNom, String empDes,
            String empCli, String proLid, String fecIni, String fecFin,
            String proUbi){
        boolean error=true;
        if (empCli.equals("") || empDes.equals("") || proNom.equals("")
                || prdNom.equals("") || proUbi.equals("") || proLid.equals("") 
                || fecIni.equals("") || fecFin.equals("")) {
            error = false;
        }
        return error;
    }
    public static boolean validaEduccion(String eduEspCar, String eduFueCar, 
            String eduDes, String eduEspEsp, String eduEspExp, String eduNom, 
            String eduObj, String eduObs, String eduTip, String eduFueTip,
            String eduVer, String eduEspNom, String eduFueNom, String eduFec){
        boolean flag = true;
        
        if(eduEspCar.equals("") || eduFueCar.equals("") || eduDes.equals("") ||
            eduEspEsp.equals("") || eduEspExp.equals("") || eduNom.equals("") ||
             eduObj.equals("") ||  eduObs.equals("") ||  eduTip.equals("") ||  
                eduFueTip.equals("") || eduVer.equals("") ||  eduEspNom.equals("")
                ||  eduFueNom.equals("") ||  eduFec.equals("")){
            flag = false;
        }
        
        return flag;
    }
    
    public static boolean validaElicitacion(String eliAre, String eliCarEsp, 
        String eliCarFue, String eliCod, String eliDes, String eliEspEsp,
        String eliEspExp, String eliNom, String eliObs, String eliPosCon,
        String eliPreCon, String eliTipfue, String eliVer, String eliEspNom,
        String eliFueNom, String eliFec){
        
        boolean flag = true;
        
        if(eliAre.equals("") || eliCarEsp.equals("") || eliCarFue.equals("") ||
                eliCod.equals("") || eliDes.equals("") || eliEspEsp.equals("") ||
                eliEspExp.equals("") || eliNom.equals("") || eliObs.equals("") 
                || eliPosCon.equals("") || eliPreCon.equals("") || eliTipfue.equals("") ||
                eliVer.equals("") || eliEspNom.equals("") || eliFueNom.equals("") ||
                eliFec.equals("")){
            flag = false;
        }
  
        return flag;
    }
    
    public static boolean validaEspecificacion(String espAre, String espCarEsp, 
        String espCarFue, String espCod, String espDes, String espEspEsp,
        String espEspExp, String espNom, String espObs, String espPosCon,
        String espPreCon, String espTipfue, String espVer, String espEspNom,
        String espFueNom, String espFec){
        
        boolean flag = true;
        
        if(espAre.equals("") || espCarEsp.equals("") || espCarFue.equals("") ||
                espCod.equals("") || espDes.equals("") || espEspEsp.equals("") ||
                espEspExp.equals("") || espNom.equals("") || espObs.equals("") 
                || espPosCon.equals("") || espPreCon.equals("") || espTipfue.equals("") ||
                espVer.equals("") || espEspNom.equals("") || espFueNom.equals("") ||
                espFec.equals("")){
            flag = false;
        }
  
        return flag;
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
}

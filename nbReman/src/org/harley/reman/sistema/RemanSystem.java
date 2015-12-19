package org.harley.reman.sistema;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * 
 * @author Christian
 */
public class RemanSystem {
    Properties propiedades;
    
    public void crearPropiedades(String proNom,String prdNom, String empDes, String empCli, String proLib, String estPro, String fecIni, String fecFin, String ubiPro) {
        OutputStream salida = null;
        try {
            salida = new FileOutputStream(ubiPro+"//remanproject//configuracion.properties");
            propiedades = new Properties();
            propiedades.setProperty("proNom", proNom);
            propiedades.setProperty("prdNom", prdNom);
            propiedades.setProperty("empDes", empDes);
            propiedades.setProperty("empCli", empCli);
            propiedades.setProperty("proLib", proLib);
            propiedades.setProperty("estPro", estPro);
            propiedades.setProperty("fecIni", fecIni);
            propiedades.setProperty("fecFin", fecFin);
            propiedades.setProperty("numEdu", "0");
            propiedades.setProperty("numEli", "0");
            propiedades.setProperty("numEsp", "0");
            propiedades.setProperty("numRnf", "0");
            propiedades.setProperty("numOrg", "0");
            propiedades.setProperty("numSth", "0");
            propiedades.setProperty("numPry", "0");
            propiedades.store(salida, null);
        } catch (IOException io) {
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    public void crearDirectorios(String dirPrincipal){
        new File(dirPrincipal).mkdir();
        new File(dirPrincipal,"remanproject").mkdir();
        new File(dirPrincipal,"src//edu").mkdirs();
        new File(dirPrincipal,"src//eli").mkdir();
        new File(dirPrincipal,"src//esp").mkdir();
        new File(dirPrincipal,"src//org").mkdir();
        new File(dirPrincipal,"src//rnf").mkdir();
        new File(dirPrincipal,"verlib//edu").mkdirs();
        new File(dirPrincipal,"verlib//eli").mkdir();
        new File(dirPrincipal,"verlib//esp").mkdir();
        new File(dirPrincipal,"verlib//rnf").mkdir();
    }
    
    public void iniciarHistoricos(String ubiPro) throws IOException{
        new File(ubiPro+"//verlib//edu//eduhis.xml").createNewFile();
        new File(ubiPro+"//verlib//eli//elihis.xml").createNewFile();
        new File(ubiPro+"//verlib//esp//esphis.xml").createNewFile();
        new File(ubiPro+"//verlib//rnf//rnfhis.xml").createNewFile();
    }

    public boolean crearProyecto(String proNom,String prdNom, String empDes, String empCli, String proLid, String estPro, String fecIni, String fecFin, String ubiPro){
        try {
            crearDirectorios(ubiPro);
            crearPropiedades(proNom, prdNom, empDes, empCli, proLid, estPro, fecIni, fecFin, ubiPro);
            iniciarHistoricos(ubiPro);
            //crearOrganizacion(empDes);    
            //crearOrganizacion(empCli);    
            //crearActor(proLid, empDes);           
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
}

package org.harley.reman.sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

       
@XmlRootElement
    @XmlType(propOrder = {
        "proNom",
        "empDes",
        "empCli",
        "lidPro",
        "estPro",
        "fecIni",
        "fecFin",
    })
public class Proyecto {
    String proNom;
    String empDes;
    String empCli;
    String lidPro;
    String estPro;
    String fecIni;
    String fecFin;
    File dirPro;
    Properties properties;

    Proyecto (){
        this.properties = new Properties();
    }
    Proyecto(String proNom, String empDes, String empCli, String lidPro, String estPro, String fecIni, String fecFin) {
        this.proNom = proNom;
        this.empDes = empDes;
        this.empCli = empCli;
        this.lidPro = lidPro;
        this.estPro = estPro;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.properties = new Properties();
    }

    public String getProNom() {
        return proNom;
    }
    
    @XmlElement
    public void setProNom(String proNom) {
        this.proNom = proNom;
    }

    public String getEmpDes() {
        return empDes;
    }
    
    @XmlElement
    public void setEmpDes(String empDes) {
        this.empDes = empDes;
    }

    public String getEmpCli() {
        return empCli;
    }
    
    @XmlElement
    public void setEmpCli(String empCli) {
        this.empCli = empCli;
    }

    public String getLidPro() {
        return lidPro;
    }
    
    @XmlElement
    public void setLidPro(String lidPro) {
        this.lidPro = lidPro;
    }

    public String getEstPro() {
        return estPro;
    }
    
    @XmlElement
    public void setEstPro(String estPro) {
        this.estPro = estPro;
    }

    public String getFecIni() {
        return fecIni;
    }
    
    @XmlElement
    public void setFecIni(String fecIni) {
        this.fecIni = fecIni;
    }

    public String getFecFin() {
        return fecFin;
    }
    
    @XmlElement
    public void setFecFin(String fecFin) {
        this.fecFin = fecFin;
    }

    public void setDirectory(File dir){
        this.dirPro = dir;
    }
    
    public void setProperty(String key, String value) {
        this.properties.setProperty(key, value);
    }
    
    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }
    
    public void saveProperties(){
        OutputStream salida = null;
        try {    
            File output = new File(dirPro, "configuracion.properties");
            salida = new FileOutputStream(output);
            properties.store(salida, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }  
   }
    
    /**
     * Crea el archivo properties insertando los valores del proyecto
     */
    public void createProperties() {
        OutputStream salida = null;
        try {
            File output = new File(dirPro, "configuracion.properties");
            salida = new FileOutputStream(output);
            properties.setProperty("proNom", proNom);
            properties.setProperty("empDes", empDes);
            properties.setProperty("empCli", empCli);
            properties.setProperty("lidPro", lidPro);
            properties.setProperty("estPro", estPro);
            properties.setProperty("fecIni", fecIni);
            properties.setProperty("fecFin", fecFin);
            properties.setProperty("numEdu", "0");
            properties.setProperty("numEli", "0");
            properties.setProperty("numEsp", "0");
            properties.store(salida, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }    
    }
   
    public void loadProperties(){
        InputStream entrada = null;
        try {
            File input = new File(dirPro, "configuracion.properties");
            entrada = new FileInputStream(input);
            properties.load(entrada);
            proNom = properties.getProperty("proNom");
            empDes = properties.getProperty("empDes");
            empCli = properties.getProperty("empCli");
            lidPro = properties.getProperty("lidPro");
            estPro = properties.getProperty("estPro");
            fecIni = properties.getProperty("fecIni");
            fecFin = properties.getProperty("fecFin");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    File getDirectory() {
        return this.dirPro;
    }
    
}

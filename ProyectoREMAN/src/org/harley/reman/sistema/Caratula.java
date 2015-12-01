package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
    @XmlType(propOrder = {
        "titulo",
        "proyecto",
        "empDes",
        "empCli",
        "lidPro",
        "estPro",
        "fecIni",
        "fecFin",
        "fecAct",
        "lugar"
    })
public class Caratula {
    String titulo;
    String proyecto;
    String empDes;
    String empCli;
    String lidPro;
    String estPro;
    String fecIni;
    String fecFin;
    String fecAct;
    String lugar;

    public Caratula() {
        this.lugar = "Arequipa, Peru";
    }
 
    public String getTitulo() {
        return titulo;
    }
    
    @XmlElement
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProyecto() {
        return proyecto;
    }
    
    @XmlElement
    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
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

    public String getFecAct() {
        return fecAct;
    }
    
    @XmlElement
    public void setFecAct(String fecAct) {
        this.fecAct = fecAct;
    }

    public String getLugar() {
        return lugar;
    }
    
    @XmlElement
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    
}
package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
    @XmlType(propOrder = {
        "titulo",
        "pro",
        "fecAct",
        "lugar"
    })
public class Caratula {
    String titulo;
    Proyecto pro;
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

    public Proyecto getPro() {
        return pro;
    }
    
    @XmlElement
    public void setPro(Proyecto pro) {
        this.pro = pro;
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
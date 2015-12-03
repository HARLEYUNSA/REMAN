package org.harley.reman.sistema;

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
        
    public Caratula(){
        
    }
    public Caratula(String titulo, String proNom, String empDes, String empCli, 
            String proLid, String proEst, String fecIni, String fecFin, String fecAct, String lugar) {
        this.titulo = titulo;
        this.pro = new Proyecto(proNom, empDes, empCli, proLid, proEst, fecIni,
        fecFin);
        this.fecAct = fecAct;
        this.lugar = lugar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Proyecto getPro() {
        return pro;
    }

    public void setPro(Proyecto pro) {
        this.pro = pro;
    }

    public String getFecAct() {
        return fecAct;
    }

    public void setFecAct(String fecAct) {
        this.fecAct = fecAct;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }    
}
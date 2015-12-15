package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EliNombre {

    String eliCod;
    String eliNom;

    public EliNombre() {
    }

    public EliNombre(String eliCod, String eliNom) {
        this.eliCod = eliCod;
        this.eliNom = eliNom;
    }
    
    public String getEliCod() {
        return eliCod;
    }
    
    public void setEliCod(String eduCod) {
        this.eliCod = eduCod;
    }

    public String getEliNom() {
        return eliNom;
    }
    
    public void setEliNom(String descripcion) {
        this.eliNom = descripcion;
    }

}

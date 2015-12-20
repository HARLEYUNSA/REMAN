package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "espCod",
    "espNom"
})
public class EspNombre {

    String espCod;
    String espNom;

    public EspNombre() {
    }

    public EspNombre(String espCod, String espNom) {
        this.espCod = espCod;
        this.espNom = espNom;
    }
    
    public String getEspCod() {
        return espCod;
    }
    
    public void setEspCod(String espCod) {
        this.espCod = espCod;
    }

    public String getEspNom() {
        return espNom;
    }
    
    public void setEspNom(String descripcion) {
        this.espNom = descripcion;
    }
}

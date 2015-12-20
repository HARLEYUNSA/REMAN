
package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RnfNombre {
    String rnfCod;
    String rnfNom;

    public RnfNombre() {
    }

    public RnfNombre(String rnfCod, String rnfNom) {
        this.rnfCod = rnfCod;
        this.rnfNom = rnfNom;
    }
    
    public String getRnfCod() {
        return rnfCod;
    }
    
    public void setRnfCod(String rnfCod) {
        this.rnfCod = rnfCod;
    }

    public String getRnfNom() {
        return rnfNom;
    }
    
    public void setRnfNom(String descripcion) {
        this.rnfNom = descripcion;
    }
}

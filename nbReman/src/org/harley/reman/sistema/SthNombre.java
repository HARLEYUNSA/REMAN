package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gonzalo
 */
@XmlRootElement
class SthNombre {
    String sthCod;
    String sthNom;

    public SthNombre() {
    }

    public SthNombre(String sthCod, String sthNom) {
        this.sthCod = sthCod;
        this.sthNom = sthNom;
    }

    public String getSthCod() {
        return sthCod;
    }

    public void setSthCod(String sthCod) {
        this.sthCod = sthCod;
    }

    public String getSthNom() {
        return sthNom;
    }

    public void setSthNom(String sthNom) {
        this.sthNom = sthNom;
    }
    
}

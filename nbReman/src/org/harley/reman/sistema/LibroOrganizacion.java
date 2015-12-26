package org.harley.reman.sistema;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Gonzalo
 */
@XmlRootElement(name = "libroOrganizacion")
@XmlType(propOrder = {
    "intro",
    "orgs"
})
class LibroOrganizacion {

    Caratula intro;
    ArrayList<Organizacion> orgs;

    public LibroOrganizacion() {
    }
    
    public LibroOrganizacion(Caratula intro, ArrayList<Organizacion> orgs) {
        this.intro = intro;
        this.orgs = orgs;
    }

    public Caratula getIntro() {
        return intro;
    }

    public void setIntro(Caratula intro) {
        this.intro = intro;
    }

    public ArrayList<Organizacion> getOrgs() {
        return orgs;
    }

    @XmlElementWrapper(name = "tabla")
    @XmlElement(name = "tablas")
    public void setOrgs(ArrayList<Organizacion> orgs) {
        this.orgs = orgs;
    }
    
    void addOrg(Organizacion org) {
        if( this.orgs == null ){
            this.orgs = new ArrayList<>();
        }
        this.orgs.add(org);    
    }

    public Organizacion getOrg(String orgCod){
        for (Organizacion org : orgs) {
            if (org.getOrgNombre().getCodigo().equals(orgCod)) {
                return org;
            }
        }
       return null;
    }
    
}

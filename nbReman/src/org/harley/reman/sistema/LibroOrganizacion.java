package org.harley.reman.sistema;

import java.util.ArrayList;
import java.util.List;
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
    List<Organizacion> orgs;

    public LibroOrganizacion() {
    }
    
    public LibroOrganizacion(Caratula intro, List<Organizacion> orgs) {
        this.intro = intro;
        this.orgs = orgs;
    }

    public Caratula getIntro() {
        return intro;
    }

    public void setIntro(Caratula intro) {
        this.intro = intro;
    }

    public List<Organizacion> getOrgs() {
        return orgs;
    }

    @XmlElementWrapper(name = "Organizaciones")
    @XmlElement(name = "Organizacion")
    public void setOrgs(List<Organizacion> orgs) {
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
            if (org.getOrgNom().getOrgCod().equals(orgCod)) {
                return org;
            }
        }
       return null;
    }
    
}

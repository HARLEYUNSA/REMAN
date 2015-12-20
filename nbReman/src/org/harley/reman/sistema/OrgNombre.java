package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "orgCod",
    "orgNom"
})
public class OrgNombre {
    String orgCod;
    String orgNom;

    public OrgNombre() {
    }

    public OrgNombre(String orgCod, String orgNom) {
        this.orgCod = orgCod;
        this.orgNom = orgNom;
    }

    public String getOrgCod() {
        return orgCod;
    }

    public void setOrgCod(String orgCod) {
        this.orgCod = orgCod;
    }

    public String getOrgNom() {
        return orgNom;
    }

    public void setOrgNom(String orgNom) {
        this.orgNom = orgNom;
    }
    
    
}

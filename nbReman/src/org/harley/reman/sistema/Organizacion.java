package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "orgNom",
    "orgDir",
    "orgTel",
    "orgPagWeb",
    "orgCorEle",
    "orgCom"
})
public class Organizacion {
    String orgNom;
    String ordDir;
    String orgTel;
    String orgPagWeb;
    String orgCorEle;
    String orgCom;

    public String getOrgNom() {
        return orgNom;
    }
    
    @XmlElement
    public void setOrgNom(String orgNom) {
        this.orgNom = orgNom;
    }

    public String getOrdDir() {
        return ordDir;
    }
    
    @XmlElement
    public void setOrdDir(String ordDir) {
        this.ordDir = ordDir;
    }

    public String getOrgTel() {
        return orgTel;
    }
    
    @XmlElement
    public void setOrgTel(String orgTel) {
        this.orgTel = orgTel;
    }

    public String getOrgPagWeb() {
        return orgPagWeb;
    }
    
    @XmlElement
    public void setOrgPagWeb(String orgPagWeb) {
        this.orgPagWeb = orgPagWeb;
    }

    public String getOrgCorEle() {
        return orgCorEle;
    }
    
    @XmlElement
    public void setOrgCorEle(String orgCorEle) {
        this.orgCorEle = orgCorEle;
    }

    public String getOrgCom() {
        return orgCom;
    }
    
    @XmlElement
    public void setOrgCom(String orgCom) {
        this.orgCom = orgCom;
    }

    
}
package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "eduCod",
    "eduNom"
})
public class EduNombre {

    String eduCod;
    String eduNom;

    public EduNombre() {
    }

    public EduNombre(String eduCod, String eduNom) {
        this.eduCod = eduCod;
        this.eduNom = eduNom;
    }

    public String getEduCod() {
        return eduCod;
    }

    public void setEduCod(String eduCod) {
        this.eduCod = eduCod;
    }

    public String getEduNom() {
        return eduNom;
    }

    public void setEduNom(String eduNom) {
        this.eduNom = eduNom;
    }    
}
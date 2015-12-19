package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EduNombre {

    String eduCod;
    String eduNom;

    public EduNombre() {
    }

    public EduNombre(String codigo, String nombre) {
        this.eduCod = codigo;
        this.eduNom = nombre;
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
    
    public void setEduNom(String descripcion) {
        this.eduNom = descripcion;
    }

}
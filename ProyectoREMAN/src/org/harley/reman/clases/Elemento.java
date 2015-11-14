package org.harley.reman.clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
    @XmlType(propOrder = {
        "eleNumero",
        "eleDescripcion"
    })
public class Elemento {
    int eleNumero;
    String eleDescripcion;

    public int getEleNumero() {
        return eleNumero;
    }
    
    @XmlElement
    public void setEleNumero(int eleNumero) {
        this.eleNumero = eleNumero;
    }

    public String getEleDescripcion() {
        return eleDescripcion;
    }
    
    @XmlElement
    public void setEleDescripcion(String eleDescripcion) {
        this.eleDescripcion = eleDescripcion;
    }

 
}
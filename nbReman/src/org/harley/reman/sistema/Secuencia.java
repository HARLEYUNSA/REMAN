package org.harley.reman.sistema;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Secuencia {
    int number;
    ArrayList<Paso> paso;

    public Secuencia() {
    }

    public Secuencia(int number, ArrayList<Paso> pasos) {
        this.number = number;
        this.paso = pasos;
    }

    public int getNumber() {
        return number;
    }
    
    @XmlAttribute(name = "number")
    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Paso> getPaso() {
        return paso;
    }
    
    @XmlElement
    public void setPaso(ArrayList<Paso> paso) {
        this.paso = paso;
    }
    
}

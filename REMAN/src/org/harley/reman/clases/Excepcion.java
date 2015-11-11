package org.harley.reman.clases;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Excepcion {
    List<Paso> pasos;

    public List<Paso> getPasos() {
        return pasos;
    }
    
    @XmlElement (name = "paso" )
    public void setPasos(List<Paso> pasos) {
        this.pasos = pasos;
    }
    
    public void add(Paso paso){
    if( this.pasos == null ){
        this.pasos = new ArrayList<>();
    }
        this.pasos.add(paso);
    }
}
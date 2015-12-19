package org.harley.reman.sistema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "libroEduccion")
@XmlType(propOrder = {
    "intro",
    "educciones"
})

public class LibroEduccion {

    Caratula intro;
    List<Educcion> educciones;
    
    public LibroEduccion() {
    }

    public Caratula getIntro() {
        return intro;
    }
    
    @XmlElement
    public void setIntro(Caratula intro) {
        this.intro = intro;
    }

    public List<Educcion> getEducciones() {
        return educciones;
    }
    
    @XmlElementWrapper(name = "educciones")
    @XmlElement(name = "educcion")
    public void setEducciones(List<Educcion> educciones) {
        this.educciones = educciones;
    }
    
    public boolean isEmpty(){
        return (this.educciones == null);
    }
    
    public void addEduccion(Educcion edu){
        if (isEmpty()){
           educciones = new ArrayList<>();
        }
        educciones.add(edu);
    }
   
    
}
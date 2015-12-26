package org.harley.reman.sistema;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "libroElicitacion")
@XmlType(propOrder = {
    "intro",
    "elicitaciones"
})

public class LibroElicitacion {
    Caratula intro;
    ArrayList<Elicitacion> elicitaciones;

    public LibroElicitacion() {
    }

    public Caratula getIntro() {
        return intro;
    }
    
    @XmlElement
    public void setIntro(Caratula intro) {
        this.intro = intro;
    }

    public ArrayList<Elicitacion> getElicitaciones() {
        return elicitaciones;
    }
    
    @XmlElementWrapper(name = "tablas")
    @XmlElement(name = "tabla")
    public void setElicitaciones(ArrayList<Elicitacion> elicitaciones) {
        this.elicitaciones = elicitaciones;
    }
    
    public boolean isEmpty(){
        return (this.elicitaciones == null);
    }
    
    public void addElicitacion(Elicitacion eli){
        if (isEmpty()){
           elicitaciones = new ArrayList<>();
        }
        elicitaciones.add(eli);
    }
}

package org.harley.reman.sistema;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "libroEspecificacion")
@XmlType(propOrder = {
    "intro", 
    "especificaciones"
})

public class LibroEspecificacion {
    Caratula intro;
    ArrayList<Especificacion> especificaciones;

    public LibroEspecificacion() {
    }

    public Caratula getIntro() {
        return intro;
    }

    public void setIntro(Caratula intro) {
        this.intro = intro;
    }

    public ArrayList<Especificacion> getEspecificaciones() {
        return especificaciones;
    }
    @XmlElementWrapper(name = "tablas")
    @XmlElement(name = "tabla")
    public void setEspecificaciones(ArrayList<Especificacion> especificaciones){
        this.especificaciones = especificaciones;
    }
    
    public boolean isEmpty(){
        return (this.especificaciones == null);
    }
    
    public void addEspecificacion(Especificacion esp){
        if (isEmpty()){
           especificaciones = new ArrayList<>();
        }
        especificaciones.add(esp);
    }
}
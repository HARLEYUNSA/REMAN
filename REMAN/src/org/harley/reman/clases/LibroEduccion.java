package org.harley.reman.clases;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "libroEduccion")
@XmlType(propOrder = {
    "titulo",
    "intro",
    "educciones"
})

public class LibroEduccion {

    String titulo;
    String intro;
    List<Educcion> educciones;

    public String getTitulo() {
        return titulo;
    }
    
    @XmlElement
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIntro() {
        return intro;
    }
    
    @XmlElement
    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<Educcion> getEducciones() {
        return educciones;
    }
    
    @XmlElement
    public void setEducciones(List<Educcion> educciones) {
        this.educciones = educciones;
    }
    
    public void addEduccion(Educcion edu){
        if( this.educciones == null ){
            this.educciones = new ArrayList<>();
        }
        this.educciones.add(edu);
    }

}


package org.harley.reman.clases;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement (name = "libroEsp" )
@XmlType(propOrder={
    "titulo", 
    "intro", 
    "especificaciones"
})

public class LibroEspecificacion {
    String titulo;
    String intro;
    List<Especificacion> especificaciones;
    
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
    
    public List<Especificacion> getEspecificaciones() {
        return especificaciones;
    }
    @XmlElementWrapper(name = "especificaciones")
    @XmlElement(name = "especificacion")
    public void setEspecificaciones(List<Especificacion> especificaciones) {
        this.especificaciones = especificaciones;
    }
    
    public void addEspecificacion(Especificacion esp){
        if( this.especificaciones == null ){
            this.especificaciones = new ArrayList<>();
        }
        this.especificaciones.add(esp);
    }
}

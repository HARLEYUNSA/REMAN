package org.harley.reman.clases;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "libroActores")
@XmlType(propOrder = {
    "titulo",
    "intro",
    "actores"
})

public class LibroActores {
    String titulo;
    String intro;
    List<Actor> actores;

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

    public List<Actor> getActores() {
        return actores;
    }
    @XmlElementWrapper(name = "actores")
    @XmlElement(name = "actor")
    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }
    
    public void addActor(Actor act){
        if( this.actores == null ){
            this.actores = new ArrayList<>();
        }
            this.actores.add(act);
    }
}

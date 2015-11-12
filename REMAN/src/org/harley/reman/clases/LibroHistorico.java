package org.harley.reman.clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "libroHistorico")
@XmlType(propOrder = {
    "titulo",
    "intro",
    "actores"
})

public class LibroHistorico {
    String titulo;
    String intro;
    String version;
    String fecha;
    String razon;
    String autor;

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

    public String getVersion() {
        return version;
    }
    
    @XmlElement
    public void setVersion(String version) {
        this.version = version;
    }

    public String getFecha() {
        return fecha;
    }
    
    @XmlElement
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRazon() {
        return razon;
    }
    
    @XmlElement
    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getAutor() {
        return autor;
    }
    
    @XmlElement
    public void setAutor(String autor) {
        this.autor = autor;
    }

    
}

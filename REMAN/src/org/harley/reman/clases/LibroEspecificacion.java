package org.harley.reman.clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement (name = "libroEsp" )
@XmlType(propOrder={"titulo", "intro", "esp"})
public class LibroEspecificacion {
    String titulo;
    String intro;
    Especificacion esp;
    
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

    public Especificacion getEsp() {
        return esp;
    }

    @XmlElement (name = "especificacionReq" )
    public void setEsp(Especificacion esp) {
        this.esp = esp;
    }
    
}

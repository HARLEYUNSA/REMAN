package org.harley.reman.clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Nombre {

    String codigo;
    String nombre;

    public String getCodigo() {
        return codigo;
    }
    
    @XmlElement
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
    @XmlElement
    public void setNombre(String descripcion) {
        this.nombre = descripcion;
    }

}
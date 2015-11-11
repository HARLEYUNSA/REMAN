package org.harley.reman.clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "nombre",
    "org",
    "cargo",
    "tipo",
    "correo",
    "comentarios"
})

public class Actor {
        String nombre;
        String org;
        String cargo;
        String tipo;
        String correo;
        String comentarios;

    public String getNombre() {
        return nombre;
    }
    
    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrg() {
        return org;
    }
    
    @XmlElement
    public void setOrg(String org) {
        this.org = org;
    }

    public String getCargo() {
        return cargo;
    }
    
    @XmlElement
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipo() {
        return tipo;
    }
    
    @XmlElement
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCorreo() {
        return correo;
    }
    
    @XmlElement
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getComentarios() {
        return comentarios;
    }
    
    @XmlElement
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    

}
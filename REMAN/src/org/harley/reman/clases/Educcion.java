package org.harley.reman.clases;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

    @XmlType(propOrder = {
        "educcionNombre",
        "version",
        "actor",
        "cargo",
        "especialista",
        "especialEspecial",
        "especialTipo",
        "especialExp",
        "educcionTipo",
        "educcionObj",
        "educcionFecha",
        "descripcion",
        "observaciones"
    })
public class Educcion {
        Nombre educcionNombre;
        Version version;
        String actor;
        String cargo;
        String especialista;
        String especialEspecial;
        String especialTipo;
        String especialExp;
        String educcionTipo;
        String educcionObj;
        String educcionFecha;
        String descripcion;
        String observaciones;

    public Nombre getEduccionNombre() {
        return educcionNombre;
    }
    
    @XmlElement
    public void setEduccionNombre(Nombre educcionNombre) {
        this.educcionNombre = educcionNombre;
    }

    public Version getVersion() {
        return version;
    }
    
    @XmlElement
    public void setVersion(Version version) {
        this.version = version;
    }

    public String getActor() {
        return actor;
    }
    
    @XmlElement
    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getCargo() {
        return cargo;
    }
    
    @XmlElement
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecialista() {
        return especialista;
    }
    
    @XmlElement
    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    public String getEspecialEspecial() {
        return especialEspecial;
    }
    
    @XmlElement
    public void setEspecialEspecial(String especialEspecial) {
        this.especialEspecial = especialEspecial;
    }

    public String getEspecialTipo() {
        return especialTipo;
    }
    
    @XmlElement
    public void setEspecialTipo(String especialTipo) {
        this.especialTipo = especialTipo;
    }

    public String getEspecialExp() {
        return especialExp;
    }
    
    @XmlElement
    public void setEspecialExp(String especialExp) {
        this.especialExp = especialExp;
    }

    public String getEduccionTipo() {
        return educcionTipo;
    }
    
    @XmlElement
    public void setEduccionTipo(String educcionTipo) {
        this.educcionTipo = educcionTipo;
    }

    public String getEduccionObj() {
        return educcionObj;
    }
    
    @XmlElement
    public void setEduccionObj(String educcionObj) {
        this.educcionObj = educcionObj;
    }

    public String getEduccionFecha() {
        return educcionFecha;
    }
    
    @XmlElement
    public void setEduccionFecha(String educcionFecha) {
        this.educcionFecha = educcionFecha;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @XmlElement
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }
    
    @XmlElement
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}

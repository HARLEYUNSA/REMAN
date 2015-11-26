package org.harley.reman.clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

    @XmlRootElement
    @XmlType(propOrder = {
        "educcionNombre",
        "version",
        "fuenteNombre",
        "fuenteCargo",
        "fuenteTipo",
        "especialNombre",
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
        private static int numero = 0;
        Nombre educcionNombre;
        String version;
        String fuenteNombre;
        String fuenteCargo;
        String fuenteTipo;
        String especialNombre;
        String especialEspecial;
        String especialTipo;
        String especialExp;
        String educcionTipo;
        String educcionObj;
        String educcionFecha;
        String descripcion;
        String observaciones;

    public Educcion() {    }
    
    public Educcion(String cod, String name) { 
        educcionNombre = new Nombre(cod, name);
    }
    
    public Educcion(String name, String version, String fuenteNombre, String fuenteCargo, String fuenteTipo, String especialNombre, String especialEspecial, String especialTipo, String especialExp, String educcionTipo, String educcionObj, String educcionFecha, String descripcion, String observaciones) {
        numero++;
        educcionNombre = new Nombre("edu000"+numero, name);
        this.version = version;
        this.fuenteNombre = fuenteNombre;
        this.fuenteCargo = fuenteCargo;
        this.fuenteTipo = fuenteTipo;
        this.especialNombre = especialNombre;
        this.especialEspecial = especialEspecial;
        this.especialTipo = especialTipo;
        this.especialExp = especialExp;
        this.educcionTipo = educcionTipo;
        this.educcionObj = educcionObj;
        this.educcionFecha = educcionFecha;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
    }

    public Nombre getEduccionNombre() {
        return educcionNombre;
    }
    
    @XmlElement
    public void setEduccionNombre(Nombre educcionNombre) {
        this.educcionNombre = educcionNombre;
    }

    public String getVersion() {
        return version;
    }
    
    @XmlElement
    public void setVersion(String version) {
        this.version = version;
    }

    public String getFuenteNombre() {
        return fuenteNombre;
    }
    
    @XmlElement
    public void setFuenteNombre(String fuenteNombre) {
        this.fuenteNombre = fuenteNombre;
    }

    public String getFuenteCargo() {
        return fuenteCargo;
    }
    
    @XmlElement
    public void setFuenteCargo(String fuenteCargo) {
        this.fuenteCargo = fuenteCargo;
    }

    public String getFuenteTipo() {
        return fuenteTipo;
    }
    
    @XmlElement
    public void setFuenteTipo(String fuenteTipo) {
        this.fuenteTipo = fuenteTipo;
    }

    public String getEspecialNombre() {
        return especialNombre;
    }
    
    @XmlElement
    public void setEspecialNombre(String especialNombre) {
        this.especialNombre = especialNombre;
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

package org.harley.reman.sistema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "especificacionNombre", 
    "eliNumero", 
    "version", 
    "autor", 
    "fuente", 
    "dependencias",
    "descripcion", 
    "precondicion", 
    "postcondicion", 
    "excepciones",
    "comentarios" 
})

public class Especificacion {
        EduNombre especificacionNombre;
	String eliNumero;
        String espFecha;
        String version;
        String fuenteNombre;
        String fuenteCargo;
        String fuenteTipo;
        String especialistaNombre;
        String especialistaExp;
        String especialistaCargo;
        String dependencias;
        String descripcion;
        List<String> precondiciones;
        List<String> postcondiciones;
        List<Elemento> excepciones; 
        String observaciones;

    public EduNombre getEspecificacionNombre() {
        return especificacionNombre;
    }

    public void setEspecificacionNombre(EduNombre especificacionNombre) {
        this.especificacionNombre = especificacionNombre;
    }

    public String getEliNumero() {
        return eliNumero;
    }

    public void setEliNumero(String eliNumero) {
        this.eliNumero = eliNumero;
    }

    public String getEspFecha() {
        return espFecha;
    }

    public void setEspFecha(String espFecha) {
        this.espFecha = espFecha;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFuenteNombre() {
        return fuenteNombre;
    }

    public void setFuenteNombre(String fuenteNombre) {
        this.fuenteNombre = fuenteNombre;
    }

    public String getFuenteCargo() {
        return fuenteCargo;
    }

    public void setFuenteCargo(String fuenteCargo) {
        this.fuenteCargo = fuenteCargo;
    }

    public String getFuenteTipo() {
        return fuenteTipo;
    }

    public void setFuenteTipo(String fuenteTipo) {
        this.fuenteTipo = fuenteTipo;
    }

    public String getEspecialistaNombre() {
        return especialistaNombre;
    }

    public void setEspecialistaNombre(String especialistaNombre) {
        this.especialistaNombre = especialistaNombre;
    }

    public String getEspecialistaExp() {
        return especialistaExp;
    }

    public void setEspecialistaExp(String especialistaExp) {
        this.especialistaExp = especialistaExp;
    }

    public String getEspecialistaCargo() {
        return especialistaCargo;
    }

    public void setEspecialistaCargo(String especialistaCargo) {
        this.especialistaCargo = especialistaCargo;
    }

    public String getDependencias() {
        return dependencias;
    }

    public void setDependencias(String dependencias) {
        this.dependencias = dependencias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getPrecondiciones() {
        return precondiciones;
    }
    
    @XmlElementWrapper(name = "precondiciones")
    @XmlElement(name = "precondicion")
    public void setPrecondiciones(List<String> precondiciones) {
        this.precondiciones = precondiciones;
    }

    public void addPrecondicion(String pre){
        if (this.precondiciones == null ){
            this.precondiciones = new ArrayList<>();
        }
        this.precondiciones.add(pre);
    }
    
    public List<String> getPostcondiciones() {
        return postcondiciones;
    }
    
    @XmlElementWrapper(name = "postcondiciones")
    @XmlElement(name = "postcondicion")
    public void setPostcondiciones(List<String> postcondiciones) {
        this.postcondiciones = postcondiciones;
    }

    public void addPostcondicion(String post){
        if (this.postcondiciones == null ){
            this.postcondiciones = new ArrayList<>();
        }
        this.postcondiciones.add(post);
    }

    public List<Elemento> getExcepciones() {
        return excepciones;
    }
    
    @XmlElementWrapper(name = "excepciones")
    @XmlElement(name = "excepcion")
    public void setExcepciones(List<Elemento> excepciones) {
        this.excepciones = excepciones;
    }
    
    public void addExcepcion(Elemento exc){
        if (this.excepciones == null ){
            this.excepciones = new ArrayList<>();
        }
        this.excepciones.add(exc);
    }
    
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
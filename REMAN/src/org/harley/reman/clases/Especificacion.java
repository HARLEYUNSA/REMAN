package org.harley.reman.clases;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"requisito", "eliNombre", "version", "autor", "fuente", "dependencias",
                    "descripcion", "precondicion", "postcondicion", "excepciones", "comentarios" })
public class Especificacion {
        Nombre requisito;
	String eliNombre;
        Version version;
        String autor;
        String fuente;
        String dependencias;
        String descripcion;
        List<String> precondicion;
        List<String> postcondicion;
        List<Excepcion> excepciones; 
        String comentarios;

    public Nombre getRequisito() {
        return requisito;     
    }

    @XmlElement
    public void setRequisito(Nombre requisito) {
        this.requisito = requisito;
    }

    public String getEliNombre() {
        return eliNombre;
    }
    
    @XmlElement
    public void setEliNombre(String eliNombre) {
        this.eliNombre = eliNombre;
    }

    public Version getVersion() {
        return version;
    }
    
    @XmlElement
    public void setVersion(Version version) {
        this.version = version;
    }

    public String getAutor() {
        return autor;
    }

    @XmlElement
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFuente() {
        return fuente;
    }

    @XmlElement
    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getDependencias() {
        return dependencias;
    }

    @XmlElement
    public void setDependencias(String dependencias) {
        this.dependencias = dependencias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @XmlElement
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getPrecondicion() {
        return precondicion;
    }

    @XmlElementWrapper(name = "precondiciones")
    @XmlElement(name = "precondicion")
    public void setPrecondicion(List<String> precondicion) {
        this.precondicion = precondicion;
    }

    public List<String> getPostcondicion() {
        return postcondicion;
    }

    public void addPrecondicion(String pre){
    if( this.precondicion == null ){
        this.precondicion = new ArrayList<>();
    }
        this.precondicion.add(pre);
    }
    
    @XmlElementWrapper(name = "postcondiciones")
    @XmlElement(name = "postcondicion")
    public void setPostcondicion(List<String> postcondicion) {
        this.postcondicion = postcondicion;
    }

    public List<Excepcion> getExcepciones() {
        return excepciones;
    }
    
    public void addPostcondicion(String post){
    if( this.postcondicion == null ){
        this.postcondicion = new ArrayList<>();
    }
        this.postcondicion.add(post);
    }

    @XmlElementWrapper(name = "excepciones")
    @XmlElement(name = "excepcion")
    public void setExcepciones(List<Excepcion> excepciones) {
        this.excepciones = excepciones;
    }
    
    public void addExcepcion(Excepcion exc){
    if( this.excepciones == null ){
        this.excepciones = new ArrayList<>();
    }
        this.excepciones.add(exc);
    }

    public String getComentarios() {
        return comentarios;
    }

    @XmlElement
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
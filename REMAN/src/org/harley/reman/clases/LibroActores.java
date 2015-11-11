
package org.harley.reman.clases;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "titulo",
    "intro",
    "actores"
})
@XmlRootElement(name = "libroActores")
public class LibroActores {

    @XmlElement(required = true)
    protected String titulo;
    @XmlElement(required = true)
    protected String intro;
    @XmlElement(required = true)
    protected LibroActores.Actores actores;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String value) {
        this.titulo = value;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String value) {
        this.intro = value;
    }

    public LibroActores.Actores getActores() {
        return actores;
    }

    public void setActores(LibroActores.Actores value) {
        this.actores = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "actor",
        "org",
        "cargo",
        "tipo",
        "correo",
        "comentarios"
    })
    public static class Actores {

        @XmlElement(required = true)
        protected String actor;
        @XmlElement(required = true)
        protected String org;
        @XmlElement(required = true)
        protected String cargo;
        @XmlElement(required = true)
        protected String tipo;
        @XmlElement(required = true)
        protected String correo;
        @XmlElement(required = true)
        protected String comentarios;

        public String getActor() {
            return actor;
        }

        public void setActor(String value) {
            this.actor = value;
        }

        public String getOrg() {
            return org;
        }

        public void setOrg(String value) {
            this.org = value;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String value) {
            this.cargo = value;
        }

        public String getTipo() {
            return tipo;
        }

        
        public void setTipo(String value) {
            this.tipo = value;
        }

        
        public String getCorreo() {
            return correo;
        }

        
        public void setCorreo(String value) {
            this.correo = value;
        }

        public String getComentarios() {
            return comentarios;
        }


        public void setComentarios(String value) {
            this.comentarios = value;
        }

    }

}

package org.harley.reman.clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "version",
    "fecha",
    "razon",
    "autor"
})
public class Historico {

    String version;
    String fecha;
    String razon;
    String autor;

    public Historico() {
    }

    public Historico(Version version, String fecha, String razon, String autor) {
        this.version = version.getvMax() + "." + version.vMin;
        this.fecha = fecha;
        this.razon = razon;
        this.autor = autor;
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

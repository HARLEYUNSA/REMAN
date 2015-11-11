package org.harley.reman.clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Nombre {

    String espNombre;
    String espDes;
    
    public String getEspNombre() {
        return espNombre;
    }
	
    @XmlElement
    public void setEspNombre(String espNombre) {
        this.espNombre = espNombre;
    }
	
    public String getEspDes() {
        return espDes;
    }
    
    @XmlElement
    public void setEspDes(String espDes) {
        this.espDes = espDes;
    }
}
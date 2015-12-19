package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
    @XmlType(propOrder = {
        "pasNum",
        "pasDes"
    })

public class Paso {
    String pasNum;
    String pasDes;

    public Paso() {
    }

    public Paso(String pasNum, String pasDes) {
        this.pasNum = pasNum;
        this.pasDes = pasDes;
    }
    
    public String getPasNum() {
        return pasNum;
    }
    
    @XmlElement
    public void setPasNum(String pasNum) {
        this.pasNum = pasNum;
    }

    public String getPasDes() {
        return pasDes;
    }
    
    @XmlElement
    public void setPasDes(String pasDes) {
        this.pasDes = pasDes;
    }

 
}
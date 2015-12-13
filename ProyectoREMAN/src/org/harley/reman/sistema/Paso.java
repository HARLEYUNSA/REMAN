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
    int pasNum;
    String pasDes;

    public int getPasNum() {
        return pasNum;
    }
    
    @XmlElement
    public void setPasNum(int pasNum) {
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
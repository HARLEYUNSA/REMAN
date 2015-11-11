package org.harley.reman.clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Paso {
    int pasoNum;
    String pasoDes;

    public int getPasoNum() {
        return pasoNum;
    }

    @XmlElement
    public void setPasoNum(int pasoNum) {
        this.pasoNum = pasoNum;
    }

    public String getPasoDes() {
        return pasoDes;
    }

    @XmlElement
    public void setPasoDes(String pasoDes) {
        this.pasoDes = pasoDes;
    }
}

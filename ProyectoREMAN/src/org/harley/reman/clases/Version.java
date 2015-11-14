package org.harley.reman.clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "Customers" )
public class Version {
    int vMax;
    int vMin;

    public int getvMax() {
        return vMax;
    }

    @XmlElement
    public void setvMax(int vMax) {
        this.vMax = vMax;
    }

    public int getvMin() {
        return vMin;
    }
    
    @XmlElement
    public void setvMin(int vMin) {
        this.vMin = vMin;
    }
}


package org.harley.reman.sistema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Teo
 */

@XmlRootElement(name = "libroStakeHolder")
@XmlType(propOrder = {
    "intro",
    "sths"
})
public class LibroStakeholder {
    String intro;
    List<Stakeholder> sths;

    public LibroStakeholder() {
    }
    
    public LibroStakeholder(String intro, List<Stakeholder> sths) {
        this.intro = intro;
        this.sths = sths;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<Stakeholder> getSths() {
        return sths;
    }

    @XmlElementWrapper(name = "Stakeholders")
    @XmlElement(name = "Stakeholder")
    public void setstakehs(List<Stakeholder> sths) {
        this.sths = sths;
    }
    
    void addStakeh(Stakeholder sth) {
        if( this.sths == null ){
            this.sths = new ArrayList<>();
        }
        this.sths.add(sth);    
    }

    public Stakeholder getStakeh(String sthCod){
        for (Stakeholder sth : sths) {
            if (sth.getSthNom().getSthCod().equals(sthCod)) {
                return sth;
            }
        }
       return null;
    }
}

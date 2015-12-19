
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
@XmlRootElement(name = "libroProyectTeam")
@XmlType(propOrder = {
    "intro",
    "Pyts"
})
public class LibroProyectTeam {
    
    Caratula intro;
    List<ProyectTeam> pyts;

    public LibroProyectTeam() {
    }
    
    public LibroProyectTeam(Caratula intro, List<ProyectTeam> pyts) {
        this.intro = intro;
        this.pyts = pyts;
    }

    public Caratula getIntro() {
        return intro;
    }

    public void setIntro(Caratula intro) {
        this.intro = intro;
    }

    public List<ProyectTeam> getPyts() {
        return pyts;
    }

    @XmlElementWrapper(name = "ProyectTeams")
    @XmlElement(name = "ProyectTeam")
    public void setPyts(List<ProyectTeam> pyts) {
        this.pyts = pyts;
    }
    
    void addPyt(ProyectTeam pyt) {
        if( this.pyts == null ){
            this.pyts = new ArrayList<>();
        }
        this.pyts.add(pyt);    
    }

    public ProyectTeam getPyt(String pytCod){
        for (ProyectTeam pyt : pyts) {
            if (pyt.getTeamNombre().getPytCod().equals(pytCod)) {
                return pyt;
            }
        }
       return null;
    }
    
}

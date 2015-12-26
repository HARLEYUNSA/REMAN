package org.harley.reman.sistema;

import java.util.ArrayList;
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
    
    String intro;
    ArrayList<ProyectTeam> pyts;

    public LibroProyectTeam() {
    }
    
    public LibroProyectTeam(String intro, ArrayList<ProyectTeam> pyts) {
        this.intro = intro;
        this.pyts = pyts;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public ArrayList<ProyectTeam> getPyts() {
        return pyts;
    }

    @XmlElementWrapper(name = "tabla")
    @XmlElement(name = "tabla")
    public void setPyts(ArrayList<ProyectTeam> pyts) {
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
            if (pyt.getPytNombre().getCodigo().equals(pytCod)) {
                return pyt;
            }
        }
       return null;
    }
    
}

package org.harley.reman.sistema;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "libroEspecificacion")
@XmlType(propOrder = {
    "intro", 
    "requisitosNF"
})
class LibroRequisitoNF {
    Caratula intro;
    ArrayList<RequisitoNF> requisitosNF;

    public LibroRequisitoNF() {
    }

    public Caratula getIntro() {
        return intro;
    }

    public void setIntro(Caratula intro) {
        this.intro = intro;
    }

    public ArrayList<RequisitoNF> getRequisitosNF() {
        return requisitosNF;
    }
    @XmlElementWrapper(name = "tablas")
    @XmlElement(name = "tabla")
    public void setRequisitosNF(ArrayList<RequisitoNF> reqnofuncionales) {
        this.requisitosNF = reqnofuncionales;
    }
    
    public boolean isEmpty(){
        return (this.requisitosNF == null);
    }
    
    public void addReqNoFuncional(RequisitoNF rnf){
        if (isEmpty()){
           requisitosNF = new ArrayList<>();
        }
        requisitosNF.add(rnf);
    }
}


package org.harley.reman.sistema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "libroEspecificacion")
@XmlType(propOrder = {
    "intro", 
    "reqnofuncionales"
})
class LibroRequisitoNF {

    Caratula intro;
    List<ReqNoFuncional> reqnofuncionales;

    public LibroRequisitoNF() {
    }

    public Caratula getIntro() {
        return intro;
    }

    public void setIntro(Caratula intro) {
        this.intro = intro;
    }

    public List<ReqNoFuncional> getReqNoFuncional() {
        return reqnofuncionales;
    }
    @XmlElementWrapper(name = "reqnofuncionale")
    @XmlElement(name = "reqnofuncionales")
    public void setReqNoFuncionales(List<ReqNoFuncional> reqnofuncionales) {
        this.reqnofuncionales = reqnofuncionales;
    }
    
    public boolean isEmpty(){
        return (this.reqnofuncionales == null);
    }
    
    public void addReqNoFuncional(ReqNoFuncional rnf){
        if (isEmpty()){
           reqnofuncionales = new ArrayList<>();
        }
        reqnofuncionales.add(rnf);
    }
    
}

package org.harley.reman.sistema;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "reqnofuncionales")
@XmlType(propOrder = {
    "actual",
    "historicos",
    "versiones"
})

public class ReqNoFuncionales {
    ReqNoFuncional actual;
    List<ReqNoFuncional> versiones;
    List<Historico> historicos;

    public ReqNoFuncionales() {
        this.versiones = new ArrayList<>();
        this.historicos = new ArrayList<>();
    }

    public ReqNoFuncional getActual() {
        return actual;
    }

    public void setActual(ReqNoFuncional actual) {
        this.actual = actual;
    }
    
    public List<ReqNoFuncional> getVersiones() {
        return versiones;
    }
    
@XmlElementWrapper(name = "versiones")
@XmlElement(name = "version")
    public void setVersiones(List<ReqNoFuncional> versiones) {
        this.versiones = versiones;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }
    
@XmlElementWrapper(name = "historicos")
@XmlElement(name = "historico")
    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }
    
    public boolean isEmpty(){
        return (this.historicos == null);
    }
    
    public void newRnf(ReqNoFuncional rnf){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String nomRnf = rnf.getRnfNombre().getRnfNom();    
        addHistorico(rnf, dateFormat.format(cal.getTime()), 
                   "Creación de la ReqNoFuncional " + nomRnf, "Gonzalo");
        addReqNoFuncional(rnf);
        actual = rnf;
    }
    
    public void modRnf(ReqNoFuncional rnf){
        actual = rnf;
    }
    
    public void verRnf(String verVer, String verFec, String verRnf, 
            String verRazCam){
        actual.setRnfVer(verVer);
        addHistorico(actual, verFec, verRnf, verRazCam);
        addReqNoFuncional(actual);
    }
    
    public void addHistorico(ReqNoFuncional rnf, String fecha, String actor, String razon){
        Historico hist = new Historico(rnf.getRnfVer(), fecha, razon, actor);
        historicos.add(hist);
    }
    
    public void addReqNoFuncional(ReqNoFuncional rnf){	
        versiones.add(rnf);
    }
    
    public ReqNoFuncional getVer(String ver){
       for (int i = 0; i < versiones.size(); i++){
           if(versiones.get(i).getRnfVer().equals(ver))
               return versiones.get(i);
       }
       return null;
    }
    
    public ReqNoFuncional getLast(){
       ReqNoFuncional last = versiones.get(versiones.size()-1);
       return last;
    }
}

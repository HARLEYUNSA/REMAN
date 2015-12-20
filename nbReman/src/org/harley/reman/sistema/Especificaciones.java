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

@XmlRootElement(name = "especificaciones")
@XmlType(propOrder = {
    "actual",
    "historicos",
    "versiones"
})

public class Especificaciones {
    Especificacion actual;
    List<Especificacion> versiones;
    List<Historico> historicos;

    public Especificaciones() {
        this.versiones = new ArrayList<>();
        this.historicos = new ArrayList<>();
    }

    public Especificacion getActual() {
        return actual;
    }

    public void setActual(Especificacion actual) {
        this.actual = actual;
    }
    
    public List<Especificacion> getVersiones() {
        return versiones;
    }
    
@XmlElementWrapper(name = "versiones")
@XmlElement(name = "version")
    public void setVersiones(List<Especificacion> versiones) {
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
    
    public void newEsp(Especificacion esp){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String nomEsp = esp.getEspNombre().getEspNom();    
        addHistorico(esp, dateFormat.format(cal.getTime()), 
                   "Creación de la Especificacion " + nomEsp, "Gonzalo");
        addEspecificacion(esp);
        actual = esp;
    }
    
    public void modEsp(Especificacion esp){
        actual = esp;
    }
    
    public void verEsp(String verVer, String verFec, String verEsp, 
            String verRazCam){
        actual.setEspVer(verVer);
        addHistorico(actual, verFec, verEsp, verRazCam);
        addEspecificacion(actual);
    }
    
    public void addHistorico(Especificacion esp, String fecha, String actor, String razon){
        Historico hist = new Historico(esp.getEspVer(), fecha, razon, actor);
        historicos.add(hist);
    }
    
    public void addEspecificacion(Especificacion esp){	
        versiones.add(esp);
    }
    
    public Especificacion getVer(String ver){
       for (int i = 0; i < versiones.size(); i++){
           if(versiones.get(i).getEspVer().equals(ver))
               return versiones.get(i);
       }
       return null;
    }
    
    public Especificacion getLast(){
       Especificacion last = versiones.get(versiones.size()-1);
       return last;
    }

    void modRnf(ReqNoFuncional rnf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

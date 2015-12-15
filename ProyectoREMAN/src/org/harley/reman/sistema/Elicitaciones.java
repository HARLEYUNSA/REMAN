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

@XmlRootElement(name = "elicitaciones")
@XmlType(propOrder = {
    "actual",
    "historicos",
    "versiones"
})

public class Elicitaciones {
    Elicitacion actual;
    List<Elicitacion> versiones;
    List<Historico> historicos;

    public Elicitaciones() {
        this.versiones = new ArrayList<>();
        this.historicos = new ArrayList<>();
    }

    public Elicitacion getActual() {
        return actual;
    }

    public void setActual(Elicitacion actual) {
        this.actual = actual;
    }
    
    public List<Elicitacion> getVersiones() {
        return versiones;
    }
    
@XmlElementWrapper(name = "versiones")
@XmlElement(name = "version")
    public void setVersiones(List<Elicitacion> versiones) {
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
    
    public void newEli(Elicitacion eli){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String nomEli = eli.getEliNom().getEliNom();    
        addHistorico(eli, dateFormat.format(cal.getTime()), 
                   "Creación de la Elicitacion " + nomEli, "Gonzalo");
        addElicitacion(eli);
        actual = eli;
    }
    
    public void modEli(Elicitacion eli){
        actual = eli;
    }
    
    public void verEli(String verVer, String verFec, String verEsp, 
            String verRazCam){
        actual.setEliVer(verVer);
        addHistorico(actual, verFec, verEsp, verRazCam);
        addElicitacion(actual);
    }
    
    public void addHistorico(Elicitacion eli, String fecha, String actor, String razon){
        Historico hist = new Historico(eli.getEliVer(), fecha, razon, actor);
        historicos.add(hist);
    }
    
    public void addElicitacion(Elicitacion eli){	
        versiones.add(eli);
    }
    
    public Elicitacion getVer(String ver){
       for (int i = 0; i < versiones.size(); i++){
           if(versiones.get(i).getEliVer().equals(ver))
               return versiones.get(i);
       }
       return null;
    }
    
    public Elicitacion getLast(){
       Elicitacion last = versiones.get(versiones.size()-1);
       return last;
    }
}

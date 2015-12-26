package org.harley.reman.sistema;

import java.util.ArrayList;
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
    ArrayList<Historico> historicos;
    ArrayList<Elicitacion> versiones;
    
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
    
    public ArrayList<Elicitacion> getVersiones() {
        return versiones;
    }
    
    @XmlElementWrapper(name = "versiones")
    @XmlElement(name = "version")
    public void setVersiones(ArrayList<Elicitacion> versiones) {
        this.versiones = versiones;
    }

    public ArrayList<Historico> getHistoricos() {
        return historicos;
    }
    
    @XmlElementWrapper(name = "historicos")
    @XmlElement(name = "historico")
    public void setHistoricos(ArrayList<Historico> historicos) {
        this.historicos = historicos;
    }
    
    public boolean isEmpty(){
        return (this.historicos == null);
    }
    
    public void newEli(Elicitacion eli){
        String nomEli = eli.eliNombre.getNombre();    
        addHistorico(eli, eli.eliFec, 
                   "Creación de la Elicitación " + nomEli, eli.eliEspNom);
        addElicitacion(eli);
        actual = eli;
    }
    
    public void modEli(Elicitacion eli){
        actual = eli;
    }
    
    public void verEli(String verVer, String verFec, String verRazCam, 
            String verEsp){
        actual.setEliVer(verVer);
        addHistorico(actual, verFec, verRazCam, verEsp);
        addElicitacion(actual);
    }
    
    public void addHistorico(Elicitacion eli, String fecha, String razon, 
            String actor){
        Historico hist = new Historico(eli.getEliVer(), fecha, razon, actor);
        historicos.add(hist);
    }
    
    public void addElicitacion(Elicitacion eli){	
        versiones.add(eli);
    }
    
    public Elicitacion getVer(String ver){
        for (Elicitacion version : versiones) {
            if (version.getEliVer().equals(ver)) {
                return version;
            }
        }
       return null;
    }
    
    public Elicitacion getLast(){
       Elicitacion last = versiones.get(versiones.size()-1);
       return last;
    }
}
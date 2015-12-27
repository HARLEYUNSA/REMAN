package org.harley.reman.sistema;

import java.util.ArrayList;
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
    ArrayList<Especificacion> versiones;
    ArrayList<Historico> historicos;

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
    
    public ArrayList<Especificacion> getVersiones() {
        return versiones;
    }
    
    @XmlElementWrapper(name = "versiones")
    @XmlElement(name = "version")
    public void setVersiones(ArrayList<Especificacion> versiones) {
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
    
    public void newEsp(Especificacion esp){
        String nomEsp = esp.espNombre.getNombre();   
        addHistorico(esp, esp.espFec,
                "Creación de la Especificacion " + nomEsp, esp.espEspNom);
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
    
    public void addHistorico(Especificacion esp, String fecha, String actor, 
            String razon){
        Historico hist = new Historico(esp.getEspVer(), fecha, razon, actor);
        historicos.add(hist);
    }
    
    public void addEspecificacion(Especificacion esp){	
        versiones.add(esp);
    }
    
    public Especificacion getVer(String ver){
        for (Especificacion version : versiones) {
            if (version.getEspVer().equals(ver)) {
                return version;
            }
        }
       return null;
    }
    
    public Especificacion getLast(){
       Especificacion last = versiones.get(versiones.size()-1);
       return last;
    }

    public ArrayList<ArrayList<String>> getHist(){
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        ArrayList<String> version = new ArrayList<>();
        ArrayList<String> fecha = new ArrayList<>();
        ArrayList<String> razon = new ArrayList<>();
        ArrayList<String> autor = new ArrayList<>();
        for(Historico h : historicos){
            version.add(h.getVersion());
            fecha.add(h.getFecha());
            razon.add(h.getRazon());
            autor.add(h.getAutor());            
        }
        datos.add(version);
        datos.add(fecha);
        datos.add(razon);
        datos.add(autor);
        return datos;
    } 
}
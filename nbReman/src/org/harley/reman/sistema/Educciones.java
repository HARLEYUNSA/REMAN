package org.harley.reman.sistema;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "educciones")
@XmlType(propOrder = {
    "actual",
    "historicos",
    "versiones"
})
public class Educciones {
    Educcion actual;
    ArrayList<Educcion> versiones;
    ArrayList<Historico> historicos;

    public Educciones() {
        this.versiones = new ArrayList<>();
        this.historicos = new ArrayList<>();
    }

    public Educcion getActual() {
        return actual;
    }

    public void setActual(Educcion actual) {
        this.actual = actual;
    }
    
    public ArrayList<Educcion> getVersiones() {
        return versiones;
    }
    
    @XmlElementWrapper(name = "versiones")
    @XmlElement(name = "version")
    public void setVersiones(ArrayList<Educcion> versiones) {
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
    
    public void newEdu(Educcion edu){
        String nomEdu = edu.eduNombre.getNombre();    
        addHistorico(edu, edu.eduFec, 
                   "Creación de la Educción " + nomEdu, edu.eduEspNom);
        addEduccion(edu);
        actual = edu;
    }
    
    public void modEdu(Educcion edu){
        actual = edu;
    }
    
    public void verEdu(String verVer, String verFec, String verRazCam, 
            String verEsp){
        actual.setEduVer(verVer);
        addHistorico(actual, verFec, verRazCam, verEsp);
        addEduccion(actual);
    }
    
    public void addHistorico(Educcion edu, String fecha, String razon, 
            String actor){
        Historico hist = new Historico(edu.getEduVer(), fecha, razon, actor);
        historicos.add(hist);
    }
    
    public void addEduccion(Educcion edu){	
        versiones.add(edu);
    }
    
    public Educcion getVer(String ver){
        for (Educcion version : versiones) {
            if (version.eduVer.equals(ver)) {
                return version;
            }
        }
        return null;
    }
    
    public Educcion getLast(){
       Educcion last = versiones.get(versiones.size()-1);
       return last;
    }
    
    
}

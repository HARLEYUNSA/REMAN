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

/**
 *
 * @author Gonzalo
 */
@XmlRootElement(name = "educciones")
@XmlType(propOrder = {
    "actual",
    "historicos",
    "versiones"
})

public class Educciones {
    Educcion actual;
    List<Educcion> versiones;
    List<Historico> historicos;

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
    
    public List<Educcion> getVersiones() {
        return versiones;
    }
    
@XmlElementWrapper(name = "versiones")
@XmlElement(name = "version")
    public void setVersiones(List<Educcion> versiones) {
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
    
    public void newEdu(Educcion edu){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String nomEdu = edu.getEduNom().getEduNom();    
        addHistorico(edu, dateFormat.format(cal.getTime()), 
                   "Creación de la Educcion " + nomEdu, "Gonzalo");
        addEduccion(edu);
        actual = edu;
    }
    
    public void modEdu(Educcion edu){
        actual = edu;
    }
    
    public void verEdu(String verVer, String verFec, String verEsp, 
            String verRazCam){
        actual.setEduVer(verVer);
        addHistorico(actual, verFec, verEsp, verRazCam);
        addEduccion(actual);
    }
    
    public void addHistorico(Educcion edu, String fecha, String actor, String razon){
        Historico hist = new Historico(edu.getEduVer(), fecha, razon, actor);
        historicos.add(hist);
    }
    
    public void addEduccion(Educcion edu){	
        versiones.add(edu);
    }
    
    public Educcion getVer(String ver){
       for (int i = 0; i < versiones.size(); i++){
           if(versiones.get(i).getEduVer().equals(ver))
               return versiones.get(i);
       }
       return null;
    }
    
    public Educcion getLast(){
       Educcion last = versiones.get(versiones.size()-1);
       return last;
    }
}

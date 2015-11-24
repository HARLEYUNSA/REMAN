package org.harley.reman.clases;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.harley.reman.conversion.FileManager;

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
    }

    public Educciones(File directory) {
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
        String nomEdu = edu.getEduccionNombre().getNombre();    
        addHistorico(edu, dateFormat.format(cal.getTime()), 
                   "Creación de la Educcion " + nomEdu);
        addEduccion(edu);
        actual = edu;
    }
    
    public void modEdu(Educcion edu){
        actual = edu;
    }
    
    public void verEdu(String ver, String razon){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        actual.setVersion(ver);
        addHistorico(actual, dateFormat.format(cal.getTime()), razon);
        addEduccion(actual);
    }
    
    public void addHistorico(Educcion edu, String fecha, String razon){
        Historico hist = new Historico(edu.getVersion(), fecha, razon, edu.getFuenteNombre());
        historicos.add(hist);
    }
    
    public void addEduccion(Educcion edu){	
        versiones.add(edu);
    }
    
    public Educcion getLast(){
       Educcion last = versiones.get(versiones.size()-1);
       return last;
    }
}

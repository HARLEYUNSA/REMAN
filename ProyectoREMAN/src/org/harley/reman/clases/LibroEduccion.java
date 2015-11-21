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

@XmlRootElement(name = "libroEduccion")
@XmlType(propOrder = {
    "titulo",
    "intro",
    "educciones"
})

public class LibroEduccion {

    String titulo;
    String intro;
    List<Educcion> educciones;
    LibroHistorico histEdu;
    FileManager<LibroHistorico> managerHist;

    public LibroEduccion() {
    }

    public LibroEduccion(File directory) {
        this.managerHist = new FileManager(LibroHistorico.class, directory);
        this.histEdu = new LibroHistorico();
        this.titulo = "LIBRO DE EDUCCIÓN";
        this.intro = "Educción de Requerimientos";
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    @XmlElement
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIntro() {
        return intro;
    }
    
    @XmlElement
    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<Educcion> getEducciones() {
        return educciones;
    }
    
    @XmlElementWrapper(name = "educciones")
    @XmlElement(name = "educcion")
    public void setEducciones(List<Educcion> educciones) {
        this.educciones = educciones;
    }
    
    public boolean isEmpty(){
        return (this.educciones == null);
    }
    
    public void addEduccion(Educcion edu){
        if (isEmpty()){
           educciones = new ArrayList<>();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Calendar cal = Calendar.getInstance();
        String nombreEsp = edu.getEduccionNombre().getNombre();
        addHistorico(edu, dateFormat.format(cal.getTime()), 
                   "Creación de la Educcion " + nombreEsp);
        educciones.add(edu);
    }
    
    public void modEspecificacion(){
        
    }
    
    public void addHistorico(Educcion edu, String fecha, String razon){
        Historico hist = new Historico(edu.getVersion(), fecha, razon, edu.getFuente());
        histEdu.addHistorico(hist);
        managerHist.escribirXML("HistoricoEdu", histEdu);
    }

}


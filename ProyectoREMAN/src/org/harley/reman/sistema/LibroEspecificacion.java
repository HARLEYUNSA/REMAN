package org.harley.reman.sistema;

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
import org.harley.reman.xml.FileManager;

@XmlRootElement (name = "libroEsp" )
@XmlType(propOrder={
    "titulo", 
    "intro", 
    "especificaciones"
})

public class LibroEspecificacion {
    String titulo;
    String intro;
    List<Especificacion> especificaciones;
    LibroHistorico histEsp;
    FileManager<LibroHistorico> managerHist;

    public LibroEspecificacion() {
    }

    public LibroEspecificacion(File directory) {
        this.managerHist = new FileManager(LibroHistorico.class, directory);
        this.histEsp = new LibroHistorico();
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
    
    public List<Especificacion> getEspecificaciones() {
        return especificaciones;
    }
    @XmlElementWrapper(name = "especificaciones")
    @XmlElement(name = "especificacion")
    public void setEspecificaciones(List<Especificacion> especificaciones) {
        this.especificaciones = especificaciones;
    }
    
    public boolean isEmpty(){
        return (this.especificaciones == null);
    }
    
    public void addEspecificacion(Especificacion esp){
        if (isEmpty()){
           especificaciones = new ArrayList<>();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Calendar cal = Calendar.getInstance();
        String nombreEsp = esp.getEspecificacionNombre().getNombre();
        addHistorico(esp, dateFormat.format(cal.getTime()), 
                   "Creación de la Especificación " + nombreEsp);
        especificaciones.add(esp);
    }
    
    public void modEspecificacion(){
        
    }
    
    public void addHistorico(Especificacion esp, String fecha, String razon){
        Historico hist = new Historico(esp.getVersion(), fecha, razon, esp.getAutor());
        histEsp.addHistorico(hist);
        managerHist.escribirXML("HistoricoEsp", histEsp);
    }
}
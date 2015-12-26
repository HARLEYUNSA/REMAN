package org.harley.reman.sistema;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "libroActores")
@XmlType(propOrder = {
    "intro",
    "titulo1",
    "stakes",
    "titulo2",
    "teams"
})
public class LibroActor {
    Caratula intro;
    String titulo1;
    String titulo2;
    ArrayList<Stakeholder> stakes;
    ArrayList<ProyectTeam> teams;

    public Caratula getIntro() {
        return intro;
    }
    
    @XmlElement
    public void setIntro(Caratula intro) {
        this.intro = intro;
    }

    public ArrayList<Stakeholder> getStakes() {
        return stakes;
    }
    
    @XmlElementWrapper(name = "tablas")
    @XmlElement(name = "tabla")
    public void setStakes(ArrayList<Stakeholder> stakes) {
        this.stakes = stakes;
    }

    public void addStake(Stakeholder sth){
        if( this.stakes == null ){
            this.stakes = new ArrayList<>();
        }
            this.stakes.add(sth);
    }
    
    public ArrayList<ProyectTeam> getTeams() {
        return teams;
    }
    
    @XmlElementWrapper(name = "tablas")
    @XmlElement(name = "tabla")
    public void setTeams(ArrayList<ProyectTeam> teams) {
        this.teams = teams;
    }
    
    public void addTeam(ProyectTeam pyt){
        if( this.teams == null ){
            this.teams = new ArrayList<>();
        }
        this.teams.add(pyt);
    }

    public String getTitulo1() {
        return titulo1;
    }
    
    @XmlElement(name = "titulo")
    public void setTitulo1(String titulo1) {
        this.titulo1 = titulo1;
    }

    public String getTitulo2() {
        return titulo2;
    }
    
    @XmlElement(name = "titulo")
    public void setTitulo2(String titulo2) {
        this.titulo2 = titulo2;
    }

    public ArrayList<String> getFueCod(){
        ArrayList<String> fueNom = new ArrayList<>();
        for (Stakeholder stake : stakes) {
            fueNom.add(stake.getSthNombre().getCodigo());
        }
        return fueNom;
    }
    
    public ArrayList<String> getFueNom(){
        ArrayList<String> fueNom = new ArrayList<>();
        for (Stakeholder stake : stakes) {
            fueNom.add(stake.getSthNombre().getCodigo());
        }
        return fueNom;
    }

}

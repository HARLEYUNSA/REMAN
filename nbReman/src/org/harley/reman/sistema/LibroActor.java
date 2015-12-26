package org.harley.reman.sistema;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "libroActores")
@XmlType(propOrder = {
    "intro",
    "stakes",
    "teams"
})
public class LibroActor {
    Caratula intro;
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

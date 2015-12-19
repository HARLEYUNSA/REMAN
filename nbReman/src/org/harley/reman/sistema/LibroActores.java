package org.harley.reman.sistema;

import java.util.ArrayList;
import java.util.List;
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
public class LibroActores {
    String intro;
    List<Stakeholder> stakes;
    List<ProyectTeam> teams;

    public String getIntro() {
        return intro;
    }
    
    @XmlElement
    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<Stakeholder> getStakes() {
        return stakes;
    }
    
    @XmlElementWrapper(name = "stakes")
    @XmlElement(name = "stake")
    public void setStakes(List<Stakeholder> stakes) {
        this.stakes = stakes;
    }

    public void addStake(Stakeholder sth){
        if( this.stakes == null ){
            this.stakes = new ArrayList<>();
        }
            this.stakes.add(sth);
    }
    
    public List<ProyectTeam> getTeams() {
        return teams;
    }
    
    @XmlElementWrapper(name = "proyectTeams")
    @XmlElement(name = "proyectTeam")
    public void setTeams(List<ProyectTeam> teams) {
        this.teams = teams;
    }
    
    public void addTeam(ProyectTeam pyt){
        if( this.teams == null ){
            this.teams = new ArrayList<>();
        }
        this.teams.add(pyt);
    }
    
    public List<String> getFueCod(){
        List<String> fueNom = new ArrayList<>();
        for (Stakeholder stake : stakes) {
            fueNom.add(stake.getSthNom().getSthCod());
        }
        return fueNom;
    }
    
    public List<String> getFueNom(){
        List<String> fueNom = new ArrayList<>();
        for (Stakeholder stake : stakes) {
            fueNom.add(stake.getSthNom().getSthNom());
        }
        return fueNom;
    }

    /*public Stakeholder getSth(String sthCod){
        
    }*/
}

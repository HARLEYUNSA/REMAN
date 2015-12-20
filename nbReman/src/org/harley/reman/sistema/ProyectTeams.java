
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

@XmlRootElement(name = "proyectteams")
@XmlType(propOrder = {
    "actual"
})
class ProyectTeams {
        ProyectTeam actual;
 

    public ProyectTeams() {
    }

    public ProyectTeam getActual() {
        return actual;
    }

    public void setActual(ProyectTeam actual) {
        this.actual = actual;
    }
}

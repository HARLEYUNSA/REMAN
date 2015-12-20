
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


@XmlRootElement(name = "stakeholders")
@XmlType(propOrder = {
    "actual"
})
class Stakeholders {
    Stakeholder actual;
 

    public Stakeholders() {
    }

    public Stakeholder getActual() {
        return actual;
    }

    public void setActual(Stakeholder actual) {
        this.actual = actual;
    }
}

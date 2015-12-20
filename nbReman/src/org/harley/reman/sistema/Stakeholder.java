package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "actorNombre",
    "org",
    "cargo",
    "tipo",
    "correo",
    "comentarios"
})

public class Stakeholder {
    EduNombre stakeNombre;
    String org;
    String cargo;
    String tipo;
    String correo;
    String comentarios;
        
}
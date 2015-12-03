package org.harley.reman.sistema;

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

public class TeamProyect {
    EduNombre teamNombre;
    String org;
    String especialidad;
    String experiencia;
    String cargo;
    String correo;
    String comentarios;
}
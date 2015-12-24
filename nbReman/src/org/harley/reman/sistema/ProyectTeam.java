package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "pytNombre",
    "pytOrg",
    "pytEsp",
    "pytExp",
    "pytCar",
    "pytCor",
    "pytCom"
})
public class ProyectTeam {

    private static int numero = 0;
    private static String codigo = "PYT0000";
    Nombre pytNombre;
    String pytOrg;
    String pytEsp;
    String pytExp;
    String pytCar;
    String pytCor;
    String pytCom;

    public ProyectTeam() {
    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        ProyectTeam.numero = numero;
        for (int i = 0; i < numero; i++) {
            codigo = ToolsSystem.IncrementarCodigo(codigo);
        }
    }

    public ProyectTeam(String pytNom, String pytOrg) {
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.pytNombre = new Nombre(codigo, pytNom);
    }

    public ProyectTeam(String pytNom, String pytOrg, String pytEsp,
            String pytExp, String pytCar, String pytCor, String pytCom) {
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.pytNombre = new Nombre(codigo, pytNom);
        this.pytOrg = pytOrg;
        this.pytEsp = pytEsp;
        this.pytExp = pytExp;
        this.pytCar = pytCar;
        this.pytCor = pytCor;
        this.pytCom = pytCom;
    }

    public ProyectTeam(String pytCod, String pytNom, String pytOrg,
            String pytEsp, String pytExp, String pytCar, String pytCor,
            String pytCom) {
        this.pytNombre = new Nombre(pytCod, pytNom);
        this.pytOrg = pytOrg;
        this.pytEsp = pytEsp;
        this.pytExp = pytExp;
        this.pytCar = pytCar;
        this.pytCor = pytCor;
        this.pytCom = pytCom;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        ProyectTeam.codigo = codigo;
    }

    public Nombre getPytNombre() {
        return pytNombre;
    }
    
    @XmlElement(name = "pytNombre")
    public void setPytNombre(Nombre pytNombre) {
        this.pytNombre = pytNombre;
    }

    public String getPytOrg() {
        return pytOrg;
    }
    
    @XmlElement(name = "organizacion")
    public void setPytOrg(String pytOrg) {
        this.pytOrg = pytOrg;
    }

    public String getPytEsp() {
        return pytEsp;
    }
    
    @XmlElement(name = "especialidad")
    public void setPytEsp(String pytEsp) {
        this.pytEsp = pytEsp;
    }

    public String getPytExp() {
        return pytExp;
    }
    
    @XmlElement(name = "experiencia")
    public void setPytExp(String pytExp) {
        this.pytExp = pytExp;
    }

    public String getPytCar() {
        return pytCar;
    }
    
    @XmlElement(name = "cargo")
    public void setPytCar(String pytCar) {
        this.pytCar = pytCar;
    }

    public String getPytCor() {
        return pytCor;
    }
    
    @XmlElement(name = "email")
    public void setPytCor(String pytCor) {
        this.pytCor = pytCor;
    }

    public String getPytCom() {
        return pytCom;
    }
    
    @XmlElement(name = "comentarios")
    public void setPytCom(String pytCom) {
        this.pytCom = pytCom;
    }

}

package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "teamNombre",
    "pytOrg",
    "pytEsp",
    "pytExp",
    "pytCar",
    "pytCor",
    "pytCom"
})

public class ProyectTeam extends Actor{
    private static int numero = 0;
    private static String codigo = "pyt0000";
    PytNombre teamNombre;
    String pytOrg;
    String pytEsp;
    String pytExp;
    String pytCar;
    String pytCor;
    String pytCom;
    
    public ProyectTeam() {    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        ProyectTeam.numero = numero;
        for (int i = 0; i < numero; i++){
            codigo = ToolsSystem.IncrementarCodigo(codigo);
        }
    }

    public ProyectTeam(String pytNom, String pytOrg) {
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.teamNombre = new PytNombre(codigo, pytNom);
    }

    public ProyectTeam(String pytNom, String pytOrg, String pytEsp, 
            String pytExp, String pytCar, String pytCor, String pytCom) {
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.teamNombre = new PytNombre(codigo, pytNom);
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

    public PytNombre getTeamNombre() {
        return teamNombre;
    }

    public void setTeamNombre(PytNombre teamNombre) {
        this.teamNombre = teamNombre;
    }

    public String getpytOrg() {
        return pytOrg;
    }

    public void setpytOrg(String pytOrg) {
        this.pytOrg = pytOrg;
    }

    public String getpytEsp() {
        return pytEsp;
    }

    public void setpytEsp(String pytEsp) {
        this.pytEsp = pytEsp;
    }

    public String getpytExp() {
        return pytExp;
    }

    public void setpytExp(String pytExp) {
        this.pytExp = pytExp;
    }

    public String getpytCar() {
        return pytCar;
    }

    public void setpytCar(String pytCar) {
        this.pytCar = pytCar;
    }

    public String getpytCor() {
        return pytCor;
    }

    public void setpytCor(String pytCor) {
        this.pytCor = pytCor;
    }

    public String getpytCom() {
        return pytCom;
    }

    public void setpytCom(String pytCom) {
        this.pytCom = pytCom;
    }
    
    
}
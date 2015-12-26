package org.harley.reman.sistema;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

    @XmlRootElement
    @XmlType(propOrder = {
        "espNombre",
        "espEliCod",
        "espVer",
        "espFec",
        "espFueNom",
        "espFueCar",
        "espFueTip",
        "espEspNom",
        "espEspEsp",
        "espEspExp",
        "espEspCar",
        "espDep",
        "espDes",
        "espPre",
        "espPos",
        "espExc",
        "espObs"
    })
    

public class Especificacion {

    private static int numero = 0;
    private static String codigo = "ESP0000";
    Nombre espNombre;
    String espEliCod;
    String espVer;
    String espFec;
    String espFueNom;
    String espFueCar;
    String espFueTip;
    String espEspNom;
    String espEspEsp;
    String espEspExp;
    String espEspCar;
    String espDep;
    String espDes;
    String espPre;
    String espPos;
    Secuencia espExc;
    String espObs;
    
    public Especificacion() {
    }

    public Especificacion(String espCod, String espNom, String espEliCod, String espVer,
            String espFec, String espFueNom, String espFueCar, String espFueTip, String espEspNom,
            String espEspEsp, String espEspExp, String espEspCar, String espDep, String espDes,
            String espPre, String espPos, ArrayList<Paso> espExc, String espObs) {
        
        this.espNombre = new Nombre(espCod, espNom);
        this.espEliCod = espEliCod;
        this.espVer = espVer;
        this.espFec = espFec;
        this.espFueNom = espFueNom;
        this.espFueCar = espFueCar;
        this.espFueTip = espFueTip;
        this.espEspNom = espEspNom;
        this.espEspEsp = espEspEsp;
        this.espEspExp = espEspExp;
        this.espEspCar = espEspCar;
        this.espDep = espDep;
        this.espDes = espDes;
        this.espPre = espPre;
        this.espPos = espPos;
        this.espExc = new Secuencia(espExc.size() + 1, espExc);
        this.espObs = espObs;
    }
    
    public Especificacion(String espNom, String espEliCod, String espVer,
            String espFec, String espFueNom, String espFueCar, String espFueTip, String espEspNom,
            String espEspEsp, String espEspExp, String espEspCar, String espDep, String espDes,
            String espPre, String espPos, ArrayList<Paso> espExc, String espObs) {
        
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.espNombre = new Nombre(codigo, espNom);
        this.espEliCod = espEliCod;
        this.espVer = espVer;
        this.espFec = espFec;
        this.espFueNom = espFueNom;
        this.espFueCar = espFueCar;
        this.espFueTip = espFueTip;
        this.espEspNom = espEspNom;
        this.espEspEsp = espEspEsp;
        this.espEspExp = espEspExp;
        this.espEspCar = espEspCar;
        this.espDep = espDep;
        this.espDes = espDes;
        this.espPre = espPre;
        this.espPos = espPos;
        this.espExc = new Secuencia(espExc.size() + 1, espExc);
        this.espObs = espObs;
    }
    
    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Especificacion.numero = numero;
        for (int i = 0; i < numero; i++){
            codigo = ToolsSystem.IncrementarCodigo(codigo);
        }   
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        Especificacion.codigo = codigo;
    }

    public Nombre getEspNombre() {
        return espNombre;
    }

    @XmlElement(name = "espNombre")
    public void setEspNombre(Nombre espNombre) {
        this.espNombre = espNombre;
    }

    public String getEspEliCod() {
        return espEliCod;
    }

    @XmlElement(name = "elicitacionCodigo")
    public void setEspEliCod(String espEliCod) {
        this.espEliCod = espEliCod;
    }

    public String getEspVer() {
        return espVer;
    }

    @XmlElement(name = "version")
    public void setEspVer(String espVer) {
        this.espVer = espVer;
    }

    public String getEspFec() {
        return espFec;
    }

    @XmlElement(name = "fecha")
    public void setEspFec(String espFec) {
        this.espFec = espFec;
    }

    public String getEspFueNom() {
        return espFueNom;
    }

    @XmlElement(name = "fuenteNombre")
    public void setEspFueNom(String espFueNom) {
        this.espFueNom = espFueNom;
    }

    public String getEspFueCar() {
        return espFueCar;
    }

    @XmlElement(name = "fuenteCargo")
    public void setEspFueCar(String espFueCar) {
        this.espFueCar = espFueCar;
    }

    public String getEspFueTip() {
        return espFueTip;
    }

    @XmlElement(name = "fuenteTipo")
    public void setEspFueTip(String espFueTip) {
        this.espFueTip = espFueTip;
    }

    public String getEspEspNom() {
        return espEspNom;
    }

    @XmlElement(name = "especialistaNombre")
    public void setEspEspNom(String espEspNom) {
        this.espEspNom = espEspNom;
    }

    public String getEspEspEsp() {
        return espEspEsp;
    }

    @XmlElement(name = "especialistaEspecialidad")
    public void setEspEspEsp(String espEspEsp) {
        this.espEspEsp = espEspEsp;
    }

    public String getEspEspExp() {
        return espEspExp;
    }

    @XmlElement(name = "especialistaExperiencia")
    public void setEspEspExp(String espEspExp) {
        this.espEspExp = espEspExp;
    }

    public String getEspEspCar() {
        return espEspCar;
    }

    @XmlElement(name = "especialistaCargo")
    public void setEspEspCar(String espEspCar) {
        this.espEspCar = espEspCar;
    }

    public String getEspDep() {
        return espDep;
    }

    @XmlElement(name = "dependencias")
    public void setEspDep(String espDep) {
        this.espDep = espDep;
    }

    public String getEspDes() {
        return espDes;
    }

    @XmlElement(name = "descripcion")
    public void setEspDes(String espDes) {
        this.espDes = espDes;
    }

    public String getEspPre() {
        return espPre;
    }

    @XmlElement(name = "precondicion")
    public void setEspPre(String espPre) {
        this.espPre = espPre;
    }

    public String getEspPos() {
        return espPos;
    }

    @XmlElement(name = "postcondicion")
    public void setEspPos(String espPos) {
        this.espPos = espPos;
    }

    public Secuencia getEspExc() {
        return espExc;
    }
    
    @XmlElement(name = "excepcion")
    public void setEspExc(Secuencia espExc) {
        this.espExc = espExc;
    }

    public String getEspObs() {
        return espObs;
    }

    @XmlElement(name = "observaciones")
    public void setEspObs(String espObs) {
        this.espObs = espObs;
    }
}
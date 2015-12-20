package org.harley.reman.sistema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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
    private static String codigo = "ESP0001";
    EspNombre espNombre;
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
        
        this.espNombre = new EspNombre(espCod, espNom);
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
        this.espNombre = new EspNombre(codigo, espNom);
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

    public EspNombre getEspNombre() {
        return espNombre;
    }

    public void setEspNombre(EspNombre espNombre) {
        this.espNombre = espNombre;
    }

    public String getEspEliCod() {
        return espEliCod;
    }

    public void setEspEliCod(String espEliCod) {
        this.espEliCod = espEliCod;
    }

    public String getEspVer() {
        return espVer;
    }

    public void setEspVer(String espVer) {
        this.espVer = espVer;
    }

    public String getEspFec() {
        return espFec;
    }

    public void setEspFec(String espFec) {
        this.espFec = espFec;
    }

    public String getEspFueNom() {
        return espFueNom;
    }

    public void setEspFueNom(String espFueNom) {
        this.espFueNom = espFueNom;
    }

    public String getEspFueCar() {
        return espFueCar;
    }

    public void setEspFueCar(String espFueCar) {
        this.espFueCar = espFueCar;
    }

    public String getEspFueTip() {
        return espFueTip;
    }

    public void setEspFueTip(String espFueTip) {
        this.espFueTip = espFueTip;
    }

    public String getEspEspNom() {
        return espEspNom;
    }

    public void setEspEspNom(String espEspNom) {
        this.espEspNom = espEspNom;
    }

    public String getEspEspEsp() {
        return espEspEsp;
    }

    public void setEspEspEsp(String espEspEsp) {
        this.espEspEsp = espEspEsp;
    }

    public String getEspEspExp() {
        return espEspExp;
    }

    public void setEspEspExp(String espEspExp) {
        this.espEspExp = espEspExp;
    }

    public String getEspEspCar() {
        return espEspCar;
    }

    public void setEspEspCar(String espEspCar) {
        this.espEspCar = espEspCar;
    }

    public String getEspDep() {
        return espDep;
    }

    public void setEspDep(String espDep) {
        this.espDep = espDep;
    }

    public String getEspDes() {
        return espDes;
    }

    public void setEspDes(String espDes) {
        this.espDes = espDes;
    }

    public String getEspPre() {
        return espPre;
    }

    public void setEspPre(String espPre) {
        this.espPre = espPre;
    }

    public String getEspPos() {
        return espPos;
    }

    public void setEspPos(String espPos) {
        this.espPos = espPos;
    }

    public Secuencia getEspExc() {
        return espExc;
    }
    
    @XmlElement(name = "espExc")
    public void setEspExc(Secuencia espExc) {
        this.espExc = espExc;
    }

    public String getEspObs() {
        return espObs;
    }

    public void setEspObs(String espObs) {
        this.espObs = espObs;
    }
}
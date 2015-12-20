package org.harley.reman.sistema;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "eliNombre",
    "eliEduCod",
    "eliVer",
    "eliFec",
    "eliFueNom",
    "eliFueCar",
    "eliFueTip",
    "eliEspNom",
    "eliEspEsp",
    "eliEspExp",
    "eliEspCar",
    "eliDep",
    "eliDes",
    "eliPre",
    "eliSec",
    "eliPos",
    "eliExc",
    "eliObs"
})
public class Elicitacion {
    private static int numero = 0;
    private static String codigo = "ELI0001";
    EliNombre eliNombre;
    String eliEduCod;
    String eliVer;
    String eliFec;
    String eliFueNom;
    String eliFueCar;
    String eliFueTip;
    String eliEspNom;
    String eliEspEsp;
    String eliEspExp;
    String eliEspCar;
    String eliDep;
    String eliDes;
    String eliPre;
    Secuencia eliSec;
    String eliPos;
    Secuencia eliExc;
    String eliObs;

    public Elicitacion() {
    }

    public Elicitacion(String eliCod, String eliNom, String eliEduCod, 
            String eliVer, String eliFec, String eliFueNom, String eliFueCar, 
            String eliFueTip, String eliEspNom, String eliEspEsp, 
            String eliEspExp, String eliEspCar, String eliDep, String eliDes, 
            String eliPre, ArrayList<Paso> eliSec, String eliPos, 
            ArrayList<Paso> eliExc, String eliObs) {
        this.eliNombre = new EliNombre(eliCod, eliNom);
        this.eliEduCod = eliEduCod;
        this.eliVer = eliVer;
        this.eliFec = eliFec;
        this.eliFueNom = eliFueNom;
        this.eliFueCar = eliFueCar;
        this.eliFueTip = eliFueTip;
        this.eliEspNom = eliEspNom;
        this.eliEspEsp = eliEspEsp;
        this.eliEspExp = eliEspExp;
        this.eliEspCar = eliEspCar;
        this.eliDep = eliDep;
        this.eliDes = eliDes;
        this.eliPre = eliPre;
        this.eliSec = new Secuencia(eliSec.size() + 1, eliSec);
        this.eliPos = eliPos;
        this.eliExc = new Secuencia(eliExc.size() + 1, eliExc);
        this.eliObs = eliObs;
    }
    
    public Elicitacion(String eliNom, String eliEduCod, String eliVer, 
            String eliFec, String eliFueNom, String eliFueCar, String eliFueTip,
            String eliEspNom, String eliEspEsp, String eliEspExp, 
            String eliEspCar, String eliDep, String eliDes, String eliPre, 
            ArrayList<Paso> eliSec, String eliPos, ArrayList<Paso> eliExc, 
            String eliObs) {
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.eliNombre = new EliNombre(codigo, eliNom);
        this.eliEduCod = eliEduCod;
        this.eliVer = eliVer;
        this.eliFec = eliFec;
        this.eliFueNom = eliFueNom;
        this.eliFueCar = eliFueCar;
        this.eliFueTip = eliFueTip;
        this.eliEspNom = eliEspNom;
        this.eliEspEsp = eliEspEsp;
        this.eliEspExp = eliEspExp;
        this.eliEspCar = eliEspCar;
        this.eliDep = eliDep;
        this.eliDes = eliDes;
        this.eliPre = eliPre;
        this.eliSec = new Secuencia(eliSec.size() + 1, eliSec);
        this.eliPos = eliPos;
        this.eliExc = new Secuencia(eliExc.size() + 1, eliExc);
        this.eliObs = eliObs;
    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Elicitacion.numero = numero;
        for (int i = 0; i < numero; i++){
            codigo = ToolsSystem.IncrementarCodigo(codigo);
        }    
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        Elicitacion.codigo = codigo;
    }

    public EliNombre getEliNombre() {
        return eliNombre;
    }

    public void setEliNombre(EliNombre eliNombre) {
        this.eliNombre = eliNombre;
    }

    public String getEliEduCod() {
        return eliEduCod;
    }

    public void setEliEduCod(String eliEduCod) {
        this.eliEduCod = eliEduCod;
    }

    public String getEliVer() {
        return eliVer;
    }

    public void setEliVer(String eliVer) {
        this.eliVer = eliVer;
    }

    public String getEliFec() {
        return eliFec;
    }

    public void setEliFec(String eliFec) {
        this.eliFec = eliFec;
    }

    public String getEliFueNom() {
        return eliFueNom;
    }

    public void setEliFueNom(String eliFueNom) {
        this.eliFueNom = eliFueNom;
    }

    public String getEliFueCar() {
        return eliFueCar;
    }

    public void setEliFueCar(String eliFueCar) {
        this.eliFueCar = eliFueCar;
    }

    public String getEliFueTip() {
        return eliFueTip;
    }

    public void setEliFueTip(String eliFueTip) {
        this.eliFueTip = eliFueTip;
    }

    public String getEliEspNom() {
        return eliEspNom;
    }

    public void setEliEspNom(String eliEspNom) {
        this.eliEspNom = eliEspNom;
    }

    public String getEliEspEsp() {
        return eliEspEsp;
    }

    public void setEliEspEsp(String eliEspEsp) {
        this.eliEspEsp = eliEspEsp;
    }

    public String getEliEspExp() {
        return eliEspExp;
    }

    public void setEliEspExp(String eliEspExp) {
        this.eliEspExp = eliEspExp;
    }

    public String getEliEspCar() {
        return eliEspCar;
    }

    public void setEliEspCar(String eliEspCar) {
        this.eliEspCar = eliEspCar;
    }

    public String getEliDep() {
        return eliDep;
    }

    public void setEliDep(String eliDep) {
        this.eliDep = eliDep;
    }

    public String getEliDes() {
        return eliDes;
    }

    public void setEliDes(String eliDes) {
        this.eliDes = eliDes;
    }

    public String getEliPre() {
        return eliPre;
    }

    public void setEliPre(String eliPre) {
        this.eliPre = eliPre;
    }

    public Secuencia getEliSec() {
        return eliSec;
    }

    public void setEliSec(Secuencia eliSec) {
        this.eliSec = eliSec;
    }

    public String getEliPos() {
        return eliPos;
    }

    public void setEliPos(String eliPos) {
        this.eliPos = eliPos;
    }

    public Secuencia getEliExc() {
        return eliExc;
    }
    
    public void setEliExc(Secuencia eliExc) {
        this.eliExc = eliExc;
    }

    public String getEliObs() {
        return eliObs;
    }

    public void setEliObs(String eliObs) {
        this.eliObs = eliObs;
    }
}
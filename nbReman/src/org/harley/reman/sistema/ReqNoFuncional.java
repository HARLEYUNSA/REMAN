
package org.harley.reman.sistema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
    @XmlType(propOrder = {
        "rnfNombre", 
        "rnfVer", 
        "rnfTip", 
        "rnfObj", 
        "rnfFec", 
        "rnfFueNom", 
        "rnfFueCar", 
        "rnfFueTip", 
        "rnfEspNom", 
        "rnfEspEsp", 
        "rnfEspExp", 
        "rnfEspCar", 
        "rnfDep", 
        "rnfDes", 
        "rnfObs"
    })
public class ReqNoFuncional {
    private static int numero = 0;
    private static String codigo = "RNF0001";
    RnfNombre rnfNombre;
    String rnfVer;
    String rnfTip;
    String rnfObj;
    String rnfFec;
    String rnfFueNom;
    String rnfFueCar;
    String rnfFueTip;
    String rnfEspNom;
    String rnfEspEsp;
    String rnfEspExp;
    String rnfEspCar;
    String rnfDep;
    String rnfDes;
    String rnfObs;
    
    public ReqNoFuncional() {
    }

    public ReqNoFuncional(String rnfCod, String rnfNom, String rnfVer, 
            String rnfTip, String rnfObj, String rnfFec, String rnfFueNom,
            String rnfFueCar, String rnfFueTip, String rnfEspNom, 
            String rnfEspEsp, String rnfEspExp, String rnfEspCar, String rnfDep,
            String rnfDes, String rnfObs) {
        
        this.rnfNombre = new RnfNombre(rnfCod, rnfNom);
        this.rnfVer = rnfVer;
        this.rnfTip = rnfTip;
        this.rnfObj = rnfObj;
        this.rnfFec = rnfFec;
        this.rnfFueNom = rnfFueNom;
        this.rnfFueCar = rnfFueCar;
        this.rnfFueTip = rnfFueTip;
        this.rnfEspNom = rnfEspNom;
        this.rnfEspEsp = rnfEspEsp;
        this.rnfEspExp = rnfEspExp;
        this.rnfEspCar = rnfEspCar;
        this.rnfDep = rnfDep;
        this.rnfDes = rnfDes;
        this.rnfObs = rnfObs;

    }
    
    public ReqNoFuncional(String rnfNom, String rnfVer, String rnfTip, 
            String rnfObj, String rnfFec, String rnfFueNom,
            String rnfFueCar, String rnfFueTip, String rnfEspNom, 
            String rnfEspEsp, String rnfEspExp, String rnfEspCar, String rnfDep,
            String rnfDes, String rnfObs) {
        
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.rnfNombre = new RnfNombre(codigo, rnfNom);
        this.rnfVer = rnfVer;
        this.rnfTip = rnfTip;
        this.rnfObj = rnfObj;
        this.rnfFec = rnfFec;
        this.rnfFueNom = rnfFueNom;
        this.rnfFueCar = rnfFueCar;
        this.rnfFueTip = rnfFueTip;
        this.rnfEspNom = rnfEspNom;
        this.rnfEspEsp = rnfEspEsp;
        this.rnfEspExp = rnfEspExp;
        this.rnfEspCar = rnfEspCar;
        this.rnfDep = rnfDep;
        this.rnfDes = rnfDes;
        this.rnfObs = rnfObs;
    }
    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        ReqNoFuncional.numero = numero;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        ReqNoFuncional.codigo = codigo;
    }

    public RnfNombre getRnfNombre() {
        return rnfNombre;
    }

    public void setRnfNombre(RnfNombre rnfNombre) {
        this.rnfNombre = rnfNombre;
    }

    public String getRnfVer() {
        return rnfVer;
    }

    public void setRnfVer(String rnfVer) {
        this.rnfVer = rnfVer;
    }

    public String getRnfTip() {
        return rnfTip;
    }

    public void setRnfTip(String rnfTip) {
        this.rnfTip = rnfTip;
    }

    public String getRnfObj() {
        return rnfObj;
    }

    public void setRnfObj(String rnfObj) {
        this.rnfObj = rnfObj;
    }

    public String getRnfFec() {
        return rnfFec;
    }

    public void setRnfFec(String rnfFec) {
        this.rnfFec = rnfFec;
    }

    public String getRnfFueNom() {
        return rnfFueNom;
    }

    public void setRnfFueNom(String rnfFueNom) {
        this.rnfFueNom = rnfFueNom;
    }

    public String getRnfFueCar() {
        return rnfFueCar;
    }

    public void setRnfFueCar(String rnfFueCar) {
        this.rnfFueCar = rnfFueCar;
    }

    public String getRnfFueTip() {
        return rnfFueTip;
    }

    public void setRnfFueTip(String rnfFueTip) {
        this.rnfFueTip = rnfFueTip;
    }

    public String getRnfEspNom() {
        return rnfEspNom;
    }

    public void setRnfEspNom(String rnfEspNom) {
        this.rnfEspNom = rnfEspNom;
    }

    public String getRnfEspEsp() {
        return rnfEspEsp;
    }

    public void setRnfEspEsp(String rnfEspEsp) {
        this.rnfEspEsp = rnfEspEsp;
    }

    public String getRnfEspExp() {
        return rnfEspExp;
    }

    public void setRnfEspExp(String rnfEspExp) {
        this.rnfEspExp = rnfEspExp;
    }

    public String getRnfEspCar() {
        return rnfEspCar;
    }

    public void setRnfEspCar(String rnfEspCar) {
        this.rnfEspCar = rnfEspCar;
    }

    public String getRnfDep() {
        return rnfDep;
    }

    public void setRnfDep(String rnfDep) {
        this.rnfDep = rnfDep;
    }

    public String getRnfDes() {
        return rnfDes;
    }

    public void setRnfDes(String rnfDes) {
        this.rnfDes = rnfDes;
    }

    public String getRnfObs() {
        return rnfObs;
    }

    public void setRnfObs(String rnfObs) {
        this.rnfObs = rnfObs;
    }

}

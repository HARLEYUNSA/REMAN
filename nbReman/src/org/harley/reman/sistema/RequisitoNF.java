
package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlElement;
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
public class RequisitoNF {
    private static int numero = 0;
    private static String codigo = "RNF0000";
    Nombre rnfNombre;
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
    
    public RequisitoNF() {
    }

    public RequisitoNF(String rnfCod, String rnfNom, String rnfVer, 
            String rnfTip, String rnfObj, String rnfFec, String rnfFueNom,
            String rnfFueCar, String rnfFueTip, String rnfEspNom, 
            String rnfEspEsp, String rnfEspExp, String rnfEspCar, String rnfDep,
            String rnfDes, String rnfObs) {
        
        this.rnfNombre = new Nombre(rnfCod, rnfNom);
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
    
    public RequisitoNF(String rnfNom, String rnfVer, String rnfTip, 
            String rnfObj, String rnfFec, String rnfFueNom,
            String rnfFueCar, String rnfFueTip, String rnfEspNom, 
            String rnfEspEsp, String rnfEspExp, String rnfEspCar, String rnfDep,
            String rnfDes, String rnfObs) {
        
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.rnfNombre = new Nombre(codigo, rnfNom);
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
        RequisitoNF.numero = numero;
        codigo = "RNF0000";
        for (int i = 0; i < numero; i++) {
            codigo = ToolsSystem.IncrementarCodigo(codigo);
        }
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        RequisitoNF.codigo = codigo;
    }

    public Nombre getRnfNombre() {
        return rnfNombre;
    }
    
    @XmlElement(name = "rnfNombre")
    public void setRnfNombre(Nombre rnfNombre) {
        this.rnfNombre = rnfNombre;
    }

    public String getRnfVer() {
        return rnfVer;
    }
    
    @XmlElement(name = "version")
    public void setRnfVer(String rnfVer) {
        this.rnfVer = rnfVer;
    }

    public String getRnfTip() {
        return rnfTip;
    }
    
    @XmlElement(name = "tipo")
    public void setRnfTip(String rnfTip) {
        this.rnfTip = rnfTip;
    }

    public String getRnfObj() {
        return rnfObj;
    }
    
    @XmlElement(name = "objetivo")
    public void setRnfObj(String rnfObj) {
        this.rnfObj = rnfObj;
    }

    public String getRnfFec() {
        return rnfFec;
    }
    
    @XmlElement(name = "fecha")
    public void setRnfFec(String rnfFec) {
        this.rnfFec = rnfFec;
    }

    public String getRnfFueNom() {
        return rnfFueNom;
    }
    
    @XmlElement(name = "fuenteNombre")
    public void setRnfFueNom(String rnfFueNom) {
        this.rnfFueNom = rnfFueNom;
    }

    public String getRnfFueCar() {
        return rnfFueCar;
    }
    
    @XmlElement(name = "fuenteCargo")
    public void setRnfFueCar(String rnfFueCar) {
        this.rnfFueCar = rnfFueCar;
    }

    public String getRnfFueTip() {
        return rnfFueTip;
    }
    
    @XmlElement(name = "fuenteTipo")
    public void setRnfFueTip(String rnfFueTip) {
        this.rnfFueTip = rnfFueTip;
    }

    public String getRnfEspNom() {
        return rnfEspNom;
    }
    
    @XmlElement(name = "especialistaNombre")
    public void setRnfEspNom(String rnfEspNom) {
        this.rnfEspNom = rnfEspNom;
    }

    public String getRnfEspEsp() {
        return rnfEspEsp;
    }
    
    @XmlElement(name = "especialistaEspecialidad")
    public void setRnfEspEsp(String rnfEspEsp) {
        this.rnfEspEsp = rnfEspEsp;
    }

    public String getRnfEspExp() {
        return rnfEspExp;
    }
    
    @XmlElement(name = "especialistaExperiencia")
    public void setRnfEspExp(String rnfEspExp) {
        this.rnfEspExp = rnfEspExp;
    }

    public String getRnfEspCar() {
        return rnfEspCar;
    }
    
    @XmlElement(name = "especialistaCargo")
    public void setRnfEspCar(String rnfEspCar) {
        this.rnfEspCar = rnfEspCar;
    }

    public String getRnfDep() {
        return rnfDep;
    }
    
    @XmlElement(name = "dependencias")
    public void setRnfDep(String rnfDep) {
        this.rnfDep = rnfDep;
    }

    public String getRnfDes() {
        return rnfDes;
    }
    
    @XmlElement(name = "descripcion")
    public void setRnfDes(String rnfDes) {
        this.rnfDes = rnfDes;
    }

    public String getRnfObs() {
        return rnfObs;
    }
    
    @XmlElement(name = "observaciones")
    public void setRnfObs(String rnfObs) {
        this.rnfObs = rnfObs;
    }
}

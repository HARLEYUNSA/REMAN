package org.harley.reman.sistema;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "eduNombre",
    "eduVer",
    "eduTip",
    "eduObj",
    "eduFec",
    "eduFueNom",
    "eduFueCar",
    "eduFueTip",
    "eduEspNom",
    "eduEspEsp",
    "eduEspExp",
    "eduEspCar",
    "eduDes",
    "eduObs"
})  
public class Educcion {
    private static int numero = 0;
    private static String codigo = "EDU0000";
    Nombre eduNombre;
    String eduVer;
    String eduTip;
    String eduObj;
    String eduFec;
    String eduFueNom;
    String eduFueCar;
    String eduFueTip;
    String eduEspNom;
    String eduEspEsp;
    String eduEspExp;      
    String eduEspCar;
    String eduDes;
    String eduObs;
    
    public Educcion() {    }

    public Educcion(String eduCod, String eduNom, String eduVer, String eduTip, 
            String eduObj, String eduFec, String eduFueNom, String eduFueCar, 
            String eduFueTip, String eduEspNom, String eduEspEsp,
            String eduEspExp, String eduEspCar, String eduDes, String eduObs){
        this.eduNombre = new Nombre(eduCod, eduNom);
        this.eduVer = eduVer;
        this.eduTip = eduTip;
        this.eduObj = eduObj;
        this.eduFec = eduFec;
        this.eduFueNom = eduFueNom;
        this.eduFueCar = eduFueCar;
        this.eduFueTip = eduFueTip;
        this.eduEspNom = eduEspNom;
        this.eduEspEsp = eduEspEsp;
        this.eduEspCar = eduEspCar;
        this.eduEspExp = eduEspExp;
        this.eduDes = eduDes;
        this.eduObs = eduObs;
    }
    
    public Educcion(String eduNom, String eduVer, String eduTip, 
            String eduObj, String eduFec, String eduFueNom, String eduFueCar, 
            String eduFueTip, String eduEspNom, String eduEspEsp,
            String eduEspExp, String eduEspCar, String eduDes, String eduObs){
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.eduNombre = new Nombre(codigo, eduNom);
        this.eduVer = eduVer;
        this.eduFueNom = eduFueNom;
        this.eduFueCar = eduFueCar;
        this.eduFueTip = eduFueTip;
        this.eduEspNom = eduEspNom;
        this.eduEspEsp = eduEspEsp;
        this.eduEspCar = eduEspCar;
        this.eduEspExp = eduEspExp;
        this.eduTip = eduTip;
        this.eduObj = eduObj;
        this.eduFec = eduFec;
        this.eduDes = eduDes;
        this.eduObs = eduObs;
    }
    
    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Educcion.numero = numero;
        codigo = "EDU0000";
        for (int i = 0; i < numero; i++){
            codigo = ToolsSystem.IncrementarCodigo(codigo);
        }
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        Educcion.codigo = codigo;
    }

    public Nombre getEduNombre() {
        return eduNombre;
    }

    @XmlElement(name = "eduNombre")
    public void setEduNombre(Nombre eduNombre) {
        this.eduNombre = eduNombre;
    }

    public String getEduVer() {
        return eduVer;
    }
    
    @XmlElement(name = "version")
    public void setEduVer(String eduVer) {
        this.eduVer = eduVer;
    }

    public String getEduTip() {
        return eduTip;
    }
    
    @XmlElement(name = "tipo")
    public void setEduTip(String eduTip) {
        this.eduTip = eduTip;
    }

    public String getEduObj() {
        return eduObj;
    }
    
    @XmlElement(name = "objetivo")
    public void setEduObj(String eduObj) {
        this.eduObj = eduObj;
    }

    public String getEduFec() {
        return eduFec;
    }
    
    @XmlElement(name = "fecha")
    public void setEduFec(String eduFec) {
        this.eduFec = eduFec;
    }

    public String getEduFueNom() {
        return eduFueNom;
    }
    
    @XmlElement(name = "fuenteNombre")
    public void setEduFueNom(String eduFueNom) {
        this.eduFueNom = eduFueNom;
    }

    public String getEduFueCar() {
        return eduFueCar;
    }
    
    @XmlElement(name = "fuenteCargo")
    public void setEduFueCar(String eduFueCar) {
        this.eduFueCar = eduFueCar;
    }

    public String getEduFueTip() {
        return eduFueTip;
    }
    
    @XmlElement(name = "fuenteTipo")
    public void setEduFueTip(String eduFueTip) {
        this.eduFueTip = eduFueTip;
    }

    public String getEduEspNom() {
        return eduEspNom;
    }
    
    @XmlElement(name = "especialistaNombre")
    public void setEduEspNom(String eduEspNom) {
        this.eduEspNom = eduEspNom;
    }

    public String getEduEspEsp() {
        return eduEspEsp;
    }
    
    @XmlElement(name = "especialistaEspecialidad")
    public void setEduEspEsp(String eduEspEsp) {
        this.eduEspEsp = eduEspEsp;
    }

    public String getEduEspExp() {
        return eduEspExp;
    }
    
    @XmlElement(name = "especialistaExperiencia")
    public void setEduEspExp(String eduEspExp) {
        this.eduEspExp = eduEspExp;
    }

    public String getEduEspCar() {
        return eduEspCar;
    }
    
    @XmlElement(name = "especialistaCargo")
    public void setEduEspCar(String eduEspCar) {
        this.eduEspCar = eduEspCar;
    }

    public String getEduDes() {
        return eduDes;
    }
    
    @XmlElement(name = "descripcion")
    public void setEduDes(String eduDes) {
        this.eduDes = eduDes;
    }

    public String getEduObs() {
        return eduObs;
    }
    
    @XmlElement(name = "observaciones")
    public void setEduObs(String eduObs) {
        this.eduObs = eduObs;
    }
}
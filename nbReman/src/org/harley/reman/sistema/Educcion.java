package org.harley.reman.sistema;

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
    EduNombre eduNombre;
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

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Educcion.numero = numero;
        for (int i = 0; i < numero; i++){
            codigo = ToolsSystem.IncrementarCodigo(codigo);
        }
    }

    public Educcion(String eduCod, String eduNom, String eduVer, String eduTip, 
            String eduObj, String eduFec, String eduFueNom, String eduFueCar, 
            String eduFueTip, String eduEspNom, String eduEspEsp,
            String eduEspExp, String eduEspCar, String eduDes, String eduObs){
        this.eduNombre = new EduNombre(eduCod, eduNom);
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
        this.eduNombre = new EduNombre(codigo, eduNom);
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

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        Educcion.codigo = codigo;
    }

    public EduNombre getEduNombre() {
        return eduNombre;
    }

    public void setEduNombre(EduNombre eduNombre) {
        this.eduNombre = eduNombre;
    }

    public String getEduVer() {
        return eduVer;
    }

    public void setEduVer(String eduVer) {
        this.eduVer = eduVer;
    }

    public String getEduTip() {
        return eduTip;
    }

    public void setEduTip(String eduTip) {
        this.eduTip = eduTip;
    }

    public String getEduObj() {
        return eduObj;
    }

    public void setEduObj(String eduObj) {
        this.eduObj = eduObj;
    }

    public String getEduFec() {
        return eduFec;
    }

    public void setEduFec(String eduFec) {
        this.eduFec = eduFec;
    }

    public String getEduFueNom() {
        return eduFueNom;
    }

    public void setEduFueNom(String eduFueNom) {
        this.eduFueNom = eduFueNom;
    }

    public String getEduFueCar() {
        return eduFueCar;
    }

    public void setEduFueCar(String eduFueCar) {
        this.eduFueCar = eduFueCar;
    }

    public String getEduFueTip() {
        return eduFueTip;
    }

    public void setEduFueTip(String eduFueTip) {
        this.eduFueTip = eduFueTip;
    }

    public String getEduEspNom() {
        return eduEspNom;
    }

    public void setEduEspNom(String eduEspNom) {
        this.eduEspNom = eduEspNom;
    }

    public String getEduEspEsp() {
        return eduEspEsp;
    }

    public void setEduEspEsp(String eduEspEsp) {
        this.eduEspEsp = eduEspEsp;
    }

    public String getEduEspExp() {
        return eduEspExp;
    }

    public void setEduEspExp(String eduEspExp) {
        this.eduEspExp = eduEspExp;
    }

    public String getEduEspCar() {
        return eduEspCar;
    }

    public void setEduEspCar(String eduEspCar) {
        this.eduEspCar = eduEspCar;
    }

    public String getEduDes() {
        return eduDes;
    }

    public void setEduDes(String eduDes) {
        this.eduDes = eduDes;
    }

    public String getEduObs() {
        return eduObs;
    }

    public void setEduObs(String eduObs) {
        this.eduObs = eduObs;
    }
}

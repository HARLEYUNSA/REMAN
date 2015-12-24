package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "sthNombre",
    "sthOrg",
    "sthCar",
    "sthTip",
    "sthCorEle",
    "sthCom"
})

public class Stakeholder {
    private static int numero = 0;
    private static String codigo = "STH0000";
    SthNombre sthNombre;
    String sthOrg;
    String sthCar;
    String sthTip;
    String sthCorEle;
    String sthCom;

    public Stakeholder() {
    }

    public Stakeholder(String sthNom) {
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.sthNombre = new SthNombre(codigo, sthNom);
    }

    public Stakeholder(String sthNom, String sthOrg, String sthCar, 
            String sthTip, String sthCorEle, String sthCom) {
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.sthNombre = new SthNombre(codigo, sthNom);
        this.sthOrg = sthOrg;
        this.sthCar = sthCar;
        this.sthTip = sthTip;
        this.sthCorEle = sthCorEle;
        this.sthCom = sthCom;
    }

    public Stakeholder(String sthCod, String sthNom, String sthOrg, 
            String sthCar, String sthTip, String sthCorEle, String sthCom) {
        this.sthNombre = new SthNombre(sthCod, sthNom);
        this.sthOrg = sthOrg;
        this.sthCar = sthCar;
        this.sthTip = sthTip;
        this.sthCorEle = sthCorEle;
        this.sthCom = sthCom;
    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Stakeholder.numero = numero;
        for (int i = 0; i < numero; i++){
            codigo = ToolsSystem.IncrementarCodigo(codigo);
        }
    }

    public SthNombre getSthNombre() {
        return sthNombre;
    }

    public void setSthNombre(SthNombre sthNombre) {
        this.sthNombre = sthNombre;
    }

    public String getSthOrg() {
        return sthOrg;
    }

    public void setSthOrg(String sthOrg) {
        this.sthOrg = sthOrg;
    }

    public String getSthCar() {
        return sthCar;
    }

    public void setSthCar(String sthCar) {
        this.sthCar = sthCar;
    }

    public String getSthTip() {
        return sthTip;
    }

    public void setSthTip(String sthTip) {
        this.sthTip = sthTip;
    }

    public String getSthCorEle() {
        return sthCorEle;
    }

    public void setSthCorEle(String sthCorEle) {
        this.sthCorEle = sthCorEle;
    }

    public String getSthCom() {
        return sthCom;
    }

    public void setSthCom(String sthCom) {
        this.sthCom = sthCom;
    }
     
}
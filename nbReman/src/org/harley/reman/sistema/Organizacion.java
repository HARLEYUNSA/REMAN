package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "orgNombre",
    "orgDir",
    "orgTel",
    "orgPagWeb",
    "orgCorEle",
    "orgCom"
})
public class Organizacion {
    private static int numero = 0;
    private static String codigo = "ORG0000";
    Nombre orgNombre;
    String orgDir;
    String orgTel;
    String orgPagWeb;
    String orgCorEle;
    String orgCom;

    public Organizacion() {
    }

    public Organizacion(String orgNom) {
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.orgNombre = new Nombre(codigo, orgNom);
    }

    public Organizacion(String orgNom, String ordDir, String orgTel, 
            String orgPagWeb, String orgCorEle, String orgCom) {
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.orgNombre = new Nombre(codigo, orgNom);
        this.orgDir = ordDir;
        this.orgTel = orgTel;
        this.orgPagWeb = orgPagWeb;
        this.orgCorEle = orgCorEle;
        this.orgCom = orgCom;
    }

    public Organizacion(String orgCod, String orgNom, String ordDir, String orgTel, 
            String orgPagWeb, String orgCorEle, String orgCom) {
        this.orgNombre = new Nombre(orgCod, orgNom);
        this.orgDir = ordDir;
        this.orgTel = orgTel;
        this.orgPagWeb = orgPagWeb;
        this.orgCorEle = orgCorEle;
        this.orgCom = orgCom;
    }
    
    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Organizacion.numero = numero;
        codigo = "ORG0000";
        for (int i = 0; i < numero; i++){
            codigo = ToolsSystem.IncrementarCodigo(codigo);
        }
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        Organizacion.codigo = codigo;
    }
      
    public Nombre getOrgNombre() {
        return orgNombre;
    }
    
    @XmlElement(name = "orgNombre")
    public void setOrgNombre(Nombre orgNombre) {
        this.orgNombre = orgNombre;
    }

    public String getOrgDir() {
        return orgDir;
    }
    
    @XmlElement(name = "direccion")
    public void setOrgDir(String orgDir) {
        this.orgDir = orgDir;
    }

    public String getOrgTel() {
        return orgTel;
    }
    
    @XmlElement(name = "telefono")
    public void setOrgTel(String orgTel) {
        this.orgTel = orgTel;
    }

    public String getOrgPagWeb() {
        return orgPagWeb;
    }
    
    @XmlElement(name = "paginaWeb")
    public void setOrgPagWeb(String orgPagWeb) {
        this.orgPagWeb = orgPagWeb;
    }

    public String getOrgCorEle() {
        return orgCorEle;
    }
    
    @XmlElement(name = "email")
    public void setOrgCorEle(String orgCorEle) {
        this.orgCorEle = orgCorEle;
    }

    public String getOrgCom() {
        return orgCom;
    }
    
    @XmlElement(name = "comentarios")
    public void setOrgCom(String orgCom) {
        this.orgCom = orgCom;
    }

}
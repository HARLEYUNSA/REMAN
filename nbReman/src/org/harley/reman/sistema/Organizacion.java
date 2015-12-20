package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "orgNom",
    "orgDir",
    "orgTel",
    "orgPagWeb",
    "orgCorEle",
    "orgCom"
})
public class Organizacion {
    private static int numero = 0;
    private static String codigo = "ORG0000";
    OrgNombre orgNom;
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
        this.orgNom = new OrgNombre(codigo, orgNom);
    }

    public Organizacion(String orgNom, String ordDir, String orgTel, 
            String orgPagWeb, String orgCorEle, String orgCom) {
        numero++;
        codigo = ToolsSystem.IncrementarCodigo(codigo);
        this.orgNom = new OrgNombre(codigo, orgNom);
        this.orgDir = ordDir;
        this.orgTel = orgTel;
        this.orgPagWeb = orgPagWeb;
        this.orgCorEle = orgCorEle;
        this.orgCom = orgCom;
    }

    public Organizacion(String orgCod, String orgNom, String ordDir, String orgTel, 
            String orgPagWeb, String orgCorEle, String orgCom) {
        this.orgNom = new OrgNombre(orgCod, orgNom);
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
        for (int i = 0; i < numero; i++){
            codigo = ToolsSystem.IncrementarCodigo(codigo);
        }
    }
    
    public OrgNombre getOrgNom() {
        return orgNom;
    }

    public void setOrgNom(OrgNombre orgNom) {
        this.orgNom = orgNom;
    }

    public String getOrgDir() {
        return orgDir;
    }

    public void setOrgDir(String orgDir) {
        this.orgDir = orgDir;
    }

    public String getOrgTel() {
        return orgTel;
    }

    public void setOrgTel(String orgTel) {
        this.orgTel = orgTel;
    }

    public String getOrgPagWeb() {
        return orgPagWeb;
    }

    public void setOrgPagWeb(String orgPagWeb) {
        this.orgPagWeb = orgPagWeb;
    }

    public String getOrgCorEle() {
        return orgCorEle;
    }

    public void setOrgCorEle(String orgCorEle) {
        this.orgCorEle = orgCorEle;
    }

    public String getOrgCom() {
        return orgCom;
    }

    public void setOrgCom(String orgCom) {
        this.orgCom = orgCom;
    }

    
}
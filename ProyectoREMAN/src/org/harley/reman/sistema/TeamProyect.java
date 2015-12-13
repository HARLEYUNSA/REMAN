package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "actorNombre",
    "org",
    "cargo",
    "tipo",
    "correo",
    "comentarios"
})

public class TeamProyect extends Actor{
    private static int numero = 0;
    private static String codigo = "TPY0000";
    TpyNombre teamNombre;
    String tpyOrg;
    String tpyEsp;
    String tpyExp;
    String tpyCar;
    String tpyCor;
    String tpyCom;
    
    public TeamProyect() {    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        TeamProyect.numero = numero;
        for (int i = 0; i < numero; i++){
            codigo = Tools.IncrementarCodigo(codigo);
        }
    }

    public TeamProyect(String tpyNom, String tpyOrg) {
        numero++;
        codigo = Tools.IncrementarCodigo(codigo);
        this.teamNombre = new TpyNombre(codigo, tpyNom);
    }

    public TeamProyect(String tpyNom, String tpyOrg, String tpyEsp, String tpyExp, String tpyCar, String tpyCor, String tpyCom) {
        numero++;
        codigo = Tools.IncrementarCodigo(codigo);
        this.teamNombre = new TpyNombre(codigo, tpyNom);
        this.tpyOrg = tpyOrg;
        this.tpyEsp = tpyEsp;
        this.tpyExp = tpyExp;
        this.tpyCar = tpyCar;
        this.tpyCor = tpyCor;
        this.tpyCom = tpyCom;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        TeamProyect.codigo = codigo;
    }

    public TpyNombre getTeamNombre() {
        return teamNombre;
    }

    public void setTeamNombre(TpyNombre teamNombre) {
        this.teamNombre = teamNombre;
    }

    public String getTpyOrg() {
        return tpyOrg;
    }

    public void setTpyOrg(String tpyOrg) {
        this.tpyOrg = tpyOrg;
    }

    public String getTpyEsp() {
        return tpyEsp;
    }

    public void setTpyEsp(String tpyEsp) {
        this.tpyEsp = tpyEsp;
    }

    public String getTpyExp() {
        return tpyExp;
    }

    public void setTpyExp(String tpyExp) {
        this.tpyExp = tpyExp;
    }

    public String getTpyCar() {
        return tpyCar;
    }

    public void setTpyCar(String tpyCar) {
        this.tpyCar = tpyCar;
    }

    public String getTpyCor() {
        return tpyCor;
    }

    public void setTpyCor(String tpyCor) {
        this.tpyCor = tpyCor;
    }

    public String getTpyCom() {
        return tpyCom;
    }

    public void setTpyCom(String tpyCom) {
        this.tpyCom = tpyCom;
    }
    
    
}
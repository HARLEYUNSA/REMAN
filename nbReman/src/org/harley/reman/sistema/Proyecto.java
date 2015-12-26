package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
    "proNom",
    "empDes",
    "empCli",
    "proLid",
    "proEst",
    "fecIni",
    "fecFin",
})
public class Proyecto {
    String proNom;
    String empDes;
    String empCli;
    String proLid;
    String proEst;
    String fecIni;
    String fecFin;

    public Proyecto() {
    }

    public Proyecto(String proNom, String empDes, String empCli, String proLid,
            String proEst, String fecIni, String fecFin) {
        this.proNom = proNom;
        this.empDes = empDes;
        this.empCli = empCli;
        this.proLid = proLid;
        this.proEst = proEst;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
    }

    public String getProNom() {
        return proNom;
    }

    public void setProNom(String proNom) {
        this.proNom = proNom;
    }

    public String getEmpDes() {
        return empDes;
    }

    public void setEmpDes(String empDes) {
        this.empDes = empDes;
    }

    public String getEmpCli() {
        return empCli;
    }

    public void setEmpCli(String empCli) {
        this.empCli = empCli;
    }

    public String getProLid() {
        return proLid;
    }

    public void setProLid(String proLid) {
        this.proLid = proLid;
    }

    public String getProEst() {
        return proEst;
    }

    public void setProEst(String proEst) {
        this.proEst = proEst;
    }

    public String getFecIni() {
        return fecIni;
    }

    public void setFecIni(String fecIni) {
        this.fecIni = fecIni;
    }

    public String getFecFin() {
        return fecFin;
    }

    public void setFecFin(String fecFin) {
        this.fecFin = fecFin;
    }
}

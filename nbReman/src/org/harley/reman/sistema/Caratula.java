package org.harley.reman.sistema;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
        "carTit",
        "carPro",
        "carFec",
        "carLug"
})
public class Caratula {
    String carTit;
    Proyecto carPro;
    String carFec;
    String carLug;
        
    public Caratula(){
        
    }
    
    public Caratula(String carTit, String proNom, String empDes, String empCli, 
            String proLid, String proEst, String fecIni, String fecFin,
            String carFec, String carLug) {
        this.carTit = carTit;
        this.carPro = new Proyecto(proNom, empDes, empCli, proLid, proEst, 
                fecIni, fecFin);
        this.carFec = carFec;
        this.carLug = carLug;
    }

    public String getCarTit() {
        return carTit;
    }

    public void setCarTit(String carTit) {
        this.carTit = carTit;
    }

    public Proyecto getCarPro() {
        return carPro;
    }

    public void setCarPro(Proyecto carPro) {
        this.carPro = carPro;
    }

    public String getCarFec() {
        return carFec;
    }

    public void setCarFec(String carFec) {
        this.carFec = carFec;
    }

    public String getCarLug() {
        return carLug;
    }

    public void setCarLug(String carLug) {
        this.carLug = carLug;
    }    
}
package org.harley.reman.sistema;

/**
 *
 * @author Gonzalo
 */
class pytNombre {

    String pytCod;
    String pytNom;

    public pytNombre() {
    }

    public pytNombre(String pytCod, String pytNom) {
        this.pytCod = pytCod;
        this.pytNom = pytNom;
    }

    public String getpytCod() {
        return pytCod;
    }

    public void setpytCod(String pytCod) {
        this.pytCod = pytCod;
    }

    public String getpytNom() {
        return pytNom;
    }

    public void setpytNom(String pytNom) {
        this.pytNom = pytNom;
    }

}

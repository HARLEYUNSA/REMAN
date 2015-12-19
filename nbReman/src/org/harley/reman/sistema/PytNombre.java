package org.harley.reman.sistema;

/**
 *
 * @author Gonzalo
 */
class PytNombre {

    String pytCod;
    String pytNom;

    public PytNombre() {
    }

    public PytNombre(String pytCod, String pytNom) {
        this.pytCod = pytCod;
        this.pytNom = pytNom;
    }

    public String getPytCod() {
        return pytCod;
    }

    public void setPytCod(String pytCod) {
        this.pytCod = pytCod;
    }

    public String getPytNom() {
        return pytNom;
    }

    public void setpytNom(String pytNom) {
        this.pytNom = pytNom;
    }

}

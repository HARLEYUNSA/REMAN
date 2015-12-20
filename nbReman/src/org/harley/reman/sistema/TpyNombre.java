/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.harley.reman.sistema;

/**
 *
 * @author Gonzalo
 */
class TpyNombre {

    String tpyCod;
    String tpyNom;

    public TpyNombre() {
    }

    
    public TpyNombre(String tpyCod, String tpyNom) {
        this.tpyCod = tpyCod;
        this.tpyNom = tpyNom;
    }

    public String getTpyCod() {
        return tpyCod;
    }

    public void setTpyCod(String tpyCod) {
        this.tpyCod = tpyCod;
    }

    public String getTpyNom() {
        return tpyNom;
    }

    public void setTpyNom(String tpyNom) {
        this.tpyNom = tpyNom;
    }
    
    
}

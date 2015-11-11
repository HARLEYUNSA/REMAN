
package org.harley.reman.clases;


import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {


    public ObjectFactory() {
    }


    public LibroActores createLibroActores() {
        return new LibroActores();
    }


    public LibroActores.Actores createLibroActoresActores() {
        return new LibroActores.Actores();
    }

}


package edu.upc.dsa.clases;

import java.util.LinkedList;
import java.util.List;

public class Seguimiento {

    private String fechaseg;
    private String descripcion;
    private List<Vacunaciones> listavacunaciones = new LinkedList<Vacunaciones>();

    public Seguimiento(){};

    public Seguimiento(List<Vacunaciones> listavacunaciones, String fechaseg, String descripcion){
        this.setListavacunaciones(listavacunaciones);
        this.setDescripcion(descripcion);
        this.setFechaseg(fechaseg);
    }

    public List<Vacunaciones> getListavacunaciones() {
        return listavacunaciones;
    }

    public void setListavacunaciones(List<Vacunaciones> listavacunaciones) {
        this.listavacunaciones = listavacunaciones;
    }

    public String getFechaseg() {
        return fechaseg;
    }

    public void setFechaseg(String fechaseg) {
        this.fechaseg = fechaseg;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

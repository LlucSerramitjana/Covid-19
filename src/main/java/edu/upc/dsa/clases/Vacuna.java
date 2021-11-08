package edu.upc.dsa.clases;

import java.util.ArrayList;
import java.util.List;

public class Vacuna {
    public String marca;
    public int cantidad = 0;
    public int id;

    public Vacuna(String marca, int cantidad, int id){
        this.marca = marca;
        this.cantidad = cantidad;
        this.id = id;
    }
    public Vacuna(){}

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void addCantidad(int cantidad){
        this.cantidad = this.cantidad + cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

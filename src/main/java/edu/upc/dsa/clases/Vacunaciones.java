package edu.upc.dsa.clases;

import java.util.ArrayList;
import java.util.List;

public class Vacunaciones {

    private String fecha;
    private int userid;
    private int vacunaid;

    public Vacunaciones(String fecha, int userid, int vacunaid){
        this.setFecha(fecha);
        this.setVacunaid(vacunaid);
        this.setUserid(userid);
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getVacunaid() {
        return vacunaid;
    }

    public void setVacunaid(int vacunaid) {
        this.vacunaid = vacunaid;
    }
}

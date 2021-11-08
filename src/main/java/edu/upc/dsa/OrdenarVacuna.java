package edu.upc.dsa;
import edu.upc.dsa.clases.Vacuna;
import edu.upc.dsa.clases.Vacunaciones;
import java.util.Comparator;
public class OrdenarVacuna implements Comparator<Vacuna>{

    public int compare(Vacuna v1, Vacuna v2){
        return (int)(v1.getCantidad() - v2.getCantidad());
    }
}

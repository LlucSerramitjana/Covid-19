package edu.upc.dsa;
import edu.upc.dsa.clases.Vacuna;
import edu.upc.dsa.clases.Vacunaciones;
import java.util.Comparator;
public class OrdenarVacunaciones implements Comparator<Vacunaciones>{
    public int compare(Vacunaciones v1, Vacunaciones v2){
        return (int)(v1.getVacunaid() - v2.getVacunaid());
    }
}

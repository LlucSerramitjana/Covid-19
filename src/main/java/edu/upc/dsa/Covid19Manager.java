package edu.upc.dsa;

import edu.upc.dsa.clases.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Covid19Manager {

    public List<Seguimiento> ListadoSeguimientos(int userid);
    public void AñadirSeguimiento(String fechaseg, String descripcion, int usuarioid, List<Vacunaciones> listaVacunaciones);
    public List<Vacuna> OrdenarVacunas() throws EmptyList;
    public List<Vacunaciones> OrdenarVacunaciones();
    public Vacunaciones AplicarVacuna(int iduser, int idvacuna, String fecha);
    public List<Vacunaciones> getListaVacunaciones() throws EmptyList;
    public void addUser(User user);
    public void añadirVacunacionLista(Vacunaciones vacunacion);
    public int getNumVacunados();
    public int getNumUsuarios();
    public int getNumVacunas();
    public void addVacuna(Vacuna vacuna);
}

package edu.upc.dsa;

import edu.upc.dsa.clases.Seguimiento;
import edu.upc.dsa.clases.Vacuna;
import edu.upc.dsa.clases.Vacunaciones;
import edu.upc.dsa.clases.User;

import org.apache.log4j.Logger;

import java.util.*;

public class Covid19ManagerImpl implements Covid19Manager {

    private HashMap<Integer, User> usuaris;
    private List<Vacunaciones> listaVacunaciones;
    private List<Seguimiento> listaSeguimientos;
    private Vacuna[] misVacunas;

    static final Logger logger = Logger.getLogger(Covid19ManagerImpl.class.getName());

    private static Covid19ManagerImpl instance;

    public static Covid19ManagerImpl getInstance(){//Singletone, puerta de entrada a la instancia
        if (instance == null){
            instance = new Covid19ManagerImpl();
        }
        return instance;
    }
    public static void delete(){
        instance = null; //para reiniciar la base de datos
        logger.info("Instancia Covid19ManagerImpl borrada");
    }

    public Covid19ManagerImpl(){
        usuaris = new HashMap<Integer, User>();
        listaSeguimientos = new LinkedList<Seguimiento>();
        listaVacunaciones = new LinkedList<Vacunaciones>();
        misVacunas = new Vacuna[]{};
    }

    public List<Vacunaciones> getListaVacunaciones(){
        return listaVacunaciones;
    }
    public Vacunaciones AplicarVacuna(int iduser, int idvacuna, String fecha){
        Vacunaciones vacunacion = new Vacunaciones(fecha, iduser, idvacuna);
        this.listaVacunaciones.add(vacunacion);
        logger.info("Vacuna puesta al usuario con id " + iduser);
        return vacunacion;
    }
    public List<Vacunaciones> OrdenarVacunaciones(){
        List<Vacunaciones> listaOrdenada = this.listaVacunaciones;
        Collections.sort(listaOrdenada, new OrdenarVacunaciones());
        logger.info("Se han ordenado las vacunaciones por vacuna");
        return listaOrdenada;
    }
    public List<Vacuna> OrdenarVacunas(){
        List<Vacuna> listaOrdenada2 = Arrays.asList(this.misVacunas);
        Collections.sort(listaOrdenada2, new OrdenarVacuna().reversed());
        logger.info("Se han ordenado las vacunas por cantidad de vacunas aplicadas");
        return listaOrdenada2;
    }
    public void AñadirSeguimiento(String fechaseg, String descripcion, int usuarioid, List<Vacunaciones> listaVacunaciones){
        for(int i=0; i<listaVacunaciones.size(); i++){
            if(listaVacunaciones.get(i).getUserid() == usuarioid){
                Seguimiento seguimiento = new Seguimiento(listaVacunaciones, fechaseg, descripcion);
                this.listaSeguimientos.add(seguimiento);
                logger.info("Seguimiento añadido al usuario con id " + usuarioid);
            }
        }
        logger.info("Este usuario no se ha vacunado aún");
    }
    public List<Seguimiento> ListadoSeguimientos(int userid){
        List<Seguimiento> seguimientosUsuario = new LinkedList<Seguimiento>();
        List<Seguimiento> seguimientos = this.listaSeguimientos;
        for(int i=0; i<listaSeguimientos.size(); i++){
            for(int j=0; i<listaVacunaciones.size(); j++) {
                if (listaSeguimientos.get(i).getListavacunaciones().get(j).getUserid() == userid){
                    seguimientosUsuario.add(listaSeguimientos.get(i));
                }
            }
        }
        return seguimientosUsuario;
    }
    public void addUser(User user){
        usuaris.put(user.getId(), user);
        logger.info("Usuario" + user.getUser() + " añadido");
    }
    public void añadirVacunacionLista(Vacunaciones vacunacion){
        this.listaVacunaciones.add(vacunacion);
        logger.info("Vacunacion añadida");
    }
    public int getNumVacunados(){return listaVacunaciones.size();}
    public int getNumUsuarios(){return usuaris.size();}
    public int getNumVacunas(){return misVacunas.length;}
    public void addVacuna(Vacuna vacuna){
        List<Vacuna> listaaux = Arrays.asList(this.misVacunas);
        listaaux.add(vacuna);
    }
}

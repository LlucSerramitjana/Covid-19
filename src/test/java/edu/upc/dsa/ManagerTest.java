package edu.upc.dsa;

import edu.upc.dsa.clases.Seguimiento;
import edu.upc.dsa.clases.User;
import edu.upc.dsa.clases.Vacuna;
import edu.upc.dsa.clases.Vacunaciones;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ManagerTest {
    Covid19ManagerImpl manager = Covid19ManagerImpl.getInstance();
    Vacuna pfizer;
    Vacuna moderna;
    Vacuna jansen;
    Seguimiento s1;
    Vacunaciones v1;
    Vacunaciones v2;

    @Before
    public void setUp (){
        manager.addUser(new User("user1", 1));
        manager.addUser(new User("user2", 2));
        manager.addUser(new User("user3", 3));

        pfizer = new Vacuna("pfizer", 200,1);
        moderna = new Vacuna("moderna", 300,2);
        jansen = new Vacuna("jansen",1,3);

        v1 = new Vacunaciones("22/03/21", 1,1);
        v2 = new Vacunaciones("22/12/21",1,1);
        manager.añadirVacunacionLista(v1);
        s1 = new Seguimiento(manager.getListaVacunaciones(), "16/09/21", "ok");
        manager.AplicarVacuna(1,1,"31/02/21");
        manager.AñadirSeguimiento("12/08/21", "ok",1, manager.getListaVacunaciones());
    }
    @Test
    public void probarAplicarVacuna(){
        Assert.assertEquals(1, manager.getNumVacunados());
        manager.AplicarVacuna(1,1,"22/05/21");
        Assert.assertEquals(2,manager.getNumVacunados());
    }
}

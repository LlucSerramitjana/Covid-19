package edu.upc.dsa.services;

import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.EmptyList;
import edu.upc.dsa.clases.User;
import edu.upc.dsa.clases.Vacuna;
import edu.upc.dsa.clases.Vacunaciones;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.*;

@Api(value = "/Vacunas", description = "Endpoint to Vacunas Service")
@Path("/vacunas")
public class VacunaServicio {
    private Covid19Manager manager;

    public VacunaServicio() {
        this.manager = Covid19ManagerImpl.getInstance();

        if(manager.getNumVacunados() == 0){
            manager.añadirVacunacionLista(new Vacunaciones("22/03/21", 1, 1));
        }
        if(manager.getNumVacunas() == 0){
            manager.addVacuna(new Vacuna("pfizer", 200, 1));
        }
        if(manager.getNumUsuarios() == 0){
            manager.addUser(new User("usuari1", 1));
            manager.AplicarVacuna(1,1,"22/03/21");
            List<Vacunaciones> llista = new LinkedList<Vacunaciones>();
            llista.add(new Vacunaciones("22/03/21", 1, 1));
            llista.add(new Vacunaciones("22/04/21", 1, 1));
            manager.AñadirSeguimiento("21/09/21", "ok", 1, llista);
            manager.ListadoSeguimientos(1);
        }
    }
    @GET
    @ApiOperation(value = "get vacunaciones ordenado por vacuna", notes = "asdads")
    @ApiResponses(value = {
            @ApiResponse(code=201, message = "Successful", response = Vacunaciones.class, responseContainer = "List"),
    })
    @Path("/Vacunaciones")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrdenarVacunaciones() throws EmptyList {
        List<Vacunaciones> OrdenarVacunaciones = manager.OrdenarVacunaciones();
        GenericEntity<List<Vacunaciones>> entity = new GenericEntity<List<Vacunaciones>>(OrdenarVacunaciones){};
        return Response.status(201).entity(entity).build();
    }
    @POST
    @ApiOperation(value="Aplicar una vacuna", notes = "asdadas")
    @ApiResponses(value = {
             @ApiResponse(code = 201, message = "Successful", response = Vacunaciones.class),
            @ApiResponse(code= 500, message = "Validation Error")
    })
    @Path("/Vacunar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AplicarVacuna(int iduser, int idvacuna, String fecha){
        int error = 0;
        if(iduser==0||idvacuna==0||fecha==null){
            error = 1;
        }
        if(error == 1){
            Vacunaciones v = this.manager.AplicarVacuna(iduser, idvacuna, fecha);
            return Response.status(500).entity(v).build();
        }
        else{
            Vacunaciones v = this.manager.AplicarVacuna(iduser, idvacuna, fecha);
            return Response.status(201).entity(v).build();
        }
    }
}

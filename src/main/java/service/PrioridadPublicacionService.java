package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.PrioridadPublicacionFacade;
import model.PrioridadPublicacion;

@Path("/prioridadpublicaciones")
public class PrioridadPublicacionService {
	
	@EJB 
	PrioridadPublicacionFacade PrioridadPublicacionFacadeEJB;
	
	Logger logger = Logger.getLogger(PrioridadPublicacionService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<PrioridadPublicacion> findAll(){
		return PrioridadPublicacionFacadeEJB.findAll();
	}
	
	
	@POST
	@Path("crearprioridadpublicacion")
    @Consumes({"application/xml", "application/json"})
    public void create(PrioridadPublicacion entity) {
		PrioridadPublicacionFacadeEJB.create(entity);
    }
	

    @PUT
    @Path("editarprioridadpublicacion/{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, PrioridadPublicacion entity) {
    	entity.setIdPrioridadpublicacion(id.intValue());
    	PrioridadPublicacionFacadeEJB.edit(entity);
    }

}

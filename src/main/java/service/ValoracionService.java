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

import facade.ValoracionFacade;
import facade.PublicacionFacade;
import facade.UsuarioFacade;
import model.Valoracion;
import model.Usuario;
import model.Comentario;
import model.Publicacion;

@Path("/valoraciones")
public class ValoracionService {
	
	@EJB 
	ValoracionFacade ValoracionFacadeEJB;
	
	@EJB 
	PublicacionFacade PublicacionFacadeEJB;
	
	@EJB 
	UsuarioFacade UsuarioFacadeEJB;
	
	Logger logger = Logger.getLogger(ValoracionService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Valoracion> findAll(){
		return ValoracionFacadeEJB.findAll();
	}
	
	@GET
	@Path("buscarvaloracionporid/{idvaloracion}")
	@Produces({"application/xml", "application/json"})
	public Valoracion encontrarPorId(@PathParam("idvaloracion") Integer idvaloracion){
		return ValoracionFacadeEJB.find(idvaloracion);
	}
	
	@GET
	@Path("promediodevaloraciondeunapublicacion/{idpublicacion}")
	@Produces("text/plain")
	public int promedioDeValoracionDeUnaPublicacion(@PathParam("idpublicacion") Integer idpublicacion){
		Publicacion publicacionACalcularPromedio = PublicacionFacadeEJB.find(idpublicacion);
		return ValoracionFacadeEJB.promedioDeValoracionDeUnaPublicacion(publicacionACalcularPromedio) ;
	}
	
	@GET
	@Path("comprobarsielusuariohavalorado/{idpublicacion}/{idusuario}")
	@Produces("text/plain")
	public int promedioDeValoracionDeUnaPublicacion(@PathParam("idpublicacion") Integer idpublicacion, @PathParam("idusuario") Integer idusuario){
		Publicacion publicacionARevisar = PublicacionFacadeEJB.find(idpublicacion);
		Usuario usuarioARevisar = UsuarioFacadeEJB.find(idusuario);
		return ValoracionFacadeEJB.elUsuarioHaValoradoEstaPublicacionONo(publicacionARevisar, usuarioARevisar);
	}
	
	
	@POST
	@Path("crearvaloracion")
    @Consumes({"application/xml", "application/json"})
    public void create(Valoracion entity) {
		ValoracionFacadeEJB.create(entity);
    }
	

    @PUT
    @Path("editarvaloracion/{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Valoracion entity) {
    	entity.setIdValoracion(id.intValue());
    	ValoracionFacadeEJB.edit(entity);
    }
    
    @POST
    @Path("borrarvaloracion/{id}")
    @Consumes({"application/xml", "application/json"})
    public void borrar(@PathParam("id") Integer idDeValoracionABorrar, Valoracion entity) {
    	Valoracion ValoracionABorrar = encontrarPorId(idDeValoracionABorrar);
    	ValoracionFacadeEJB.remove(ValoracionABorrar);
    }

}

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

import facade.ComentarioFacade;
import facade.PublicacionFacade;
import facade.UsuarioFacade;
import facade.ValoracionFacade;
import model.Publicacion;
import model.Usuario;
import model.Valoracion;
import model.Comentario;

@Path("/publicaciones")
public class PublicacionService {
	
	@EJB 
	PublicacionFacade PublicacionFacadeEJB;
	
	@EJB 
	ComentarioFacade ComentarioFacadeEJB;
	
	@EJB 
	ValoracionFacade ValoracionFacadeEJB;
	
	Logger logger = Logger.getLogger(PublicacionService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Publicacion> findAll(){
		return PublicacionFacadeEJB.findAll();
	}
	
	@GET
	@Path("buscarpublicacionporid/{idpublicacion}")
	@Produces({"application/xml", "application/json"})
	public Publicacion encontrarPorId(@PathParam("idpublicacion") Integer idpublicacion){
		return PublicacionFacadeEJB.find(idpublicacion);
	}
	
	@GET
	@Path("buscarcomentariosdeunapublicacion/{idpublicacion}")
	@Produces({"application/xml", "application/json"})
	public List<Comentario> comentariosDeUnaPublicacion(@PathParam("idpublicacion") Integer idpublicacion){
		Publicacion publicacionABuscarComentarios = PublicacionFacadeEJB.find(idpublicacion);
		return PublicacionFacadeEJB.comentariosDeUnaPublicacion(publicacionABuscarComentarios);
	}
	
	
	@POST
	@Path("crearpublicacion")
    @Consumes({"application/xml", "application/json"})
    public void create(Publicacion entity) {
		PublicacionFacadeEJB.create(entity);
    }
	

    @PUT
    @Path("editarpublicacion/{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Publicacion entity) {
    	entity.setIdPublicacion(id.intValue());
    	PublicacionFacadeEJB.edit(entity);
    }
    
    @POST
    @Path("borrarpublicacion/{id}")
    @Consumes({"application/xml", "application/json"})
    public void borrar(@PathParam("id") Integer idDePublicacionABorrar, Publicacion entity) {
    	Publicacion publicacionABorrar = encontrarPorId(idDePublicacionABorrar);
    	List<Comentario> comentariosDeUnaPublicacion = PublicacionFacadeEJB.comentariosDeUnaPublicacion(publicacionABorrar);
    	for (Comentario comentarioDeLaPublicacion : comentariosDeUnaPublicacion)
    	{
    		ComentarioFacadeEJB.remove(comentarioDeLaPublicacion);
    	}
    	List<Valoracion> valoracionesDeUnaPublicacion = PublicacionFacadeEJB.valoracionesDeUnaPublicacion(publicacionABorrar);
    	for (Valoracion valoracionDeLaPublicacion : valoracionesDeUnaPublicacion)
    	{
    		ValoracionFacadeEJB.remove(valoracionDeLaPublicacion);
    	}
    	PublicacionFacadeEJB.remove(publicacionABorrar);
    }

}

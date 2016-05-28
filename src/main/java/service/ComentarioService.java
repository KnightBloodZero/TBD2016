package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.ComentarioFacade;
import model.Comentario;
import model.Publicacion;

@Path("/comentarios")
public class ComentarioService {
	
	@EJB 
	ComentarioFacade ComentarioFacadeEJB;
	
	Logger logger = Logger.getLogger(ComentarioService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Comentario> findAll(){
		return ComentarioFacadeEJB.findAll();
	}
	
	@GET
	@Path("buscarcomentarioporid/{idComentario}")
	@Produces({"application/xml", "application/json"})
	public Comentario encontrarPorId(@PathParam("idComentario") Integer idComentario){
		return ComentarioFacadeEJB.find(idComentario);
	}
	
	
	@POST
	@Path("crearcomentario")
    @Consumes({"application/xml", "application/json"})
    public void create(Comentario entity) {
		ComentarioFacadeEJB.create(entity);
    }
	

    @PUT
    @Path("editarcomentario/{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Comentario entity) {
    	entity.setIdComentario(id.intValue());
    	ComentarioFacadeEJB.edit(entity);
    }
    
    @POST
    @Path("borrarcomentario/{id}")
    @Consumes({"application/xml", "application/json"})
    public void borrar(@PathParam("id") Integer idDeComentarioABorrar, Comentario entity) {
    	Comentario comentarioABorrar = encontrarPorId(idDeComentarioABorrar);
    	ComentarioFacadeEJB.remove(comentarioABorrar);
    }

}

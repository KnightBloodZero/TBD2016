package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;

import facade.AbstractFacade;
import facade.PublicacionFacade;
import model.Comentario;
import model.Publicacion;
import model.Usuario;
import model.Valoracion;

@Stateless
public class PublicacionFacadeEJB extends AbstractFacade<Publicacion> implements PublicacionFacade {
	
	
	@PersistenceContext(unitName = "tbd2016")
	private EntityManager em;
	
	public PublicacionFacadeEJB() {
		super(Publicacion.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	public List<Comentario> comentariosDeUnaPublicacion(Publicacion publicacionABuscarComentarios)
	{
		List<Comentario> comentariosDeLaPublicacion = new ArrayList<Comentario>();
		List<Comentario> comentariosTotales = new ArrayList<Comentario>();
		comentariosTotales = em.createQuery("SELECT u FROM Comentario u").getResultList();
		for(Comentario cadaComentario : comentariosTotales)
		{
			if(cadaComentario.getPublicacion().getIdPublicacion() == publicacionABuscarComentarios.getIdPublicacion())
			{
				comentariosDeLaPublicacion.add(cadaComentario);
			}
		}
		return comentariosDeLaPublicacion;	
	}
	
	public List<Valoracion> valoracionesDeUnaPublicacion(Publicacion publicacionABuscarValoraciones)
	{
		List<Valoracion> valoracionesDeLaPublicacion = new ArrayList<Valoracion>();
		List<Valoracion> valoracionesTotales = new ArrayList<Valoracion>();
		valoracionesTotales = em.createQuery("SELECT u FROM Valoracion u").getResultList();
		for(Valoracion cadaValoracion : valoracionesTotales)
		{
			if(cadaValoracion.getPublicacion().getIdPublicacion() == publicacionABuscarValoraciones.getIdPublicacion())
			{
				valoracionesDeLaPublicacion.add(cadaValoracion);
			}
		}
		return valoracionesDeLaPublicacion;	
	}
	

}

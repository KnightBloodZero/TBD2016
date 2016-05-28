package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;

import facade.AbstractFacade;
import facade.ComentarioFacade;
import model.Comentario;

@Stateless
public class ComentarioFacadeEJB extends AbstractFacade<Comentario> implements ComentarioFacade {
	
	
	@PersistenceContext(unitName = "tbd2016")
	private EntityManager em;
	
	public ComentarioFacadeEJB() {
		super(Comentario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	

}

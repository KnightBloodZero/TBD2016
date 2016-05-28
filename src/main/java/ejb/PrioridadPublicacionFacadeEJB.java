package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;

import facade.AbstractFacade;
import facade.PrioridadPublicacionFacade;
import model.PrioridadPublicacion;

@Stateless
public class PrioridadPublicacionFacadeEJB extends AbstractFacade<PrioridadPublicacion> implements PrioridadPublicacionFacade {
	
	
	@PersistenceContext(unitName = "tbd2016")
	private EntityManager em;
	
	public PrioridadPublicacionFacadeEJB() {
		super(PrioridadPublicacion.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	

}

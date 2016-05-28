package facade;

import java.util.List;

import javax.ejb.Local;

import model.PrioridadPublicacion;

@Local
public interface PrioridadPublicacionFacade {

	public void create(PrioridadPublicacion entity);

	public void edit(PrioridadPublicacion entity);

	public void remove(PrioridadPublicacion entity);

	public PrioridadPublicacion find(Object id);

	public List<PrioridadPublicacion> findAll();

	public List<PrioridadPublicacion> findRange(int[] range);

	public int count();

}

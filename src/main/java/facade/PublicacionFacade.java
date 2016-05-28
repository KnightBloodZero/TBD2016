package facade;

import java.util.List;

import javax.ejb.Local;

import model.Comentario;
import model.Publicacion;
import model.Valoracion;

@Local
public interface PublicacionFacade {

	public void create(Publicacion entity);

	public void edit(Publicacion entity);

	public void remove(Publicacion entity);

	public Publicacion find(Object id);

	public List<Publicacion> findAll();

	public List<Publicacion> findRange(int[] range);

	public int count();
	
	public List<Comentario> comentariosDeUnaPublicacion(Publicacion publicacionABuscarComentarios);
	
	public List<Valoracion> valoracionesDeUnaPublicacion(Publicacion publicacionABuscarValoraciones);

}

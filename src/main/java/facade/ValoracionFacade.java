package facade;

import java.util.List;

import javax.ejb.Local;

import model.Comentario;
import model.Publicacion;
import model.Usuario;
import model.Valoracion;

@Local
public interface ValoracionFacade {

	public void create(Valoracion entity);

	public void edit(Valoracion entity);

	public void remove(Valoracion entity);

	public Valoracion find(Object id);

	public List<Valoracion> findAll();

	public List<Valoracion> findRange(int[] range);

	public int count();

	public int promedioDeValoracionDeUnaPublicacion(Publicacion publicacionACalcularPromedio);
	
	public int elUsuarioHaValoradoEstaPublicacionONo(Publicacion publicacionARevisar, Usuario usuarioARevisar);
}

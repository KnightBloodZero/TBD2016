package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;

import facade.AbstractFacade;
import facade.ValoracionFacade;
import model.Comentario;
import model.Publicacion;
import model.Usuario;
import model.Valoracion;

@Stateless
public class ValoracionFacadeEJB extends AbstractFacade<Valoracion> implements ValoracionFacade {
	
	
	@PersistenceContext(unitName = "tbd2016")
	private EntityManager em;
	
	public ValoracionFacadeEJB() {
		super(Valoracion.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	public int promedioDeValoracionDeUnaPublicacion(Publicacion publicacionACalcularPromedio)
	{
		List<Valoracion> valoracionesTotales = em.createQuery("SELECT u FROM Valoracion u").getResultList();
		int sumador = 0;
		int contadorParaSacarPromedio = 0;
		for(Valoracion cadaValoracion : valoracionesTotales)
		{
			if(cadaValoracion.getPublicacion().getIdPublicacion() == publicacionACalcularPromedio.getIdPublicacion())
			{
				sumador = sumador + cadaValoracion.getValorvaloracion();
				contadorParaSacarPromedio = contadorParaSacarPromedio + 1;
			}
		}
		int promedio = sumador/contadorParaSacarPromedio;
		return promedio;
	}
	
	public int elUsuarioHaValoradoEstaPublicacionONo(Publicacion publicacionARevisar, Usuario usuarioARevisar)
	{
		List<Valoracion> valoracionesTotales = em.createQuery("SELECT u FROM Valoracion u").getResultList();
		for (Valoracion valoracionIndividual : valoracionesTotales)
		{
			if(valoracionIndividual.getUsuario().getIdUsuario() == usuarioARevisar.getIdUsuario() && 
					valoracionIndividual.getPublicacion().getIdPublicacion() == publicacionARevisar.getIdPublicacion())
			{
				return 1;
			}
		}
		return 0;
	}
	
	
	

}

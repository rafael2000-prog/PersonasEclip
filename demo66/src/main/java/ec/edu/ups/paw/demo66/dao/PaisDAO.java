package ec.edu.ups.paw.demo66.dao;

import java.util.List;

import ec.edu.ups.paw.demo66.model.Pais;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class PaisDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Pais pais) {
		em.persist(pais);
	}
	
	public void update(Pais pais) {
		
		em.persist(pais);
	}
	
	public Pais read(String codigo) {
		Pais pais = em.find(Pais.class, codigo);
		return pais;
		
	}
	
	public void delete(String codigo) {
		Pais pais = this.read(codigo);
		em.remove(pais);
				
	}
	
	public List<Pais> getAll() {
		String jpql = "SELECT pa FROM Pais pa";
		Query q = em.createQuery(jpql,Pais.class);
		return q.getResultList();
		
	}

		
	

}

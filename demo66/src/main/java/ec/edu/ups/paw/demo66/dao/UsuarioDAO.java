package ec.edu.ups.paw.demo66.dao;

import java.util.List;

import ec.edu.ups.paw.demo66.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void update(Usuario usuario) {
		
		em.persist(usuario);
	}
	
	public Usuario read(int userId) {
		Usuario persona = em.find(Usuario.class, userId);
		return persona;
		
	}
	
	public void delete(int userId) {
		Usuario persona = this.read(userId);
		em.remove(persona);
				
	}
	
	public List<Usuario> getAll() {
		String jpql = "SELECT s FROM Usuario s";
		Query q = em.createQuery(jpql,Usuario.class);
		return q.getResultList();
		
	}

}

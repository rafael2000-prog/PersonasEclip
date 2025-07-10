package ec.edu.ups.paw.demo66.dao;

import java.util.List;

import ec.edu.ups.paw.demo66.model.Persona;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class PersonaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public void update(Persona persona) {
		
		em.persist(persona);
	}
	
	public Persona read(String cedula) {
		Persona persona = em.find(Persona.class, cedula);
		return persona;
	}
	
	public List<Persona> readPorNombre(String nombre) {
	    TypedQuery<Persona> query = em.createQuery(
	        "SELECT p FROM Persona p WHERE p.nombre = :nombre", Persona.class);
	    query.setParameter("nombre", nombre);
	    return query.getResultList();
	}
	
	public void delete(String cedula) {
		Persona persona = this.read(cedula);
		em.remove(persona);
				
	}
	
	public List<Persona> getAll() {
		String jpql = "SELECT p FROM Persona p";
		Query q = em.createQuery(jpql,Persona.class);
		return q.getResultList();
	}
	
	public List<Persona> readPorNombreParcial(String patron) {
	    String jpql = "SELECT p FROM Persona p WHERE LOWER(p.nombre) LIKE LOWER(:patron)";
	    return em.createQuery(jpql, Persona.class)
	                        .setParameter("patron", patron)
	                        .getResultList();
	}
}

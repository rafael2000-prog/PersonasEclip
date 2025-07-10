package ec.edu.ups.paw.demo66.dao;

import java.text.ParseException;
import java.util.List;

import ec.edu.ups.paw.demo66.model.Persona;
import ec.edu.ups.paw.demo66.model.Schedule;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class AppointmentDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Schedule schedule) {
		em.persist(schedule);
	}
	
	public void update(Schedule schedule) {
		em.persist(schedule);
	}
	
	/*public Schedule read(int appointmentId) {
		Schedule schedule = em.find(Persona.class, Strin appointmentId);
		return schedule;
		
	}
	
	public void delete(String cedula) {
		Schedule schedule = this.read(cedula);
		em.remove(schedule);
				
	}*/
	
	public List<Schedule> getAll() {
		String jpql = "SELECT s FROM Schedule s";
		Query q = em.createQuery(jpql,Persona.class);
		return q.getResultList();
		
	}
}

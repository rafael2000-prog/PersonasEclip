package ec.edu.ups.paw.demo66.business;

import java.util.List;

import ec.edu.ups.paw.demo66.dao.PersonaDAO;
import ec.edu.ups.paw.demo66.model.Persona;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ContactosON {
	
	@Inject
	private PersonaDAO daoPersona;

	public void guardarPersona(Persona p) {
		Persona aux=daoPersona.read(p.getCedula());
		if(aux==null) {
			daoPersona.insert(p);
		}else
			daoPersona.update(p);
		
	}
	
	public List<Persona> getContactos() {
		return daoPersona.getAll();
		
	}
	
	public Persona getContactosById(String cedula) throws Exception {
		if (cedula.length() != 10)
			throw new Exception("Cedula Incorrecta");
		
		return daoPersona.read(cedula);
	}
	
	public List<Persona> getContactosByNombre(String nombre) throws Exception {
		if (nombre == null || nombre.isBlank()) {
	        throw new Exception("Nombre no ingresado");
	    }

	    List<Persona> lista = daoPersona.readPorNombreParcial(nombre.trim() + "%");
	    if (lista == null || lista.isEmpty()) {
	        throw new Exception("No se encontraron personas: " + nombre);
	    }

	    return lista;
	}
}

package ec.edu.ups.paw.demo66.business;

import java.util.List;

import ec.edu.ups.paw.demo66.dao.AppointmentDAO;
import ec.edu.ups.paw.demo66.dao.PaisDAO;
import ec.edu.ups.paw.demo66.dao.PersonaDAO;
import ec.edu.ups.paw.demo66.dao.UsuarioDAO;
import ec.edu.ups.paw.demo66.model.Appointment;
import ec.edu.ups.paw.demo66.model.Pais;
import ec.edu.ups.paw.demo66.model.Persona;
import ec.edu.ups.paw.demo66.model.Role;
import ec.edu.ups.paw.demo66.model.Schedule;
import ec.edu.ups.paw.demo66.model.Specialty;
import ec.edu.ups.paw.demo66.model.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class InilizarBD {
	
	@Inject
	private PersonaDAO daoPersona;
	
	@Inject
	private PaisDAO daoPais;
		
	@Inject
	private UsuarioDAO daoUsuario;
	
	@PostConstruct
	public void init() {
		System.out.print("Inicializando BD");
		
		Persona persona =new Persona();
		persona.setCedula("10");
		persona.setNombre("Rafael Serrano");
		persona.setDireccion("Lamar");
		
		Pais pais =new Pais(593,"EC");
		daoPais.insert(pais);
		
		persona.setPais(pais);
		
		Usuario usuario= new Usuario();
		usuario.setUserId(10);
		usuario.setName("Pepe");
		usuario.setDireccion("San Joaquin");
		usuario.setTelefono("0987654321");
		usuario.setCorreo("elpastelito@bandida.com");
		
		Role role=new Role(1,"Doctor");
		Specialty specialty=new Specialty(1,"Cardiologia");
		
		usuario.setRole(role);
		usuario.setSpecialty(specialty);
		
		daoPersona.insert(persona);
		daoUsuario.insert(usuario);
			
		List<Persona> personas = daoPersona.getAll();
		for(Persona p: personas) {
			System.out.println(p.toString() +" pais: "+ persona.getPais().toString());
		}
		
		List<Usuario> usuarios = daoUsuario.getAll();
		for(Usuario s: usuarios) {
			System.out.println(s.toString() +" Role: "+ s.getRole().getName()+" Specialty: "+ s.getSpecialty().getName());
		}
		
		
		
		
	}

}

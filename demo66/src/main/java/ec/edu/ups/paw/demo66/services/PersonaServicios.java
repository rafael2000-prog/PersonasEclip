package ec.edu.ups.paw.demo66.services;

import java.util.List;
import ec.edu.ups.paw.demo66.business.ContactosON;
import ec.edu.ups.paw.demo66.model.ApiResponse;
import ec.edu.ups.paw.demo66.model.Persona;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/personas")
public class PersonaServicios {

	@Inject
	private ContactosON onContactos;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPersona(Persona p) {
		try {
			onContactos.guardarPersona(p);
			
			ApiResponse response = new ApiResponse(
		            Response.Status.OK.getStatusCode(),
		            "Persona agregada exitosamente.",
		            "/rest/personas"
		        );
		        return Response.ok(response).build();
			//return Response.ok("Guardado Satisfactory").build();   //MensajePlano
		}catch (Exception e) {
			
			ApiResponse error = new ApiResponse(
		            Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
		            "Error al guardar la persona.",
		            "/rest/personas"
		        );
		        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
			//return Response.status(Response.Status.NOT_FOUND).build();   //MensajePlano
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonas() {
		List<Persona> listado=onContactos.getContactos();
		return Response.ok(listado).build();
	}
	
	@GET
	@Path("/{cedula}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersona(@PathParam("cedula") String cedula) {
		
		try {
			Persona p = onContactos.getContactosById(cedula);
			if (p==null) {
				ApiResponse error = new ApiResponse(
			            Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
			            "Persona no encontrada.",
			            "/rest/personas"
			        );
				return Response.status(Response.Status.NOT_FOUND).entity(error).build();
			}
			
				return Response.ok(p).build();
		} catch (Exception e) {
			ApiResponse error = new ApiResponse(
		            Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
		            "Error al guardar la persona.",
		            "/rest/personas"
		        );			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}
	
	@GET
	@Path("/nombre/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonaPorNombre(@PathParam("nombre") String nombre) {
	    try {
	        List<Persona> personas = onContactos.getContactosByNombre(nombre);
	        return Response.ok(personas).build();

	    } catch (Exception e) {
	        ApiResponse error = new ApiResponse(
	            Response.Status.NOT_FOUND.getStatusCode(),
	            e.getMessage(),
	            "/rest/personas/nombre/" + nombre
	        );
	        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
	    }
	}

}

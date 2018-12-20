package pl.shop.javaee.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.shop.javaee.domain.Person;
import pl.shop.javaee.service.PersonManager;

@Path("person")
@Stateless
public class PersonRestService {	
	
	@Inject
	private PersonManager pm;
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person) {
		pm.addPerson(person);

		return Response.status(201).entity("Person").build();
	}
	
	@GET
	@Path("/{PersonId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@PathParam("PersonId") Long id) {
		Person p = pm.getPerson(id);
		return p;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePerson(Person person) {
		pm.updatePerson(person);

		return Response.status(201).entity("Person").build();
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "EJB + REST + JPA API /Person is running today!";
	}
	
	@DELETE
	@Path("/{PersonId}")
	public Response deletePerson(@PathParam("PersonId") Long id) {
		pm.deletePerson(id);
		return Response.status(200).build();
	}

}

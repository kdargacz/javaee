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

import pl.shop.javaee.domain.Tree;
import pl.shop.javaee.service.TreeManager;

@Path("tree")
@Stateless
public class TreeRESTService {

	
	@Inject
	private TreeManager tm;
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTree(Tree tree) {
		tm.addTree(tree);

		return Response.status(201).entity("Tree").build();
	}
	
	
	@GET
	@Path("/{TreeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tree getTree(@PathParam("TreeId") Long id) {
		Tree t = tm.getTree(id);
		return t;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTree(Tree tree) {
		tm.updateTree(tree);

		return Response.status(201).entity("Tree").build();
	}
	
	/*
	@GET
	@Path("/tree")
	@Produces(MediaType.APPLICATION_JSON)
	public Tree getTreeExample() {
		Tree t = tm.getTreeExample();
		return t;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tree> getTrees() {
		return tm.getAllTrees();
	}
	
	
	
	


	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /Tree is running today!";
	}

	@DELETE
	public Response clearTrees() {
		tm.deleteAllTrees();
		return Response.status(200).build();
	}

	@DELETE
	@Path("/{TreeId}")
	public Response clearTree(@PathParam("TreeId") Integer id) {
		tm.deleteTree(tm.getTree(id));
		return Response.status(200).build();
	}
	*/
}

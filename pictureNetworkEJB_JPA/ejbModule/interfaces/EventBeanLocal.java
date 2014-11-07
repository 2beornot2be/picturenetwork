package interfaces;
//ok
import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Event;
@Path("/Event")
@Local
public interface EventBeanLocal {


	@GET
	@Path("/FindEvent/{idEvent}")
	@Produces("application/json")
	public Event findEvent(@PathParam("idEvent") int id);

	@DELETE
	@Path("/DeleteEvent/{idEvent}")
	@Produces("application/json")
	public void removeEvent(@PathParam("idEvent") int id);

	@DELETE
	@Path("/RemoveEvent")
	@Consumes("application/json")
	public void removeEvent(Event e);

	
	@POST
	@Path("/addEvent")
	@Consumes("application/json")
	public void CreateEvent(Event e);

	@POST
	@Path("/UpdateEvent")
	@Consumes("application/json")
	public void UpdateEvente(Event e);

	
	@GET
	@Path("/FindAll")
	@Produces("application/json")
	public List<Event> findAllEvents();

	
	@GET
	@Path("/FindAllByUser/{owner}")
	@Produces("application/json")
	public List<Event> findByUser(@PathParam("owner")int owner);
}

package interfaces;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Profile;
import entities.User;

@Remote
public interface UserBeanRemote 
{
	// ok
	@POST
	@Path("/adduser")
	@Consumes("application/json")
	public void addUser(User User);

	@GET
	@Path("/authentification")
	@Consumes("application/json/{prenom}/{nom}/{pwd}")
	public User authenticateUser(@PathParam("prenom")String first,@PathParam("nom") String last,
								 @PathParam("pwd") String Password);
	
	@POST
	@Path("/updateuser")
	@Consumes("application/json")
	public void updateUser(User User);
	
	
	
	
	public boolean removeUser(User User);
	public boolean removeUser(int id);
	@GET
	@Produces("application/json")
	@Path("/finduser/{id}")
	public User findUser(@PathParam("id")int id);
	
	
	public List<User> findAllUsers();
	public List<User> findAllPhtograhers();
	public List<Profile> findAllFollowingProfiles();
	public List<Profile> findAllFriends();
}

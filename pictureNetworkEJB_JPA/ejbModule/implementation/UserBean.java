package implementation;

import java.util.List;

import interfaces.UserBeanLocal;
import interfaces.UserBeanRemote;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.jboss.security.auth.spi.Users;

import entities.Model;
import entities.Profile;
import entities.State;
import entities.User;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
@LocalBean
public class UserBean implements UserBeanRemote, UserBeanLocal {

    /**
     * Default constructor. 
     */
	@PersistenceUnit(name="pictureNetwork")
	private EntityManagerFactory emf;
	private EntityManager em;
	
    public UserBean() {
        // TODO Auto-generated constructor stub
    }
    
    private void begin()
    {
    	if(emf != null)
		{
			em = emf.createEntityManager();
		}
    }
    //ok test
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub`
		
		begin();
		if(em == null)
		{
			System.err.println("\n\n\nEM == NULL\n\n\n");
		}
		if(em != null)
		{
			
			em.merge(user);			
			
			
		}
	}

	private void finish() {
		// TODO Auto-generated method stub
		
		
			if(em != null)
			{
				em.close();
			}
			
		}
	
	//testing
	@SuppressWarnings("unchecked")
	@Override
	public User authenticateUser(String first, String last, String Password) {
		// TODO Auto-generated method stub
		User user = null;
		
		String query = String.format("select  u from User u where u.firstName = '%s' and  u.lastName = '%s' and u.password = '%s'", first, last, Password);
		List<User> users = (List<User>) em.createQuery(query).getResultList();
		if(users.size() >= 1)
		{
			user = users.get(0);
		}
		
		return user;
	}
	
	@Override
	public void updateUser(User User) {
		// TODO Auto-generated method stub
		if(emf != null)
		{
			em = emf.createEntityManager();
		}
		if(em != null)
		{
			em.merge(User);
			
		}
		
		
	}
	
	@Override
	public boolean removeUser(User User) {
		// TODO Auto-generated method stub
		if(emf != null)
		{
			em = emf.createEntityManager();
		}
		if(em != null)
		{
			em.remove(em.contains(User) ? User : em.merge(User));
			return true;
		}
		
		
		return false;
	}
	// ok
	@Override
	public boolean removeUser(int id) {
		// TODO Auto-generated method stub
		if(emf != null)
		{
			em = emf.createEntityManager();
		}
		if(em != null)
		{
			User u = findUser(id);
			if(u != null)
			{
				em.remove(u);
				return true;
			}
			
		}
		
		return false;
		
	}
	//ok
	@Override
	public User findUser(int id) {
		if(emf != null)
		{
			em = emf.createEntityManager();
		}
		// TODO Auto-generated method stub
		User user = null;
		if(em != null)
		{
			return em.find( User.class, id);
			
		}
		
		return user;
	}
	//ok
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		if(emf != null)
		{
			em = emf.createEntityManager();
		}
		List<User> users = null;
		if(em != null)
		{
			users = em.createQuery("select u from User u").getResultList();
			
		}
		
		return users;
	}

	@Override
	public List<Profile> findAllFollowingProfiles() {
		// TODO Auto-generated method stub
		List<Profile> profiles = null;
		
		
		return profiles;
	}

	@Override
	public List<Profile> findAllFriends() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllPhtograhers() {
		// TODO Auto-generated method stub
		begin();
		List<User> models = null;
		if(em != null)
		{
			String query = String.format("select  u from User u where u.state = '%s'", State.USER.toString());
			models = (List<User>)em.createQuery(query).getResultList();
		}
		return models;
	}

}

package implementation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import entities.Category;
import entities.SubCategory;
import entities.User;
import interfaces.CategoryLocal;
import interfaces.CategoryRemote;

@Stateless
public class CategoryBean implements CategoryLocal,CategoryRemote{

	@PersistenceUnit(name="pictureNetwork")
	private EntityManagerFactory emf;
	private EntityManager em;
	 private void begin()
	    {
	    	if(emf != null)
			{
				em = emf.createEntityManager();
			}
	    }
	
	@Override
	public boolean addCategory(Category category) {
		begin();
		em.persist(category);
		return false;
	}

	@Override
	public Category findCategory(int id) {
	begin();
		
		return em.find(Category.class, id);
	}
	


}

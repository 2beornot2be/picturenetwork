package implementation;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import entities.Category;
import entities.SubCategory;
import entities.User;
import interfaces.CategoryBeanLocal;
import interfaces.CategoryBeanRemote;

@Stateless
@LocalBean
public class CategoryBean implements CategoryBeanLocal, CategoryBeanRemote {

	@PersistenceUnit(name="pictureNetwork")
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CategoryBean()
	{
		
	}
	
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
		if(em != null)
		{
			em.persist(category);
			return true;
		}
		
		return false;
	}

	@Override
	public Category findCategory(int id) {
	begin();
	Category c = null;
		if(em != null)
		{
			c = em.find(Category.class, id);
			return c;
		}
		return c;
		
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		begin();
		if(em != null)
		{
			em.merge(category);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeCategory(Category category) {
		// TODO Auto-generated method stub
		begin();
		if(em != null)
		{
			em.remove(em.contains(category) ? category : em.merge(category));
			return true;
		}
		return false;
	}

	@Override
	public boolean removeCategory(int id) {
		// TODO Auto-generated method stub
		begin();
		if(em != null )
		{
			Category c = findCategory(id);
			if(c != null)
			{
				em.remove(em.contains(c) ? c : em.merge(c));
				return true;
			}
			
		}
		return false;
	}

	@Override
	public List<Category> findAllCategories() {
		// TODO Auto-generated method stub
		begin();
		List<Category> categories = null;
		String query = "select c from Category c";
		if(em != null)
		{
			categories = em.createQuery(query).getResultList();
			return categories;
		}
		return categories;
		
	}
	


}

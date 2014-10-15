package implementation;

import java.util.List;

import interfaces.ModelBeanLocal;
import interfaces.ModelBeanRemote;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import entities.Model;
import entities.ModelState_Activation;
import entities.State;

/**
 * Session Bean implementation class ModelBean
 */
@Stateless
@LocalBean
public class ModelBean implements ModelBeanRemote, ModelBeanLocal {

    /**
     * Default constructor. 
     */
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
    public ModelBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addModel(Model Model) {
		// TODO Auto-generated method stub
		begin();
		if(em == null)
		{
			System.err.println("\n\n\nEM == NULL\n\n\n");
		}
		if(em != null)
		{
			
			em.persist(Model);			
			
			
			return true;
		}
		
		
		return false;
	}

	@Override
	public Model authenticateModel(String first, String last, String Password) {
		// TODO Auto-generated method stub
		Model model = null;
		begin();
		if(em != null)
		{
			
			String query = String.format("select  u from User u where u.firstName = '%s' and  u.lastName = '%s' and u.password = '%s' and u.modelState_Activation = '%s'", first, last, Password, ModelState_Activation.ACTIVATED.toString());
			List<Model> models = em.createQuery(query).getResultList();
			if(models.size() >= 1)
			{
				model = models.get(0);
			}
		}
		
		return model;
	}

	@Override
	public boolean updateModel(Model Model) {
		// TODO Auto-generated method stub
		begin();
		if(em != null)
		{
			em.merge(Model);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeModel(Model Model) {
		// TODO Auto-generated method stub
		begin();
		if(em != null)
		{
			em.remove(em.contains(Model) ? Model : em.merge(Model));
			return true;
		}
		return false;
	}
	// ok
	@Override
	public boolean removeModel(int id) {
		// TODO Auto-generated method stub
		begin();
		if(em != null)
		{
			Model m = findModel(id);
			if(m != null)
			{
				em.remove(em.contains(m) ? m : em.merge(m));
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Model findModel(int id) {
		// TODO Auto-generated method stub
		begin();
		Model model = null;
		if(em != null)
		{
			return em.find(Model.class, id);
		}
		return model;
	}

	@Override
	public boolean desactivateReactivateModel(Model model, boolean desactivate) {
		// TODO Auto-generated method stub
		if(model != null)
		{
			if(desactivate)
			{
				model.setModelState_Activation(ModelState_Activation.DESACTIVATED.toString());
			}
			else
			{
				model.setModelState_Activation(ModelState_Activation.ACTIVATED.toString());
			}
			begin();
			if(em != null)
			{
				em.merge(model);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public List<Model> findAllModels() {
		// TODO Auto-generated method stub
		begin();
		List<Model> models = null;
		if(em != null)
		{
			String query = String.format("select  u from User u where u.state = '%s'", State.MODEL.toString());
			models = (List<Model>)em.createQuery(query).getResultList();
		}
		return models;
	}

	@Override
	public List<Model> findAllDesactivatedModels() {
		// TODO Auto-generated method stub
		begin();
		List<Model> models = null;
		if(em != null)
		{
			String query = String.format("select  u from User u where u.state = '%s' and u.modelState_Activation = '%s'", State.MODEL.toString(), ModelState_Activation.DESACTIVATED.toString());
			models = (List<Model>)em.createQuery(query).getResultList();
		}
		return models;
	}

}

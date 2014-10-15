package implementation;
// ok
import interfaces.EventBeanLocal;
import interfaces.EventBeanRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import entities.Event;
import entities.ModelState_Activation;

/**
 * Session Bean implementation class EventBean
 */
@Stateless
public class EventBean implements EventBeanRemote, EventBeanLocal {
	@PersistenceUnit(unitName = "pictureNetwork")
	private EntityManagerFactory emf;
	private EntityManager em;

	private void begin() {
		if (emf != null) {
			em = emf.createEntityManager();
		}
	}

	public EventBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Event findbyid(int id) {
		begin();
		return em.find(Event.class, id);
	}

	@Override
	public void del(int id) {
		begin();
		em.remove(findbyid(id));
	}

	@Override
	public boolean ApproveEvent(Event event, boolean Approve) {

		if (event != null) {
			if (Approve) {
				event.setModelState_Activation(ModelState_Activation.DESACTIVATED
						.toString());
			} else {
				event.setModelState_Activation(ModelState_Activation.ACTIVATED
						.toString());
			}
			begin();
			if (em != null) {
				em.merge(event);
				return true;
			}
		}

		return false;
	}

	@Override
	public void del(Event e) {
		begin();
		
		em.remove(em.merge(e));

	}

}

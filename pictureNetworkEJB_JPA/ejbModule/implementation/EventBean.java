package implementation;
// ok
import java.util.List;

import interfaces.EventBeanLocal;
import interfaces.EventBeanRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import entities.Admin;
import entities.Event;
import entities.ModelState_Activation;
import entities.State;

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
	public Event findEvent(int id) {
		// TODO Auto-generated method stub
		begin();
		return em.find(Event.class, id);
	}

	@Override
	public void removeEvent(int id) {
		// TODO Auto-generated method stub
		begin();
		Event e = findEvent(id);
		if(e != null)
		{
			em.remove(em.contains(e) ? e : em.merge(e));
		}
	}

	@Override
	public void removeEvent(Event e) {
		begin();
		em.remove(em.contains(e) ? e : em.merge(e));
	}

	@Override
	public boolean addEvent(Event e) {
		// TODO Auto-generated method stub
		begin();
		em.persist(e);
		return true;
	}

	@Override
	public boolean updateEvent(Event event) {
		// TODO Auto-generated method stub
		begin();
		if(em != null)
		{
			em.merge(event);
			return true;
		}
		return false;
	}

	@Override
	public List<Event> findAllEvents() {
		// TODO Auto-generated method stub
		begin();
		
		return   ((List<Event>) em.createQuery("select  u from Event u").getResultList());
		
	}

}

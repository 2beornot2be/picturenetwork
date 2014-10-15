package interfaces;
//ok
import java.util.List;

import javax.ejb.Local;

import entities.Event;

@Local
public interface EventBeanLocal {


	public Event findEvent(int id);

	public void removeEvent(int id);

	public void removeEvent(Event e);

	public boolean ApproveEvent(Event event, boolean Approve);
	
	public boolean addEvent(Event e);
	public boolean updateEvent(Event event);
	public List<Event> findAllEvents();
}

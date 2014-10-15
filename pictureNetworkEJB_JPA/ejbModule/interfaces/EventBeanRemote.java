package interfaces;
//ok
import java.util.List;

import javax.ejb.Remote;

import entities.Admin;
import entities.Event;

@Remote
public interface EventBeanRemote {

	public Event findEvent(int id);

	public void removeEvent(int id);

	public void removeEvent(Event e);

	public boolean ApproveEvent(Event event, boolean Approve);
	
	public boolean addEvent(Event e);
	public boolean updateEvent(Event event);
	public List<Event> findAllEvents();
}

package interfaces;
//ok
import javax.ejb.Local;

import entities.Event;

@Local
public interface EventBeanLocal {


	public Event findbyid(int id);

	public void del(int id);
	public void del(Event e);

	
	public boolean ApproveEvent(Event event, boolean Approve);
}

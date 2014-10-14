package interfaces;
//ok
import javax.ejb.Remote;

import entities.Event;

@Remote
public interface EventBeanRemote {

	public Event findbyid(int id);

	public void del(int id);

	public void del(Event e);

	public boolean ApproveEvent(Event event, boolean Approve);
}

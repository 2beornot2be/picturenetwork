package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-09-30T00:17:03.036+0100")
@StaticMetamodel(Event.class)
public class Event_ {
	public static volatile SingularAttribute<Event, Integer> id;
	public static volatile SingularAttribute<Event, String> topic;
	public static volatile SingularAttribute<Event, String> description;
	public static volatile SingularAttribute<Event, Date> eventDate;
	public static volatile SingularAttribute<Event, User> Owner;
	public static volatile ListAttribute<Event, User> participants;
	public static volatile ListAttribute<Event, Comment> eventComment;
}

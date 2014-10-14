package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity
public class Event implements Serializable {
	private String modelState_Activation = ModelState_Activation.ACTIVATED.toString();
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String topic;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date eventDate;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User Owner;
	@ManyToMany
    @JoinTable(name="Event_Participant", 
        joinColumns=
            @JoinColumn(name="Event_ID", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="PARTICIPANT_ID", referencedColumnName="id")
        )
	private List<User> participants;
	@OneToMany(mappedBy="event")
	private List<EventComment> eventComment = null;
	// a faire list<Comment>
	
	
	public Event() {
		super();
	}
	
	
	
	
	
	public Event(String topic, String description, Date eventDate, User owner,
			List<User> participants, List<EventComment> eventComments) {
		super();
		this.topic = topic;
		this.description = description;
		this.eventDate = eventDate;
		Owner = owner;
		this.participants = participants;
		this.setEventComment(eventComments);
	}





	public Event(int id, String topic, String description, Date eventDate,
			User owner, List<User> participants, List<EventComment> eventComments) {
		super();
		this.id = id;
		this.topic = topic;
		this.description = description;
		this.eventDate = eventDate;
		Owner = owner;
		this.participants = participants;
		this.setEventComment(eventComments);
	}





	public Event(String topic, String description, Date eventDate, User owner,
			List<User> participants) {
		super();
		this.topic = topic;
		this.description = description;
		this.eventDate = eventDate;
		Owner = owner;
		this.participants = participants;
	}





	public Event(int id, String topic, String description, Date eventDate,
			User owner, List<User> participants) {
		super();
		this.id = id;
		this.topic = topic;
		this.description = description;
		this.eventDate = eventDate;
		Owner = owner;
		this.participants = participants;
	}





	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}



	public User getOwner() {
		return Owner;
	}



	public void setOwner(User owner) {
		Owner = owner;
	}



	public List<User> getParticipants() {
		return participants;
	}



	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}





	





	public List<EventComment> getEventComment() {
		return eventComment;
	}





	public void setEventComment(List<EventComment> eventComment) {
		this.eventComment = eventComment;
	}





	public String getModelState_Activation() {
		return modelState_Activation;
	}





	public void setModelState_Activation(String modelState_Activation) {
		this.modelState_Activation = modelState_Activation;
	}
   
}

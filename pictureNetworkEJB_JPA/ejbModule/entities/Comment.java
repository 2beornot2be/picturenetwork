package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.ejb.Timeout;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity
//ok
public class Comment implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	@Temporal(TemporalType.DATE)
	private Date dateModified;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User sender;
	
	public Comment() {
		super();
	}   
	
	
	public Comment(String content, Date dateCreated, Date dateModified,
			User sender) {
		super();
		this.content = content;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.sender = sender;
	}


	public Comment(int id, String content, Date dateCreated, Date dateModified,
			User sender) {
		super();
		this.id = id;
		this.content = content;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.sender = sender;
	}


	public Comment(String content, Date dateCreated, Date dateModified) {
		super();
		this.content = content;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
	}


	public Comment(int id, String content, Date dateCreated, Date dateModified) {
		super();
		this.id = id;
		this.content = content;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}   
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}   
	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}


	public User getSender() {
		return sender;
	}


	public void setSender(User sender) {
		this.sender = sender;
	}
   
}

package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: BadWorld
 *
 */
@Entity
public class BadWorld implements Serializable {

	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	private static final long serialVersionUID = 1L;
	
	
	
	public BadWorld(String description) {
		super();
		this.description = description;
	}

	public BadWorld(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public BadWorld() {
		super();
	}   
	 
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}

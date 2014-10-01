package entities;

import entities.User;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Model
 *
 */
@Entity

public class Model extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	

	public Model() {
		super();
	}

	public Model(int id, String lastName, String firstName, String address,
			String tel, String password, String state, String credit) {
		super(id, lastName, firstName, address, tel, password, State.MODEL.toString(), credit);
		// TODO Auto-generated constructor stub
	}

	public Model(String lastName, String firstName, String address, String tel,
			String password, String state, String credit) {
		super(lastName, firstName, address, tel, password, State.MODEL.toString(), credit);
		
		
		// TODO Auto-generated constructor stub
	}
	
	
   
}

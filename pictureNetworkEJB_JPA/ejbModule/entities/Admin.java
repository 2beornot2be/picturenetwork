package entities;

import entities.User;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
//test0
public class Admin extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}

	public Admin(int id, String lastName, String firstName, String address,
			String tel, String password, String state, String credit) {
		super(id, lastName, firstName, address, tel, password, State.ADMIN.toString(), Credit.PICTURE_NETWORK_TEAM.toString());
		// TODO Auto-generated constructor stub
	}

	public Admin(String lastName, String firstName, String address, String tel,
			String password, String state, String credit) {
		super(lastName, firstName, address, tel, password, State.ADMIN.toString(), Credit.PICTURE_NETWORK_TEAM.toString());
		// TODO Auto-generated constructor stub
	}
	
	
   
}

package entities;

import entities.User;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Profile
 *
 */
@Entity
public class Profile implements Serializable {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private User profileOwner;
	
	
	@ManyToMany
    @JoinTable(name="PROFILE_FRIEND",
        joinColumns=
            @JoinColumn(name="Profile_ID", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="Friend_ID", referencedColumnName="id")
        )
	private List<User> friends = null;
	
	
	
	@ManyToMany
    @JoinTable(name="PROFILE_FOLLOWER",
        joinColumns=
            @JoinColumn(name="Profile_ID", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="Follower_ID", referencedColumnName="id")
        )
	private List<User> followers = null;
	// a ajouter List<ProfileComment>
	@OneToMany(mappedBy="userProfile")
	private List<ProfileComment> profileComments;
	
	private static final long serialVersionUID = 1L;

	public Profile(int id, User profileOwner, List<User> friends,
			List<User> followers, List<ProfileComment> profileComments) {
		super();
		this.id = id;
		this.profileOwner = profileOwner;
		this.friends = friends;
		this.followers = followers;
		this.profileComments = profileComments;
	}

	public Profile() {
		super();
	}   
	   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public User getProfileOwner() {
		return this.profileOwner;
	}

	public void setProfileOwner(User profileOwner) {
		this.profileOwner = profileOwner;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}

	public List<ProfileComment> getProfileComments() {
		return profileComments;
	}

	public void setProfileComments(List<ProfileComment> profileComments) {
		this.profileComments = profileComments;
	}
   
}

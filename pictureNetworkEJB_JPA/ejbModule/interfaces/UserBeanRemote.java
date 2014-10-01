package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Profile;
import entities.User;

@Remote
public interface UserBeanRemote 
{
	public boolean addUser(User User);
	public User authenticateUser(String first, String last, String Password);
	public boolean updateUser(User User);
	public boolean removeUser(User User);
	public boolean removeUser(int id);
	public User findUser(int id);
	public List<User> findAllUsers();
	public List<Profile> findAllFollowingProfiles();
	public List<Profile> findAllFriends();
}

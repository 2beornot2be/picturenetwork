package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Admin;

@Remote
public interface AdminBeanRemote {
	public boolean addAdmin(Admin Admin);
	public Admin authenticateAdmin(String first, String last, String Password);
	public boolean updateAdmin(Admin Admin);
	public boolean removeAdmin(Admin Admin);
	public boolean removeAdmin(int id);
	public Admin findAdmin(int id);
	public List<Admin> findAllAdmins();

}
